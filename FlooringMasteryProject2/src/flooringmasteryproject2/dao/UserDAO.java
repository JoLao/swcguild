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
public class UserDAO {

    private HashMap<String,  User>     userMap     = new HashMap<>();

    public static final String USER_FILE      = "users.txt";  
    public static final String DELIMITER      = ",";

    public User checkIfUserExists(String userName, String password) {
        if (userMap.containsKey(userName)) {
            if (userMap.get(userName).getPassword().equals(password)) {
                return userMap.get(userName);
            }
        }
        return null;
    }
    
    public void loadUsers() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(USER_FILE)));
        
        String   currentRecord = "";
        String[] currentTokens;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            userMap.put(currentTokens[0], 
                        new User(currentTokens[0],
                                 currentTokens[1],
                                 currentTokens[2],
                                 currentTokens[3],
                                 Integer.parseInt(currentTokens[4])));
        }
    }

}
