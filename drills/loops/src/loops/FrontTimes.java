
package loops;

//Given a string and a non-negative int n, we'll say that the front of the string is 
//the first 3 chars, or whatever is there if the string is less than length 3. 
//Return n copies of the front; 
//
//FrontTimes("Chocolate", 2) -> "ChoCho"
//FrontTimes("Chocolate", 3) -> "ChoChoCho"
//FrontTimes("Abc", 3) -> "AbcAbcAbc"


public class FrontTimes {
    public String frontTimes(String str, int n) {
        String result = "";
        
        for (int i = 1; i <= n; i++) {
            result = result + str.substring(0, (str.length() > 2? 3: str.length()));
        }
        
        return result;
}
}
