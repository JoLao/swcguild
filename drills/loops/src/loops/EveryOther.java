/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

//Given a string, return a new string made of every other char starting with the first, 
//so "Hello" yields "Hlo". 
//
//EveryOther("Hello") -> "Hlo"
//EveryOther("Hi") -> "H"
//EveryOther("Heeololeo") -> "Hello"
public class EveryOther {

    public String everyOther(String str) {
        String result = "";
        boolean flip = true;
        
        for (int i=0; i<str.length(); i++) {
            if (flip) {
                result = result + str.charAt(i);
                flip = false;
            } else {
                flip = true;
            }
        }
        return result;
    }
}
