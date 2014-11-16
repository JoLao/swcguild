package logic;

public class GreatParty {
//When squirrels get together for a party, they like to have cigars. A squirrel party is successful 
//when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case 
//there is no upper bound on the number of cigars. Return true if the party with the given values is 
//successful, or false otherwise. 
//
//GreatParty(30, false) → false
//GreatParty(50, false) → true
//GreatParty(70, true) → true    

    public boolean greatParty(int cigars, boolean isWeekend) {
        if (isWeekend) {
            if (cigars >= 40) {
                return true;
            } else {
                return false;
            }
        } else {
            if (cigars >= 40 && cigars <= 60) {
                return true;
            } else {
                return false;
            }
        }
    }

}