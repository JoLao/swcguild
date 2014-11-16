package flooringmasteryproject2.dao;


import flooringmasteryproject2.domain.Order;
import flooringmasteryproject2.domain.Product;
import flooringmasteryproject2.domain.StateTax;
import flooringmasteryproject2.domain.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OrdersDAO {

    private boolean workSaved = false;
    private int orderNumber;

    private ArrayList<String> orderFile            = new ArrayList<>();

    private HashMap<Integer, Order>    orderMap    = new HashMap<>();

    private HashMap<String, HashMap<Integer, Order>> orderList = new HashMap<>();

    public static final String ORDERLIST_FILE = "allordersfiles.txt";
    public static final String DELIMITER      = ",";

    public Order[] getListOfOrdersByDate(String orderDate) {

        if (orderList.containsKey(orderDate)) {
            orderMap = orderList.get(orderDate);

            if (!orderMap.isEmpty()) {
                Collection<Order> values = orderMap.values();
                return values.toArray(new Order[0]);
            }
        }
        return new Order[0];
    }

    public void addOrder(String orderDate, String customerName, String stateName, String productType, 
                         double area, double taxRate, double costPerSqFt, double laborCostPerSqFt) {

        boolean orderDatePresent = orderList.containsKey(orderDate);

        if (orderDatePresent) {
            orderMap    = orderList.get(orderDate);
            orderNumber = getLastOrderNumber();
        } else {
            orderNumber = 0;
            orderMap    = new HashMap<>();
        }

        orderNumber++;
        
        Order order = new Order(customerName, stateName, productType, area);
        order.setOrderNumber(orderNumber);
        order.setCostPerSquareFoot(costPerSqFt);
        order.setLaborCostPerSquareFoot(laborCostPerSqFt);
        order.setTaxRate(taxRate);
        order.calculate();

        orderMap.put(orderNumber, order);

        if (!orderDatePresent) {
            orderList.put(orderDate, orderMap);
            if (!isOrderFileInArrayList("Orders_" + orderDate + ".txt")) {
                orderFile.add("Orders_" + orderDate + ".txt");
            }
        }

    }

    public void addOrderFromFile(String orderDate, Order order) {

        boolean orderDatePresent = orderList.containsKey(orderDate);

        if (orderDatePresent) {
            orderMap = orderList.get(orderDate);
        }

        orderNumber = order.getOrderNumber();
        orderMap.put(orderNumber, order);

        if (!orderDatePresent) {
            orderList.put(orderDate, orderMap);
        }

    }

    public void removeOrder(String orderDate, int orderNumber) {
        boolean orderDatePresent = orderList.containsKey(orderDate);
        Order o;

        if (orderDatePresent) {
            orderMap = orderList.get(orderDate);
            o = orderMap.remove(orderNumber);
            if (orderMap.isEmpty()) {
                orderList.remove(orderDate);
            }
        }
    }

    public boolean isOrderFileInArrayList(String fileName) {
//    for (String fileName1 : orderFile) {
//            if (fileName.equalsIgnoreCase(fileName1)) {
//                return true;
//            }
//        }
//        return false;
        return orderFile.stream().anyMatch((fileName1) -> (fileName.equalsIgnoreCase(fileName1)));
    }

    public boolean isOrderListEmpty() {

        return orderList.isEmpty();
    }

    public boolean isOrderByDateListEmpty(String orderDate) {
        return !orderList.containsKey(orderDate);
    }

    public boolean checkOrderDate(String orderDate) {
        return orderList.containsKey(orderDate);
    }

    public Order getOrder(String orderDate, int orderNumber) {
        boolean orderDatePresent = orderList.containsKey(orderDate);
        Order o;

        if (orderDatePresent) {
            orderMap = orderList.get(orderDate);
            o = orderMap.get(orderNumber);
        } else {
            o = null;
        }
        return o;
    }

    public int getLastOrderNumber() {
//        Set<Integer> keys = orderMap.keySet();
//
//        Integer[] orderNumbers = keys.toArray(new Integer[0]);
//        Arrays.sort(orderNumbers);
//        return (orderNumbers.length > 0 ? orderNumbers[orderNumbers.length - 1] : 0);

        return (!orderMap.isEmpty() ? Collections.max(orderMap.keySet()) : 0);
    }

    public String loadAllOrderFiles() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(ORDERLIST_FILE)));
        String fileName = "";
        boolean isFileLoaded = false;
        boolean isOrderFileLoaded = false;
        String warningMessage = "";

        orderList = new HashMap<>();
        while (in.hasNext()) {
            fileName = in.nextLine();
            isOrderFileLoaded = true;
            try {
                isFileLoaded = loadOrdersPerFile(fileName);
                if (isFileLoaded) {
                    orderFile.add(fileName);
                } else {
                    deleteEmptyOrderFile(fileName);
                }
            } catch (FileNotFoundException fnf) {
                warningMessage += fnf.getMessage();
            }
        }

        in.close();

        if (!isOrderFileLoaded) {
            warningMessage = "Order Directory is empty. " + warningMessage;
        }

        return warningMessage;
    }

    public boolean loadOrdersPerFile(String orderFileName) throws FileNotFoundException {
        boolean isFileLoaded = false;

        Scanner in = new Scanner(new BufferedReader(new FileReader(orderFileName)));

        String orderDate = orderFileName.substring(7, 15);

//OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,
//LaborCost,Tax,Total
//1,Wise,OH,6.25,Wood,100.00,5.15,4.75,515.00,475.00,61.88,1051.88          
        orderMap = new HashMap<>();
        Order o;

        String   currentRecord;
        String[] currentTokens;
        String   customerName;

        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            //Order(String customerName, String state, String productType, double area)
            customerName = currentTokens[1];
                    
            if (customerName.contains("|")) {
                customerName = customerName.replace('|', ',');
            }
            o = new Order(customerName, currentTokens[2], currentTokens[4],
                    Double.parseDouble(currentTokens[5]));

            o.setOrderNumber(Integer.parseInt(currentTokens[0]));
            o.setTaxRate(Double.parseDouble(currentTokens[3]));
            o.setCostPerSquareFoot(Double.parseDouble(currentTokens[6]));
            o.setLaborCostPerSquareFoot(Double.parseDouble(currentTokens[7]));
            o.setMaterialCost(Double.parseDouble(currentTokens[8]));
            o.setLaborCost(Double.parseDouble(currentTokens[9]));
            o.setTax(Double.parseDouble(currentTokens[10]));
            o.setTotal(Double.parseDouble(currentTokens[11]));
            addOrderFromFile(orderDate, o);
            isFileLoaded = true;
        }
        in.close();
        return isFileLoaded;
    }

    public void saveAllOrders() throws IOException {
        boolean isThereData = false;
        PrintWriter out = new PrintWriter(new FileWriter(ORDERLIST_FILE));

//        for (int i = 0; i < orderFile.size(); i++) {
//            isThereData = savePerFile(orderFile.get(i));
//            if (isThereData) {
//                out.println(orderFile.get(i));
//            } else {
//                deleteEmptyOrderFile(orderFile.get(i));
//            }
//            out.flush();
//        }
        for (String orderFile1 : orderFile) {
            isThereData = savePerFile(orderFile1);
            if (isThereData) {
                out.println(orderFile1);
            } else {
                deleteEmptyOrderFile(orderFile1);
            }
            out.flush();
        }
        out.close();
        workSaved = true;
    }

    public boolean savePerFile(String orderFileName) throws IOException {
        boolean isThereData = false;

        PrintWriter out = new PrintWriter(new FileWriter(orderFileName));

        String orderDate = orderFileName.substring(7, 15);
        String customerName;

        Order[] orderArray = getListOfOrdersByDate(orderDate);

//        for (int i = 0; i < orderArray.length; i++) {
//
////OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,
////LaborCost,Tax,Total            
//            out.println(orderArray[i].getOrderNumber() + DELIMITER
//                    + orderArray[i].getCustomerName() + DELIMITER
//                    + orderArray[i].getState() + DELIMITER
//                    + orderArray[i].getTaxRate() + DELIMITER
//                    + orderArray[i].getProductType() + DELIMITER
//                    + orderArray[i].getArea() + DELIMITER
//                    + orderArray[i].getCostPerSquareFoot() + DELIMITER
//                    + orderArray[i].getLaborCostPerSquareFoot() + DELIMITER
//                    + orderArray[i].getMaterialCost() + DELIMITER
//                    + orderArray[i].getLaborCost() + DELIMITER
//                    + orderArray[i].getTax() + DELIMITER
//                    + orderArray[i].getTotal());
//            out.flush();
//            isThereData = true;
//        }

        for (Order orderArray1 : orderArray) {
//OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,
//LaborCost,Tax,Total
            customerName = orderArray1.getCustomerName();
            if (customerName.contains(",")) {
                customerName = customerName.replace(',', '|');
            }
            out.println(orderArray1.getOrderNumber() + DELIMITER
                      + customerName + DELIMITER
                      + orderArray1.getState() + DELIMITER
                      + orderArray1.getTaxRate() + DELIMITER
                      + orderArray1.getProductType() + DELIMITER
                      + orderArray1.getArea() + DELIMITER
                      + orderArray1.getCostPerSquareFoot() + DELIMITER
                      + orderArray1.getLaborCostPerSquareFoot() + DELIMITER
                      + orderArray1.getMaterialCost() + DELIMITER
                      + orderArray1.getLaborCost() + DELIMITER
                      + orderArray1.getTax() + DELIMITER
                      + orderArray1.getTotal());
            out.flush();
            isThereData = true;
        }
        out.close();
        return isThereData;
    }

    public void deleteEmptyOrderFile(String fileName) {
        File fName = new File(fileName);
        fName.delete();
    }

}
