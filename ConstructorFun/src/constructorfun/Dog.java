

package constructorfun;


public class Dog {
    protected String name;

//    public Dog() {
//        System.out.println("Dog's default constructor.");
//    }
    
    public Dog(String name) {
        System.out.println("Dog's String arg constructor.");
        this.name = name;
    }

    
    
    
    public void bark() {
        System.out.println("WOOF");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
