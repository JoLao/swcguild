/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classmodeling;

/**
 *
 * @author apprentice
 */
public class City {
    private String cityName;
    private String location;
    private String mayorName;
    private double populationCount;

    public City() {
    }

    public City(String cityName, String location) {
        this.cityName = cityName;
        this.location = location;
    } 
    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLocation() {
        return location;
    }

    public String getMayorName() {
        return mayorName;
    }

    public void setMayorName(String mayorName) {
        this.mayorName = mayorName;
    }

    public double getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(double populationCount) {
        this.populationCount = populationCount;
    }
    
    private double calculateRevenue() {
        return 10000.000;
    }
}
