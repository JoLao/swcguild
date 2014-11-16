/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.serverinventory.dao;

import com.swcguild.serverinventory.domain.Server;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class ServerDaoTest {
    
    public ServerDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
      @Test
    public void addGetRemoveServerTest() {
        Server temp = new Server();
        temp.setName("web01");
        temp.setMake("Dell");
        temp.setIp("123.44.55.11");
        temp.setNumProcessors("4");
        temp.setRam("128");
        temp.setPurchaseDate(LocalDate.parse("2000-01-01", DateTimeFormatter.ISO_DATE));
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServerDao dao = (ServerDao) ctx.getBean("dao");
        
        dao.addServer(temp.getName(), temp);
        
        Server retServer = dao.getServer(temp.getName());
        assertEquals(temp, retServer);
        
        dao.removeServer(temp.getName());
        
        retServer = dao.getServer(temp.getName());
        assertNull(retServer);
        
    }
    
}
