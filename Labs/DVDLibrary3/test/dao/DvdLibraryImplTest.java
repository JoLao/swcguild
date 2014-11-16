/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dvdlibrary3.dao.DvdLibraryImpl;
import dvdlibrary3.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DvdLibraryImplTest {

    public DvdLibraryImplTest() {
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
    public void DvdLibraryImplTest() {
        DvdLibraryImpl test = new DvdLibraryImpl();

        //String title, String releaseDate, String mpaaRating, 
        //       String directorName, String studio, String notes) 
        Dvd dvd1 = new Dvd();
        dvd1.setTitle("Up");
        dvd1.setReleaseDate(LocalDate.parse("2009-07-09", DateTimeFormatter.ISO_DATE));
        dvd1.setMpaaRating("R");
        dvd1.setDirector("David Lassetter");
        dvd1.setStudio("Pixar");
        dvd1.setNote("Four Stars");
        
        Dvd dvd2 = new Dvd();
        dvd2.setTitle("Toy Story 1");
        dvd2.setReleaseDate(LocalDate.parse("1998-07-09", DateTimeFormatter.ISO_DATE));
        dvd2.setMpaaRating("R"); 
        dvd2.setDirector("David Lassetter"); 
        dvd2.setStudio("Pixar");
        dvd2.setNote("Four Stars");
        
        Dvd dvd3 = new Dvd();
        dvd3.setTitle("Toy Story 2");
        dvd3.setReleaseDate(LocalDate.parse("2002-07-10", DateTimeFormatter.ISO_DATE));
        dvd3.setMpaaRating("R");
        dvd3.setDirector("David Lassetter");
        dvd3.setStudio("Pixar");
        dvd3.setNote("Four Stars");
        
        Dvd dvd4 = new Dvd();
        dvd4.setTitle("Toy Story 3");
        dvd4.setReleaseDate(LocalDate.parse("2010-07-09", DateTimeFormatter.ISO_DATE)); 
        dvd4.setMpaaRating("R");
        dvd4.setDirector("David Lassetter");
        dvd4.setStudio("Pixar");
        dvd4.setNote("Four Stars");
        
        test.add(dvd1);
        test.add(dvd2);

        List<Dvd> getDvd = test.getByTitle("Up");
        List<Dvd> inDvd1 = new ArrayList<>();
        inDvd1.add(dvd1);
        boolean result = getDvd.equals(inDvd1);
        assertTrue(result);

        test.remove(dvd2);
        result = test.listAll().equals(inDvd1);
        assertTrue(result);

        test.add(dvd3);
        test.add(dvd4);
        List<Dvd> allDvds = test.listAll();
        List<Dvd> dvdList = new ArrayList<>();
        dvdList.add(dvd1);
        dvdList.add(dvd3);
        dvdList.add(dvd4);
        result = allDvds.equals(dvdList);
        assertTrue(result);


        List<Dvd> dvdList1 = new ArrayList<>();
        dvdList1.add(dvd1);
        dvdList1.add(dvd4);
        List<Dvd> dvdOut2 = test.getReleasesInLastNYears(5);
        Collections.sort(dvdList1);
        Collections.sort(dvdOut2);
        result = dvdOut2.equals(dvdList1);
        assertTrue(result);

        dvdOut2 = test.getByRating("R");
        Collections.sort(dvdList);
        Collections.sort(dvdOut2);
        result = dvdOut2.equals(dvdList);
        assertTrue(result);

        Map<String, List<Dvd>> dvdMap1 = test.getByDirectorGroupByRating("David Lassetter");
        List<Dvd> dvdList2 = dvdMap1.get("R");
        Collections.sort(dvdList2);
        Map<String, List<Dvd>> dvdMap = new HashMap<>();
        dvdList1 = new ArrayList<>();
        dvdList1.add(dvd1);
        dvdList1.add(dvd3);
        dvdList1.add(dvd4);
        Collections.sort(dvdList1);
        dvdMap.put("R", dvdList1);

        result = dvdMap1.equals(dvdMap);
        assertTrue(result);

        dvdList2 = test.getByStudio("Pixar");
        Collections.sort(dvdList2);
        result = dvdList2.equals(dvdList1);
        assertTrue(result);

        double age = test.getAverageAge();
        BigDecimal ageBig = new BigDecimal(age).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal ageBig1 = new BigDecimal(7).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(ageBig, ageBig1);

       

        try {
            test.writeToFile();
        } catch (IOException e) {

        }

        try {
            DvdLibraryImpl test2 = new DvdLibraryImpl();
            test2.loadFromFile();
            List<Dvd> allDvds2 = test.listAll();
            Collections.sort(allDvds);
            Collections.sort(allDvds2);
            result = allDvds2.equals(allDvds);
            assertTrue(result);
        } catch (FileNotFoundException e) {

        }

    }

}
