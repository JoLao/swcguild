package com.swcguild.dvdrentalstore.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.swcguild.dvdrentalstore.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
public class DvdRentalDaoTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    DvdRentalDao dvdRentalDao;
    DvdRentalDao dvdRentalDao1;
    ComputeFeeUtility cmpFeeUtil;
    
    Dvd dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, dvd11;
    List<Dvd> allList;
            
    boolean result; 
        
    public DvdRentalDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dvdRentalDao  = (DvdRentalDaoImpl) ctx.getBean("dvdRentalDao");
        dvdRentalDao1 = (DvdRentalDaoImpl) ctx.getBean("dvdRentalDao");
        
        cmpFeeUtil = (ComputeFeeUtility) ctx.getBean("cmpFeeUtil");
        
        //1::DVD::Up::2009-07-09::G::John Lasseter::Pixar::Four Stars::2014-09-28
        dvd1 = new Dvd();
        dvd1.setDvdNumber(1);
        dvd1.setVideoType("DVD");
        dvd1.setTitle("Up");        
        dvd1.setReleaseDate(LocalDate.parse("2009-07-09", DateTimeFormatter.ISO_DATE));
        dvd1.setMpaaRating("G");
        dvd1.setDirector("John Lasseter");
        dvd1.setStudio("Pixar");
        dvd1.setReviews("Four Stars");        
        dvd1.setCheckOutDate(LocalDate.parse("2014-09-28", DateTimeFormatter.ISO_DATE));
//        } catch(DateTimeParseException d) {
//            
//        }
        dvd1.setAccount(1);
        
        //2::BluRay::Toy Story::1998-07-10::G::John Lasseter::Pixar::Four Stars:: 
        dvd2 = new Dvd();
        dvd2.setDvdNumber(2);
        dvd2.setVideoType("BluRay");
        dvd2.setTitle("Toy Story");        
        dvd2.setReleaseDate(LocalDate.parse("1998-07-10", DateTimeFormatter.ISO_DATE));
        dvd2.setMpaaRating("G");
        dvd2.setDirector("John Lasseter");
        dvd2.setStudio("Pixar");
        dvd2.setReviews("Four Stars");        
        dvd2.setCheckOutDate(null);
        dvd2.setAccount(0);
        
        //3::BluRay::Toy Story::1998-07-10::G::John Lasseter::Pixar::Four Stars:: 
        dvd3 = new Dvd();
        dvd3.setDvdNumber(3);
        dvd3.setVideoType("BluRay");
        dvd3.setTitle("Toy Story");        
        dvd3.setReleaseDate(LocalDate.parse("1998-07-10", DateTimeFormatter.ISO_DATE));
        dvd3.setMpaaRating("G");
        dvd3.setDirector("John Lasseter");
        dvd3.setStudio("Pixar");
        dvd3.setReviews("Four Stars");        
        dvd3.setCheckOutDate(null);
        dvd3.setAccount(0);
        
        //4::DVD::Toy Story::1998-07-10::G::John Lasseter::Pixar::Four Stars:: 
        dvd4 = new Dvd();
        dvd4.setDvdNumber(4);
        dvd4.setVideoType("DVD");
        dvd4.setTitle("Toy Story");        
        dvd4.setReleaseDate(LocalDate.parse("1998-07-10", DateTimeFormatter.ISO_DATE));
        dvd4.setMpaaRating("G");
        dvd4.setDirector("John Lasseter");
        dvd4.setStudio("Pixar");
        dvd4.setReviews("Four Stars");        
        dvd4.setCheckOutDate(null);
        dvd4.setAccount(0);

        //5::BluRay::Toy Story 2::2002-07-10::G::John Lasseter::Pixar::Four Stars:: 
        dvd5 = new Dvd();
        dvd5.setDvdNumber(5);
        dvd5.setVideoType("BluRay");
        dvd5.setTitle("Toy Story 2");        
        dvd5.setReleaseDate(LocalDate.parse("2002-07-10", DateTimeFormatter.ISO_DATE));
        dvd5.setMpaaRating("G");
        dvd5.setDirector("John Lasseter");
        dvd5.setStudio("Pixar");
        dvd5.setReviews("Four Stars");        
        dvd5.setCheckOutDate(LocalDate.parse("2014-10-04", DateTimeFormatter.ISO_DATE));
        dvd5.setAccount(1);
        
        //6::BluRay::Toy Story 2::2002-07-10::G::John Lasseter::Pixar::Four Stars:: 
        dvd6 = new Dvd();
        dvd6.setDvdNumber(6);
        dvd6.setVideoType("BluRay");
        dvd6.setTitle("Toy Story 2");        
        dvd6.setReleaseDate(LocalDate.parse("2002-07-10", DateTimeFormatter.ISO_DATE));
        dvd6.setMpaaRating("G");
        dvd6.setDirector("John Lasseter");
        dvd6.setStudio("Pixar");
        dvd6.setReviews("Four Stars");        
        dvd6.setCheckOutDate(null);
        dvd6.setAccount(0);

        //7::DVD::Up::2009-07-09::G::John Lasseter::Pixar::Four Stars:: 
        dvd7 = new Dvd();
        dvd7.setDvdNumber(7);
        dvd7.setVideoType("DVD");
        dvd7.setTitle("Up");        
        dvd7.setReleaseDate(LocalDate.parse("2009-07-09", DateTimeFormatter.ISO_DATE));
        dvd7.setMpaaRating("G");
        dvd7.setDirector("John Lasseter");
        dvd7.setStudio("Pixar");
        dvd7.setReviews("Four Stars");        
        dvd7.setCheckOutDate(null);
        dvd7.setAccount(0);
        
        //8::DVD::Toy Story 2::2002-07-10::G::John Lasseter::Pixar::Four Stars:: 
        dvd8 = new Dvd();
        dvd8.setDvdNumber(8);
        dvd8.setVideoType("DVD");
        dvd8.setTitle("Toy Story 2");        
        dvd8.setReleaseDate(LocalDate.parse("2002-07-10", DateTimeFormatter.ISO_DATE));
        dvd8.setMpaaRating("G");
        dvd8.setDirector("John Lasseter");
        dvd8.setStudio("Pixar");
        dvd8.setReviews("Four Stars");        
        dvd8.setCheckOutDate(null);
        dvd8.setAccount(0);
        
        //9::BluRay::Toy Story 3::2010-07-09::G::John Lasseter::Pixar::Four Stars:: 
        dvd9 = new Dvd();
        dvd9.setDvdNumber(9);
        dvd9.setVideoType("BluRay");
        dvd9.setTitle("Toy Story 3");        
        dvd9.setReleaseDate(LocalDate.parse("2010-07-09", DateTimeFormatter.ISO_DATE));
        dvd9.setMpaaRating("G");
        dvd9.setDirector("John Lasseter");
        dvd9.setStudio("Pixar");
        dvd9.setReviews("Four Stars");        
        dvd9.setCheckOutDate(null);
        dvd9.setAccount(0);
        
        //10::BluRay::Godzilla::2014-09-16::PG13::Gareth Edwards::Warner Bros. Pictures::Four Stars:: 
        dvd10 = new Dvd();
        dvd10.setDvdNumber(10);
        dvd10.setVideoType("BluRay");
        dvd10.setTitle("Godzilla");        
        dvd10.setReleaseDate(LocalDate.parse("2014-09-16", DateTimeFormatter.ISO_DATE));
        dvd10.setMpaaRating("PG13");
        dvd10.setDirector("Gareth Edwards");
        dvd10.setStudio("Warner Bros. Pictures");
        dvd10.setReviews("Four Stars");        
        dvd10.setCheckOutDate(null);
        dvd10.setAccount(0);
        
        //11::DVD::Godzilla::2014-09-16::PG13::Gareth Edwards::Warner Bros. Pictures::Four Stars:: 
        dvd11 = new Dvd();
        dvd11.setDvdNumber(11);
        dvd11.setVideoType("DVD");
        dvd11.setTitle("Godzilla");        
        dvd11.setReleaseDate(LocalDate.parse("2014-09-16", DateTimeFormatter.ISO_DATE));
        dvd11.setMpaaRating("PG13");
        dvd11.setDirector("Gareth Edwards");
        dvd11.setStudio("Warner Bros. Pictures");
        dvd11.setReviews("Four Stars");        
        dvd11.setCheckOutDate(LocalDate.parse("2014-10-02", DateTimeFormatter.ISO_DATE));
        dvd11.setAccount(1);
        
        allList    = new ArrayList<>();
        allList.add(dvd1);
        allList.add(dvd2);
        allList.add(dvd3);
        allList.add(dvd4);
        allList.add(dvd5);
        allList.add(dvd6);
        allList.add(dvd7);
        allList.add(dvd8);
        allList.add(dvd9);
        allList.add(dvd10);
        allList.add(dvd11);
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
    public void dvdRentalDaoDisplayTest() {
        dvdRentalDao.setMode("test");
        dvdRentalDao1.setMode("test");
                
        List<Dvd> dvdList    = new ArrayList<>();
        List<Dvd> bluRayList = new ArrayList<>();
        Map<String, List<Dvd>> allGrpByVideoType = new HashMap<>();                      
        
        dvdList.add(dvd1);
        dvdList.add(dvd4);
        dvdList.add(dvd7);
        dvdList.add(dvd8);
        dvdList.add(dvd11);
        
        bluRayList.add(dvd2);
        bluRayList.add(dvd3);
        bluRayList.add(dvd5);
        bluRayList.add(dvd6);
        bluRayList.add(dvd9);
        bluRayList.add(dvd10);
        
        allGrpByVideoType.put("BluRay", bluRayList);
        allGrpByVideoType.put("DVD", dvdList);
        
        try {
            cmpFeeUtil.loadCurrentFeesFile();
            dvdRentalDao.loadInventoryFile();
        } catch (FileNotFoundException fnf) {
            
        }
        
        List<Dvd> dvdListByTitle           = new ArrayList<>();
        dvdListByTitle.add(dvd1);
        dvdListByTitle.add(dvd7);
        Collections.sort(dvdListByTitle);
        
        List<Dvd> dvdListByTitleFrDao      = dvdRentalDao.listDvdByTitle("Up");
        Collections.sort(dvdListByTitleFrDao);
        result = dvdListByTitleFrDao.equals(dvdListByTitle);
        
        assertTrue(result);
        
//===================================================================================================================//        
        List<Dvd> bluRayListByTitle        = new ArrayList<>();
        bluRayListByTitle.add(dvd2);
        bluRayListByTitle.add(dvd3);
        Collections.sort(bluRayListByTitle);        
        
        List<Dvd> bluRayListByTitleFrDao   = dvdRentalDao.listBluRayByTitle("Toy Story");
        Collections.sort(bluRayListByTitleFrDao);
        result = bluRayListByTitleFrDao.equals(bluRayListByTitle);
        assertTrue(result);

//===================================================================================================================//        

        Map<String, List<Dvd>> allGrpByVideoTypeFrDao = dvdRentalDao.listAllGroupByVideoType();
        result = allGrpByVideoTypeFrDao.equals(allGrpByVideoType);
        
        assertTrue(result);

//===================================================================================================================//        
        List<Dvd> listAllAvailableByTitle      = new ArrayList<>();        
//        listAllAvailableByTitle.add(dvd5);
        listAllAvailableByTitle.add(dvd6);
        listAllAvailableByTitle.add(dvd8);
        Collections.sort(listAllAvailableByTitle);
        
        List<Dvd> listAllAvailableByTitleFrDao = dvdRentalDao.listAllAvailableByTitle("Toy Story 2");
        Collections.sort(listAllAvailableByTitleFrDao);
        result = listAllAvailableByTitleFrDao.equals(listAllAvailableByTitle);
        
        assertTrue(result);
        
//===================================================================================================================//        
        List<Dvd> listAllByTitle               = new ArrayList<>();        
        listAllByTitle.add(dvd10);
        listAllByTitle.add(dvd11);
        Collections.sort(listAllByTitle);
        
        List<Dvd> listAllByTitleFrDao          = dvdRentalDao.listAllByTitle("Godzilla");
        Collections.sort(listAllByTitle);
        
        result = listAllByTitleFrDao.equals(listAllByTitle);
        
        assertTrue(result);
        
        
//    public double computeFees(Dvd dvd);
        
        
//===================================================================================================================//           
        Dvd dvdFrDao = dvdRentalDao.getDvd(9);
        result = dvdFrDao.equals(dvd9);
                
        assertTrue(result);
        
//===================================================================================================================//           
        assertTrue(dvdRentalDao.isDvdAvailable(10));
        assertFalse(dvdRentalDao.isDvdAvailable(11));
        
//===================================================================================================================//                                 
        Dvd dvd = dvdRentalDao.getDvd(5);        
//        dvd.setCheckOutDate(LocalDate.now());
//        LocalDate dueDateFrDao = LocalDate.now().plusDays(dvdRentalDao.getDuration());
//        dvd5.setCheckOutDate(LocalDate.now());   
        dvd.setCheckOutDate(LocalDate.parse("2014-10-04", DateTimeFormatter.ISO_DATE));
        LocalDate dueDateFrDao = LocalDate.parse("2014-10-04", DateTimeFormatter.ISO_DATE)
                                     .plusDays(cmpFeeUtil.getDuration());

        dvd5.setCheckOutDate(LocalDate.parse("2014-10-04", DateTimeFormatter.ISO_DATE));
        
        LocalDate dueDate = LocalDate.parse("2014-10-06", DateTimeFormatter.ISO_DATE);
        result = dueDateFrDao.equals(dueDate);
        
        assertTrue(result);
        
        System.out.println("dvd5 "+dvd5);
        System.out.println("dvdFrDao "+dvd);
        result = dvd.equals(dvd5);                       
        assertTrue(result);
        
//===================================================================================================================//                   
        //Tested as of 2014-10-04
        //DVD Classic checked out on 2014-09-28 : $2.25 + $1 * 4
        double totalFeeFrDao = cmpFeeUtil.computeFees(dvd1);
        double totalFee;
        Period p = dvd1.getCheckOutDate().until(LocalDate.now());        
        
        totalFee = cmpFeeUtil.getDvdFee() + (p.getDays() > 2 ? ((p.getDays() - 2) * 1) : 0);        
        
        BigDecimal totalFeeFrDaoBig = new BigDecimal(totalFeeFrDao).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal totalFeeBig      = new BigDecimal(totalFee).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(totalFeeFrDaoBig, totalFeeBig);
        
        double determineFee = 2.25;
        double determineFeeFrDao = cmpFeeUtil.determineFee(dvd1);
        BigDecimal determineFeeFrDaoBig = new BigDecimal(determineFeeFrDao).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal determineFeeBig      = new BigDecimal(determineFee).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(determineFeeFrDaoBig, determineFeeBig);
        
        int daysElapsed = p.getDays();
        int daysElapsedFrDao = cmpFeeUtil.computeDaysElapsed(dvd1);
        assertEquals(daysElapsedFrDao, daysElapsed);
        
        double lateFees = p.getDays() > 2 ? ((p.getDays() - 2) * 1) : 0;
        double lateFeesFrDao = cmpFeeUtil.computeLateFees(dvd1);
        BigDecimal lateFeesFrDaoBig = new BigDecimal(lateFeesFrDao).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal lateFeesBig      = new BigDecimal(lateFees).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(lateFeesFrDaoBig, lateFeesBig);

        //BluRay Classic : $2.25 + $1.50
        totalFeeFrDao = cmpFeeUtil.computeFees(dvd);
        p = dvd.getCheckOutDate().until(LocalDate.now());
        totalFee = cmpFeeUtil.getDvdFee() + cmpFeeUtil.getBluRayAdditionalFee() + (p.getDays() > 2 ? ((p.getDays() - 2) * 1) : 0);        
        totalFeeFrDaoBig = new BigDecimal(totalFeeFrDao).setScale(2, RoundingMode.HALF_EVEN);
        totalFeeBig      = new BigDecimal(totalFee).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(totalFeeFrDaoBig, totalFeeBig);
         
        double determineBluRayFee = 3.75;
        double determineBluRayFeeFrDao = cmpFeeUtil.determineFee(dvd);
        BigDecimal determineBluRayFeeFrDaoBig = new BigDecimal(determineFeeFrDao).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal determineBluRayFeeBig      = new BigDecimal(determineFee).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(determineBluRayFeeFrDaoBig, determineBluRayFeeBig);
        
        daysElapsed = p.getDays();
        daysElapsedFrDao = cmpFeeUtil.computeDaysElapsed(dvd);
        assertEquals(daysElapsedFrDao, daysElapsed);
        
        lateFees = p.getDays() > 2 ? ((p.getDays() - 2) * 1) : 0;
        lateFeesFrDao = cmpFeeUtil.computeLateFees(dvd);
        lateFeesFrDaoBig = new BigDecimal(lateFeesFrDao).setScale(2, RoundingMode.HALF_EVEN);
        lateFeesBig      = new BigDecimal(lateFees).setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(lateFeesFrDaoBig, lateFeesBig);
        
//===================================================================================================================//                   
        try {
            dvdRentalDao.saveInventoryFile();
            dvdRentalDao1.loadInventoryFile();
        } catch (IOException io) {
            
        } 
        allGrpByVideoTypeFrDao = dvdRentalDao1.listAllGroupByVideoType();
        result = allGrpByVideoTypeFrDao.equals(allGrpByVideoType);
        
        assertTrue(result);        
        
    }
    
//    @Test
//    public void dvdRentalDaoRentalTest() {        
//        Dvd dvd = dvdRentalDao.getDvd(5);        
//        dvd.setCheckOutDate(LocalDate.now());
//        LocalDate dueDate = LocalDate.now().plusDays(dvdRentalDao.getDuration());
//        dvd5.setCheckOutDate(dueDate);
//        
//        
//    }
}
