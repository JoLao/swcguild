
package com.swcguild.baseballleague.domain;

import java.util.Objects;


public class Player implements Comparable<Player> {
    private static String[] positions = {"PITCHER", "CATCHER", "1ST BASE", "2ND BASE", "SHORTSTOP",
                                         "3RD BASE", "LEFT FIELD", "CENTER FIELD", "RIGHT FIEDL"};
    
    private String name;
    private int    jerseyNumber;
    private String teamName;
    
    private String position;
    private String battingHand;
    private String throwingHand;
    
    private String phone;
    private String birthday;            

    public Player() {
    }

    public Player(String name, String position, String battingHand, String throwingHand, String phone, String birthday) {
        this.name         = name.toUpperCase();
        this.position     = position.toUpperCase();
        this.battingHand  = battingHand.toUpperCase();
        this.throwingHand = throwingHand.toUpperCase();
        this.phone        = phone;
        this.birthday     = birthday;
    }

    
    public Player(String name, int jerseyNumber, String teamName, String position, String battingHand, String throwingHand, String phone, String birthday) {
        this.name         = name.toUpperCase();
        this.jerseyNumber = jerseyNumber;
        this.teamName     = teamName.toUpperCase();
        this.position     = position.toUpperCase();
        this.battingHand  = battingHand.toUpperCase();
        this.throwingHand = throwingHand.toUpperCase();
        this.phone        = phone;
        this.birthday     = birthday;
    }

    public boolean isPositionValid(String position) {
        for (int i = 0; i < position.length(); i++) {
            if (positions[i].equalsIgnoreCase(position)) {
                return true;
            }
        }
        return false;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName.toUpperCase();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position.toUpperCase();
    }

    public String getBattingHand() {
        return battingHand;
    }

    public void setBattingHand(String battingHand) {
        this.battingHand = battingHand.toUpperCase();
    }

    public String getThrowingHand() {
        return throwingHand;
    }

    public void setThrowingHand(String throwingHand) {
        this.throwingHand = throwingHand.toUpperCase();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Player comparePlayer) {
        int cmp;        
        cmp = this.name.compareToIgnoreCase(comparePlayer.name);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = Integer.valueOf(this.jerseyNumber).compareTo(comparePlayer.jerseyNumber);        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.teamName.compareToIgnoreCase(comparePlayer.teamName);        
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.position.compareToIgnoreCase(comparePlayer.position);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.battingHand.compareToIgnoreCase(comparePlayer.battingHand);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.throwingHand.compareToIgnoreCase(comparePlayer.throwingHand);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.phone.compareToIgnoreCase(comparePlayer.phone);
        if (cmp != 0) {
            return cmp;
        }
        
        return this.birthday.compareToIgnoreCase(comparePlayer.birthday);
        
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + this.jerseyNumber;
        hash = 83 * hash + Objects.hashCode(this.teamName);
        hash = 83 * hash + Objects.hashCode(this.position);
        hash = 83 * hash + Objects.hashCode(this.battingHand);
        hash = 83 * hash + Objects.hashCode(this.throwingHand);
        hash = 83 * hash + Objects.hashCode(this.phone);
        hash = 83 * hash + Objects.hashCode(this.birthday);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.jerseyNumber != other.jerseyNumber) {
            return false;
        }
        if (!Objects.equals(this.teamName, other.teamName)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.battingHand, other.battingHand)) {
            return false;
        }
        if (!Objects.equals(this.throwingHand, other.throwingHand)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return Objects.equals(this.birthday, other.birthday);
    }
    
    
    
}
