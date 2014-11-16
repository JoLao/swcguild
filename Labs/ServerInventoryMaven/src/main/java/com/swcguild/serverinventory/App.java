/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {

    public static void main(String[] args) {
//        ServerInventoryController sic = new ServerInventoryController();
//        sic.setDao(new ServerDaoMockImpl());
//        sic.setIo(new IOConsoleImpl());
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServerInventoryController sic = (ServerInventoryController) ctx.getBean("controller");
        sic.run();
        
    }

}
