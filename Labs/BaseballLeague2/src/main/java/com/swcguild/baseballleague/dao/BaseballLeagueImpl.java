
package com.swcguild.baseballleague.dao;

import com.swcguild.baseballleague.domain.Player;
import com.swcguild.baseballleague.domain.Team;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;



public class BaseballLeagueImpl implements BaseballLeague {

    private String name;
    private HashMap<String, Team> teamMap   = new HashMap<>();    
    
    @Override
    public Team createNewTeam(Team team) {
        return teamMap.put(team.getName().toUpperCase(), team);
    }
    
    @Override
    public Team getTeam(String teamName) {
        return teamMap.get(teamName.toUpperCase());
    }
    
    @Override
    public Player addPlayer(Team team, Player player) {
        return team.addPlayer(player);
    }
    
    @Override
    public boolean doesTeamExists(String teamName) {
        return teamMap.containsKey(teamName.toUpperCase());
    }
    
    @Override
    public Team isPlayerOnATeam(String playerName) {
        Team[] team  = listAllTeamsInTheLeague();
        Team   team1 = new Team();
        for (int i = 0; i < team.length; i++) {
            if (team[i].isPlayerOnThisTeam(playerName.toUpperCase())) {
                team1 = team[i];
            }
        }
        return team1;
    }        
    
    @Override
    public Team[] listAllTeamsInTheLeague() {
        return teamMap.values().toArray(new Team[0]);
    }
    
    @Override
    public Player[] listAllPlayersInATeam(String teamName) {
        return teamMap.get(teamName.toUpperCase()).listPlayers();        
    }
    
    @Override
    public void tradePlayers(Team team1, Player player1, Team team2, Player player2) {
        team1.removePlayer(player1.getName());
        team2.removePlayer(player2.getName());
        team1.addPlayer(player2);
        team2.addPlayer(player1);               
    }    
    
    @Override
    public void loadDataFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(BASEBALL_FILE)));
        
        teamMap    = new HashMap<>();
        
        String   currentRecord;
        String[] currentTokens;
        String   currentTeamName = "";
        String   currentCoach;
        Team     currentTeam     = new Team();
        Player   currentPlayer;
        while (in.hasNext()) {
            currentRecord = in.nextLine();
            currentTokens = currentRecord.split(DELIMITER);
            
            if (!currentTeamName.equalsIgnoreCase(currentTokens[0])) {
                currentTeamName  = currentTokens[0].toUpperCase();
                currentCoach     = currentTokens[1].toUpperCase();  
                currentTeam      = new Team(currentTeamName, currentCoach);
                createNewTeam(currentTeam);
            }
            currentPlayer = new Player(currentTokens[2].toUpperCase(), 
                                       Integer.parseInt(currentTokens[3]),
                                       currentTokens[0].toUpperCase(),
                                       currentTokens[4].toUpperCase(),
                                       currentTokens[5].toUpperCase(),
                                       currentTokens[6].toUpperCase(),
                                       currentTokens[7].toUpperCase(),
                                       currentTokens[8].toUpperCase());
            addPlayer(currentTeam, currentPlayer);            
        }
        in.close();
    }
    
    public void saveDataToFile() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(BASEBALL_FILE));
        
        Collection<Team> values = teamMap.values();
        Iterator<Team>   iter   = values.iterator();
        
        Team team;
        Player[] players;
        while (iter.hasNext()) {
            team = iter.next();
            players = team.listPlayers();
            for (int i = 0; i < players.length; i++) {
                out.println(team.getName()+DELIMITER+
                            team.getCoach()+DELIMITER+
                            players[i].getName()+DELIMITER+
                            players[i].getJerseyNumber()+DELIMITER+
                            players[i].getPosition()+DELIMITER+
                            players[i].getBattingHand()+DELIMITER+
                            players[i].getThrowingHand()+DELIMITER+
                            players[i].getPhone()+DELIMITER+
                            players[i].getBirthday());
                out.flush();
            }
        }
        out.close();
        
    }
}
