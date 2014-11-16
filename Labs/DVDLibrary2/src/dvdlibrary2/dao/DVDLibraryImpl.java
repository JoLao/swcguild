/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary2.dao;

//Design a DVDLibrary class to hold all the DVD's in the library.  You can use either a 
import dvdlibrary2.domain.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
public class DVDLibraryImpl implements DVDLibraryDAO {

    HashMap<String, DVD> dvdLibrary = new HashMap<>();

    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(DVD dvd) {       
        return dvdLibrary.put(dvd.getTitle(), dvd);
    }

    @Override
    public DVD removeDVD(String title) {
        return dvdLibrary.remove(title);
    }

    @Override
    public DVD retrieveDVD(String title) {
        return dvdLibrary.get(title);
    }

    @Override
    public List<DVD> retrieveAllDVDs() {
        //return dvdLibrary.values().toArray(new DVD[0]);
        Collection<DVD> values = dvdLibrary.values();
        return values.stream().collect(Collectors.toList());
    }

    @Override
    public List<DVD> moviesReleasedInLastNYEars(int year) {
        return dvdLibrary.values().stream()
                .filter(d -> d.getMovieAge() <= year)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> moviesWithAGivenMPAARating(String mpaaRating) {
        return dvdLibrary.values().stream()
                .filter(d -> d.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .sorted(DVD.DVDMPAARatingComparator)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<DVD>> moviesReleasedByDirector(String director) {
        return dvdLibrary.values().stream()
                .filter(d -> d.getDirectorName().equalsIgnoreCase(director))
                .sorted()
                .collect(Collectors.groupingBy(d -> d.getMpaaRating()));
    }

    @Override
    public List<DVD> moviesReleasedByStudio(String studio) {
        return dvdLibrary.values().stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<DVD> moviesByReleasedDate(LocalDate releaseDate) {
        return dvdLibrary.values().stream()
                .filter(d -> d.getReleaseDate().equals(releaseDate))
                .collect(Collectors.toList());
    }
    
    @Override
    public double getAverageAgeInCollection() {
        return dvdLibrary.values().stream()
                .mapToDouble(d -> d.getMovieAge())
                .average()
                .getAsDouble();
    }

    @Override
    public DVD getNewestMovieInCollection() {

        return dvdLibrary.values().stream()
                .max(DVD.DVDReleaseDateComparatorAscending)
                .get();
    }

    @Override
    public DVD getOldestMovieInCollection() {
        return dvdLibrary.values().stream()
                .min(DVD.DVDReleaseDateComparatorAscending)
                .get();
    }

    @Override
    public double getAverageNumberOfNotesInCollection() {
        return dvdLibrary.values().stream()
                .mapToInt(d -> d.getNotesArray().length)
                .average()
                .getAsDouble();
    }

    @Override
    public void loadDVDFromFile(String inputFile) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(inputFile)));

        String currentLine;
        String[] currentTokens;
        while (in.hasNext()) {
            currentLine = in.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            dvdLibrary.put(currentTokens[0],
                    //LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE)
                    new DVD(currentTokens[0], LocalDate.parse(currentTokens[1], DateTimeFormatter.ISO_DATE),
                            currentTokens[2], currentTokens[3],
                            currentTokens[4], currentTokens[5]));
        }
        in.close();

    }

    @Override
    public void saveDVDToFile(String outputFile) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(outputFile));

        Collection<DVD> values = dvdLibrary.values();
        Iterator<DVD> iter = values.iterator();

        DVD dvd;
        while (iter.hasNext()) {
            dvd = iter.next();
            out.println(dvd.getTitle() + DELIMITER + dvd.getReleaseDate() + DELIMITER + dvd.getMpaaRating() + DELIMITER
                    + dvd.getDirectorName() + DELIMITER + dvd.getStudio() + DELIMITER + dvd.getNotes());
            out.flush();
        }
        out.close();
    }
}
