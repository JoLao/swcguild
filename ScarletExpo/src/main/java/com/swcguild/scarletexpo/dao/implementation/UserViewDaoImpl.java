/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.implementation;

import com.swcguild.scarletexpo.dao.interfaces.UserViewDao;
import com.swcguild.scarletexpo.model.Note;
import com.swcguild.scarletexpo.model.User;
import com.swcguild.scarletexpo.model.view.UserView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author jlao
 */
public class UserViewDaoImpl implements UserViewDao {

    private JdbcTemplate jdbcTemplate;

    public static final String SQL_SELECT_ALL_USERS
            = "SELECT u.*, CASE WHEN au.authnum = 1 THEN 'ADMIN_USER' "
            + "WHEN au.authnum = 2 THEN 'MANAGER_USER' "
            + "WHEN au.authnum = 3 THEN 'EMPLOYEE_USER' "
            + "ELSE 'CUSTOMER_USER' END AS authority "
            + "FROM users u "
            + "INNER JOIN ( "
            + "SELECT a.username, "
            + "MIN(CASE WHEN authority = 'ADMIN_USER' THEN 1 "
            + "WHEN authority = 'MANAGER_USER' THEN 2 "
            + "WHEN authority = 'EMPLOYEE_USER' THEN 3 "
            + "ELSE 4 "
            + "END) as authnum "
            + "FROM authorities a "
            + "GROUP BY a.username) au "
            + "ON u.username = au.username";

    public static final String SQL_SELECT_USER_BY_USERNAME
            = "SELECT u.*, CASE WHEN au.authnum = 1 THEN 'ADMIN_USER' "
            + "WHEN au.authnum = 2 THEN 'MANAGER_USER' "
            + "WHEN au.authnum = 3 THEN 'EMPLOYEE_USER' "
            + "ELSE 'CUSTOMER_USER' END AS authority "
            + "FROM users u "
            + "INNER JOIN ( "
            + "SELECT a.username, "
            + "MIN(CASE WHEN authority = 'ADMIN_USER' THEN 1 "
            + "WHEN authority = 'MANAGER_USER' THEN 2 "
            + "WHEN authority = 'EMPLOYEE_USER' THEN 3 "
            + "ELSE 4 "
            + "END) as authnum "
            + "FROM authorities a "
            + "GROUP BY a.username) au "
            + "ON u.username = au.username "
            + "where username = ?";

    public static final String SQL_SELECT_USERS_BY_PROFILEID
            = "SELECT u.*, CASE WHEN au.authnum = 1 THEN 'ADMIN_USER' "
            + "WHEN au.authnum = 2 THEN 'MANAGER_USER' "
            + "WHEN au.authnum = 3 THEN 'EMPLOYEE_USER' "
            + "ELSE 'CUSTOMER_USER' END AS authority "
            + "FROM users u "
            + "INNER JOIN ( "
            + "SELECT a.username, "
            + "MIN(CASE WHEN authority = 'ADMIN_USER' THEN 1 "
            + "WHEN authority = 'MANAGER_USER' THEN 2 "
            + "WHEN authority = 'EMPLOYEE_USER' THEN 3 "
            + "ELSE 4 "
            + "END) as authnum "
            + "FROM authorities a "
            + "GROUP BY a.username) au "
            + "ON u.username = au.username "
            + "users where profileId = ?";

//    public static final String SQL_SELECT_USER_BY_USERID
//            = "SELECT u.*, CASE WHEN au.authnum = 1 THEN 'ADMIN_USER' "
//            + "WHEN au.authnum = 2 THEN 'MANAGER_USER' "
//            + "WHEN au.authnum = 3 THEN 'EMPLOYEE_USER' "
//            + "ELSE 'CUSTOMER_USER' END AS authority "
//            + "FROM users u "
//            + "INNER JOIN ( "
//            + "SELECT a.username, "
//            + "MIN(CASE WHEN authority = 'ADMIN_USER' THEN 1 "
//            + "WHEN authority = 'MANAGER_USER' THEN 2 "
//            + "WHEN authority = 'EMPLOYEE_USER' THEN 3 "
//            + "ELSE 4 "
//            + "END) as authnum "
//            + "FROM authorities a "
//            + "GROUP BY a.username) au "
//            + "ON u.username = au.username "
//            + "WHERE userId = ?";

    private static final String SQL_SELECT_NOTES_BY_USERID
            = "select n.notesId, DATE_FORMAT(DATE(dateEntered), '%m-%d-%Y') as dateEntered, n.notes "
            + "from notes n"
            + " join users_notes un"
            + " on n.notesId = un.notesId"
            + " where userId = ?"
            + " order by dateEntered desc";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserView> displayAllUsers() {
        List<UserView> uvList = jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserViewMapper());

        //get all notes
        for (UserView uv : uvList) {
            List<Note> n = jdbcTemplate.query(SQL_SELECT_NOTES_BY_USERID, new NoteMapper(), uv.getUserId());
            uv.setUserNotes(n);
        }
        return uvList;
    }
    
    //HELPER CLASSES
    private static final class NoteMapper implements ParameterizedRowMapper<Note> {

        @Override
        public Note mapRow(ResultSet rs, int i) throws SQLException {
            Note n = new Note();
            n.setNoteId(rs.getInt("notesId"));
            String dateParser = rs.getTimestamp("dateEntered").toString();
//            LocalDateTime dateEntered = rs.getTimestamp("dateEntered").toLocalDateTime();
            n.setDateEntered(rs.getString("dateEntered"));
            n.setNote(rs.getString("notes"));
            return n;
        }
    }

    private static final class UserViewMapper implements RowMapper<UserView> {

        @Override
        public UserView mapRow(ResultSet rs, int i) throws SQLException {
            UserView u = new UserView();
            u.setUserName(rs.getString("userName"));
//            u.setUserPass(rs.getString("userPass"));
            u.setFirstName(rs.getString("firstName"));
            u.setLastName(rs.getString("lastName"));
            u.setIsActive(rs.getBoolean("isActive"));
            u.setProfileId(rs.getInt("profileId"));
            u.setAuthority(rs.getString("authority"));
            u.setUserId(rs.getInt("userId"));
            return u;
        }
    }
}
