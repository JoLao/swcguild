

package logic;
//We'll say a number is special if it is a multiple of 11 or if it is one more than a multiple of 11. 
//Return true if the given non-negative number is special. Use the % "mod" operator
//
//SpecialEleven(22) → true
//SpecialEleven(23) → true
//SpecialEleven(24) → false
public class SpecialEleven {
    
    public boolean specialEleven(int n) {
        boolean isSpecial = false;
    
        if (n > 0 && ((n % 11) == 0 || ( (n-1) % 11) == 0 )) {
            isSpecial = true;
        } else {
            isSpecial = false;
        }
        return isSpecial;
    }
    
}
