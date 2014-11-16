
package conditionals;
//Given a string, return a new string where the first and last chars have been exchanged. 
//
//FrontBack("code") -> "eodc"
//FrontBack("a") -> "a"
//FrontBack("ab") -> "ba"

public class FrontBack {

    public String frontBack(String str) {
        
        if (str.length() == 1) {
            return str;
        }
        return str.charAt(str.length() - 1)+str.substring(1, str.length() - 1)+str.charAt(0);
    }
}
