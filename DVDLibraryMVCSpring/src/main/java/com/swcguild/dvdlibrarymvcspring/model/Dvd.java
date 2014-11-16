package com.swcguild.dvdlibrarymvcspring.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Dvd implements Comparable<Dvd> {

    private int dvdId;
    private String videoType;

    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String reviews;

//    private LocalDate checkOutDate;
//    private Integer accountNumber;

    public int getAge() {
        Period p = releaseDate.until(LocalDate.now());
        return p.getYears();
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
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

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

//    public LocalDate getCheckOutDate() {
//        return checkOutDate;
//    }
//
//    public void setCheckOutDate(LocalDate checkOutDate) {
//        this.checkOutDate = checkOutDate;
//    }
//
//    public int getAccount() {
//        return accountNumber;
//    }
//
//    public void setAccount(int accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    @Override
    public int compareTo(Dvd compareDvd) {
        int cmp = this.dvdId > compareDvd.dvdId ? +1 : this.dvdId < compareDvd.dvdId ? -1 : 0;
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.videoType.compareToIgnoreCase(compareDvd.videoType);
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.title.compareToIgnoreCase(compareDvd.title);
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.releaseDate.compareTo(compareDvd.releaseDate);
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.mpaaRating.compareToIgnoreCase(compareDvd.mpaaRating);
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.director.compareToIgnoreCase(compareDvd.director);
        if (cmp != 0) {
            return cmp;
        }

        cmp = this.studio.compareToIgnoreCase(compareDvd.studio);
        if (cmp != 0) {
            return cmp;
        }

        return this.reviews.compareToIgnoreCase(compareDvd.reviews);
        
//        try {
//            cmp = this.checkOutDate.compareTo(compareDvd.checkOutDate);
//            if (cmp != 0) {
//                return cmp;
//            }
//        } catch (NullPointerException npe) {
//            if (this.checkOutDate == null & compareDvd.checkOutDate == null) {
//                cmp = 0;
//            } else if (this.checkOutDate == null & compareDvd.checkOutDate != null) {
//                cmp = -1;
//            } else if (this.checkOutDate != null & compareDvd.checkOutDate == null) {
//                cmp = 1;
//            }
//        }
//
//        return Integer.compare(this.accountNumber, compareDvd.accountNumber);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.dvdId;
        hash = 23 * hash + Objects.hashCode(this.videoType);
        hash = 23 * hash + Objects.hashCode(this.title);
        hash = 23 * hash + Objects.hashCode(this.releaseDate);
        hash = 23 * hash + Objects.hashCode(this.mpaaRating);
        hash = 23 * hash + Objects.hashCode(this.director);
        hash = 23 * hash + Objects.hashCode(this.studio);
        hash = 23 * hash + Objects.hashCode(this.reviews);
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
        if (this.dvdId != other.dvdId) {
            return false;
        }
        if (!Objects.equals(this.videoType, other.videoType)) {
            return false;
        }
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
        if (!Objects.equals(this.reviews, other.reviews)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return this.dvdId + " " + this.videoType + " " + this.title;
    }

}
