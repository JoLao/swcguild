package conditionals;

//We have two children, a and b, and the parameters aSmile and bSmile indicate if each is smiling. 
//We are in trouble if they are both smiling or if neither of them is smiling. Return true if we 
//are in trouble. 
//
//AreWeInTrouble(true, true) -> true
//AreWeInTrouble(false, false) -> true
//AreWeInTrouble(true, false) -> false
public class MischievousChildren {

    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        boolean inTrouble = false;
        
        if ( (aSmile && bSmile) || (!aSmile && !bSmile)) {
            inTrouble = true;
        }
        return inTrouble;
    }
}
