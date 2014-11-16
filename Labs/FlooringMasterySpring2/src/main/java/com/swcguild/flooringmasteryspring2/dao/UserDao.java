/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringmasteryspring2.dao;

import com.swcguild.flooringmasteryspring2.domain.User;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface UserDao {
    String DELIMITER = ",";
    String USER_FILE = "users.txt";

    User checkIfUserExists(String userName, String password);
    
    public HashMap<String, User> listAllUsers();
    void loadUsers() throws FileNotFoundException;
    
}
