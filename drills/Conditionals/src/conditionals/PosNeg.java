package conditionals;

//Given two int values, return true if one is negative and one is positive. 
//Except if the parameter "negative" is true, then return true only if both are negative. 
//
//PosNeg(1, -1, false) -> true
//PosNeg(-1, 1, false) -> true
//PosNeg(-4, -5, true) -> true
public class PosNeg {

    public boolean posNeg(int a, int b, boolean negative) {
        boolean result = false;
        
        if (negative) {
            if (a < 0 && b < 0) {
                result = true;
            }
        } else if (a  < 0 ^ b < 0) {
//( (a < 0 && b >= 0) || (a >= 0 && b < 0) ) {
            result = true;
        }
        return result;
    }
}
