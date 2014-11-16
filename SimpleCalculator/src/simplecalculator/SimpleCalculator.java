
package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleCalculator {

    public static void main(String[] args) {
     
//        CalculatorUI calcUI = new CalculatorUI();
//        calcUI.askInput();
//        

        double a = 0, b = 0, c = 0;
        String op;
        int choice = 0;
        Calculator calc = new Calculator();
        
        //couldn't find my ConsoleIO class. tried import ConsoleIO but it didn't work
        ConsoleIO  io = new ConsoleIO();

        displayMenu();
        Scanner keybd = new Scanner(System.in);
        while (choice != 5) {
            //choice = keybd.nextInt();
            choice = io.promptForIntegerWithRange("Enter choice",1,5);
            if (choice > 0 && choice < 5) {
            //    System.out.print("Enter first number : ");
            //    a = keybd.nextDouble();
                a = io.promptForDouble("Enter first number");
            //    System.out.print("Enter second number : ");
            //    b = keybd.nextDouble();
                b = io.promptForDouble("Enter second number");
            }
            switch (choice) {
                case 1:
                    op = "+";
                    break;
                case 2:
                    op = "-";
                    break;
                case 3:
                    op = "*";
                    break;
                case 4:
                    op = "/";
                    break;
                case 5:
                    op = "";
                    break;
                default:
                    op = "error";
                    System.out.println("Invalid Choice");
            }

            c = calc.doSimpleMathFunctions(a, op, b);
            System.out.println(a + " " + op + " " + b + " = " + c);
            displayMenu();
        }

    }

    public static void displayMenu() {
        System.out.println("");
        System.out.println("Calculator Menu");
        System.out.println("1) Add two numbers");
        System.out.println("2) Subtract two numbers");
        System.out.println("3) Multiply two numbers");
        System.out.println("4) Divide two numbers");
        System.out.println("5) Quit");
        System.out.println("");
        System.out.print("Enter your choice : ");
    }

}
