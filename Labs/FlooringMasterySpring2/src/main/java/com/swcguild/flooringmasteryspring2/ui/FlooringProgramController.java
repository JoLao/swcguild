package com.swcguild.flooringmasteryspring2.ui;


import com.swcguild.flooringmasteryspring2.dao.FlooringMasteryServiceLayer;
import com.swcguild.flooringmasteryspring2.dao.FlooringMasteryServiceLayerImpl;
import com.swcguild.flooringmasteryspring2.domain.Order;
import com.swcguild.flooringmasteryspring2.domain.Product;
import com.swcguild.flooringmasteryspring2.domain.StateTax;
import com.swcguild.flooringmasteryspring2.domain.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class FlooringProgramController {

    ConsoleIO cIO;
    FlooringMasteryServiceLayer service;

    DateFormat df = new SimpleDateFormat("MMddYYYY");
    Date currentDate = new Date();
    String currentDateString = df.format(currentDate);
    Scanner userInput = new Scanner(System.in);
    User user;

    public void setService(FlooringMasteryServiceLayer service) {
        this.service = service;
    }


    public void setcIO(ConsoleIO cIO) {
        this.cIO = cIO;
    }

    public void run() {
        //logon();
        int choice;
        int managerChoice;
        if (user != null) {
            try {
                load();
                do {
                    choice = cIO.promptForInteger(" ________________________________________________________\n"
                            + "|                                                        |\n"
                            + "|                      MAIN MENU                         |\n"
                            + "|                                                        |\n"
                            + "|    Please make your selection from the menu below:     |\n"
                            + "|                                                        |\n"
                            + "|         1. Display Orders                              |\n"
                            + "|         2. List All Products                           |\n"
                            + "|         3. List All States                             |\n"
                            + "|         4. Add an Order                                |\n"
                            + "|         5. Edit an Order                               |\n"
                            + "|         6. Remove an Order                             |\n"
                            + "|         7. Save Current Work                           |\n"
                            + "|         8. Manager Options                             |\n"
                            + "|         9. Quit Program                                |\n"
                            + "|________________________________________________________|\n");
                    switch (choice) {
                        case 1:
                            displayOrders();
                            break;
                        case 2:
                            listAllProducts();
                            break;
                        case 3:
                            listAllStates();
                            break;
                        case 4:
                            addOrder();
                            break;
                        case 5:
                            editOrder();
                            break;
                        case 6:
                            removeOrder();
                            break;
                        case 7:
                            saveCurrentWork();
                            break;
                        case 8:
                            managerChoice = managerMenu();
                            if (managerChoice == 11) {
                                choice = 9;
                            }
                        case 9:
                            break;
                        default:
                            cIO.printStringLn("Invalid option.");
                    }
                } while (choice != 9);
            } catch (FileNotFoundException fnf) {
                System.out.println("Application error. Please consult programmer. " + fnf.getMessage());
            }
            quit();
        }
    }

    public void logon() {
        String userId;
        String password;
        int attempts = 1;
        try {
            service.loadUsers();
            while (attempts <= 3) {
                userId = cIO.promptForString("User Id : ");
                password = cIO.promptForString("Password: ");
                user = service.checkIfUserExists(userId, password);
                if (user != null) {
                    break;
                }
                attempts++;
            }
            if (attempts > 3) {
                cIO.printStringLn("Too many failed logon attempts. Program closing.");
            }

        } catch (FileNotFoundException fnf) {
            cIO.printStringLn("Cannot proceed. User file not found.");
        }
        run();
    }

    public void load() throws FileNotFoundException {
        String warningMessage = "";
        service.loadConfig();
        service.loadProductMap();
        service.loadStateTaxMap();

        try {
            service.loadAllOrderFiles();
        } catch (FileNotFoundException fnf) {
            cIO.printStringLn("Warning: Order file missing " + fnf.getMessage());
        }
        if (!warningMessage.equals("")) {
            cIO.printStringLn("Warning: " + warningMessage);
        }

    }

    public void displayOrders() {
        String displayDate = cIO.promptForString("Please enter a date in MMDDYYYY format: ");
        Order[] orderMapByDate = service.getListOfOrdersByDate(displayDate);
        if (orderMapByDate == null || orderMapByDate.length == 0) {
            cIO.printStringLn("There are no orders for the date you entered.");
        } else {
            for (Order orderMapByDate1 : orderMapByDate) {
                cIO.printStringLn("");
                cIO.printStringLn("");
                cIO.printStringLn("Order Number            : " + orderMapByDate1.getOrderNumber());
                cIO.printStringLn("Customer Name           : " + orderMapByDate1.getCustomerName());
                cIO.printStringLn("Product Type            : " + orderMapByDate1.getProductType());
                cIO.printStringLn("Area                    : " + orderMapByDate1.getArea() + " sq. ft.");
                cIO.printStringLn("Material Cost / sq. ft. : $" + orderMapByDate1.getCostPerSquareFoot());
                cIO.printStringLn("Labor Cost / sq. ft.    : $" + orderMapByDate1.getLaborCostPerSquareFoot());
                cIO.printStringLn(" ");
                cIO.printStringLn("Total Material Cost       $" + orderMapByDate1.getMaterialCost());
                cIO.printStringLn("Total Labor Cost        + $" + orderMapByDate1.getLaborCost());
                cIO.printStringLn("                          ----------");
                cIO.printStringLn("Order Subtotal            $" + (orderMapByDate1.getLaborCost() + orderMapByDate1.getMaterialCost()));
                cIO.printStringLn("Tax Rate (" + orderMapByDate1.getTaxRate() + "%)         $  " + orderMapByDate1.getTax());
                cIO.printStringLn("                          __________");
                cIO.printStringLn("Order Total               $" + orderMapByDate1.getTotal());
                cIO.printStringLn("");
            }
        }
    }

    public void addOrder() {
        String state = "";
        String productType = "";
        String customerName = cIO.promptForString("What is the customer's name? ");
        do {
            state = cIO.promptForString("What state is the customer located in? ");
            if (!service.isStateAvailable(state)) {
                cIO.printStringLn("Please enter either of the following:");
                listAllStates();
            }
        } while (!service.isStateAvailable(state));
        do {
            productType = cIO.promptForString("What is the flooring type? ");
            if (!service.isProductAvailable(productType)) {
                cIO.printStringLn(productType + " not available. Please enter either of the following:");
                listAllProducts();
            }
        } while (!service.isProductAvailable(productType));
        double area;
        do {
            area = cIO.promptForDouble("What is the area in square feet? ");
            if (area < 1) {
                cIO.printStringLn("Please enter a positive number.");
            }
        } while (area < 1);

        String userCommit = cIO.promptForString("Would you like to save this order? [Y]es or [N]o ");
        if (userCommit.equalsIgnoreCase("Y")) {
            service.addOrder(currentDateString, customerName, state, productType, area);
            cIO.printStringLn("This order has been saved.");
        } else {
            cIO.printStringLn("This order has not been saved.");
        }
    }

    public String checkOrderDate() {
        String editDate = "";
        boolean isOrderEmpty = true;
        while (isOrderEmpty) {
            editDate = cIO.promptForString("Please enter a date in MMDDYYYY format: (Press M to return to main menu.) ");
            if (editDate.equalsIgnoreCase("m")) {
                editDate = "";
                break;
            }
            if (service.isOrderListEmpty()) {
                cIO.printStringLn("There are no orders to edit.");
                break;
            }
            if (service.isOrderByDateListEmpty(editDate)) {
                cIO.printStringLn("There are no orders from this date. Please enter another date.");
            }
            isOrderEmpty = service.isOrderByDateListEmpty(editDate);
        }
        return editDate;
    }

    public Order checkOrderNumber(String orderDate) {
        int orderNumber;
        boolean checkOrderNumber = false;
        Order checkOrder = null;
        while (checkOrderNumber != true) {
            try {
                String sOrderNumber = cIO.promptForString("Please enter an order number: (Press M to return to main menu.) ");
                orderNumber = Integer.parseInt(sOrderNumber);
            } catch (NumberFormatException nfe) {                
                break;
            }
            checkOrder = service.getOrder(orderDate, orderNumber);
            if (checkOrder != null) {
                checkOrderNumber = true;
            } else {
                cIO.printStringLn("Order number not found. Please enter again.");
            }
        }
        return checkOrder;
    }

    public void editOrder() {        
        String editDate = checkOrderDate();
        if (editDate != null && !editDate.equals("")) {
            if (editDate.equals(currentDateString) || user.getSecurityLevel() == 10) {
                Order editOrder = checkOrderNumber(editDate);
                if (editOrder != null) {
                    cIO.printStringLn("Customer Name : " + editOrder.getCustomerName());
                    cIO.printStringLn("State         : " + editOrder.getState());
                    cIO.printStringLn("Product Type  : " + editOrder.getProductType());
                    cIO.printStringLn("Area          : " + editOrder.getArea());

                    String useredit = cIO.promptForString("Are you sure you want to edit this order? [Y]es or [N]o ");
                    if (useredit.equalsIgnoreCase("y")) {
                        String state = "";
                        String productType = "";
                        double area = 0;
                        System.out.println("Customer's name: " + editOrder.getCustomerName());
                        String customerName = userInput.nextLine();
                        if (!customerName.equals("")) {
                            editOrder.setCustomerName(customerName);
                        }
                        do {
                            System.out.println("State (OH, PA, MI, or IN): " + editOrder.getState());
                            state = userInput.nextLine();
                            if (state.equals("")) {
                                break;
                            }
                            if (!service.isStateAvailable(state)) {
                                cIO.printStringLn("Please enter either OH, PA, MI, or IN.");
                            }
                        } while (!service.isStateAvailable(state));
                        if (!state.equals("")) {
                            editOrder.setState(state);
                            editOrder.setTaxRate(service.getStateTaxRate(state));
                        }
                        do {
                            System.out.println("Flooring Type (Carpet, Laminate, Tile, or Wood): " + editOrder.getProductType());
                            productType = userInput.nextLine();
                            if (productType.equals("")) {
                                break;
                            }
                            if (!service.isProductAvailable(productType)) {
                                cIO.printStringLn("Please enter either Carpet, Laminate, Tile, or Wood.");
                            }
                        } while (!service.isProductAvailable(productType));
                        if (!productType.equals("")) {
                            editOrder.setProductType(productType);
                            editOrder.setCostPerSquareFoot(service.getProductCostPerSquareFoot(productType));
                            editOrder.setLaborCostPerSquareFoot(service.getProductLaborCostPerSquareFoot(productType));
                        }
                        System.out.println("Area in Square Feet: " + editOrder.getArea());
                        do {
                            try {
                                area = Double.parseDouble(userInput.nextLine());
                                if (area < 1) {
                                    cIO.printStringLn("Please enter a positive number.");
                                } else {
                                    editOrder.setArea(area);
                                }
                            } catch (NumberFormatException nfe) {
                                break;
                            }
                        } while (area < 1);

                        editOrder.calculate();
                        cIO.printStringLn("This order has been updated.");
                    }
                }
            } else {
                cIO.printStringLn("You are not authorized to edit past orders.");
            }
        }
    }

    public void removeOrder() {
        String removeDate = checkOrderDate();
        if (removeDate != null && !removeDate.equals("")) {
            if (removeDate.equals(currentDateString) || user.getSecurityLevel() == 10) {
                Order removeOrderNumber = checkOrderNumber(removeDate);
                if (removeOrderNumber != null && !removeOrderNumber.getCustomerName().equals("")) {
                    if (removeOrderNumber != null) {
                        cIO.printStringLn("Customer Name : " + removeOrderNumber.getCustomerName());
                        cIO.printStringLn("Product Type  : " + removeOrderNumber.getProductType());
                        cIO.printStringLn("Area          : " + removeOrderNumber.getArea());
                        cIO.printStringLn("Subtotal      : " + (removeOrderNumber.getLaborCost() + removeOrderNumber.getMaterialCost()));
                        cIO.printStringLn("Tax           : " + removeOrderNumber.getTax());
                        cIO.printStringLn("Total         : " + removeOrderNumber.getTotal());
                        String userRemoved = cIO.promptForString("Are you sure you want to delete this order? [Y]es or [N]o ");
                        if (userRemoved.equalsIgnoreCase("y")) {
                            service.removeOrder(removeDate, removeOrderNumber.getOrderNumber());
                            cIO.printStringLn("This order has been deleted.");
                        }
                    }
                }
            } else {
                cIO.printStringLn("You are not authorized to remove past orders.");
            }
        }
    }

    public int managerMenu() {
        int managerChoice = -1;
        if (user.getSecurityLevel() == 10) {
            do {
                managerChoice = cIO.promptForInteger(" ________________________________________________________\n"
                        + "|                                                        |\n"
                        + "|                     MANAGER MENU                       |\n"
                        + "|                                                        |\n"
                        + "|    Please make your selection from the menu below:     |\n"
                        + "|                                                        |\n"
                        + "|         1. List Existing Products                      |\n"
                        + "|         2. Add a Product                               |\n"
                        + "|         3. Edit an Existing Product                    |\n"
                        + "|         4. Remove an Existing Product                  |\n"
                        + "|         5. List All States                             |\n"
                        + "|         6. Add a New State                             |\n"
                        + "|         7. Edit an Existing State                      |\n"
                        + "|         8. Remove an Existing State                    |\n"
                        + "|         9. Save Current Work                           |\n"
                        + "|        10. Return to Main Menu                         |\n"
                        + "|        11. Quit Flooring Program                       |\n"
                        + "|________________________________________________________|\n");

                switch (managerChoice) {

                    case 1:
                        listAllProducts();
                        break;
                    case 2:
                        addAProduct();
                        break;
                    case 3:
                        editAProduct();
                        break;
                    case 4:
                        removeAProduct();
                        break;
                    case 5:
                        listAllStates();
                        break;
                    case 6:
                        addAState();
                        break;
                    case 7:
                        editAState();
                        break;
                    case 8:
                        removeAState();
                        break;
                    case 9:
                        saveManagerWork();
                        break;
                    case 10:
                    case 11:
                        break;
                    default:
                        cIO.printStringLn("Invalid option.");
                }
            } while (managerChoice > 0 && managerChoice < 10);

        } else {
            cIO.printStringLn("You are not authorized to view the manager menu.");
        }
        return managerChoice;
    }

    public void listAllProducts() {
        Product[] displayProducts = service.getAllProducts();
        for (Product allProducts : displayProducts) {
            cIO.printStringLn("\nProduct Type: " + allProducts.getProductType() + "\nCost per square foot: $"
                    + allProducts.getCostPerSquareFoot() + "\nLabor cost per square foot: $" + allProducts.getLaborCostPerSquareFoot());
        }
    }

    public void addAProduct() {
        String productName;

        do {
            productName = cIO.promptForString("New product: ");
            if (service.isProductAvailable(productName)) {
                cIO.printStringLn("Product already exists.");
            }
        } while (service.isProductAvailable(productName));

        double costPerSquareFoot = cIO.promptForDouble("Cost per square foot for " + productName + ": ");
        double laborCostPerSquareFoot = cIO.promptForDouble("Labor cost per square foot for " + productName + ": ");

        service.addProduct(productName, costPerSquareFoot, laborCostPerSquareFoot);
        cIO.printStringLn(productName + " has been added to inventory.");
    }

    public void editAProduct() {
        listAllProducts();
        String editProduct = "";
        double productCost = 0;
        double laborCost = 0;
        boolean productInList = true;
        boolean productUpdated = false;
        do {
            editProduct = cIO.promptForString("Product to be edited: ");
            productInList = service.isProductAvailable(editProduct);
            if (!productInList) {
                cIO.printStringLn("That is not a product currently in inventory.");
            }
        } while (!productInList);

        Product p = service.getProduct(editProduct);
        cIO.printStringLn("Product cost per square foot: " + p.getCostPerSquareFoot());
        do {
            try {
                productCost = Double.parseDouble(userInput.nextLine());
                if (productCost < 1) {
                    cIO.printStringLn("Please enter a positive number.");
                } else {
                    p.setCostPerSquareFoot(productCost);
                    productUpdated = true;
                }
            } catch (NumberFormatException nfe) {
                break;
            }
        } while (productCost < 1);

        cIO.printStringLn("Product labor cost per square foot: " + p.getCostPerSquareFoot());
        do {
            try {
                laborCost = Double.parseDouble(userInput.nextLine());
                if (laborCost < 1) {
                    cIO.printStringLn("Please enter a positive number.");
                } else {
                    p.setLaborCostPerSquareFoot(laborCost);
                    productUpdated = true;
                }
            } catch (NumberFormatException nfe) {
                break;
            }
        } while (laborCost < 1);

        if (productUpdated) {
            cIO.printStringLn("This product has been updated.");
        }
    }

      public void removeAProduct() {
        Product[] displayProducts = service.getAllProducts();
        for (Product allProducts : displayProducts) {
            cIO.printStringLn("\nProduct Type: " + allProducts.getProductType());
        }
        String removeProduct;
        do {
            removeProduct = cIO.promptForString("Product to be removed: ");
            if (!service.isProductAvailable(removeProduct)) {
                cIO.printStringLn("Product is not available.");
            }
        } while (!service.isProductAvailable(removeProduct));

        String areYouSure = cIO.promptForString("Are you sure you want to remove " + removeProduct + " from the database? [Y]es or [N]o");
        if (areYouSure.equalsIgnoreCase("y")) {
            service.removeProduct(removeProduct);
            cIO.printStringLn(removeProduct + " has been removed.");

        }
    }

    public void addAState() {
        String addState;
        double taxRate = 0;
        do {
            addState = cIO.promptForString("New state name: ");
            if (service.isStateAvailable(addState)) {
                cIO.printStringLn("State already on file.");
            }
        } while (service.isStateAvailable(addState));

        do {
            taxRate = cIO.promptForDouble("Tax rate for new state (in %): ");
            if (taxRate < 0 || taxRate > 100) {
                cIO.printStringLn("Please enter a postive non-zero value in percentage.");
            }
        } while (taxRate <= 0 || taxRate > 100);

        service.addStateTax(addState, taxRate);
        cIO.printStringLn(addState + " has been added.");
    }

    public void listAllStates() {
        StateTax[] displayStates = service.getAllStateTaxes();
        for (StateTax allStates : displayStates) {
            cIO.printStringLn("\nState: " + allStates.getState() + "\nTax Rate: " + allStates.getTaxRate() + "%");
        }
    }

    public void editAState() {
        listAllStates();
        String editState;
        double taxRate = 0;
        do {
            editState = cIO.promptForString("\nWhich state would you like to edit?");
            if (!service.isStateAvailable(editState)) {
                cIO.printStringLn("State not found.");
            }
        } while (!service.isStateAvailable(editState));

        StateTax s = service.getStateTax(editState);
        cIO.printStringLn("Tax Rate (%): " + s.getTaxRate());
        do {
            try {
                taxRate = Double.parseDouble(userInput.nextLine());
                if (taxRate < 0 || taxRate > 100) {
                    cIO.printStringLn("Please enter a postive non-zero value in percentage.");
                } else {
                    s.setTaxRate(taxRate);
                    cIO.printStringLn("State tax has been updated.");
                }
            } catch (NumberFormatException nfe) {
                break;
            }
        } while (taxRate <= 0 || taxRate > 100);

    }

    public void removeAState() {
        String removeState;
        do {
            removeState = cIO.promptForString("State to be removed: ");
            if (!service.isStateAvailable(removeState)) {
                cIO.printStringLn("State is not on file.");
            }
        } while (!service.isStateAvailable(removeState));

        String areYouSure = cIO.promptForString("Are you sure you want to remove " + removeState + " from the database? [Y]es or [N]o");
        if (areYouSure.equalsIgnoreCase("y")) {
            service.removeStateTax(removeState);
            cIO.printStringLn(removeState + " has been removed.");
        }
    }

    public void saveManagerWork() {
        if (service.getMode().equalsIgnoreCase("prod")) {
            try {
                service.saveProducts();
                service.saveStateTax();
                cIO.printStringLn("Your work has been saved (Manager Menu).");
            } catch (IOException ioException) {
                cIO.printStringLn("IO error! The save was not successful.");
            }
        } else {
            cIO.printStringLn("The program is in test mode, your work has not been saved to file.");
        }
    }

    public void saveCurrentWork() {
        if (service.getMode().equalsIgnoreCase("prod")) {
            try {
                service.saveAllOrders();
                if (user.getSecurityLevel() == 10) {
                    saveManagerWork();
                }
                cIO.printStringLn("Your work has been saved (Main Menu).");
            } catch (IOException ioException) {
                cIO.printStringLn("IO error! The save was not successful.");
            }
        } else {
            cIO.printStringLn("The program is in test mode, your work has not been saved to file.");
        }
    }

    public void quit() {
        if (cIO.promptForString("Do you want to save your current work? [Y]es or [N]o ").equalsIgnoreCase("y")) {
            saveCurrentWork();
        } else {
            cIO.printStringLn("This order has not been saved.");
        }
        if (cIO.promptForString("Are you sure you want to quit? [Y]es or [N]o ").equalsIgnoreCase("y")) {
            cIO.printStringLn("Thank you, goodbye!");
            System.exit(0);
        }
    }
}
