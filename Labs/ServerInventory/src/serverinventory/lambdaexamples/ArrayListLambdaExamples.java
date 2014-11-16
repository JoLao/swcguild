/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinventory.lambdaexamples;

import serverinventory.domain.Server;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ArrayListLambdaExamples {

    public static void main(String[] args) {
        ArrayList<Server> servers = new ArrayList<>();

        Server temp = new Server();
        temp.setName("web01");
        temp.setIp("192.168.1.1");
        temp.setMake("Dell");
        temp.setRam("8GB");
        temp.setNumProcessors("8");
        temp.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);

        temp = new Server();
        temp.setName("db01");
        temp.setIp("192.168.3.45");
        temp.setMake("HP");
        temp.setRam("16GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);

        temp = new Server();
        temp.setName("hr200");
        temp.setIp("192.168.32.111");
        temp.setMake("IBM");
        temp.setRam("16GB");
        temp.setNumProcessors("12");
        temp.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);

        temp = new Server();
        temp.setName("eng64");
        temp.setIp("192.168.34.56");
        temp.setMake("HP");
        temp.setRam("20GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);

        temp = new Server();
        temp.setName("web02");
        temp.setIp("192.168.1.5");
        temp.setMake("Dell");
        temp.setRam("8GB");
        temp.setNumProcessors("24");
        temp.setPurchaseDate(LocalDate.parse("2005-01-01", DateTimeFormatter.ISO_DATE));
        servers.add(temp);

        String make = "dElL";
        servers.stream()
                .filter((Server myServer) -> {

                    return myServer.getMake().equalsIgnoreCase(make);

                })
                .forEach((Server e) -> {
                    System.out.println(e.getName());
                });
        
        long testAge = 3;
        servers.stream()
                .filter(s -> s.getServerAge() > testAge)
                .forEach(e -> System.out.println(e.getName()));
        
        List<Server> oldServers = 
                servers.stream()
                .filter(s -> s.getServerAge() > testAge)
                .collect(Collectors.toList());
        
        System.out.println(oldServers.size());
        
        double averageAge = 
                servers.stream()
                .mapToDouble(s -> s.getServerAge())
                .average()
                .getAsDouble();
        
        System.out.println("Avg age of servers is: " + averageAge);
        
        OptionalLong maxAge = servers.stream()
                .mapToLong(s -> s.getServerAge())
                .max();
        
        if (maxAge.isPresent()) {
            System.out.println("Max server age is " + maxAge.getAsLong());
        }

    }

}
