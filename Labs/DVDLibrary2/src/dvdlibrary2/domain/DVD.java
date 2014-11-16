
package dvdlibrary2.domain;

//Design a DVD class to hold all the information about a DVD.  It must contain at least the 

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Objects;

//following: 
//a. Title 
//b. Release date 
//c. MPAA Rating 
//d. Director's Name 
//e. Studio 
//f. User Rating or Note (allows user to enter additional information about the DVD i.e. 
//'Good family movie') 
public class DVD implements Comparable<DVD> {
    
    private String    title;
    private LocalDate releaseDate;
    private String    mpaaRating;
    private String    directorName;
    private String    studio;
    private String    notes;
    //private ArrayList<String> notesArr;
    
    public static final String NOTES_DELIM = "##";

    public DVD(String title, LocalDate releaseDate, String mpaaRating, 
               String directorName, String studio, String notes) {
        this.title        = title;
        this.releaseDate  = releaseDate;
        this.mpaaRating   = mpaaRating;
        this.directorName = directorName;
        this.studio       = studio;
        this.notes        = notes;
        //this.notesArr     = new  ArrayList<String>(Arrays.asList(notes.toLowerCase().split(NOTES_DELIM)));
    }
    
    public long getMovieAge() {
        Period p = releaseDate.until(LocalDate.now());         
        return p.getYears();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
    
    public void addNotes(String notes) {
        if (!this.notes.equals("")) {
            //this.notesArr.add(notes);
            notes = NOTES_DELIM + notes;   
//            System.out.println("add notes delim "+notes);
        }                
        this.notes = this.notes + notes;
//        System.out.println("new notes :"+this.notes);
    }
    
    public void resetNotes() {
        this.notes = "";
    }
    
    public String getNotes() {
        return this.notes;
    }
    
    public String[] getNotesArray() {
  
        return this.notes.split(NOTES_DELIM);
        //return this.notesArr.toArray(new String[0]);
    }
    
    public int compareTo(DVD compareDVD) {
//        String title, String releaseDate, String mpaaRating, 
//               String directorName, String studio, String notes
        int cmp = this.title.compareToIgnoreCase(compareDVD.title);
        if (cmp != 0) {
            return cmp;
        }
        cmp = this.releaseDate.compareTo(compareDVD.releaseDate);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.mpaaRating.compareToIgnoreCase(compareDVD.mpaaRating);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.directorName.compareToIgnoreCase(compareDVD.directorName);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.studio.compareToIgnoreCase(compareDVD.studio);
        if (cmp != 0) {
            return cmp;
        }
        
        return this.notes.compareToIgnoreCase(compareDVD.notes);                        
    }
//    public static Comparator<DVD> DVDReleaseDateComparatorAscending
//                    = new Comparator<DVD>() {
//
//                public int compare(DVD dvd1, DVD dvd2) {
//
//                    LocalDate dvdReleaseDate1 = dvd1.getReleaseDate();
//                    LocalDate dvdReleaseDate2 = dvd2.getReleaseDate();
//
//                    //ascending order
//                    return dvdReleaseDate1.compareTo(dvdReleaseDate2);
//                    //return carMake1.compareTo(carMake2);
//
//                    //descending order
//                    //return carMake2.compareTo(carMake1);
//                }
//            };
    public static Comparator<DVD> DVDReleaseDateComparatorAscending
                    = (DVD dvd1, DVD dvd2) -> {
                        LocalDate dvdReleaseDate1 = dvd1.getReleaseDate();
                        LocalDate dvdReleaseDate2 = dvd2.getReleaseDate();
                        
                        //ascending order
                        return dvdReleaseDate1.compareTo(dvdReleaseDate2);
    };
            
    public static Comparator<DVD> DVDMPAARatingComparator
                    = (DVD dvd1, DVD dvd2) -> {
                        String dvdMPAARating1 = dvd1.getMpaaRating();
                        String dvdMPAARating2 = dvd2.getMpaaRating();
                        
                        //descending order
                        return dvdMPAARating1.compareTo(dvdMPAARating2);
    };
            
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.releaseDate);
        hash = 89 * hash + Objects.hashCode(this.mpaaRating);
        hash = 89 * hash + Objects.hashCode(this.directorName);
        hash = 89 * hash + Objects.hashCode(this.studio);
        hash = 89 * hash + Objects.hashCode(this.notes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.directorName, other.directorName)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.notes, other.notes)) {
            return false;
        }
        return true;
    }
    
    
}
