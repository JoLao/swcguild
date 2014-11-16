/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

//Suppose the string "yak" is unlucky. Given a string, return a version where 
//all the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap. 
//
//DoNotYak("yakpak") -> "pak"
//DoNotYak("pakyak") -> "pak"
//DoNotYak("yak123ya") -> "123ya"
public class DoNotYak {

    public String doNotYak(String str) {
        String result = "";
        int j = 0;

        for (int i = 0; i < str.length()-3; i++) {

            if (i >= j) {
                j = i;               
                if (!str.substring(i, i + 3).equals("yak")) {                    
                    result += str.substring(j, j + 1);                    
                } else {
                    j += 3;                    
                }

            }
        }
        if (!str.substring(str.length() - 3, str.length()).equals("yak")) {
            result += str.substring(str.length() - 3, str.length());
        }

        return result;

    }
}
