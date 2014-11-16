/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conditionals;

/**
 *
 * @author apprentice
 */
public class Conditionals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NotString test = new NotString();
                        
        //NotString("not bad") -> "not bad"
        String s = test.notString("not bad");
        System.out.println(s);
        
        RemoveDel test1 = new RemoveDel();
        
        //RemoveDel("adelbc") -> "abc"
        String result = test1.removeDel("adelbc");
        System.out.println(result);
        
        IxStart test2= new IxStart();
        
        //IxStart("mix snacks") -> true
        boolean result1 = test2.ixStart("mix snacks");
        
    }
    
}
