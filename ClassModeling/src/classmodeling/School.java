/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classmodeling;

/**
 *
 * @author apprentice
 */
public class School {
    private String schoolName;
    
    private String typeOfSchool;  //public, chartered, Catholic, etc.
    private String location;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTypeOfSchool() {
        return typeOfSchool;
    }

    public void setTypeOfSchool(String typeOfSchool) {
        this.typeOfSchool = typeOfSchool;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public void calculateCost() {
        
    }
}
