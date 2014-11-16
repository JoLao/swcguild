package com.swcguild.dvdrentalstore.dao;


import com.swcguild.dvdrentalstore.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DvdRentalDao {
    
    public static final String INVENTORY_FILE      = "dvdinventory.txt";
    public static final String INVENTORY_FILE_TEST = "dvdinventorytest.txt";

    public static final String DELIMITER           = "::";
       
    public void setMode(String mode);
    
    public void loadInventoryFile() throws FileNotFoundException;  
    public void saveInventoryFile() throws IOException;
    
    public List<Dvd> listDvdByTitle(String title);
    public List<Dvd> listBluRayByTitle(String title);
    public Map<String, List<Dvd>> listAllGroupByVideoType();
    public List<Dvd> listAllAvailableByTitle(String title);
    public List<Dvd> listAllByTitle(String title);
    
    public Dvd    getDvd(int dvdNumber);
    public boolean isDvdAvailable(int dvdNumber);
     
}
