/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.User;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserDaoImpl implements UserDao {

    private HashMap<String,  User>     userMap     = new HashMap<>();


    @Override
    public User checkIfUserExists(String userName, String password) {
        if (userMap.containsKey(userName)) {
            if (userMap.get(userName).getPassword().equals(password)) {
                return userMap.get(userName);
            }
        }
        return null;
    }
    
    @Override
    public HashMap<String, User> listAllUsers() {
        return userMap;
    }
    
    @Override
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
