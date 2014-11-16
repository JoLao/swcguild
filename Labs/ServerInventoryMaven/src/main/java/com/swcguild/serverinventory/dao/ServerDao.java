/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.dao;

import com.swcguild.serverinventory.domain.Server;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface ServerDao {
    public Server addServer(String name, Server server);
    public Server removeServer(String name);
    public Server getServer(String name);
    public List<Server> getServersOlderThan(int ageInYears);
    public Map<String, List<Server>> getServersOlderThanGroupByMake(int ageInYears);
    public List<Server> getServersByMake(String make);
    public double getAverageServerAge();
}
