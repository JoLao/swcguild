package conditionals;

//Given a string, return a string made of the first 2 chars (if present), however 
//include first char only if it is 'o' and include the second only if it is 'z', 
//so "ozymandias" yields "oz". 
//
//StartOz("ozymandias") -> "oz"
//StartOz("bzoo") -> "z"
//StartOz("oxx") -> "o"
public class StartOz {

    public String startOz(String str) {
        String result = "";
        
        if (str.charAt(0) == 'o') {
            result = "o";
        }
        
        if (str.charAt(1) == 'z') {
            result += "z";
        }
        return result;
    }
}
