/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.dao.interfaces;

import com.swcguild.scarletexpo.model.Note;
import java.util.List;

/**
 *
 * @author klove
 */
public interface NoteDao {

    public void addNote(Note note);
    
    public List<Note> getNotesByUserId(int userId);
    
    public List<Note> getNotesByEventId(int eventId);
    
    public List<Note> getNotesByProductItemId(int prodItemId);
}
