/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package collectionsexamples;

/**
 *
 * @author apprentice
 */
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
