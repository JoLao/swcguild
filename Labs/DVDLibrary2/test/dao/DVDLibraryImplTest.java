/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dvdlibrary2.dao.DVDLibraryImpl;
import dvdlibrary2.domain.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class DVDLibraryImplTest {
    
    public DVDLibraryImplTest() {
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
    public void dvdLibraryImplTest() {
        DVDLibraryImpl test = new DVDLibraryImpl();
        
                //String title, String releaseDate, String mpaaRating, 
        //       String directorName, String studio, String notes) 
        DVD dvd1 = new DVD("Up", LocalDate.parse("2009-07-09", DateTimeFormatter.ISO_DATE), "R", "David Lassetter", "Pixar", "Four Stars");
        DVD dvd2 = new DVD("Toy Story 1", LocalDate.parse("1998-07-09", DateTimeFormatter.ISO_DATE), "R", "David Lassetter", "Pixar", "Four Stars");
        DVD dvd3 = new DVD("Toy Story 2", LocalDate.parse("2002-07-10", DateTimeFormatter.ISO_DATE), "R", "David Lassetter", "Pixar", "Four Stars");
        DVD dvd4 = new DVD("Toy Story 3", LocalDate.parse("2010-07-09", DateTimeFormatter.ISO_DATE), "R", "David Lassetter", "Pixar", "Four Stars");

        test.addDVD(dvd1);
        test.addDVD(dvd2);

        DVD getDVD = test.retrieveDVD("Up");
        assertEquals(getDVD, dvd1);

        getDVD = test.removeDVD("Toy Story 1");
        assertEquals(getDVD, dvd2);

        test.addDVD(dvd3);
        test.addDVD(dvd4);
        List<DVD> allDVDs = test.retrieveAllDVDs();
        List<DVD> dvdList = new ArrayList<>();
        dvdList.add(dvd1);
        dvdList.add(dvd3);
        dvdList.add(dvd4);
        boolean result = allDVDs.equals(dvdList);
        assertTrue(result);
        
        DVD dvdOut1 = test.retrieveDVD("Toy Story 3");
        result = dvdOut1.equals(dvd4);
        assertTrue(result);
        
        List<DVD> dvdList1 = new ArrayList<>();
        dvdList1.add(dvd1);
        dvdList1.add(dvd4);
        List<DVD> dvdOut2 = test.moviesReleasedInLastNYEars(5);
        Collections.sort(dvdList1);
        Collections.sort(dvdOut2);
        result = dvdOut2.equals(dvdList1);
        assertTrue(result);
        
        dvdOut2 = test.moviesWithAGivenMPAARating("R");
        Collections.sort(dvdList);
        Collections.sort(dvdOut2);
        result = dvdOut2.equals(dvdList);
        assertTrue(result);
        
        Map<String, List<DVD>> dvdMap1 = test.moviesReleasedByDirector("David Lassetter");
        List<DVD> dvdList2 = dvdMap1.get("R");
        Collections.sort(dvdList2);
        Map<String, List<DVD>> dvdMap  = new HashMap<>();
        dvdList1 = new ArrayList<>();
        dvdList1.add(dvd1);
        dvdList1.add(dvd3);
        dvdList1.add(dvd4);
        Collections.sort(dvdList1);
        dvdMap.put("R", dvdList1);
        
        result = dvdMap1.equals(dvdMap);
        assertTrue(result);
        
        dvdList2 = test.moviesReleasedByStudio("Pixar");
        Collections.sort(dvdList2);
        result = dvdList2.equals(dvdList1);
        assertTrue(result);
        
        double age = test.getAverageAgeInCollection();
        BigDecimal ageBig  = new BigDecimal(age).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal ageBig1 = new BigDecimal(7).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(ageBig, ageBig1);
        
        dvdOut1 = test.getNewestMovieInCollection();
        result  = dvdOut1.equals(dvd4);
        assertTrue(result);
        
        dvdOut1 = test.getOldestMovieInCollection();
        result  = dvdOut1.equals(dvd2);
        
        double average  = test.getAverageNumberOfNotesInCollection();
        BigDecimal avg1 = new BigDecimal(average).setScale(2, RoundingMode.UP);
        BigDecimal avg2 = new BigDecimal(1).setScale(2, RoundingMode.UP);
        assertEquals(avg1, avg2);
        
        LocalDate releaseDate = LocalDate.parse("2002-07-10", DateTimeFormatter.ISO_DATE);
        dvdList2 = test.moviesByReleasedDate(releaseDate);        
        dvdList1 = new ArrayList<>();
        dvdList1.add(dvd3);
//        Collections.sort(dvdList2);
//        Collections.sort(dvdList1);
        result = dvdList2.equals(dvdList1);
        assertTrue(result);
        


        try {
            test.saveDVDToFile("dvdtest.txt");
        } catch (IOException e) {

        }

        try {
            DVDLibraryImpl test2 = new DVDLibraryImpl();
            test2.loadDVDFromFile("dvdtest.txt");
            List<DVD> allDVDs2 = test.retrieveAllDVDs();            
            Collections.sort(allDVDs);
            Collections.sort(allDVDs2);
            result = allDVDs2.equals(allDVDs);
            assertTrue(result);
        } catch (FileNotFoundException e) {

        }
        
    }
}
