
package collectionsexamples;


public class NonStaticFromMainExample {
    
    public static void main(String[] args) {
        
        NonStaticFromMainExample foo = new NonStaticFromMainExample();
        int sum = foo.add(4, 5);
    }
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
}
