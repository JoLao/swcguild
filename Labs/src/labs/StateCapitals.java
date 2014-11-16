
package labs;

//1. This program will be a Java Console Application called StateCaptials  

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//2. Creates a HashMap to hold the names of all the states and their corresponding capital 
//names (State name is the key, capital name is the value) 
//3. Loads the HashMap with the each State/Capital pair (this should be hard coded) 
//4. Prints all of the state names to the screen (hint ­ get the keys from the map and then print 
//each state name one by one) 
//5. Prints all of the capital names to the screen (hint ­ get the values from the map and then 
//print each capital name to the screen one by one) 
//6. Prints each state along with its capital to the screen (hint ­ use the key set to get each 
//value from the map one by one printing both the key and value as you go) 
public class StateCapitals {
    public static void main(String[] args) {
        HashMap<String, String> stateMap =  new HashMap<>();
                
        stateMap.put("Alabama", "Montgomery");
        stateMap.put("Alaska", "Juneau");
        stateMap.put("Arizona", "Phoenix");
        stateMap.put("Arkansas", "Little Rock");
        stateMap.put("California", "Sacramento");
        stateMap.put("Colorado", "Denver");
        stateMap.put("Connecticut", "Hartford");
        stateMap.put("Delaware", "Dover");
        stateMap.put("Florida", "Tallahassee");
        stateMap.put("Georgia", "Atlanta");
        stateMap.put("Hawaii", "Honolulu");
        stateMap.put("Idaho", "Boise");
        stateMap.put("Illinois", "Springfield");
        stateMap.put("Indiana", "Indianapolis");
        stateMap.put("Iowa", "Des Moines");
        stateMap.put("Kansas", "Topeka");
        stateMap.put("Kentucky", "Frankfort");
        stateMap.put("Louisana", "Baton Rouge");
        stateMap.put("Maine", "Augusta");
        stateMap.put("Maryland", "Annapolis");
        stateMap.put("Massachusetts", "Boston");
        stateMap.put("Michigan", "Lansing");
        stateMap.put("Minnesota", "Saint Paul");
        stateMap.put("Mississippi", "Jackson");
        stateMap.put("Missouri", "Jefferson City");
        stateMap.put("Montana", "Helena");
        stateMap.put("Nebraska", "Lincoln");
        stateMap.put("Nevada", "Carson City");
        stateMap.put("New Hampshire", "Concord");
        stateMap.put("New Jersey", "Trenton");
        stateMap.put("New Mexico", "Santa Fe");
        stateMap.put("New York", "Albany");
        stateMap.put("North Carolina", "Raleigh");
        stateMap.put("North Dakota", "Bismarck");
        stateMap.put("Ohio", "Columbus");
        stateMap.put("Oklahoma", "Oklahoma City");
        stateMap.put("Oregon", "Salem");
        stateMap.put("Pennsylvania", "Harrisburg");
        stateMap.put("Rhode Island", "Providence");
        stateMap.put("South Carolina", "Columbia");
        stateMap.put("South Dakota", "Pierre");
        stateMap.put("Tennessee", "Nashville");
        stateMap.put("Texas", "Austin");
        stateMap.put("Utah", "Salt Lake City");
        stateMap.put("Vermont", "Monpelier");
        stateMap.put("Virginia", "Richmond");
        stateMap.put("Washington", "Olympia");
        stateMap.put("West Virginia", "Charleston");
        stateMap.put("Wisconsin", "Madison");
        stateMap.put("Wyoming", "Cheyenne");     
        
        //list out all the keys in the map
        System.out.println("");
        System.out.println("List of States:");
        Set<String> keys = stateMap.keySet();
        
        Iterator<String> iter1 = keys.iterator();
        
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        
        //list out all the values in the map
        System.out.println("");
        System.out.println("List of Values: ");        
        Collection<String> values = stateMap.values();
        Iterator<String> iter2 = values.iterator();
        while (iter2.hasNext()) {            
            System.out.println(iter2.next());
        }
        
        System.out.println("");
        System.out.println("State                     Capital");
        System.out.println("==================================================");
        Iterator<String> iter3 = keys.iterator();
        String state = "";
        while (iter3.hasNext()) {
            state = iter3.next();
            //System.out.println(state+"        "+stateMap.get(state));
            System.out.printf("%-25s %-25s \n",state,stateMap.get(state));
        }
    }
}
