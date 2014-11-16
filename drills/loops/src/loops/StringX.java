/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

//Given a string, return a version where all the "x" have been removed. Except an 
//"x" at the very start or end should not be removed. 
//
//StringX("xxHxix") -> "xHix"
//StringX("abxxxcd") -> "abcd"
//StringX("xabxxxcdx") -> "xabcdx"
public class StringX {

    public String stringX(String str) {
        String result = "" + str.charAt(0);

        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) != 'x') {
                result += str.charAt(i);
            }
        }
        result += str.charAt(str.length()-1);
        return result;

    }
}
