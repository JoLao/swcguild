package dvdlibrary3.dao;

import dvdlibrary3.domain.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DvdLibraryImpl implements DvdLibraryDao {

    List<Dvd> dvdLibrary = new ArrayList<>();

    public static final String DVD_FILE = "dvdLibrary.txt";
    public static final String DELIMITER  = "::";

    @Override
    public void add(Dvd dvd) {
        dvdLibrary.add(dvd);
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        return dvdLibrary.stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Dvd dvd) {
        dvdLibrary.remove(dvd);
    }

    @Override
    public List<Dvd> listAll() {       
        
        return dvdLibrary.stream().collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getReleasesInLastNYears(int years) {
        return dvdLibrary.stream()
                .filter(d -> d.getAge() <= years)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByRating(String mpaaRating) {
        return dvdLibrary.stream()
                .filter(d -> d.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director) {
        return dvdLibrary.stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(director))
                .sorted()
                .collect(Collectors.groupingBy(d -> d.getMpaaRating()));
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        return dvdLibrary.stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .sorted()
                .collect(Collectors.toList());
    }

    
    @Override
    public double getAverageAge() {
        return dvdLibrary.stream()
                .mapToDouble(d -> d.getAge())
                .average()
                .getAsDouble();
    }

   

    @Override
    public void loadFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));

        String currentLine;
        String[] currentTokens;
        Dvd    dvd;
        while (in.hasNext()) {
            currentLine = in.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            dvd = new Dvd();
            dvd.setTitle(currentTokens[0]);
            dvd.setReleaseDate(LocalDate.parse(currentTokens[1], DateTimeFormatter.ISO_DATE));
            dvd.setMpaaRating(currentTokens[2]);
            dvd.setDirector(currentTokens[3]);
            dvd.setStudio(currentTokens[4]);
            dvd.setNote(currentTokens[5]);
            dvdLibrary.add(dvd);
        }
        in.close();
        Collections.sort(dvdLibrary);
    }

    @Override
    public void writeToFile() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(DVD_FILE));

        for (Dvd dvd : dvdLibrary) {
        
            out.println(dvd.getTitle() + DELIMITER 
                      + dvd.getReleaseDate() + DELIMITER 
                      + dvd.getMpaaRating() + DELIMITER
                      + dvd.getDirector() + DELIMITER 
                      + dvd.getStudio() + DELIMITER 
                      + dvd.getNote());
            out.flush();
        }
        out.close();
    }
}

