/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given a String, return a String length 1 from its front, unless front is false, 
//in which case return a String length 1 from its back. The String will be non-empty. 
//
//TakeOne("Hello", true) -> "H"
//TakeOne("Hello", false) -> "o"
//TakeOne("oh", true) -> "o"
public class TakeOne {

    public String TakeOne(String str, boolean fromFront) {
        return (fromFront ? str.substring(0, 1) : str.substring(str.length()-1, str.length()));
    }
}
