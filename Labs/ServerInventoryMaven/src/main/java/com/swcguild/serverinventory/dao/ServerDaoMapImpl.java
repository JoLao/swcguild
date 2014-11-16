/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.dao;

import com.swcguild.serverinventory.domain.Server;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ServerDaoMapImpl implements ServerDao {

    private Map<String, Server> servers = new HashMap<>();

    @Override
    public Server addServer(String name, Server server) {
        return servers.put(name, server);
    }

    @Override
    public Server removeServer(String name) {
        return servers.remove(name);
    }
    
    @Override
    public Server getServer(String name) {
        return servers.get(name);
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        return servers.values().stream()
                .filter(myServer -> myServer.getServerAge() > ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByMake(int ageInYears) {
        return servers.values().stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.groupingBy(s -> s.getMake()));
    }

    @Override
    public List<Server> getServersByMake(String make) {
        return servers.values().stream()
                .filter(s -> s.getMake().equalsIgnoreCase(make))
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageServerAge() {
        return servers.values().stream()
                .mapToDouble(s -> s.getServerAge())
                .average()
                .getAsDouble();
    }

}
