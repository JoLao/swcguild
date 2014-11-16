/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;

/**
 *
 * @author apprentice
 */
public class Strings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RotateRight2 test = new RotateRight2();
        //Rotateleft2("Hello") -> "lloHe"
        //Rotateleft2("java") -> "vaja"
        //Rotateleft2("Hi") -> "Hi"
        String result = test.rotateRight2("Hello");
        System.out.println("Hello".length() - 2);
        System.out.println(result);
    }
    
}
