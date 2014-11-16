/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.StateTax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class StateTaxDaoImpl implements StateTaxDao {
    
    private HashMap<String,  StateTax> stateTaxMap = new HashMap<>();
    
    
    @Override
    public StateTax[] getAllStateTaxes() {
        StateTax[] s = stateTaxMap.values().toArray(new StateTax[0]);
        Arrays.sort(s);
        return s;
    }
    
    @Override
    public boolean isStateAvailable(String state) {

        return stateTaxMap.containsKey(state.toUpperCase());
    }           
    
    @Override
    public void addStateTax(String stateName, double taxRate) {
        stateTaxMap.put(stateName.toUpperCase(), new StateTax(stateName, taxRate));
    }
    
    @Override
    public StateTax getStateTax(String stateName) {
        return stateTaxMap.get(stateName.toUpperCase());
    }
    
    @Override
    public double getStateTaxRate(String stateName) {
        return stateTaxMap.get(stateName.toUpperCase()).getTaxRate();
    }
    
    
    @Override
    public void removeStateTax(String stateName) {
        stateTaxMap.remove(stateName.toUpperCase());
    }

    @Override
    public void loadStateTaxMap() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(STATE_TAX_FILE)));

        String currentRecord = "";
        String[] currentTokens;
        StateTax s;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            s = new StateTax(currentTokens[0], Double.parseDouble(currentTokens[1]));
            stateTaxMap.put(currentTokens[0].toUpperCase(), s);
        }
        in.close();

    }
    
    @Override
    public void saveStateTax() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(STATE_TAX_FILE));
        
        Collection<StateTax> values = stateTaxMap.values();
        Iterator<StateTax>   iter   = values.iterator();
        StateTax s;
        while (iter.hasNext()) {
            s = iter.next();
            out.println(s.getState()+DELIMITER
                      + s.getTaxRate());
            out.flush();
        }
        out.close();
        
    }
    
}
