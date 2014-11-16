package com.swcguild.dvdrentalstore.dao;

import com.swcguild.dvdrentalstore.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DvdRentalDaoImpl implements DvdRentalDao {

    private String mode = "PROD";    

    private HashMap<Integer, Dvd> dvdMap = new HashMap<>();
 
    @Override
    public void setMode(String mode) {
        this.mode = mode;
    }    

    private void addDvd(Dvd dvd) {                
        dvdMap.put(dvd.getDvdNumber(), dvd);
    }

    @Override
    public List<Dvd> listDvdByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title) && d.getVideoType().equalsIgnoreCase("DVD"))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> listBluRayByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title) && d.getVideoType().equalsIgnoreCase("BluRay"))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> listAllGroupByVideoType() {
        return dvdMap.values().stream()
                .sorted()
                .collect(Collectors.groupingBy(d -> d.getVideoType()));                         
    }

    @Override
    public List<Dvd> listAllAvailableByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title) && d.getCheckOutDate() == null)
                .sorted()
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Dvd> listAllByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title))
                .sorted()
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean isDvdAvailable(int dvdNumber) {
        return dvdMap.containsKey(dvdNumber) && (dvdMap.get(dvdNumber).getCheckOutDate() == null);
    }
    
    @Override
    public Dvd    getDvd(int dvdNumber) {
        return dvdMap.get(dvdNumber);
    }

    @Override
    public void loadInventoryFile() throws FileNotFoundException {
        String inputFile = mode.equalsIgnoreCase("PROD") ? INVENTORY_FILE : INVENTORY_FILE_TEST;
        
        Scanner in = new Scanner(new FileReader(inputFile));

        String currentRecord;
        String[] currentTokens;
        Dvd dvd;
        LocalDate checkOutDate = null;
        int acctNum;
        while (in.hasNextLine()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            dvd = new Dvd();
//1::BluRay::Avatar::2010-08-05::R::James Cameron::Paramount::Two Thumbs Up!##Must see movie##Graphics nicely done  
            dvd.setDvdNumber(Integer.parseInt(currentTokens[0]));
            dvd.setVideoType(currentTokens[1]);
            dvd.setTitle(currentTokens[2]);
            dvd.setReleaseDate(LocalDate.parse(currentTokens[3], DateTimeFormatter.ISO_DATE));
            dvd.setMpaaRating(currentTokens[4]);
            dvd.setDirector(currentTokens[5]);
            dvd.setStudio(currentTokens[6]);
            dvd.setReviews(currentTokens[7]);
            try {
                checkOutDate = LocalDate.parse(currentTokens[8], DateTimeFormatter.ISO_DATE);
            } catch (DateTimeException e) {
                checkOutDate = null;
            }
            dvd.setCheckOutDate(checkOutDate);
            
            try {
                acctNum = Integer.parseInt(currentTokens[9]);
            } catch (NumberFormatException nfe) {
                acctNum = 0;
            }            
            dvd.setAccount(acctNum);
            addDvd(dvd);
        }
        in.close();
    }
    
    @Override
    public void saveInventoryFile() throws IOException {
        String inputFile = mode.equalsIgnoreCase("PROD") ? INVENTORY_FILE : INVENTORY_FILE_TEST;
        
        PrintWriter out = new PrintWriter(new FileWriter(inputFile));
        Collection<Dvd> values = dvdMap.values();
        Iterator<Dvd>   iter   = values.iterator();
        Dvd dvd;
        while (iter.hasNext()) {
            dvd = iter.next();
            out.println(dvd.getDvdNumber() + DELIMITER 
                      + dvd.getVideoType() + DELIMITER 
                      + dvd.getTitle() + DELIMITER 
                      + dvd.getReleaseDate() + DELIMITER
                      + dvd.getMpaaRating() + DELIMITER
                      + dvd.getDirector() + DELIMITER 
                      + dvd.getStudio() + DELIMITER 
                      + dvd.getReviews() + DELIMITER 
                      + (dvd.getCheckOutDate() == null ? " " : dvd.getCheckOutDate()) + DELIMITER 
                      + (dvd.getAccount() == 0 ? " " : dvd.getAccount()));
            out.flush();
        }
        out.close();
    }
    
}
