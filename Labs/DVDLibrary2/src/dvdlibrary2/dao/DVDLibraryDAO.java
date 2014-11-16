package dvdlibrary2.dao;
//In this lab you will add the following features to your program: 
// 

import dvdlibrary2.domain.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//1. Find all movies released in the last N years 
//2. Find all the movies with a given MPAA rating 
//3. Find all the movies by a given director 
//a. When searching by director, the movies should be sorted into separate data 
//structures by MPAA rating 
//4. Find all the movies released by a particular studio 
//5. Find the average age of the movies in the collection 
//6. Find the newest movie in your collection 
//7. Find the oldest movie in your collection 
//8. Find the average number of notes associated with movies in your collection 
//9. You must create an Interface for the DVDLibrary API (i.e. your DAO) that contains all the 
//methods specified here and in Version 1 of this lab 
//10. You must create an DVDLibraryImpl class that implements the DVDLibrary interface ­ 
//you must use Lambdas, Streams, and Aggregates in your implementation. 
public interface DVDLibraryDAO {
    public DVD addDVD(DVD dvd);
    
    public DVD removeDVD(String title);
    
    public DVD retrieveDVD(String title);
    
    public List<DVD> retrieveAllDVDs();
    
    public List<DVD> moviesReleasedInLastNYEars(int year);
    public List<DVD> moviesWithAGivenMPAARating(String mpaaRating);
    public Map<String, List<DVD>>  moviesReleasedByDirector(String director);
    public List<DVD> moviesReleasedByStudio(String studio);
    public double    getAverageAgeInCollection();
    public DVD       getNewestMovieInCollection();
    public DVD       getOldestMovieInCollection();
    public double    getAverageNumberOfNotesInCollection();
    public List<DVD> moviesByReleasedDate(LocalDate releaseDate);
    
    
    public void loadDVDFromFile(String inputFile) throws FileNotFoundException;
    public void saveDVDToFile(String outputFile) throws IOException;
}
