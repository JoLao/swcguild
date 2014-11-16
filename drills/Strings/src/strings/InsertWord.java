/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given an "out" String length 4, such as "<<>>", and a word, return a new String 
//where the word is in the middle of the out String, e.g. "<<word>>".
//
//Hint: SubStrings are your friend here 
//
//InsertWord("<<>>", "Yay") -> "<<Yay>>"
//InsertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
//InsertWord("[[]]", "word") -> "[[word]]"
public class InsertWord {

    public String InsertWord(String container, String word) {
        return container.substring(0, 2)+word+container.substring(2, 4);
    }
}
