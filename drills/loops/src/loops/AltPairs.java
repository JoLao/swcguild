/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

//Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien". 
//
//AltPairs("kitten") -> "kien"
//AltPairs("Chocolate") -> "Chole"
//AltPairs("CodingHorror") -> "Congrr"
public class AltPairs {

    public String altPairs(String str) {
        String  result = "";

        for (int i = 0; i <= str.length()-1; i = i + 4) {
 
            if (i+2 < str.length()) {
                result += str.substring(i, i + 2);
            } else {
                result += str.substring(i);
            }
        }
        return result;
    }
}
