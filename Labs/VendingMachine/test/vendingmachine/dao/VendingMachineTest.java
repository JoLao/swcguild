package vendingmachine;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vendingmachine.dao.VendingMachine;
import vendingmachine.domain.Item;

/**
 *
 * @author apprentice
 */
public class VendingMachineTest {

    public VendingMachineTest() {
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

    @Test
    public void VendingMachine() {
        VendingMachine test = new VendingMachine();
        Item[] inventory = {};
        try {
            inventory = test.loadItemsToVendingMachine();
        } catch (FileNotFoundException fnf) {
        }
        boolean result = test.sufficientUserFund(2, 1);
        assertTrue(result);
        try {
            test.saveInventoryToFile();
        } catch (IOException e) {
        }
// double change = test.vendItem(3, 2);
// double x = 1;
// assertEquals(x, change, 0.02);
        Arrays.sort(inventory);
        VendingMachine test2 = new VendingMachine();
        Item[] inventory2 = {};
        try {
            inventory2 = test2.loadItemsToVendingMachine();
        } catch (FileNotFoundException fnf) {
        }
        Arrays.sort(inventory2);
        boolean result2 = Arrays.equals(inventory, inventory2);
        assertTrue(result2);
    }
}
