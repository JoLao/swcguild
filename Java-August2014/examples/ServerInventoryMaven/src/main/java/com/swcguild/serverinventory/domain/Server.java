/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

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
    
    public long getServerAge() {
        Period p = purchaseDate.until(LocalDate.now());
        return p.getYears();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.name).append("\n");
        sb.append("IP Address: ").append(this.ip).append("\n");
        sb.append("Make: ").append(this.make).append("\n");
        sb.append("Num Processors: ").append(this.numProcessors).append("\n");
        sb.append("RAM (GB): ").append(this.ram).append("\n");
        sb.append("Purchase Date: ").append(this.purchaseDate).append("\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.ip);
        hash = 37 * hash + Objects.hashCode(this.make);
        hash = 37 * hash + Objects.hashCode(this.ram);
        hash = 37 * hash + Objects.hashCode(this.numProcessors);
        hash = 37 * hash + Objects.hashCode(this.purchaseDate);
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
        final Server other = (Server) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ip, other.ip)) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        if (!Objects.equals(this.ram, other.ram)) {
            return false;
        }
        if (!Objects.equals(this.numProcessors, other.numProcessors)) {
            return false;
        }
        if (!Objects.equals(this.purchaseDate, other.purchaseDate)) {
            return false;
        }
        return true;
    }
    
    
    
}
