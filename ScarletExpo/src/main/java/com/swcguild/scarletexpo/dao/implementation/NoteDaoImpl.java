/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.implementation;


import com.swcguild.scarletexpo.dao.interfaces.NoteDao;
import com.swcguild.scarletexpo.model.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;


/**
 *
 * @author klove
 */
public class NoteDaoImpl implements NoteDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final String SQL_INSERT_NOTE
            ="insert into notes (dateEntered, notes)"
            + " values (?, ?)";
    
    private static final String SQL_SELECT_NOTES_BY_USERID
            ="select * from notes n"
            + " join users_notes un"
            + " on n.notesId = un.notesId"
            + " where userId = ?"
            + " order by dateEntered desc";
    
    private static final String SQL_SELECT_NOTES_BY_EVENTID
            ="select * from notes n"
            + " join events_notes en"
            + " on n.notesId = en.notesId"
            + " where eventId = ?"
            + " order by dateEntered desc";
    
    private static final String SQL_SELECT_NOTES_BY_PRODUCTITEMID
            ="select * from notes n"
            + " join product_items_notes pin"
            + " on n.notesId = pin.notesId"
            + " where productItemId = ?"
            + " order by dateEntered desc";
    

    @Override
    public void addNote(Note note) {
        jdbcTemplate.update(SQL_INSERT_NOTE,
                note.getDateEntered(),
                note.getNote());
        note.setNoteId(jdbcTemplate.queryForObject("select INSERT_LAST_ID()", Integer.class));
    }

    @Override
    public List<Note> getNotesByUserId(int userId) {
        List<Note> nList = jdbcTemplate.query(SQL_SELECT_NOTES_BY_USERID, new NoteMapper(), userId);
        return nList;
    }

    @Override
    public List<Note> getNotesByEventId(int eventId) {
         List<Note> nList = jdbcTemplate.query(SQL_SELECT_NOTES_BY_EVENTID, new NoteMapper(), eventId);
        return nList;
    }

    @Override
    public List<Note> getNotesByProductItemId(int prodItemId) {
         List<Note> nList = jdbcTemplate.query(SQL_SELECT_NOTES_BY_PRODUCTITEMID, new NoteMapper(), prodItemId);
        return nList;
    }
    
    private static final class NoteMapper implements ParameterizedRowMapper<Note> {

        @Override
        public Note mapRow(ResultSet rs, int i) throws SQLException {
            Note n = new Note();
            n.setNoteId(rs.getInt("notesId"));
            String dateParser = rs.getTimestamp("dateEntered").toString();
//            n.setDateEntered(new LocalDate(dateParser));
            n.setDateEntered(dateParser);
            n.setNote(rs.getString("notes"));
            return n;
        }   
        
    }
    

}
