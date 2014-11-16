/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverinventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ServerInventoryHashMap {
 
    public static void main(String[] args) {
        HashMap<String, Server> servers = new HashMap<>();
        
        //Aggregate operation works with any types of Collections
        Server temp = new Server();
        temp.setName("web01");
        temp.setIp("192.168.1.1");
        temp.setMake("Dell");
        temp.setRam("8GB");
        temp.setNumProcessors("8");
        temp.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        servers.put(temp.getName(), temp);
        
        temp = new Server();
        temp.setName("db01");
        temp.setIp("192.168.3.45");
        temp.setMake("HP");
        temp.setRam("16GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));
        servers.put(temp.getName(), temp);
        
        temp = new Server();
        temp.setName("hr200");
        temp.setIp("192.168.32.11");
        temp.setMake("IBM");
        temp.setRam("16GB");
        temp.setNumProcessors("12");
        temp.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));
        servers.put(temp.getName(), temp);
        
        temp = new Server();
        temp.setName("eng64");
        temp.setIp("192.168.34.56");
        temp.setMake("HP");
        temp.setRam("20GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));
        servers.put(temp.getName(), temp);
        
        temp = new Server();
        temp.setName("web02");
        temp.setIp("192.168.1.5");
        temp.setMake("Dell");
        temp.setRam("8GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2005-01-01", DateTimeFormatter.ISO_DATE));
        servers.put(temp.getName(), temp);
        
        String make = "dElL";
        servers.values().stream()                                   //grab a stream of Server
                .filter(s -> s.getMake().equalsIgnoreCase(make))    //create filter                
                .forEach(e -> System.out.println(e.getName()));     //terminal operation
        
        long testAge = 3;
        servers.values().stream()
                .filter(s -> s.getServerAge() > testAge)
                .forEach(e -> System.out.println(e.getName()));
        
        List<Server> oldServers = 
                servers.values().stream()
                    .filter(s -> s.getServerAge() > testAge)
                    .collect(Collectors.toList());
        
        System.out.println(oldServers.size());
        
        double averageAge =
                servers.values().stream()
                    .mapToDouble(s -> s.getServerAge())   // this is also valid
                    //.mapToLong(Server::getServerAge)    //:: get server age and map to long
                    .average()                        
                    .getAsDouble();
        
        System.out.println("Average age of servers is "+averageAge);
    }
}
