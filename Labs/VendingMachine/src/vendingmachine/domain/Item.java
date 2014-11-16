package vendingmachine.domain;

/**
 *
 * @author apprentice
 */
//a. Item Name
import java.util.Objects;
//b. Item Cost
//c. Number of items in inventory

public class Item implements Comparable<Item> {

    private String name;
    private double cost;
    private int    count;

    public Item(String name, double cost, int count) {
        this.name  = name;
        this.cost  = cost;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }
// public void setCost(double cost) {
// this.cost = cost;
// }

    public int getCount() {
        return count;
    }
// public void setCount(int count) {
// this.count = count;
// }

    public void subtractCount() {
        if (this.count > 1) {
            this.count--;
        }
    }

    public int compareTo(Item compareItem) {
        int cmp = this.name.compareToIgnoreCase(compareItem.name);
        if (cmp != 0) {
            return cmp;
        }
        cmp = Integer.valueOf(this.count).compareTo(Integer.valueOf(compareItem.count));
        if (cmp != 0) {
            return cmp;
        }
        return Double.valueOf(this.cost).compareTo(Double.valueOf(compareItem.cost));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 41 * hash + this.count;
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        return true;
    }
}

