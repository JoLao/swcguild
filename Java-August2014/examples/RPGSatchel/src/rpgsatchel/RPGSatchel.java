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
public class RPGSatchel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sword weapon = new Sword();
        Sheild protection = new Sheild("Large Sheild", 30);
        Satchel backpack = new Satchel(50);
        
        backpack.addToSatchel(weapon);
        backpack.addToSatchel(protection);
        
        Item magic = new Potion();
        backpack.addToSatchel(magic);
        
        String[] items = backpack.listItemsInSatchel();
        
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
    
    
}
