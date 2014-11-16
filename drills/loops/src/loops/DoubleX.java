/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

//Given a string, return true if the first instance of "x" in the string is immediately 
//followed by another "x". 
//
//DoubleX("axxbb") -> true
//DoubleX("axaxxax") -> false
//DoubleX("xxxxx") -> true
public class DoubleX {

    public boolean doubleX(String str) {
          
          for (int i = 0; i < str.length() - 1; i++) {
              if (str.charAt(i) == 'x') {
                  if (str.charAt(i+1) == 'x') {
                      return true;
                  } else {
                      return false;
                  }
              }
          }
          return false;
    }
}
