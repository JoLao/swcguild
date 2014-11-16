/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unitoneskillcheck;

/**
 *
 * @author apprentice
 */
public class AreTheyTrue {
    public static void main(String[] args) {
//Implement a static method called howTrue that takes two booleans as parameters 
//and returns a String.  The String value returned follows these rules:
//
//    Return “NEITHER” if neither input is true
//
//    Return “BOTH” if both inputs are true
//
//    Return “ONLY ONE” if only one of the inputs is true
        System.out.println("true and true : "+howTrue(true,true));
        System.out.println("false and false : "+howTrue(false,false));
        System.out.println("true and false : "+howTrue(true,false));
        System.out.println("false and true : "+howTrue(false,true));
    }
    
    public static String howTrue(boolean check1, boolean check2) {
        String result = "";
        if (check1 && check2) {
            result = "BOTH";
        }
        if ((check1 && !check2) || (!check1 && check2)) {
            result = "ONLY ONE";
        }
        if (!check1 && !check2) {
            result = "NEITHER";
        }
        return result;
    }
}
