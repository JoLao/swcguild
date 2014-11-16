/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverinventory;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author apprentice
 */
public class Server {
    private String name;
    private String ip;
    private String make;
    private String ram;
    private String numProcessors;
    private LocalDate purchaseDate;

    public long getServerAge() {
        Period p = purchaseDate.until(LocalDate.now());
        return p.getYears();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getNumProcessors() {
        return numProcessors;
    }

    public void setNumProcessors(String numProcessors) {
        this.numProcessors = numProcessors;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    
}
