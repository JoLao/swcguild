/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.StateTax;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class StateTaxTest {

    ApplicationContext ctx;
    StateTaxDao stateTaxDao;

    public StateTaxTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        stateTaxDao = (StateTaxDao) ctx.getBean("stateTaxDao");
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
    public void stateTaxDaoTest() {
        try {
            stateTaxDao.loadStateTaxMap();
        } catch (FileNotFoundException fnf) {
        }

        StateTax[] stateTaxFromMap = stateTaxDao.getAllStateTaxes();
        Arrays.sort(stateTaxFromMap);

        StateTax[] stTax = new StateTax[4];
        stTax[0] = new StateTax("OH", 6.25);
        stTax[1] = new StateTax("PA", 6.75);
        stTax[2] = new StateTax("MI", 5.75);
        stTax[3] = new StateTax("IN", 6.00);
        Arrays.sort(stTax);

        boolean stateTaxTest = Arrays.equals(stateTaxFromMap, stTax);
        assertTrue(stateTaxTest);

//isStateAvailable        
        assertTrue(stateTaxDao.isStateAvailable("OH"));

        StateTax addState = new StateTax("NJ", 7.00);
        stateTaxDao.addStateTax("NJ", 7.00);
        StateTax getState = stateTaxDao.getStateTax("NJ");
        assertTrue(addState.equals(getState));

        BigDecimal taxRate = new BigDecimal(stateTaxDao.getStateTaxRate("NJ")).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal myTaxRate = new BigDecimal(7.00).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(taxRate, myTaxRate);

        stateTaxDao.removeStateTax("NJ");
        getState = stateTaxDao.getStateTax("NJ");
        assertEquals(getState, null);
        
        stateTaxDao.addStateTax("NJ", 7.00);
        
        try {            
            stateTaxDao.saveStateTax();
        } catch (IOException e) {

        }
        
        stateTaxFromMap = stateTaxDao.getAllStateTaxes();
        Arrays.sort(stateTaxFromMap);
        stTax = new StateTax[5];
        stTax[0] = new StateTax("OH", 6.25);
        stTax[1] = new StateTax("PA", 6.75);
        stTax[2] = new StateTax("MI", 5.75);
        stTax[3] = new StateTax("IN", 6.00);
        stTax[4] = new StateTax("NJ", 7.00);
        Arrays.sort(stTax);

        stateTaxTest = Arrays.equals(stateTaxFromMap, stTax);
        assertTrue(stateTaxTest);
      
        stateTaxDao.removeStateTax("NJ");
        try {                        
            stateTaxDao.saveStateTax();
        } catch (IOException e) {

        }
    }
}
