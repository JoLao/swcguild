package conditionals;

//We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
//Given 3 int values, return true if 1 or more of them are teen. 
//
//HasTeen(13, 20, 10) -> true
//HasTeen(20, 19, 10) -> true
//HasTeen(20, 10, 12) -> false
public class HasTeen {

    public boolean hasTeen(int a, int b, int c) {
        boolean result = false;
        
        if ((a > 12 && a < 20) || (b > 12 && b < 20) || (c > 12 && c < 20)) {
            result = true;
        }
        return result;
    }
}
