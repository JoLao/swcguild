/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vendingmachine.domain;

/**
 *
 * @author apprentice
 */
public class Change {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    
    public Change(double change) {

        
        pennies = (int) (change * 100);
        
        quarters = (int) (pennies / 25);
        
        pennies = pennies - (quarters * 25);
        
        dimes = (int) (pennies / 10);
        
        pennies = pennies - (dimes * 10);
        
        nickels = (int) (pennies / 5);
        
        pennies = pennies - (nickels * 5);
        
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }
    
    
}
