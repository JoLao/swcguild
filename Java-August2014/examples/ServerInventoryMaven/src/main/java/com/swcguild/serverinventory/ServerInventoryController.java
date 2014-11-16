package com.swcguild.serverinventory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.swcguild.serverinventory.dao.ServerDao;
import com.swcguild.serverinventory.dao.ServerDaoMockImpl;
import com.swcguild.serverinventory.domain.Server;
import com.swcguild.serverinventory.ui.IO;
import com.swcguild.serverinventory.ui.IOConsoleImpl;
import java.util.List;


/**
 *
 * @author apprentice
 */
public class ServerInventoryController {

    private IO io;
    private ServerDao dao;
    
    public ServerInventoryController(IO io, ServerDao dao) {
        this.io = io;
        this.dao = dao;
    }

//    public void setIo(IO io) {
//        this.io = io;
//    }
//
//    public void setDao(ServerDao dao) {
//        this.dao = dao;
//    }

    public void run() {
        String menuChoice = "";

        do {
            menuChoice = displayMenu();
            
            switch (menuChoice) {
                case "1":
                    addServer();
                    break;
                case "2":
                    removeServer();
                    break;
                case "3":
                    getServersOlderThan();
                    break;
                case "4":
                    getServersByMake();
                    break;
                case "5":
                    displayAverageAgeOfServers();
                    break;
                case "6":
                    getServerByName();
                    break;
                case "Q":
                case "q":
                    // do nothing, this will get us out of the do/while loop
                    io.print("Thank you!  Good Bye.");
                    break;
                default:
                    io.print("ERROR: Invalid choice");
            }

        } while (!menuChoice.equalsIgnoreCase("Q"));
    }
    
    private String displayMenu() {
        return io.readString("\n===========================================\n" + 
                             "1. Add a Server\n" +
                             "2. Remove a Server\n" +
                             "3. Get Servers Older Than\n" +
                             "4. Get Servers by Make\n" +
                             "5. Display Average Age of Server Inventory\n" +
                             "6. Get Server By Name\n" +
                             "Press 'Q' to Quit\n" +
                             "============================================\n");
        
    }

    private void addServer() {
        io.print("ADD SERVER MENU");
        Server temp = new Server();
        temp.setName(io.readString("Enter Server Name:"));
        temp.setIp(io.readString("Enter Server IP Address:"));
        temp.setMake(io.readString("Enter Server Make:"));
        temp.setNumProcessors(io.readString("Enter Number of Processors:"));
        temp.setRam(io.readString("Enter Amount of RAM (in GB):"));
        temp.setPurchaseDate(io.readDate("Enter Purchase Date (yyyy-mm-dd):"));
        dao.addServer(temp.getName(), temp);
        io.print("Server Added Successfully");
    }

    private void removeServer() {
        io.print("REMOVE SERVER MENU");
        String targetServer = io.readString("Enter name of server to remove:");
        dao.removeServer(targetServer);
        io.print("Server Removed Successfully");
        
    }

    private void getServersOlderThan() {
        io.print("GET SERVERS OLDER THAN MENU");
        int targetAge = io.readInt("Enter Target Age:");
        List<Server> serverList = dao.getServersOlderThan(targetAge);
        io.print("===================================");
        serverList.stream()
                .forEach(s -> io.print(s.toString()));
        io.print("===================================");        
    }

    private void getServersByMake() {
        io.print("GET SERVERS BY MAKE MENU");
        String make = io.readString("Enter Server Make:");
        List<Server> serverList = dao.getServersByMake(make);
        io.print("===================================");
        serverList.stream()
                .forEach(s -> io.print(s.toString()));
        io.print("===================================");
    }

    private void displayAverageAgeOfServers() {
        io.print("DISPLY AVERAGE AGE OF SERVERS MENU");
        io.print("===================================");
        io.print("Average Age of Server Inventory: " + dao.getAverageServerAge());
        io.print("===================================");
    }
    
    public void getServerByName() {
        io.print("GET SERVER BY NAME MENU");
        String name = io.readString("Enter Server Name:");
        Server server = dao.getServer(name);
        String msg = "No Server Found With Name [" + name + "]";
        if (server != null) {
            msg = server.toString();
        }
        io.print(msg);
    }

}