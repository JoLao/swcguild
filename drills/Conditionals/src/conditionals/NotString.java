package conditionals;

//Given a string, return a new string where "not " has been added to the front. 
//However, if the string already begins with "not", return the string unchanged.
//
//Hint: Look up how to use "SubString" in c#
//
//NotString("candy") -> "not candy"
//NotString("x") -> "not x"
//NotString("not bad") -> "not bad"
public class NotString {

    public String notString(String s) {
        String result = "";
//        System.out.println(!s.substring(0, 3).equalsIgnoreCase("not"));
//        System.out.println(s.length());
        if (s.length() < 3 || !(s.substring(0, 3).equalsIgnoreCase("not"))) {
            result = "not "+s;
        } else {
            result = s;
        }
        return result;
    }
}
