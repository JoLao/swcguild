
package vendingmachine.ui;

import java.io.FileNotFoundException;
import vendingmachine.dao.VendingMachine;
import vendingmachine.domain.Change;
import vendingmachine.domain.Item;


public class VendingMachineController {

    private ConsoleIO cIO = new ConsoleIO();
    private VendingMachine vendMachine = new VendingMachine();
//private Change changeDue = new Change();
    Double money;
    Integer userSelection;
    Double change;
    private final String DELIMITER = "::";

    public static void main(String[] args) throws Exception {
        VendingMachineController vend = new VendingMachineController();
        vend.run();
    }

    public void run() throws Exception {
        loadItemsToVendingMachine();
        enterMoney();
        userSelection();
        saveInventoryToFile();
    }

    public void loadItemsToVendingMachine() throws FileNotFoundException {
        Item[] inventory = vendMachine.loadItemsToVendingMachine();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getCount() > 0) {
                System.out.println((i + 1) + ". " + inventory[i].getName() + " " + inventory[i].getCost());
            }
        }
    }

    public void enterMoney() {
        money = cIO.promptForDouble("Please enter money in order to vend: ");
    }

    public void userSelection() {
        int userSelection;
        boolean askItem = true;
        while (askItem) {
            userSelection = cIO.promptForInteger("Please enter your item selection: ");
            boolean vending = true;
            int choice;
            do {
                Boolean enoughMoney = vendMachine.sufficientUserFund(userSelection - 1, money);
                if (enoughMoney) {
                    change = vendMachine.vendItem(userSelection - 1, money);
                    cIO.printString("Your item has been vended.");
                    returnChange(change);
                    vending = false;
                    askItem = false;
                } else {
                    choice = insufficientMoney();
                    if (choice == 1) {
                        vending = true;
                    }
                    if (choice == 2) {
                        vending = false;
                    }
                    if (choice == 3) {
                        vending = false;
                        askItem = false;
                    }
                }
            } while (vending);
        }
    }

    public int insufficientMoney() {
        int insufficient$Selection = cIO.promptForInteger("Check selection price and choose from the menu below: \n 1. Enter more money \n 2. Make another selection \n 3. Return your money and quit");
        switch (insufficient$Selection) {
            case 1:
                Double additionalMoney = cIO.promptForDouble("Please enter additional money to receieve this item");
                money += additionalMoney;
                break;
            case 2:
// userSelection();
                break;
            default:
                cIO.printString("Your change of " + money + " has been returned.");
                quit();
        }
        return insufficient$Selection;
    }

    public void returnChange(double change) {
        Change changeCalculation = new Change(change);
        if (change > 0) {
            cIO.printString("Your change is: ");
            if (changeCalculation.getQuarters() > 0) {
                cIO.printString(changeCalculation.getQuarters() + " quarter(s)");
            }
            if (changeCalculation.getDimes() > 0) {
                cIO.printString(changeCalculation.getDimes() + " dime(s)");
            }
            if (changeCalculation.getNickels() > 0) {
                cIO.printString(changeCalculation.getNickels() + " nickel(s)");
            }
            if (changeCalculation.getPennies() > 0) {
                cIO.printString(changeCalculation.getPennies() + " pennies");
            }
        } else {
            cIO.printString("You have no change. Thank you!");
        }
    }

    public void saveInventoryToFile() throws Exception {
        vendMachine.saveInventoryToFile();
    }

    private void quit() {
        if (cIO.promptForString("Are you sure you want to quit? [Y]es or [N]o").equalsIgnoreCase("y")) {
            cIO.printString("Thank you, goodbye!");
            System.exit(0);
        }
    }
}
