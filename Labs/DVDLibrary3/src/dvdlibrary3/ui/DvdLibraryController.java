/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdlibrary3.ui;

import dvdlibrary3.dao.DvdLibraryImpl;
import dvdlibrary3.domain.Dvd;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DvdLibraryController {


    private DvdLibraryImpl dvdLibrary = new DvdLibraryImpl();
    private ConsoleIO io = new ConsoleIO();

    public static void main(String[] args) {
        DvdLibraryController ui = new DvdLibraryController();
        ui.run();
    }

    public void run() {
        int userChoice = 0;
        do {
            userChoice = displayMenu();
            switch (userChoice) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    removeDvd();
                    break;
                case 3:
                    editDvd();
                    break;
                case 4:
                    listAllDvds();
                    break;
                case 5:
                    moviesReleasedInLastNYEars();
                    break;
                case 6:
                    moviesWithAGivenMPAARating();
                    break;
                case 7:
                    moviesReleasedByDirector();
                    break;
                case 8:
                    moviesReleasedByStudio();
                    break;
                case 9:
                    averageAgeOfMoviesInCollection();
                    break;
                
                case 10:
                    searchDvd();
                    break;
                case 11:
                    loadFromFile();
                    break;
            }

        } while (userChoice != 12);
        // Save the Dvd library back to the file when the program completes. 
        saveToTile();

    }

    private int displayMenu() {
        int choice = -1;        

        while (choice < 0 || choice > 12) {
            io.printStringLn("");
            io.printStringLn(" 1. Add a Dvd to the collection");
            io.printStringLn(" 2. Remove a Dvd from the collection");
            io.printStringLn(" 3. Edit Dvd information from the collection");
            io.printStringLn(" 4. List the Dvd's in the collection");
            io.printStringLn(" 5. List movies released in the last n years");
            io.printStringLn(" 6. List of movies with a given MPAA rating");
            io.printStringLn(" 7. List of movies by director");
            io.printStringLn(" 8. List of movies by studio");
            io.printStringLn(" 9. Average age of movies in the collection"); 
            io.printStringLn("10. Search for a Dvd by title");
            io.printStringLn("11. Load the Dvd library from a file");
            io.printStringLn("12. Quit");
            io.printStringLn("");
            choice = io.promptForInteger("Enter choice: ");
        }
        return choice;
    }

    private void addDvd() {
        io.printStringLn("Please enter the following information");
        String title          = io.promptForString("Title       : ");
        LocalDate releaseDate = io.promptForDate("Release Date: ");
        String mpaaRating     = io.promptForString("MPAA Rating : ");
        String directorName   = io.promptForString("Director    : ");
        String studio         = io.promptForString("Studio      : ");
        String note           = io.promptForString("Notes       : ");
            
        Dvd dvd = new Dvd();
        dvd.setTitle(title);
        dvd.setReleaseDate(releaseDate);
        dvd.setMpaaRating(mpaaRating);
        dvd.setDirector(directorName);
        dvd.setStudio(studio);
        dvd.setNote(note);
        dvdLibrary.add(dvd);
        io.printStringLn("");
        io.printStringLn("Dvd added");
    }

    private void removeDvd() {
        List<Dvd> dvdList = searchDvd();
     
        int entry = io.promptForInteger("Pleaes enter which entry number : ");
        Dvd dvd   = dvdList.get(entry);
        
        dvdLibrary.remove(dvd);
    }

    private void editDvd() {
        List<Dvd> dvdList = searchDvd();

        int entry = io.promptForInteger("Pleaes enter which entry number : ");
        Dvd dvd   = dvdList.get(entry);
        
        LocalDate releaseDate;
        String mpaaRating;
        String directorName;
        String studio;
        String note;

        int choice = -1;

        if (dvd == null) {
            io.printStringLn("Dvd not found");
        } else {

            while (choice != 6) {
                choice = editMenu();
                switch (choice) {
                    case 1:
                        releaseDate = io.promptForDate("Release Date: ");
                        dvd.setReleaseDate(releaseDate);
                        break;

                    case 2:
                        mpaaRating = io.promptForString("MPAA Rating : ");
                        dvd.setMpaaRating(mpaaRating);
                        break;

                    case 3:
                        directorName = io.promptForString("Director    : ");
                        dvd.setDirector(directorName);
                        break;

                    case 4:
                        studio = io.promptForString("Studio      : ");
                        dvd.setStudio(studio);
                        break;

                    case 5:
                        
                        note = io.promptForString("Notes       : ");
                        dvd.setNote(note);                        
                        break;
                }
            }

        }

    }

    private int editMenu() {

        io.printStringLn("Edit Menu: Please select field to edit");
        io.printStringLn("1) Release Date");
        io.printStringLn("2) MPAA Rating");
        io.printStringLn("3) Director");
        io.printStringLn("4) Studio");
        io.printStringLn("5) Notes");
        io.printStringLn("6) Exit Edit Menu");
        int option = io.promptForIntegerWithRange("Enter Choice Now ", 1, 6);
        return option;
    }

    private String askChange(String msg) {
        String isChange;
        do {
            isChange = io.promptForString(msg);
        } while (!isChange.equalsIgnoreCase("y") && !isChange.equalsIgnoreCase("n"));
        return isChange;
    }

    private void displayDvdInfo(Dvd dvd) {
        io.printStringLn("Title       : " + dvd.getTitle());
        io.printStringLn("Release Date: " + dvd.getReleaseDate());
        io.printStringLn("MPAA Rating : " + dvd.getMpaaRating());
        io.printStringLn("Director    : " + dvd.getDirector());
        io.printStringLn("Studio      : " + dvd.getStudio());
        io.printStringLn("Notes       : " + dvd.getNote());
        
        io.printStringLn("");
    }

    private List<Dvd> searchDvd() {
        String title = io.promptForString("Enter Title of Dvd : ");
        List<Dvd> dvdList = dvdLibrary.getByTitle(title);
        displayTheList(dvdList);        
        return dvdList;
    }

    public void listAllDvds() {
        List<Dvd> dvdList = dvdLibrary.listAll();
        displayTheList(dvdList);
    }

    public void moviesReleasedInLastNYEars() {
        int year = io.promptForInteger("Please enter number of years: ");
        List<Dvd> dvdList = dvdLibrary.getReleasesInLastNYears(year);
        displayTheList(dvdList);
    }

    public void moviesWithAGivenMPAARating() {
        String mpaaRating = io.promptForString("Please enter MPAA Rating: ");
        List<Dvd> dvdList = dvdLibrary.getByRating(mpaaRating);
        displayTheList(dvdList);
    }

    public void moviesReleasedByDirector() {
        String director = io.promptForString("Please enter director's name: ");
        Map<String, List<Dvd>> dvdMap = dvdLibrary.getByDirectorGroupByRating(director);

        Set keys = dvdMap.keySet();
        Iterator<String> iter = keys.iterator();
        String mpaa = "";
        List<Dvd> dvdList;

        while (iter.hasNext()) {
            mpaa = iter.next();
            dvdList = dvdMap.get(mpaa);
            io.printStringLn("MPAA Rating : " + mpaa);
            io.printStringLn("");
            displayTheList(dvdList);
        }
    }

    public void moviesReleasedByStudio() {
        String studio = io.promptForString("Please enter studio: ");
        List<Dvd> dvdList = dvdLibrary.getByStudio(studio);
        displayTheList(dvdList);
    }

    public void averageAgeOfMoviesInCollection() {
        double average = dvdLibrary.getAverageAge();
        io.printStringLn("The average age of movies in the collection is "+average);
    }

 
    public void displayTheList(List<Dvd> dvdList) {
        
        for (int i= 0; i < dvdList.size(); i++) {
            io.printStringLn("Entry "+i);
            displayDvdInfo(dvdList.get(i));
        }
    }

    private void loadFromFile() {

        try {
            dvdLibrary.loadFromFile();
        } catch (FileNotFoundException e) {
            io.printStringLn("File not found : " + e.getMessage());
        }
    }

    private void saveToTile() {

        try {
            dvdLibrary.writeToFile();
        } catch (IOException e) {
            io.printStringLn("IO Exception Error : " + e.getMessage());
        }

    }
}

