/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdrentalstore;

import com.swcguild.dvdrentalstore.ui.DvdRentalController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DvdRentalStore {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdRentalController dvdController = (DvdRentalController) ctx.getBean("dvdRentalController");
        dvdController.run();        
    }
}
