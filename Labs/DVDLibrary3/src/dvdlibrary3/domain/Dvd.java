
package dvdlibrary3.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Dvd implements Comparable<Dvd> {
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String note;

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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public long getAge() {
        Period p = releaseDate.until(LocalDate.now());
        return p.getYears();
    }
    
    public int compareTo(Dvd compareDVD) {
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
        
        cmp = this.director.compareToIgnoreCase(compareDVD.director);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.studio.compareToIgnoreCase(compareDVD.studio);
        if (cmp != 0) {
            return cmp;
        }
        
        return this.note.compareToIgnoreCase(compareDVD.note);                        
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.releaseDate);
        hash = 97 * hash + Objects.hashCode(this.mpaaRating);
        hash = 97 * hash + Objects.hashCode(this.director);
        hash = 97 * hash + Objects.hashCode(this.studio);
        hash = 97 * hash + Objects.hashCode(this.note);
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
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }
    
}


