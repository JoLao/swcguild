package com.swcguild.flooringmasteryspring2.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringProgramRunner {

    ConsoleIOImpl cIO = new ConsoleIOImpl();
    
    public static void main(String[] args) {
//        FlooringProgramController flooringOrders = new FlooringProgramController();
//        flooringOrders.logon();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringProgramController flooringOrders = (FlooringProgramController) ctx.getBean("flooringProgramController");
        flooringOrders.logon();
    }
}
