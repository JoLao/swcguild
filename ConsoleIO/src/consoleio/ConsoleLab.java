/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package consoleio;

/**
 *
 * @author apprentice
 */
public class ConsoleLab {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        
        int a = io.promptForInteger("Please enter an integer :");
        int b = io.promptForInteger("Please enter another integer :");
        int sum = a + b;
        
        io.printString("Your sum is "+sum);
    }
}
