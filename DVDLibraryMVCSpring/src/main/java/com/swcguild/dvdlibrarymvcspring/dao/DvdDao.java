/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcspring.dao;

import com.swcguild.dvdlibrarymvcspring.model.Dvd;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DvdDao {

    void add(Dvd dvd);

    void edit(Dvd dvd);

    double getAverageAge();

    Dvd getDvd(int dvdNumber);

    Map<String, List<Dvd>> getByDirectorGroupByRating(String director);
    
    Map<String, List<Dvd>> getByDirectorGroupByRating2(String director);

    List<Dvd> getByRating(String mpaaRating);

    List<Dvd> getByStudio(String studio);

    List<Dvd> getByTitle(String title);

    List<Dvd> getReleasesInLastNYears(int years);

    List<Dvd> listAll();

    List<Dvd> listDvdByTitle(String title);

    List<Dvd> listBluRayByTitle(String title);

    Map<String, List<Dvd>> listAllGroupByVideoType();

    List<Dvd> listAllByTitle(String title);

    void remove(int dvdNumber);

}
