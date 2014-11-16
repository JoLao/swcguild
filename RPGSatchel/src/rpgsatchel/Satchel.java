

package rpgsatchel;

import java.util.HashMap;
import java.util.Set;


public class Satchel  {
    private int weightLimit;
    private int currentWeight = 0;
    
    private HashMap<String, Item> itemMap = new HashMap<>();

    public Satchel(int weightLimit) {
        this.weightLimit = weightLimit;
    }
    
    public boolean addToSatchel(Item item) {
        if ((item.getItemWeight() + currentWeight) > weightLimit) {
            return false;
        } else {
            currentWeight += item.getItemWeight();
            itemMap.put(item.getItemName(), item);
            return true;
        }        
    }
    
    public Item removeFromSatchel(String itemName) {
        Item temp = itemMap.remove(itemName);
        
        if (temp != null) {
            currentWeight -= temp.getItemWeight();
        }
        return temp;
    }
    
    public String[] listItemsInSatchel() {
        Set<String> keys = itemMap.keySet();
        String[] keyArray = keys.toArray(new String[0]);
        return keyArray;        
    }
}
