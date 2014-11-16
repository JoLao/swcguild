/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinventory.lambdaexamples;

import serverinventory.domain.Server;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class HashMapLambdaExamples {
    
    public static void main(String[] args) {
        HashMap<String, Server> servers = new HashMap<>();

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
        temp.setIp("192.168.32.111");
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
        servers.values().stream()
                .filter((Server myServer) -> {

                    return myServer.getMake().equalsIgnoreCase(make);

                })
                .forEach((Server e) -> {
                    System.out.println(e.getName());
                });
 
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
                .mapToDouble(s -> s.getServerAge())
                .average()
                .getAsDouble();
        
        System.out.println("Avg age of servers is: " + averageAge);


    }
    
}
