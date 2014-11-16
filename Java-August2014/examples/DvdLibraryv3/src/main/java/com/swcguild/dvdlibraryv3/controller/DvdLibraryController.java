/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3.controller;

import com.swcguild.dvdlibrarydao.dao.DvdLibraryDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class DvdLibraryController {
    DvdLibraryDao dao;
    
    public DvdLibraryController(DvdLibraryDao library) {
        this.dao = dao;
    }
    
    public static void main(String[] args) {
//        DvdLibraryDaoImpl daoImpl = new DvdLibraryDaoImpl();
//        DvdLibraryController controller = new DvdLibraryController(daoImpl);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdLibraryController controller = (DvdLibraryController) ctx.getBean("controller");
        controller.run();
        
    }
    
    public void run() {
        System.out.println("RUN");
    }
    
}
