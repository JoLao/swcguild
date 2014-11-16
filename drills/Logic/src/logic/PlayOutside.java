
package logic;

//The children in Cleveland spend most of the day playing outside. In particular, 
//they play if the temperature is between 60 and 90 (inclusive). Unless it is summer, 
//then the upper limit is 100 instead of 90. Given an int temperature and a boolean isSummer, 
//return true if the children play and false otherwise. 
//
//PlayOutside(70, false) → true
//PlayOutside(95, false) → false
//PlayOutside(95, true) → true
public class PlayOutside {
    public boolean canPlayOutside(int temp, boolean isSummer) {
        boolean canPlay = false;
        if (isSummer) {
            if (temp >= 60 && temp <= 100) {
                canPlay = true;
            } 
        } else if (temp >= 60 && temp <= 90) {
            canPlay = true;            
        } else {
            canPlay = false;
        }
        return canPlay;
    }
    
}
