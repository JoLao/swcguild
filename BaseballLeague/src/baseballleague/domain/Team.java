
package baseballleague.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Team {

    private String name;
    private String coach;
    
    private HashMap<String, Player> roster = new HashMap<>();

    public Team() {
    }

    public Team(String name, String coach) {
        this.name = name.toUpperCase();
        this.coach = coach.toUpperCase();
    }            
    
    public Player[] listPlayers() {
        Collection<Player> values = roster.values();        
        return values.toArray(new Player[0]);
    }

    /**
     *
     * @param player
     * @return null if player is not found else return player added
     */    
    public Player addPlayer(Player player) {
        return roster.putIfAbsent(player.getName(), player);        
    }
    
    /**
     *
     * @param player
     * @return null if player is not found else return player removed
     */
    public void removePlayer(Player player) {
        roster.remove(player.getName());
    }
    
    public boolean isPlayerOnThisTeam(String playerName) {
        if (roster.containsKey(playerName)) {
            return true;
        }
        return false;
    }
    
    public boolean isJerseyNumberAlreadyTaken(int jerseyNumber) {
        Player[] players = listPlayers();
        
        for (Player p : players) {
            if (p.getJerseyNumber() == jerseyNumber) {
                return true;
            }
        }
        return false;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach.toUpperCase();
    }

    public HashMap<String, Player> getRoster() {
        return roster;
    }

    public void setRoster(HashMap<String, Player> roster) {
        this.roster = roster;
    }

    public int compareTo(Team compareTeam) {
        int cmp = this.name.compareToIgnoreCase(compareTeam.name);
        if (cmp != 0) {
            return cmp;
        }
        
        cmp = this.coach.compareToIgnoreCase(compareTeam.coach);
        if (cmp != 0) {
            return cmp;
        }
        
        Set<String>        keys   = roster.keySet();
        Collection<Player> values = roster.values();
        String[] names    = keys.toArray(new String[0]);
        Player[] players  = values.toArray(new Player[0]);
        
        Set<String>        cmpKeys   = compareTeam.roster.keySet();
        Collection<Player> cmpValues = compareTeam.roster.values();
        String[] cmpNames    = cmpKeys.toArray(new String[0]);
        Player[] cmpPlayers  = cmpValues.toArray(new Player[0]);
        
        Arrays.sort(names);
        Arrays.sort(players);
        
        Arrays.sort(cmpNames);
        Arrays.sort(cmpPlayers);
        
        
        
        return cmp;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.coach);
        hash = 17 * hash + Objects.hashCode(this.roster);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.coach, other.coach)) {
            return false;
        }
        if (!Objects.equals(this.roster, other.roster)) {
            return false;
        }
        return true;
    }
    
    
}
