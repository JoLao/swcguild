/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.StateTax;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public interface StateTaxDao {
    String DELIMITER = ",";
    String STATE_TAX_FILE = "taxes.txt";

    void addStateTax(String stateName, double taxRate);

    StateTax[] getAllStateTaxes();

    StateTax getStateTax(String stateName);

    double getStateTaxRate(String stateName);

    boolean isStateAvailable(String state);

    void loadStateTaxMap() throws FileNotFoundException;

    void removeStateTax(String stateName);

    void saveStateTax() throws IOException;
    
}
