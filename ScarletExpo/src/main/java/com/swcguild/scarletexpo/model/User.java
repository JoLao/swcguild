/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.scarletexpo.model;

import java.util.Arrays;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author klove
 */
public class User {
    private int userId;
   @NotNull
    @Size(min=8, max=20, message="User Name must be between 8 and 20 characters in length")
    private String userName;
    
    @NotNull
    @Size(min=5, max=20, message="Password must be between 5 and 20 characters in length")
    private String userPass;
    
    @NotNull
    @Size(min=2, max=50, message="First Name must be between 2 and 50 characters in length.")
    private String firstName;
    
    @NotNull
    @Size(min=2, max=50, message="Last Name must be between 2 and 50 characters in length.")
    private String lastName;
    private int[] noteIds;
    
    @NotNull
    private int profileId;
    
    @NotNull
    private String authority;
    
    private boolean isActive;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int[] getNoteIds() {
        return noteIds;
    }

    public void setNoteIds(int[] noteIds) {
        this.noteIds = noteIds;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.userId;
        hash = 67 * hash + Objects.hashCode(this.userName);
        hash = 67 * hash + Objects.hashCode(this.userPass);
        hash = 67 * hash + Objects.hashCode(this.firstName);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Arrays.hashCode(this.noteIds);
        hash = 67 * hash + this.profileId;
        hash = 67 * hash + Objects.hashCode(this.authority);
        hash = 67 * hash + (this.isActive ? 1 : 0);
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
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.userPass, other.userPass)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Arrays.equals(this.noteIds, other.noteIds)) {
            return false;
        }
        if (this.profileId != other.profileId) {
            return false;
        }
        if (!Objects.equals(this.authority, other.authority)) {
            return false;
        }
        if (this.isActive != other.isActive) {
            return false;
        }
        return true;
    }
}
