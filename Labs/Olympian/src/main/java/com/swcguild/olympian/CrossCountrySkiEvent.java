/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.olympian;

/**
 *
 * @author apprentice
 */
public class CrossCountrySkiEvent implements Event {

    @Override
    public String compete() {
       System .out.println("Skiing.  Really Fast.  Cross Country.  Even up hills."); 
       return  "CrossCountrySki"; 
    }
    
}
