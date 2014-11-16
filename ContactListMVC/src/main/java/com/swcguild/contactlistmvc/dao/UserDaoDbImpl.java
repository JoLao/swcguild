package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.User;
import java.util.ArrayList;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoDbImpl implements UserDao {

    // #1 - We need to update both the users and authorities tables
    private static final String SQL_INSERT_USER = 
            "insert into users (username, password, enabled) values (?, ?, 1)";
    private static final String SQL_INSERT_AUTHORITY = 
            "insert into authorities (username, authority) values (?, ?)";
    private static final String SQL_DELETE_USER = 
            "delete from users where username = ?";
    private static final String SQL_DELETE_AUTHORITIES = 
            "delete from authorities where username = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public User addUser(User newUser) {
        // #2 - First insert user data into the users table and then insert data into 
        //      the authorities table (failing to do so will result in foreign key 
        //      constraint errors)
        jdbcTemplate.update(SQL_INSERT_USER, newUser.getUsername(), newUser.getPassword());
        newUser.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        
        // now insert user's roles
        ArrayList<String> authorities = newUser.getAuthorities();
        for(String authority : authorities) {
            jdbcTemplate.update(SQL_INSERT_AUTHORITY, newUser.getUsername(), authority);
        }
        
        return newUser;
    }

    @Override
    public void deleteUser(String username) {
        // #3 - first delete all authorities for this user
        jdbcTemplate.update(SQL_DELETE_AUTHORITIES, username);
        // #3 - second delete the user - failing to do so will result in foreign
        //      key constraint errors
        jdbcTemplate.update(SQL_DELETE_USER, username);
    }
}
