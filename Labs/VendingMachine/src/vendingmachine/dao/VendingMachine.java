package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import vendingmachine.domain.Item;

/**
 *
 * @author apprentice
 */
public class VendingMachine {
//private ArrayList<Item> slots = new ArrayList<>();

    private Item[] slot = new Item[4];
    public static final String INVENTORY_FILE = "VendingMachineInventory.txt";
    public static final String DELIMITER = "::";

    public boolean sufficientUserFund(int x, double money) {
        return (money >= slot[x].getCost() ? true : false);
    }

    public double vendItem(int x, double money) {
        double change = 0;
        if (slot[x].getCount() > 0) {
            change = money - slot[x].getCost();
            slot[x].subtractCount();
        }
        return change;
    }

    public Item[] loadItemsToVendingMachine() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        String currentRecord;
        String[] currentToken;
        Item individualItem;
        int x = 0;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentToken = currentRecord.split(DELIMITER);
            individualItem = new Item(currentToken[0], Double.parseDouble(currentToken[1]),
                    Integer.parseInt(currentToken[2]));
            //slots.add(individualItem);
            slot[x] = individualItem;
            x++;
            if (x > 4) {
                System.out.println("No more space in vending machine for " + individualItem.getName());
                break;
            }
        }
        in.close();
        return slot;
    }

    public void saveInventoryToFile() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        for (int i = 0; i < slot.length; i++) {
            out.println(slot[i].getName() + DELIMITER + slot[i].getCost() + DELIMITER + slot[i].getCount());
            out.flush();
        }
        out.close();
    }
}
