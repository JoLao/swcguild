package conditionals;

//Given two temperatures, return true if one is less than 0 and the other is greater than 100. 
//
//IcyHot(120, -1) -> true
//IcyHot(-1, 120) -> true
//IcyHot(2, 120) -> false
public class IcyHot {

    public boolean icyHot(int temp1, int temp2) {
        boolean result = false;
        
        if ((temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0)) {
            result = true;
        }
        return result;
    }
}
