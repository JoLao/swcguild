/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rpgsatchel;

/**
 *
 * @author apprentice
 */
public class Sword implements Item {
    
    @Override
    public String getItemName() {
        return "Sword";
    }
    
    @Override
    public int getItemWeight() {
        return 15;
    }
    
    public void sharpen() {
        System.out.println("Sharpening...");
    }
    
    public void swing() {
        System.out.println("Swing...");
    }
    
}
