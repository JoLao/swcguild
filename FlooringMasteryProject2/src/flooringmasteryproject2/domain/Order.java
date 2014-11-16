package flooringmasteryproject2.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

public class Order implements Comparable<Order> {

    private int    orderNumber;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double costPerSquareFoot;
    private double laborCostPerSquareFoot;
    private double materialCost;
    private double laborCost;
    private double tax;
    private double total;

    public Order() {
        
    }
//OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total
//1,Wise,OH,6.25,Wood,100.00,5.15,4.75,515.00,475.00,61.88,1051.88      
    public Order(String customerName, String state, String productType, double area) {
        this.customerName = customerName;
        this.state        = state.toUpperCase();
        this.productType  = productType.toUpperCase();
        this.area         = area;
    }

    public void calculate() {
        BigDecimal bd;
        materialCost = area * costPerSquareFoot;
        bd = new BigDecimal(materialCost).setScale(2, RoundingMode.HALF_EVEN);
        materialCost = bd.doubleValue();
        
        laborCost = area * laborCostPerSquareFoot;
        bd = new BigDecimal(laborCost).setScale(2, RoundingMode.HALF_EVEN);
        laborCost = bd.doubleValue();
        
        tax = (materialCost + laborCost) * taxRate / 100;        
        bd = new BigDecimal(tax).setScale(2, RoundingMode.HALF_EVEN);
        tax = bd.doubleValue();
        
        total = materialCost + laborCost + tax;        
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state.toUpperCase();
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType.toUpperCase();
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(double costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public double getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(double laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int compareTo(Order compareOrder) {
        int cmp = Integer.valueOf(this.orderNumber).compareTo(Integer.valueOf(compareOrder.orderNumber));

        if (cmp != 0) {
            return cmp;
        }

        cmp = this.customerName.compareToIgnoreCase(compareOrder.customerName);
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.state.compareToIgnoreCase(compareOrder.state);
        if (cmp != 0) {
            return cmp;
        }

        cmp = Double.valueOf(this.taxRate).compareTo(compareOrder.taxRate);
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.productType.compareToIgnoreCase(compareOrder.productType);
        if (cmp != 0) {
            return cmp;
        }

        cmp = Double.valueOf(this.area).compareTo(compareOrder.area);
        if (cmp != 0) {
            return cmp;
        }

        cmp = Double.valueOf(this.costPerSquareFoot).compareTo(compareOrder.costPerSquareFoot);
        if (cmp != 0) {
            return cmp;
        }

        cmp = Double.valueOf(this.laborCostPerSquareFoot).compareTo(compareOrder.laborCostPerSquareFoot);
        if (cmp != 0) {
            return cmp;
        }

        cmp = Double.valueOf(this.materialCost).compareTo(compareOrder.materialCost);
        if (cmp != 0) {
            return cmp;
        }
        cmp = Double.valueOf(this.laborCost).compareTo(compareOrder.laborCost);
        if (cmp != 0) {
            return cmp;
        }
        cmp = Double.valueOf(this.tax).compareTo(compareOrder.tax);
        if (cmp != 0) {
            return cmp;
        }
        return Double.valueOf(this.total).compareTo(compareOrder.total);        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.orderNumber;
        hash = 29 * hash + Objects.hashCode(this.customerName);
        hash = 29 * hash + Objects.hashCode(this.state);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.taxRate) ^ (Double.doubleToLongBits(this.taxRate) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.productType);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.area) ^ (Double.doubleToLongBits(this.area) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.costPerSquareFoot) ^ (Double.doubleToLongBits(this.costPerSquareFoot) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.laborCostPerSquareFoot) ^ (Double.doubleToLongBits(this.laborCostPerSquareFoot) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.materialCost) ^ (Double.doubleToLongBits(this.materialCost) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.laborCost) ^ (Double.doubleToLongBits(this.laborCost) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.tax) ^ (Double.doubleToLongBits(this.tax) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (Double.doubleToLongBits(this.taxRate) != Double.doubleToLongBits(other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (Double.doubleToLongBits(this.area) != Double.doubleToLongBits(other.area)) {
            return false;
        }
        if (Double.doubleToLongBits(this.costPerSquareFoot) != Double.doubleToLongBits(other.costPerSquareFoot)) {
            return false;
        }
        if (Double.doubleToLongBits(this.laborCostPerSquareFoot) != Double.doubleToLongBits(other.laborCostPerSquareFoot)) {
            return false;
        }
        if (Double.doubleToLongBits(this.materialCost) != Double.doubleToLongBits(other.materialCost)) {
            return false;
        }
        if (Double.doubleToLongBits(this.laborCost) != Double.doubleToLongBits(other.laborCost)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tax) != Double.doubleToLongBits(other.tax)) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        return true;
    }

}
