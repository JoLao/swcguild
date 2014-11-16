/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdlibrary.dao;

//Design a DVDLibrary class to hold all the DVD's in the library.  You can use either a 

import dvdlibrary.domain.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//Collection or a Map to hold the DVD objects.  This class must have methods to do the 
//following: 
//a. Add a DVD 
//b. Remove a DVD 
//c. Retrieve a DVD by Title 
//d. Retrieve all the DVD's in the library 

//1. Allow the user to add a DVD to the collection. 
//2. Allow the user to remove a DVD from the collection. 
//3. Allow the user to list the DVD's in the collection. 
//4. Allow the user to display the information for a  particular DVD. 
//5. Allow the user to search for a DVD by title. 
//6. Load the DVD library from a file. 
//7. Save the DVD library back to the file when the program completes. 
//8. Allows the user to add/edit/delete many DVD's in one session. 
public class DVDLibrary {
    
    HashMap<String, DVD> dvdLibrary = new HashMap<>();
    
    public static final String DELIMITER = "::";
    
    public DVD addDVD(DVD dvd) {
        return dvdLibrary.put(dvd.getTitle(), dvd);
    }
    
    public DVD removeDVD(String title) {
        return dvdLibrary.remove(title);
    }
    
    public DVD retrieveDVD(String title) {
        return dvdLibrary.get(title);
    }
    
    public DVD[] retrieveAllDVDs() {
        Collection<DVD> values = dvdLibrary.values();
        DVD[] dvd = values.toArray(new DVD[0]);
        return dvd;
    }
    
    public void loadDVDFromFile(String inputFile) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));
        
        String   currentLine;
        String[] currentTokens;
        while (in.hasNext()) {
            currentLine   = in.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            dvdLibrary.put(currentTokens[0], 
                           new DVD(currentTokens[0], currentTokens[1],
                                   currentTokens[2], currentTokens[3],
                                   currentTokens[4], currentTokens[5]));
        }
        in.close();
        
    }
    
    public void saveDVDToFile(String outputFile) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));
        
        Collection<DVD> values = dvdLibrary.values();
        Iterator<DVD>   iter   = values.iterator();
        
        DVD dvd;
        while (iter.hasNext()) {
            dvd = iter.next();
            out.println(dvd.getTitle()+DELIMITER+dvd.getReleaseDate()+DELIMITER+dvd.getMpaaRating()+DELIMITER+
                      dvd.getDirectorName()+DELIMITER+dvd.getStudio()+DELIMITER+dvd.getNotes());
            out.flush();
        }
        out.close();
    }
}
