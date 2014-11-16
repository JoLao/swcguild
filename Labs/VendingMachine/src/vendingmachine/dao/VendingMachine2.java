
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static vendingmachine.dao.VendingMachine.DELIMITER;
import static vendingmachine.dao.VendingMachine.INVENTORY_FILE;
import vendingmachine.domain.Item;

public class VendingMachine2 {

    //private ArrayList<Item> slots      = new ArrayList<>();    
    private Item[][] slot = new Item[5][5];
    private final int X = 5;
    private final int Y = 5;
    
    public static final String INVENTORY_FILE = "vendingmachineinventory.txt";
    public static final String DELIMITER = "::";
    
    
    private boolean sufficientUserFund(int x, int y, double money) {
        return (money >= slot[x][y].getCost() ? true : false);
    }
    
    public double vendItem(int x, int y, double money) {
        double change = 0;
        
        if (slot[x][y].getCount() > 0) {
            if (sufficientUserFund(x, y, money)) {
                change = money - slot[x][y].getCost();
                slot[x][y].subtractCount();
            } else {
                change = -1;
            }
        }
        
        return change;
        
    }
    
    public Item[][] loadItemsToVendingMachine() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        
        String currentRecord;
        String[] currentToken;
        Item    individualItem;
        int      x = 0;
        int      y = 0;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentToken  = currentRecord.split(DELIMITER);
            individualItem = new Item(currentToken[0],Double.parseDouble(currentToken[1]),
                                  Integer.parseInt(currentToken[2]));
            //slots.add(individualItem);
            slot[x][y] = individualItem;            
            y++;            
            if (y > Y-1) {
                x++;
                y = 0;
            }
            if (x > X-1) {
                System.out.println("No more space in vending machine for "+individualItem.getName());
                break;
            }
        }
        in.close();
        return slot;
    }
        public void saveInventoryToFile() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(INVENTORY_FILE));

        for (int i = 0; i < slot[i].length; i++) {
            for (int j = 0; j < slot[j].length; j ++)
            out.println(slot[i][j].getName() + DELIMITER + slot[i][j].getCost() + DELIMITER + 
                        slot[i][j].getCount());
            out.flush();
        }
        out.close();
    }
    
}
