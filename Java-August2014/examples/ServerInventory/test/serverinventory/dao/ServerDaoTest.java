/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinventory.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import serverinventory.domain.Server;

/**
 *
 * @author apprentice
 */
public class ServerDaoTest {
    ServerDao dao;
    
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
        dao = new ServerDaoMapImpl();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addGetRemoveServerTest() {
        Server temp = new Server();
        temp.setName("web01");
        temp.setMake("Dell");
        temp.setIp("123.44.55.11");
        temp.setNumProcessors("4");
        temp.setRam("128");
        temp.setPurchaseDate(LocalDate.parse("2000-01-01", DateTimeFormatter.ISO_DATE));
        
        dao.addServer(temp.getName(), temp);
        
        Server retServer = dao.getServer(temp.getName());
        assertEquals(temp, retServer);
        
        dao.removeServer(temp.getName());
        
        retServer = dao.getServer(temp.getName());
        assertNull(retServer);
        
    }
    
}



