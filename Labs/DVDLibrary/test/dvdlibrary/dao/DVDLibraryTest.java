/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.domain.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class DVDLibraryTest {

    public DVDLibrary test;

    public DVDLibraryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        test = new DVDLibrary();
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
    public void dvdLibraryTest() {
        //String title, String releaseDate, String mpaaRating, 
        //       String directorName, String studio, String notes) 
        DVD dvd1 = new DVD("Up", "2009-07-09", "R", "David Lassetter", "Pixar", "Four Stars");
        DVD dvd2 = new DVD("Toy Story 1", "1998-07-09", "R", "David Lassetter", "Pixar", "Four Stars");
        DVD dvd3 = new DVD("Toy Story 2", "2002-07-10", "R", "David Lassetter", "Pixar", "Four Stars");
        DVD dvd4 = new DVD("Toy Story 3", "2010-07-09", "R", "David Lassetter", "Pixar", "Four Stars");

        test.addDVD(dvd1);
        test.addDVD(dvd2);

        DVD getDVD = test.retrieveDVD("Up");
        assertEquals(getDVD, dvd1);

        getDVD = test.removeDVD("Toy Story 1");
        assertEquals(getDVD, dvd2);

        test.addDVD(dvd3);
        test.addDVD(dvd4);
        DVD[] allDVDs = test.retrieveAllDVDs();
        Arrays.sort(allDVDs);
        DVD[] inputDVDs = new DVD[3];
        inputDVDs[0] = dvd3;
        inputDVDs[1] = dvd4;
        inputDVDs[2] = dvd1;
        
        boolean testArrays = Arrays.equals(allDVDs, inputDVDs);
        assertTrue(testArrays);

        try {
            test.saveDVDToFile("dvdtest.txt");
        } catch (IOException e) {

        }

        try {
            DVDLibrary test2 = new DVDLibrary();
            test2.loadDVDFromFile("dvdtest.txt");
            DVD[] allDVDs2 = test.retrieveAllDVDs();
            Arrays.sort(allDVDs2);
            testArrays = Arrays.equals(inputDVDs, allDVDs2);
            assertTrue(testArrays);
        } catch (FileNotFoundException e) {

        }
    }
}
