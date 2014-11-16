
package com.swcguild.baseballleague.dao;

import com.swcguild.baseballleague.domain.Player;
import com.swcguild.baseballleague.domain.Team;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface BaseballLeague {

    
    public static final String BASEBALL_FILE = "baseball.txt";
    public static final String DELIMITER      = "::";

    
    public Team createNewTeam(Team team);
    
    public Team getTeam(String teamName);
    
    public Player addPlayer(Team team, Player player);
    
    public boolean doesTeamExists(String teamName);
    
    public Team isPlayerOnATeam(String playerName);
    
    public Team[] listAllTeamsInTheLeague();
    
    public Player[] listAllPlayersInATeam(String teamName);
    
    public void tradePlayers(Team team1, Player player1, Team team2, Player player2);
    
    public void loadDataFromFile() throws FileNotFoundException;
    public void saveDataToFile() throws IOException;
}
