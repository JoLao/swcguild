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
public class Potion implements MagicalItem {

    @Override
    public int getItemSpellPower() {
        return 23;
    }

    @Override
    public String getItemName() {
        return "Potion";
    }

    @Override
    public int getItemWeight() {
        return 1;
    }
    
    
}
