
package baseballleague.dao;

import baseballleague.domain.Player;
import baseballleague.domain.Team;
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



public class BaseballLeague {

    private String name;
    private HashMap<String, Team> teamMap   = new HashMap<>();
    
    public static final String BASEBALL_FILE = "baseball.txt";
    public static final String DELIMITER      = "::";

    
    public Team createNewTeam(Team team) {
        return teamMap.put(team.getName(), team);
    }
    
    public Team getTeam(String teamName) {
        return teamMap.get(teamName);
    }
    
    public Player addPlayer(Team team, Player player) {
        return team.addPlayer(player);
    }
    
    public boolean doesTeamExists(String teamName) {
        return teamMap.containsKey(teamName);
    }
    
    public boolean isPlayerOnATeam(String playerName) {
        Team[] team = listAllTeamsInTheLeague();
        
        for (int i = 0; i < team.length; i++) {
            if (team[i].isPlayerOnThisTeam(playerName)) {
                return true;
            }
        }
        return false;
    }        
    
    public Team[] listAllTeamsInTheLeague() {
        return teamMap.values().toArray(new Team[0]);
    }
    
    public Player[] listAllPlayersInATeam(String teamName) {
        return teamMap.get(teamName).listPlayers();        
    }
    
    public void tradePlayers(Team team1, Player player1, Team team2, Player player2) {
        team1.removePlayer(player1);
        team2.removePlayer(player2);
        team1.addPlayer(player2);
        team2.addPlayer(player1);        
        
    }
    
    public void deletePlayer(Team team, Player player) {
        teamMap.get(team.getName()).removePlayer(player);        
    }
    
    public void loadDataFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new FileReader(BASEBALL_FILE)));
        
        teamMap   = new HashMap<>();
        
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
                currentTeamName  = currentTokens[0];
                currentCoach     = currentTokens[1];  
                currentTeam      = new Team(currentTeamName, currentCoach);
                createNewTeam(currentTeam);
            }
            currentPlayer = new Player(currentTokens[2], 
                                       Integer.parseInt(currentTokens[3]),
                                       currentTokens[0],
                                       currentTokens[4],
                                       currentTokens[5],
                                       currentTokens[6],
                                       currentTokens[7],
                                       currentTokens[8]);
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
