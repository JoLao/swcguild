package conditionals;

//Given a string, we'll say that the front is the first 3 chars of the string. 
//If the string length is less than 3, the front is whatever is there. Return 
//a new string which is 3 copies of the front. 
//
//Front3("Microsoft") -> "MicMicMic"
//Front3("Chocolate") -> "ChoChoCho"
//Front3("at") -> "atatat"
public class Front3 {

    public String front3(String str) {
        String result = "";
        
        if (str.length() < 3) {
            result = str+str+str;
        } else {
            result = str.substring(0, 3) + str.substring(0, 3) + str.substring(0, 3);
        }
        return result;
    }
}
