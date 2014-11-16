package conditionals;

//Given a string, if the string "del" appears starting at index 1, return a 
//string where that "del" has been deleted. Otherwise, return the string unchanged. 
//
//RemoveDel("adelbc") -> "abc"
//RemoveDel("adelHello") -> "aHello"
//RemoveDel("adedbc") -> "adedbc"
public class RemoveDel {

    public String removeDel(String str) {
        String s = "";
        
        //System.out.println(str.substring(1, 4));
        if (str.substring(1, 4).equals("del")) {
            s = str.charAt(0)+str.substring(4);
            //System.out.println(str.charAt(0)+" "+str.substring(4));
        } else {
            s = str;
        }
        return s;
    }
}
