/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package loops;

//Given 2 strings, a and b, return the number of the positions where they contain 
//the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", 
//"aa", and "az" substrings appear in the same place in both strings. 
//
//SubStringMatch("xxcaazz", "xxbaaz") -> 3
//SubStringMatch("abc", "abc") -> 2
//SubStringMatch("abc", "axc") -> 0


public class SubStringMatch {
   public int subStringMatch(String a, String b) {
       int count = 0;
       String aSub, bSub;
       
       for (int i = 1; i < a.length(); i++) {
           if ((i+1) <= b.length()) {
               aSub = a.substring(i-1, i+1);
               bSub = b.substring(i-1, i+1);
               if (aSub.equals(bSub)) {
                   count++;
               }
           }
       }
       return count;
    }
} 

