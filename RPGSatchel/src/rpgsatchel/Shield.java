
package rpgsatchel;

public class Shield implements Item {
    private String name;
    private int    weight;
    
    public Shield(String name, int weight) {
        this.name   = name;
        this.weight = weight;
    }

    @Override
    public String getItemName() {
        return this.name;
    }

    @Override
    public int getItemWeight() {
        return this.weight;
    }
    
    public void block() {
        System.out.println("Block...");
    }
}
