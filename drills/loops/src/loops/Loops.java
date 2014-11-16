/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

/**
 *
 * @author apprentice
 */
public class Loops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CountXX test = new CountXX();

        int result = test.countXX("abcxx");
        
        StringSplosion test2 = new StringSplosion();
        String result2 = test2.stringSplosion("Code");
        
         AltPairs test3 = new AltPairs();
         String result3 = test3.altPairs("CodingHorror");
         System.out.println(result3);
    }

}
