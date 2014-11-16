package dvdlibrary.ui;

import dvdlibrary.dao.DVDLibrary;
import dvdlibrary.domain.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DVDLibraryController {

    private DVDLibrary dvdLibrary = new DVDLibrary();
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
                    searchDVD();
                    break;
                case 6:
                    loadFromFile();
                    break;
            }

        } while (userChoice != 7);
        // Save the DVD library back to the file when the program completes. 
        saveToTile();

    }

    private int displayMenu() {
        int choice = -1;

        while (choice < 0 || choice > 7) {
            System.out.println("");
            System.out.println("1. Add a DVD to the collection");
            System.out.println("2. Remove a DVD from the collection");
            System.out.println("3. Edit DVD information from the collection");
            System.out.println("4. List the DVD's in the collection");
            //System.out.println("4. Display the information for a particular DVD");
            System.out.println("5. Search for a DVD by title");
            System.out.println("6. Load the DVD library from a file");
            System.out.println("7. Quit");
            System.out.println("");
            choice = io.promptForInteger("Enter choice: ");
        }
        return choice;
    }

    private void addDVD() {
        System.out.println("Please enter the following information");
        String title = io.promptForString("Title       : ");
        String releaseDate = io.promptForString("Release Date: ");
        String mpaaRating = io.promptForString("MPAA Rating : ");
        String directorName = io.promptForString("Director    : ");
        String studio = io.promptForString("Studio      : ");
        String notes = io.promptForString("Notes       : ");
        String notes1;
        String moreNotes = io.promptForString("Adding more notes [y/n]? ");;
        while (moreNotes.equalsIgnoreCase("y")) {
            notes1 = io.promptForString("Notes       : ");
            notes = notes + DVD.NOTES_DELIM + notes1;
            moreNotes = io.promptForString("Adding more notes [y/n]? ");

        }
        //System.out.println("notes "+notes);
        DVD dvd = new DVD(title, releaseDate, mpaaRating, directorName, studio, notes);
        dvdLibrary.addDVD(dvd);
        System.out.println("");
        System.out.println("DVD added");
    }

    private void removeDVD() {
        String title = io.promptForString("Enter Title of DVD to Remove : ");
        dvdLibrary.removeDVD(title);
    }

    private void editDVD() {
        DVD dvd = searchDVD();

        String releaseDate;
        String mpaaRating;
        String directorName;
        String studio;
        String notes;

        int choice = -1;

        if (dvd == null) {
            System.out.println("DVD not found");
        } else {

            while (choice != 6) {
                choice = editMenu();
                switch (choice) {
                    case 1:
                        releaseDate = io.promptForString("Release Date: ");
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

        System.out.println("Edit Menu: Please select field to edit");
        System.out.println("1) Release Date");
        System.out.println("2) MPAA Rating");
        System.out.println("3) Director");
        System.out.println("4) Studio");
        System.out.println("5) Notes");
        System.out.println("6) Exit Edit Menu");
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
        System.out.println("Title       : " + dvd.getTitle());
        System.out.println("Release Date: " + dvd.getReleaseDate());
        System.out.println("MPAA Rating : " + dvd.getMpaaRating());
        System.out.println("Director    : " + dvd.getDirectorName());
        System.out.println("Studio      : " + dvd.getStudio());
        System.out.println("Notes       : ");
        String[] notesArr = dvd.getNotesArray();
        for (int i = 0; i < notesArr.length; i++) {
            System.out.println("              " + notesArr[i]);
        }
        System.out.println("");
    }

    private DVD searchDVD() {
        String title = io.promptForString("Enter Title of DVD : ");
        DVD dvd = dvdLibrary.retrieveDVD(title);

        if (dvd != null) {
            displayDVDInfo(dvd);
        } else {
            System.out.println(title + " not found in DVD collection");
        }
        return dvd;

    }

    public void listAllDVDs() {
        DVD[] dvdList = dvdLibrary.retrieveAllDVDs();

        System.out.println("List of DVDs:");
        for (DVD dvd : dvdList) {
            displayDVDInfo(dvd);
            System.out.println("");
        }
    }

    private void loadFromFile() {

        String inputFile = io.promptForString("Input File: ");

        try {
            dvdLibrary.loadDVDFromFile(inputFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        }
    }

    private void saveToTile() {
        String outputFile = io.promptForString("Output File: ");

        try {
            dvdLibrary.saveDVDToFile(outputFile);
        } catch (IOException e) {
            System.out.println("IO Exception Error : " + e.getMessage());
        }

    }
}
