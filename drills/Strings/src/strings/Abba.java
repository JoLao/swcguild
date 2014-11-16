/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strings;

//Given two Strings, a and b, return the result of putting them together in the order
//abba, e.g. "Hi" and "Bye" returns "HiByeByeHi". 
//
//Abba("Hi", "Bye") -> "HiByeByeHi"
//Abba("Yo", "Alice") -> "YoAliceAliceYo"
//Abba("What", "Up") -> "WhatUpUpWhat"
public class Abba {

    public String abba(String a, String b) {
        return a+b+b+a;
    }
}
