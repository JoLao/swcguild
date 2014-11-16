/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.io.FileNotFoundException;
import vendingmachine.dao.VendingMachine2;
import vendingmachine.domain.Change;
import vendingmachine.domain.Item;

public class VendingMachineController2 {

    private VendingMachine2 vm = new VendingMachine2();
    private Item[][]       slot;
    private ConsoleIO      io = new ConsoleIO();

    public static void main(String[] args) {
        VendingMachineController2 vendingMachineController = new VendingMachineController2();
        vendingMachineController.run();
    }

    public void run() {
        boolean userDone = false;
        int[]   choice    = new int[2];
        double  money     = 0d;
        double  change    = 0d;
        String  quitSW    = "";
        Change  chge ;
        
        do {
            displayItemsInVendingMachine();            
            money  = askForMoney();
            choice = selectAnItem(money);
            if (money >= slot[choice[0]][choice[1]].getCost()) {
                change = money - slot[choice[0]][choice[1]].getCost();
                
                if (change > 0) {
                    chge = new Change(change);
                    displayChange(chge);
                    
                }
                System.out.println("Thank You!");
            } else {
                System.out.println("Not enough money.");                
            }
            quitSW = io.promptForString("Continue [y/n]? ");
            if (quitSW.equalsIgnoreCase("y")) {
                userDone = false;
            } else {
                userDone = true;
            }
        } while (!userDone);
    }

    private void displayItemsInVendingMachine() {

        Item     eachItem;
        
        try {
            slot = vm.loadItemsToVendingMachine();

            for (int i = 0; i < slot.length ; i++) {
                for (int j = 0; j < slot[i].length; j++) {
                    if (slot[i][j] != null) {
                        eachItem = slot[i][j];
                        System.out.print("["+i+""+j+"]" + eachItem.getName() + 
                                         " $" + eachItem.getCost()+ 
                                         "    ");
                        
                    } else {
                        System.out.print("["+i+""+j+"]");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Vendhing Machine is empty");
        }
    }
    
    private double askForMoney() {
        double num = 0d;
        
        do {
            num = io.promptForDouble("Please insert money : ");
        } while (num <= 0);
        
        return num;
    }

    private int[] selectAnItem(double m) {
        String itemNumStr = "";
        int[] xy       = new int[2];
        int   x        = 0;
        int   y        = 0;
        boolean itemAvailable = false;
        do {
            itemNumStr = io.promptForString("Enter slot number : ");
            if (itemNumStr.length() == 2) {
                try {
                    xy[0] = Integer.parseInt(itemNumStr.substring(0, 1));
                    xy[1] = Integer.parseInt(itemNumStr.substring(1, 2));
                    x     = xy[0];
                    y     = xy[1];
                    if (slot[x][y] != null && slot[x][y].getCount() > 0) {                        
                            itemAvailable = true;                        
                    } else {
                          System.out.println("Invalid slot number. Please try again");   
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid slot number. Please try again");
                }
            } else {
                System.out.println("Invalid slot number. Please try again");
            }
        } while (!itemAvailable);
        return xy;
    }
    
    private void displayChange(Change chge) {
        System.out.println("Here is your change: ");
        if (chge.getQuarters() > 0) {
            System.out.print(chge.getQuarters()+" quarters ");
        }
        if (chge.getDimes() > 0) {
            System.out.print(chge.getDimes()+" dimes ");
        }
        if (chge.getNickels() > 0) {
            System.out.println(chge.getNickels()+" nickels ");
        }
        if (chge.getPennies() > 0) {
            System.out.println(chge.getPennies()+" pennies");
        }
        System.out.println("");
    }
}

