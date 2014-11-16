/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinventory.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import serverinventory.domain.Server;

/**
 *
 * @author apprentice
 */
public class ServerDaoMockImpl implements ServerDao {
    
    Server temp = new Server();
    List<Server> tempList = new ArrayList<>();
    Map<String, List<Server>> tempMap = new HashMap<>();
    
    public ServerDaoMockImpl() {
        temp.setName("BOGUS");
        temp.setIp("0.0.0.0");
        temp.setMake("FAKE");
        temp.setNumProcessors("0");
        temp.setRam("0");
        temp.setPurchaseDate(LocalDate.parse("1900-01-01", DateTimeFormatter.ISO_DATE));
        tempList.add(temp);
        tempMap.put("NO COMPANY", tempList);
    }

    @Override
    public Server addServer(String name, Server server) {
        return server;
    }

    @Override
    public Server removeServer(String name) {
        return temp;
    }

    @Override
    public Server getServer(String name) {
        return temp;
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        return tempList;
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByMake(int ageInYears) {
        return tempMap;
    }

    @Override
    public List<Server> getServersByMake(String make) {
        return tempList;
    }

    @Override
    public double getAverageServerAge() {
        return 0;
    }
    
}
