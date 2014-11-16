package loops;

//Given a non-empty string like "Code" return a string like "CCoCodCode".  
//(first char, first two, first 3, etc)
//
//StringSplosion("Code") -> "CCoCodCode"
//StringSplosion("abc") -> "aababc"
//StringSplosion("ab") -> "aab"
public class StringSplosion {

    public String stringSplosion(String str) {
        String result = "";
           
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                result = result + str.charAt(j);
            }
        }
        return result;
    }
}
