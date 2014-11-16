
package flooringmasteryproject2.domain;

import java.util.Objects;

public class User implements Comparable<User> {
    private String userId;
    private String name;
    private String password;
    private String position;
    
    private int    securityLevel;

    public User() {
    }

    public User(String userId, String name, String password, String position, int securityLevel) {
        this.userId        = userId;
        this.name          = name;
        this.password      = password;
        this.position      = position;
        this.securityLevel = securityLevel;
//        if (this.position.equalsIgnoreCase("manager")) {
//            securityLevel = 10;
//        } else {
//            securityLevel = 5;
//        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

//    public void setSecurityLevel(int securityLevel) {
//        this.securityLevel = securityLevel;
//    }

    @Override
    public int compareTo(User compareUser) {
        int cmp = this.userId.compareToIgnoreCase(compareUser.userId);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.name.compareToIgnoreCase(compareUser.name);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.password.compareTo(compareUser.password);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.position.compareToIgnoreCase(compareUser.position);
        if (cmp != 0) {
            return cmp;
        }
        
        return Integer.valueOf(this.securityLevel).compareTo(compareUser.securityLevel);
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.userId);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.position);
        hash = 79 * hash + this.securityLevel;
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
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (this.securityLevel != other.securityLevel) {
            return false;
        }
        return true;
    }
   
    
    
}
