/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.model;

import java.util.Arrays;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.joda.time.LocalDate;



/**
 *
 * @author klove
 */
public class Event {
    private int eventId;
    private String eventDesc;
    private String eventStart;
    @NotNull
    private String eventEnd;
    private String returnDate;
    private int[] productItemIds;
    private int[] noteIds;
    private int userId;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventStart() {
        return eventStart;
    }

    public void setEventStart(String eventStart) {
        this.eventStart = eventStart;
    }

    public String getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(String eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    

    public int[] getProductItemIds() {
        return productItemIds;
    }

    public void setProductItemIds(int[] productItemIds) {
        this.productItemIds = productItemIds;
    }

    public int[] getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(int[] noteIds) {
        this.noteIds = noteIds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.eventId;
        hash = 79 * hash + Objects.hashCode(this.eventDesc);
        hash = 79 * hash + Objects.hashCode(this.eventStart);
        hash = 79 * hash + Objects.hashCode(this.eventEnd);
        hash = 79 * hash + Objects.hashCode(this.returnDate);
        hash = 79 * hash + Arrays.hashCode(this.productItemIds);
        hash = 79 * hash + Arrays.hashCode(this.noteIds);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.eventId != other.eventId) {
            return false;
        }
        if (!Objects.equals(this.eventDesc, other.eventDesc)) {
            return false;
        }
        if (!Objects.equals(this.eventStart, other.eventStart)) {
            return false;
        }
        if (!Objects.equals(this.eventEnd, other.eventEnd)) {
            return false;
        }
        if (!Objects.equals(this.returnDate, other.returnDate)) {
            return false;
        }
        if (!Arrays.equals(this.productItemIds, other.productItemIds)) {
            return false;
        }
        if (!Arrays.equals(this.noteIds, other.noteIds)) {
            return false;
        }
        return true;
    }
    
    
}
