/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcspring.dao;

import com.swcguild.dvdlibrarymvcspring.model.Dvd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DvdDaoInMemImpl implements DvdDao {

    Map<Integer, Dvd> dvdMap = new HashMap<>();
    private static int dvdCounter = 0;
    
    @Override
    public void add(Dvd dvd) {
        dvd.setDvdId(dvdCounter++);
        dvdMap.put(dvd.getDvdId(), dvd);
    }
    
    @Override
    public void edit(Dvd dvd) {
        dvdMap.put(dvd.getDvdId(), dvd);
    }
    
    @Override
    public Dvd    getDvd(int dvdNumber) {
        return dvdMap.get(dvdNumber);
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int dvdNumber) {
        dvdMap.remove(dvdNumber);
    }

    @Override
    public List<Dvd> listAll() {       
        
        return dvdMap.values().stream().sorted().collect(Collectors.toList());
    }
    
    @Override
    public List<Dvd> listDvdByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title) && d.getVideoType().equalsIgnoreCase("DVD"))
                .sorted()
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Dvd> listBluRayByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title) && d.getVideoType().equalsIgnoreCase("BluRay"))
                .sorted()
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Dvd> listAllByTitle(String title) {
        return dvdMap.values().stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title))
                .sorted()
                .collect(Collectors.toList());
    }
    
    @Override
    public Map<String, List<Dvd>> listAllGroupByVideoType() {
        return dvdMap.values().stream()
                .sorted()
                .collect(Collectors.groupingBy(d -> d.getVideoType()));
    }

    @Override
    public List<Dvd> getReleasesInLastNYears(int years) {
        return dvdMap.values().stream()
                .filter(d -> d.getAge() <= years)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<Dvd> getByRating(String mpaaRating) {
        return dvdMap.values().stream()
                .filter(d -> d.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director) {
        return dvdMap.values().stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(director))
                .sorted()
                .collect(Collectors.groupingBy(d -> d.getMpaaRating()));
    }
    
    @Override
    public Map<String, List<Dvd>> getByDirectorGroupByRating2(String director) {
        Map<String, List<Dvd>> directorByMpaaRating = new HashMap<>();
        
        String[] ratings = {"G", "PG-13", "R", "NC-17"};
        
        
        Collection<Dvd> values = dvdMap.values();        
        Iterator<Dvd> iter = values.iterator();
        List<Dvd> dvdListG = new ArrayList<>();
        List<Dvd> dvdListPG13 = new ArrayList<>();
        List<Dvd> dvdListR = new ArrayList<>();
        List<Dvd> dvdListNC17 = new ArrayList<>();
        String rating;
        Dvd dvd;
        while (iter.hasNext()) {
            dvd = iter.next();
            if (dvd.getDirector().equalsIgnoreCase(director)) {
                rating = dvd.getMpaaRating();
            
                switch (rating) {
                    case "G" :
                        dvdListG.add(dvd);
                        break;
                    case "PG-13":
                        dvdListPG13.add(dvd);
                        break;
                    case "R":
                        dvdListR.add(dvd);
                        break;
                    case "NC-17":
                        dvdListNC17.add(dvd);
                        break;
                }
            }
        }
        
        Collections.sort(dvdListG);
        Collections.sort(dvdListPG13);
        Collections.sort(dvdListR);
        Collections.sort(dvdListNC17);
            
        directorByMpaaRating.put("G", dvdListG);
        directorByMpaaRating.put("PG-13", dvdListPG13);
        directorByMpaaRating.put("R", dvdListR);
        directorByMpaaRating.put("NC-17", dvdListNC17);
        
        return directorByMpaaRating;
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        return dvdMap.values().stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .sorted()
                .collect(Collectors.toList());
    }

    
    @Override
    public double getAverageAge() {
        return dvdMap.values().stream()
                .mapToDouble(d -> d.getAge())
                .average()
                .getAsDouble();
    }

}
