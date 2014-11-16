package conditionals;

//Return true if the given string begins with "*ix", the '*' can be anything, so "pix", "9ix" .. all count. 
//
//IxStart("mix snacks") -> true
//IxStart("pix snacks") -> true
//IxStart("piz snacks") -> false
public class IxStart {

    public boolean ixStart(String str) {
        boolean result = false;
        
        //System.out.println(str.substring(1, 3));
        if (str.substring(1, 3).equals("ix")) {
            result = true;
        }
        return result;
    }
}
