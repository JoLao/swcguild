package com.swcguild.flooringmasteryspring.ui;

import com.swcguild.flooringmasteryspring.dao.OrdersDao;
import com.swcguild.flooringmasteryspring.domain.Order;
import com.swcguild.flooringmasteryspring.domain.Product;
import com.swcguild.flooringmasteryspring.domain.StateTax;
import com.swcguild.flooringmasteryspring.domain.User;
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
    OrdersDao orders;
    DateFormat df = new SimpleDateFormat("MMddYYYY");
    Date currentDate = new Date();
    String currentDateString = df.format(currentDate);

    Scanner userInput = new Scanner(System.in);
    User user;

    public void setcIO(ConsoleIO cIO) {
        this.cIO = cIO;
    }

    public void setOrders(OrdersDao orders) {
        this.orders = orders;
    }

    public void run() {
        //logon();
        String managerChoice = "";
        String choice = "";
        if (user != null) {
            try {
                load();
                do {
                    switch (choice = cIO.promptString(" ________________________________________________________\n"
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
                            + "|________________________________________________________|\n")) {
                        case "1":
                            displayOrders();
                            break;
                        case "2":
                            listAllProducts();
                            break;
                        case "3":
                            listAllStates();
                            break;
                        case "4":
                            addOrder();
                            break;
                        case "5":
                            editOrder();
                            break;
                        case "6":
                            removeOrder();
                            break;
                        case "7":
                            saveCurrentWork();
                            break;
                        case "8":
                            managerChoice = managerMenu();
                            if (managerChoice.equals("10")) {
                                break;
                            }
                        case "9":
                            quit();
                    }
                } while (!choice.equals("9"));

            } catch (FileNotFoundException fnf) {
                System.out.println("Application error. Please consult programmer. " + fnf.getMessage());
            }
        }
    }

    public void logon() {
        String userId;
        String password;
        int attempts = 1;
        try {
            orders.loadUsers();
            while (attempts <= 3) {
                userId = cIO.promptString("User Id: ");
                password = cIO.promptString("Password: ");
                user = orders.checkIfUserExists(userId, password);
                if (user != null) {
                    break;
                }
                attempts++;
            }
            if (attempts > 3) {
                cIO.displayMessage("Too many failed logon attempts. Program closing.");
            }

        } catch (FileNotFoundException fnf) {
            cIO.displayMessage("Cannot proceed. User file not found.");
        }
        run();
    }

    private void load() throws FileNotFoundException {
        String warningMessage = "";
        orders.loadConfig();
        orders.loadProductMap();
        orders.loadStateTaxMap();
        if (orders.getMode().equalsIgnoreCase("prod")) {
            try {
                orders.loadAllOrderFiles();
            } catch (FileNotFoundException fnf) {
                cIO.displayMessage("Order file missing" + fnf.getMessage());
            }
            if (!warningMessage.equals("")) {
                cIO.displayMessage("Warning: " + warningMessage);
            }
        }
    }

    private void displayOrders() {
        String displayDate = cIO.promptString("Please enter a date in MMDDYYYY format: ");
        Order[] orderMapByDate = orders.getListOfOrdersByDate(displayDate);
        if (orderMapByDate == null || orderMapByDate.length == 0) {
            cIO.displayMessage("There are no orders for the date you entered.");
        } else {
            for (Order orderMapByDate1 : orderMapByDate) {
                cIO.displayMessage("");
                cIO.displayMessage("");
                cIO.displayMessage("Order Number            : " + orderMapByDate1.getOrderNumber());
                cIO.displayMessage("Customer Name           : " + orderMapByDate1.getCustomerName());
                cIO.displayMessage("Product Type            : " + orderMapByDate1.getProductType());
                cIO.displayMessage("Area                    : " + orderMapByDate1.getArea() + " sq. ft.");
                cIO.displayMessage("Material Cost / sq. ft. : $" + orderMapByDate1.getCostPerSquareFoot());
                cIO.displayMessage("Labor Cost / sq. ft.    : $" + orderMapByDate1.getLaborCostPerSquareFoot());
                cIO.displayMessage(" ");
                cIO.displayMessage("Total Material Cost       $" + orderMapByDate1.getMaterialCost());
                cIO.displayMessage("Total Labor Cost        + $" + orderMapByDate1.getLaborCost());
                cIO.displayMessage("                          ----------");
                cIO.displayMessage("Order Subtotal            $" + (orderMapByDate1.getLaborCost() + orderMapByDate1.getMaterialCost()));
                cIO.displayMessage("Tax Rate (" + orderMapByDate1.getTaxRate() + "%)          $" + orderMapByDate1.getTax());
                cIO.displayMessage("                          __________");
                cIO.displayMessage("Order Total               $" + orderMapByDate1.getTotal());
                cIO.displayMessage("");
            }
        }
    }

    private void addOrder() {
        String state = "";
        String productType = "";
        String customerName = cIO.promptStringNotNull("What is the customer's name? ");
        do {
            state = cIO.promptStringNotNull("What state is the customer located in? (OH, PA, MI, or IN)");
            if (!orders.isStateAvailable(state)) {
                cIO.displayMessage("Please enter either OH, PA, MI, or IN.");
            }
        } while (!orders.isStateAvailable(state));
        do {
            productType = cIO.promptStringNotNull("What is the flooring type? (Carpet, Laminate, Tile, or Wood) ");
            if (!orders.isProductAvailable(productType)) {
                cIO.displayMessage("Please enter either Carpet, Laminate, Tile, or Wood.");
            }
        } while (!orders.isProductAvailable(productType));
        double area;
        do {
            area = cIO.promptDouble("What is the area in square feet?");
            if (area < 1) {
                cIO.displayMessage("Please enter a positive number.");
            }
        } while (area < 1);

        Order orderInfo = new Order(customerName, state, productType, area);
        String userCommit = cIO.promptString("Would you like to save this order? [Y]es or [N]o");
        if (userCommit.equalsIgnoreCase("Y")) {
            orders.addOrder(currentDateString, orderInfo);
            cIO.displayMessage("This order has been saved.");
        } else {
            cIO.displayMessage("This order has not been saved.");
        }
    }

    public String checkOrderDate() {
        String editDate = "";
        boolean checkOrderDate = false;
        while (checkOrderDate != true) {
            editDate = cIO.promptString("Please enter a date in MMDDYYYY format: (Press M to return to main menu.)");
            if (editDate.equalsIgnoreCase("m")) {
                editDate = "";
                break;
            }
            if (orders.isOrderListEmpty()) {
                cIO.displayMessage("There are no orders to edit.");
                break;
            }
            if (orders.isOrderByDateListEmpty(editDate)) {
                cIO.displayMessage("There are no orders from this date. Please enter another date.");
            }
            checkOrderDate = orders.checkOrderDate(editDate);
        }
        return editDate;
    }

    public Order checkOrderNumber(String orderDate) {
        int orderNumber;
        boolean checkOrderNumber = false;
        Order checkOrder = new Order();
        while (checkOrderNumber != true) {
            try {
                String sOrderNumber = cIO.promptString("Please enter an order number: (Press M to return to main menu.) ");
                orderNumber = Integer.parseInt(sOrderNumber);
            } catch (NumberFormatException nfe) {
                checkOrder.setCustomerName("");
                break;
            }
            checkOrder = orders.getOrder(orderDate, orderNumber);
            if (checkOrder != null) {
                checkOrderNumber = true;
            } else {
                cIO.displayMessage("TOrder number not found. Please enter again.");
            }
        }
        return checkOrder;
    }

    private void editOrder() {
        String editDate = checkOrderDate();
        if (editDate != null && !editDate.equals("")) {
            if (editDate.equals(currentDateString) || user.getSecurityLevel() == 10) {
                Order editOrder = checkOrderNumber(editDate);
                if (editOrder != null && !editOrder.getCustomerName().equals("")) {
                    cIO.displayMessage("Customer Name : " + editOrder.getCustomerName());
                    cIO.displayMessage("State         : " + editOrder.getState());
                    cIO.displayMessage("Product Type  : " + editOrder.getProductType());
                    cIO.displayMessage("Area          : " + editOrder.getArea());

                    String useredit = cIO.promptString("Are you sure you want to edit this order? [Y]es or [N]o");
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
                            if (!orders.isStateAvailable(state)) {
                                cIO.displayMessage("Please enter either OH, PA, MI, or IN.");
                            }
                        } while (!orders.isStateAvailable(state));
                        if (!state.equals("")) {
                            editOrder.setState(state);
                            editOrder.setTaxRate(orders.getStateTaxRate(state));
                        }
                        do {
                            System.out.println("Flooring Type (Carpet, Laminate, Tile, or Wood): " + editOrder.getProductType());
                            productType = userInput.nextLine();
                            if (productType.equals("")) {
                                break;
                            }
                            if (!orders.isProductAvailable(productType)) {
                                cIO.displayMessage("Please enter either Carpet, Laminate, Tile, or Wood.");
                            }
                        } while (!orders.isProductAvailable(productType));
                        if (!productType.equals("")) {
                            editOrder.setProductType(productType);
                            editOrder.setCostPerSquareFoot(orders.getProductCostPerSquareFoot(productType));
                            editOrder.setLaborCostPerSquareFoot(orders.getProductLaborCostPerSquareFoot(productType));
                        }
                        System.out.println("Area in Square Feet: " + editOrder.getArea());
                        do {
                            try {
                                area = Double.parseDouble(userInput.nextLine());
                                if (area < 1) {
                                    cIO.displayMessage("Please enter a positive number.");
                                } else {
                                    editOrder.setArea(area);
                                }
                            } catch (NumberFormatException nfe) {
                                break;
                            }
                        } while (area < 1);

                        editOrder.calculate();
                        cIO.displayMessage("This order has been updated.");
                    }
                }
            } else {
                cIO.displayMessage("You are not authorized to edit past orders.");
            }
        }
    }

    private void removeOrder() {
        String removeDate = checkOrderDate();
        if (removeDate != null && !removeDate.equals("")) {
            if (removeDate.equals(currentDateString) || user.getSecurityLevel() == 10) {
                Order removeOrderNumber = checkOrderNumber(removeDate);
                if (removeOrderNumber != null && !removeOrderNumber.getCustomerName().equals("")) {
                    if (removeOrderNumber != null) {
                        cIO.displayMessage("Customer Name : " + removeOrderNumber.getCustomerName());
                        cIO.displayMessage("Product Type  : " + removeOrderNumber.getProductType());
                        cIO.displayMessage("Area          : " + removeOrderNumber.getArea());
                        cIO.displayMessage("Subtotal      : " + (removeOrderNumber.getLaborCost() + removeOrderNumber.getMaterialCost()));
                        cIO.displayMessage("Tax           : " + removeOrderNumber.getTax());
                        cIO.displayMessage("Total         : " + removeOrderNumber.getTotal());
                        String userRemoved = cIO.promptString("Are you sure you want to delete this order? [Y]es or [N]o");
                        if (userRemoved.equalsIgnoreCase("y")) {
                            orders.removeOrder(removeDate, removeOrderNumber.getOrderNumber());
                            cIO.displayMessage("This order has been deleted.");
                        }
                    }
                }
            } else {
                cIO.displayMessage("You are not authorized to remove past orders.");
            }
        }
    }

    public String managerMenu() {
        String managerChoice = "";
        if (user.getSecurityLevel() == 10) {

            do {
                switch (managerChoice = cIO.promptString(" ________________________________________________________\n"
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
                        + "|________________________________________________________|\n")) {

                    case "1":
                        listAllProducts();
                        break;
                    case "2":
                        addAProduct();
                        break;
                    case "3":
                        editAProduct();
                        break;
                    case "4":
                        removeAProduct();
                        break;
                    case "5":
                        listAllStates();
                        break;
                    case "6":
                        addAState();
                        break;
                    case "7":
                        editAState();
                        break;
                    case "8":
                        removeAState();
                        break;
                    case "9":
                        saveManagerWork();
                        break;
                    case "10":
                        break;
                    case "11":
                        break;
                }
            } while (!(managerChoice.equals("10") || managerChoice.equals("11")));

        } else {
            cIO.displayMessage("You are not authorized to view the manager menu.");
            managerChoice = "10";
        }
        return managerChoice;
    }

    private void listAllProducts() {
        Product[] displayProducts = orders.getAllProducts();
        for (Product allProducts : displayProducts) {
            cIO.displayMessage("\nProduct Type: " + allProducts.getProductType() + "\nCost per square foot: $"
                    + allProducts.getCostPerSquareFoot() + "\nLabor cost per square foot: $" + allProducts.getLaborCostPerSquareFoot());
        }
    }

    private void addAProduct() {
        String productName;

        do {
            productName = cIO.promptStringNotNull("New product: ");
            if (orders.isProductAvailable(productName)) {
                cIO.displayMessage("Product already exists.");
            }
        } while (orders.isProductAvailable(productName));

        double costPerSquareFoot = cIO.promptDouble("Cost per square foot for " + productName + ": ");
        double laborCostPerSquareFoot = cIO.promptDouble("Labor cost per square foot for " + productName + ": ");

        orders.addProduct(productName, costPerSquareFoot, laborCostPerSquareFoot);
        cIO.displayMessage(productName + " has been added to inventory.");
    }

    private void editAProduct() {
        listAllProducts();
        String editProduct = "";
        double productCost = 0;
        double laborCost = 0;
        boolean productInList = true;
        boolean productUpdated = false;
        do {
            editProduct = cIO.promptStringNotNull("Product to be edited: ");
            productInList = orders.isProductAvailable(editProduct);
            if (!productInList) {
                cIO.displayMessage("That is not a product currently in inventory.");
            }
        } while (!productInList);

        Product p = orders.getProduct(editProduct);
        cIO.displayMessage("Product cost per square foot: " + p.getCostPerSquareFoot());
        do {
            try {
                productCost = Double.parseDouble(userInput.nextLine());
                if (productCost < 1) {
                    cIO.displayMessage("Please enter a positive number.");
                } else {
                    p.setCostPerSquareFoot(productCost);
                    productUpdated = true;
                }
            } catch (NumberFormatException nfe) {
                break;
            }
        } while (productCost < 1);

        cIO.displayMessage("Product labor cost per square foot: " + p.getCostPerSquareFoot());
        do {
            try {
                laborCost = Double.parseDouble(userInput.nextLine());
                if (laborCost < 1) {
                    cIO.displayMessage("Please enter a positive number.");
                } else {
                    p.setLaborCostPerSquareFoot(laborCost);
                    productUpdated = true;
                }
            } catch (NumberFormatException nfe) {
                break;
            }
        } while (laborCost < 1);

        if (productUpdated) {
            cIO.displayMessage("This product has been updated.");
        }
    }

    private void removeAProduct() {
        Product[] displayProducts = orders.getAllProducts();
        for (Product allProducts : displayProducts) {
            cIO.displayMessage("\nProduct Type: " + allProducts.getProductType());
        }
        String removeProduct;
        do {
            removeProduct = cIO.promptStringNotNull("Product to be removed: ");
            if (!orders.isProductAvailable(removeProduct)) {
                cIO.displayMessage("Product is not available.");
            }
        } while (!orders.isProductAvailable(removeProduct));

        String areYouSure = cIO.promptStringNotNull("Are you sure you want to remove " + removeProduct + " from the database? [Y]es or [N]o");
        if (areYouSure.equalsIgnoreCase("y")) {
            orders.removeProduct(removeProduct);
            cIO.displayMessage(removeProduct + " has been removed.");

        }
    }

    private void addAState() {
        String addState;
        double taxRate = 0;
        do {
            addState = cIO.promptStringNotNull("New state name: ");
            if (orders.isStateAvailable(addState)) {
                cIO.displayMessage("State already on file.");
            }
        } while (orders.isStateAvailable(addState));

        do {
            taxRate = cIO.promptDouble("Tax rate for new state (in %): ");
            if (taxRate < 0 || taxRate > 100) {
                cIO.displayMessage("Please enter a postive non-zero value in percentage.");
            }
        } while (taxRate <= 0 || taxRate > 100);

        orders.addStateTax(addState, taxRate);
        cIO.displayMessage(addState + " has been added.");
    }

    private void listAllStates() {
        StateTax[] displayStates = orders.getAllStateTaxes();
        for (StateTax allStates : displayStates) {
            cIO.displayMessage("\nState: " + allStates.getState() + "\nTax Rate: " + allStates.getTaxRate() + "%");
        }
    }

    private void editAState() {
        listAllStates();
        String editState;
        double taxRate = 0;
        do {
            editState = cIO.promptStringNotNull("\nWhich state would you like to edit?");
            if (!orders.isStateAvailable(editState)) {
                cIO.displayMessage("State not found.");
            }
        } while (!orders.isStateAvailable(editState));

        StateTax s = orders.getStateTax(editState);
        cIO.displayMessage("Tax Rate (%): " + s.getTaxRate());
        do {
            try {
                taxRate = Double.parseDouble(userInput.nextLine());
                if (taxRate < 0 || taxRate > 100) {
                    cIO.displayMessage("Please enter a postive non-zero value in percentage.");
                } else {
                    s.setTaxRate(taxRate);
                    cIO.displayMessage("State tax has been updated.");
                }
            } catch (NumberFormatException nfe) {
                break;
            }
        } while (taxRate <= 0 || taxRate > 100);

    }

    private void removeAState() {
        String removeState;
        do {
            removeState = cIO.promptStringNotNull("State to be removed: ");
            if (!orders.isStateAvailable(removeState)) {
                cIO.displayMessage("State is not on file.");
            }
        } while (!orders.isStateAvailable(removeState));

        String areYouSure = cIO.promptStringNotNull("Are you sure you want to remove " + removeState + " from the database? [Y]es or [N]o");
        if (areYouSure.equalsIgnoreCase("y")) {
            orders.removeStateTax(removeState);
            cIO.displayMessage(removeState + " has been removed.");
        }
    }

    private void saveManagerWork() {
        if (orders.getMode().equalsIgnoreCase("prod")) {
            try {
                orders.saveProducts();
                orders.saveStateTax();
                cIO.displayMessage("Your work has been saved");
            } catch (IOException ioException) {
                cIO.displayMessage("IO error! The save was not successful.");
            }
        } else {
            cIO.displayMessage("The program is in test mode, your work has not been saved to file.");
        }
    }

    private void saveCurrentWork() {
        if (orders.getMode().equalsIgnoreCase("prod")) {
            try {
                orders.saveAllOrders();
                if (user.getSecurityLevel() == 10) {
                    saveManagerWork();
                }
                cIO.displayMessage("Your work has been saved.");
            } catch (IOException ioException) {
                cIO.displayMessage("IO error! The save was not successful.");
            }
        } else {
            cIO.displayMessage("The program is in test mode, your work has not been saved to file.");
        }
    }

    private void quit() {
        if (cIO.promptString("Do you want to save your current work? [Y]es or [N]o").equalsIgnoreCase("y")) {
            saveCurrentWork();
        } else {
            cIO.displayMessage("This order has not been saved.");
        }
        if (cIO.promptString("Are you sure you want to quit? [Y]es or [N]o").equalsIgnoreCase("y")) {
            cIO.displayMessage("Thank you, goodbye!");
            System.exit(0);
        }
    }
}
