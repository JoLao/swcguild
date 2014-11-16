
package conditionals;

//Given a string, return true if the string starts with "hi" and false otherwise. 
//
//StartHi("hi there") -> true
//StartHi("hi") -> true

//Why should this be false? It begins with "hi"
//StartHi("high up") -> false

public class StartHi {

    public boolean startHi(String str) {
        boolean result = false;
        
        if (str.length() < 2) {
            result = false;
        } else if (str.substring(0, 2).equalsIgnoreCase("hi")) {
            result = true;
        }
        return result;
    }
}
