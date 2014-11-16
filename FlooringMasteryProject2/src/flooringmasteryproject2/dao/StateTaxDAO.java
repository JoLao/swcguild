/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmasteryproject2.dao;

import flooringmasteryproject2.domain.Order;
import flooringmasteryproject2.domain.Product;
import flooringmasteryproject2.domain.StateTax;
import flooringmasteryproject2.domain.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class StateTaxDAO {
    
    private HashMap<String,  StateTax> stateTaxMap = new HashMap<>();
    
    public static final String STATE_TAX_FILE = "taxes.txt";
    public static final String DELIMITER      = ",";
    
    public StateTax[] getAllStateTaxes() {
        StateTax[] s = stateTaxMap.values().toArray(new StateTax[0]);
        Arrays.sort(s);
        return s;
    }
    
    public boolean isStateAvailable(String state) {

        return stateTaxMap.containsKey(state.toUpperCase());
    }           
    
    public void addStateTax(String stateName, double taxRate) {
        stateTaxMap.put(stateName.toUpperCase(), new StateTax(stateName, taxRate));
    }
    
    public StateTax getStateTax(String stateName) {
        return stateTaxMap.get(stateName.toUpperCase());
    }
    
    public double getStateTaxRate(String stateName) {
        return stateTaxMap.get(stateName.toUpperCase()).getTaxRate();
    }
    
    
    public void removeStateTax(String stateName) {
        stateTaxMap.remove(stateName.toUpperCase());
    }

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
