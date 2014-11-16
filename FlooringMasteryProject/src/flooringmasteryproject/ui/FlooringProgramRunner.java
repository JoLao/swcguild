/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmasteryproject.ui;

import flooringmasteryproject.ui.ConsoleIO;

/**
 *
 * @author apprentice
 */
public class FlooringProgramRunner {

    ConsoleIO cIO = new ConsoleIO();
    
    public static void main(String[] args) {
        FlooringProgramController flooringOrders = new FlooringProgramController();
        flooringOrders.logon();
    }
}
