package ui;

import dvdlibrary2.dao.DVDLibraryImpl;
import dvdlibrary2.domain.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DVDLibraryController {

    private DVDLibraryImpl dvdLibrary = new DVDLibraryImpl();
    private ConsoleIO io = new ConsoleIO();

    public static void main(String[] args) {
        DVDLibraryController ui = new DVDLibraryController();
        ui.run();
    }

    public void run() {
        int userChoice = 0;
        do {
            userChoice = displayMenu();
            switch (userChoice) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listAllDVDs();
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
                    listNewestMoviesInCollection();
                    break;
                case 11:
                    listOldestMoviesInCollection();
                    break;
                case 12:
                    getAverageNumberOfNotesInCollection();
                    break;
                case 13:
                    searchDVD();
                    break;
                case 14:
                    loadFromFile();
                    break;
            }

        } while (userChoice != 15);
        // Save the DVD library back to the file when the program completes. 
        saveToTile();

    }

    private int displayMenu() {
        int choice = -1;        

        while (choice < 0 || choice > 15) {
            io.printStringLn("");
            io.printStringLn(" 1. Add a DVD to the collection");
            io.printStringLn(" 2. Remove a DVD from the collection");
            io.printStringLn(" 3. Edit DVD information from the collection");
            io.printStringLn(" 4. List the DVD's in the collection");
            io.printStringLn(" 5. List movies released in the last n years");
            io.printStringLn(" 6. List of movies with a given MPAA rating");
            io.printStringLn(" 7. List of movies by director");
            io.printStringLn(" 8. List of movies by studio");
            io.printStringLn(" 9. Average age of movies in the collection");
            io.printStringLn("10. List newest movies in the collection");
            io.printStringLn("11  List oldest movies in the collection");
            io.printStringLn("12. Average number of notes in collection");
            io.printStringLn("13. Search for a DVD by title");
            io.printStringLn("14. Load the DVD library from a file");
            io.printStringLn("15. Quit");
            io.printStringLn("");
            choice = io.promptForInteger("Enter choice: ");
        }
        return choice;
    }

    private void addDVD() {
        io.printStringLn("Please enter the following information");
        String title          = io.promptForString("Title       : ");
        LocalDate releaseDate = io.promptForDate("Release Date: ");
        String mpaaRating     = io.promptForString("MPAA Rating : ");
        String directorName   = io.promptForString("Director    : ");
        String studio         = io.promptForString("Studio      : ");
        String notes          = io.promptForString("Notes       : ");
        String notes1;
        String moreNotes      = io.promptForString("Adding more notes [y/n]? ");
        while (moreNotes.equalsIgnoreCase("y")) {
            notes1    = io.promptForString("Notes       : ");
            notes     = notes + DVD.NOTES_DELIM + notes1;
            moreNotes = io.promptForString("Adding more notes [y/n]? ");

        }
        //io.printStringLn("notes "+notes);
        DVD dvd = new DVD(title, releaseDate, mpaaRating, directorName, studio, notes);
        dvdLibrary.addDVD(dvd);
        io.printStringLn("");
        io.printStringLn("DVD added");
    }

    private void removeDVD() {
        String title = io.promptForString("Enter Title of DVD to Remove : ");
        dvdLibrary.removeDVD(title);
    }

    private void editDVD() {
        DVD dvd = searchDVD();

        LocalDate releaseDate;
        String mpaaRating;
        String directorName;
        String studio;
        String notes;

        int choice = -1;

        if (dvd == null) {
            io.printStringLn("DVD not found");
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
                        dvd.setDirectorName(directorName);
                        break;

                    case 4:
                        studio = io.promptForString("Studio      : ");
                        dvd.setStudio(studio);
                        break;

                    case 5:
                        dvd.resetNotes();
                        notes = io.promptForString("Notes       : ");
                        dvd.addNotes(notes);
                        String notes1;
                        String moreNotes = io.promptForString("Adding more notes [y/n]? ");
                        while (moreNotes.equalsIgnoreCase("y")) {
                            notes1 = io.promptForString("Notes       : ");
                            dvd.addNotes(notes1);
                            moreNotes = io.promptForString("Adding more notes [y/n]? ");
                        }
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

    private void displayDVDInfo(DVD dvd) {
        io.printStringLn("Title       : " + dvd.getTitle());
        io.printStringLn("Release Date: " + dvd.getReleaseDate());
        io.printStringLn("MPAA Rating : " + dvd.getMpaaRating());
        io.printStringLn("Director    : " + dvd.getDirectorName());
        io.printStringLn("Studio      : " + dvd.getStudio());
        io.printStringLn("Notes       : ");
        String[] notesArr = dvd.getNotesArray();
        for (int i = 0; i < notesArr.length; i++) {
            io.printStringLn("              " + notesArr[i]);
        }
        io.printStringLn("");
    }

    private DVD searchDVD() {
        String title = io.promptForString("Enter Title of DVD : ");
        DVD dvd = dvdLibrary.retrieveDVD(title);

        if (dvd != null) {
            displayDVDInfo(dvd);
        } else {
            io.printStringLn(title + " not found in DVD collection");
        }
        return dvd;

    }

    public void listAllDVDs() {
        List<DVD> dvdList = dvdLibrary.retrieveAllDVDs();
        displayTheList(dvdList);
    }

    public void moviesReleasedInLastNYEars() {
        int year = io.promptForInteger("Please enter number of years: ");
        List<DVD> dvdList = dvdLibrary.moviesReleasedInLastNYEars(year);
        displayTheList(dvdList);
    }

    public void moviesWithAGivenMPAARating() {
        String mpaaRating = io.promptForString("Please enter MPAA Rating: ");
        List<DVD> dvdList = dvdLibrary.moviesWithAGivenMPAARating(mpaaRating);
        displayTheList(dvdList);
    }

    public void moviesReleasedByDirector() {
        String director = io.promptForString("Please enter director's name: ");
        Map<String, List<DVD>> dvdMap = dvdLibrary.moviesReleasedByDirector(director);

        Set keys = dvdMap.keySet();
        Iterator<String> iter = keys.iterator();
        String mpaa = "";
        List<DVD> dvdList;

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
        List<DVD> dvdList = dvdLibrary.moviesReleasedByStudio(studio);
        displayTheList(dvdList);
    }

    public void averageAgeOfMoviesInCollection() {
        double average = dvdLibrary.getAverageAgeInCollection();
        io.printStringLn("The average age of movies in the collection is "+average);
    }

    public void listNewestMoviesInCollection() {
        DVD dvd = dvdLibrary.getNewestMovieInCollection();
        LocalDate releaseDate = dvd.getReleaseDate();
        List<DVD> dvdList = dvdLibrary.moviesByReleasedDate(releaseDate);
        displayTheList(dvdList);
    }

    public void listOldestMoviesInCollection() {
        DVD dvd = dvdLibrary.getOldestMovieInCollection();
        LocalDate releaseDate = dvd.getReleaseDate();
        List<DVD> dvdList = dvdLibrary.moviesByReleasedDate(releaseDate);
        displayTheList(dvdList);
    }

    public void getAverageNumberOfNotesInCollection() {
        double average = dvdLibrary.getAverageNumberOfNotesInCollection();
        io.printStringLn("The average number of notes in collection is "+average);
    }
    
    public void displayTheList(List<DVD> dvdList) {
//        io.printStringLn("List of DVDs:");
        //for (DVD dvd : dvdList) {
        dvdList.stream().map((dvd) -> {
            displayDVDInfo(dvd);
            return dvd;
        }).forEach((_item) -> {
            io.printStringLn("");
        });
    }

    private void loadFromFile() {

        String inputFile = io.promptForString("Input File: ");

        try {
            dvdLibrary.loadDVDFromFile(inputFile);
        } catch (FileNotFoundException e) {
            io.printStringLn("File not found : " + e.getMessage());
        }
    }

    private void saveToTile() {
        String outputFile = io.promptForString("Output File: ");

        try {
            dvdLibrary.saveDVDToFile(outputFile);
        } catch (IOException e) {
            io.printStringLn("IO Exception Error : " + e.getMessage());
        }

    }
}
