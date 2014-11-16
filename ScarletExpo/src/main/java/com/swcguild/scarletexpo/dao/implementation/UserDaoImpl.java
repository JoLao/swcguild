/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.implementation;

import com.swcguild.scarletexpo.dao.interfaces.UserDao;
import com.swcguild.scarletexpo.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author klove
 */
public class UserDaoImpl implements UserDao {
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //SQL PREPARED STATEMENTS
    public static final String SQL_INSERT_USER 
            ="insert into users (username, password, firstName, lastName, profileId)"
            + "values (?, ?, ?, ?, ?)";
    
    public static final String SQL_UPDATE_USER
            ="update users set username = ?, password = ?,"
            + " firstName = ?, lastName = ? , isActive = ?"
            + " where userId = ?";
    
    public static final String SQL_UPDATE_PROFILE
            ="update users set profileId = ? where userId = ?";
    
    public static final String SQL_SELECT_ALL_USERS
            ="select username, password, firstName, lastName, profileId, userId, isActive "
            + "from users";
           
    public static final String SQL_SELECT_USER_BY_USERNAME
            ="select username, password, firstName, lastName, profileId, userId, isActive "
            + "from users where username = ?";
                
    public static final String SQL_SELECT_USERS_BY_PROFILEID
            = "select username, password, firstName, lastName, profileId, userId, isActive "
            + "from users where profileId = ?";
                
    public static final String SQL_SELECT_USER_BY_USERID
            = "SELECT username, password, firstName, lastName, profileId, userId, isActive "
            + "FROM users WHERE userId = ?";
    
    public static final String SQL_SELECT_AUTHORITY_BY_USERID
            = "SELECT CASE WHEN au.authnum = 1 THEN 'ADMIN_USER' " 
            + "WHEN au.authnum = 2 THEN 'MANAGER_USER' " 
            + "WHEN au.authnum = 3 THEN 'EMPLOYEE_USER' " 
            + "ELSE 'CUSTOMER_USER' END AS authority " 
            + "FROM ( "
            + "SELECT MIN(CASE WHEN authority = 'ADMIN_USER' THEN 1 " 
            + "WHEN authority = 'MANAGER_USER' THEN 2 " 
            + "WHEN authority = 'EMPLOYEE_USER' THEN 3 " 
            + "ELSE 4 END) AS authnum " 
            + "FROM `authorities` " 
            + "WHERE username = ?) au";
    
    public static final String SQL_INSERT_USERID_INTO_AUTHORITIES
            = "INSERT INTO authorities (username, authority)"
            + " VALUES (?, ?)";
            
    public static final String SQL_REMOVE_AUTHORITY
            = "DELETE FROM authorities WHERE"
            + " username = ?";
    
    //REMOVED THE CAPABILITY TO ADD NOTES UPON USER-CREATION

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getUserName(),
                user.getUserPass(),
                user.getFirstName(),
                user.getLastName(),
                user.getProfileId());
        user.setUserId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        
        addAuthority(user.getUserName(), user.getAuthority());
        
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getUserName(),
                user.getUserPass(),
                user.getFirstName(),
                user.getLastName(),
                user.isIsActive(),
                user.getUserId());
        
        //deleting existing authority
        jdbcTemplate.update(SQL_REMOVE_AUTHORITY, user.getUserName());
        
        //re-add authority
        addAuthority(user.getUserName(), user.getAuthority());
    }
    
    @Override
    public void updateProfile(User user) {
        jdbcTemplate.update(SQL_UPDATE_PROFILE,
                user.getProfileId(),
                user.getUserId());
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserMapper());
    }

    @Override
    public User getUserByUserName(String userName) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_USERNAME, new UserMapper(), userName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> getUsersByProfileId(int profileId) {
        return jdbcTemplate.query(SQL_SELECT_USERS_BY_PROFILEID, new UserMapper(), profileId);
    }
    
    

    private void addAuthority(String userName, String authority) {
        
        switch(authority) {
            case "ADMIN_USER":
                insertAuthority(userName, "ADMIN_USER");
                insertAuthority(userName, "MANAGER_USER");
                insertAuthority(userName, "EMPLOYEE_USER");
                insertAuthority(userName, "CUSTOMER_USER");
                break;
            case "MANAGER_USER":
                insertAuthority(userName, "MANAGER_USER");
                insertAuthority(userName, "EMPLOYEE_USER");
                insertAuthority(userName, "CUSTOMER_USER");
                break;
            case "EMPLOYEE_USER":
                insertAuthority(userName, "EMPLOYEE_USER");
                insertAuthority(userName, "CUSTOMER_USER");
                break;
            case "CUSTOMER_USER":
                insertAuthority(userName, "CUSTOMER_USER");
                break;
        }          
    }
    
     private void insertAuthority (String userName, String authority) {
          jdbcTemplate.update(SQL_INSERT_USERID_INTO_AUTHORITIES,
                userName,
                authority);
     }

    @Override
    public User getUserByUserId(int userId) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_USERID, new UserMapper(), userId);
          
            user.setAuthority(jdbcTemplate.queryForObject(SQL_SELECT_AUTHORITY_BY_USERID, 
                                        String.class,
                                        user.getUserId()));
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    //HELPER CLASSES
    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User u = new User();
            u.setUserName(rs.getString("username"));
            u.setUserPass(rs.getString("password"));
            u.setFirstName(rs.getString("firstName"));
            u.setLastName(rs.getString("lastName"));
            u.setIsActive(rs.getBoolean("isActive"));
            u.setProfileId(rs.getInt("profileId"));
            u.setUserId(rs.getInt("userId"));
            return u;
        }
    }
}
