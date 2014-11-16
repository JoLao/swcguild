
package labs;
//In this lab you will write a simple program that holds all of the states and their corresponding 
//capitals in a HashMap.  This lab is similar to Lab 01 except you will create an object to hold 

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//information about the capital of each state.  This object (rather than the city name String) will be 
//the value for each state/capital pair. 
// 
//Your program must have the following features:  
// 
//1. This program will be a Java Console Application called StateCaptials2  
//2. A class called Capital with the following properties: 
//   a. Name 
//   b. Population 
//   c. Square mileage 
//3. A HashMap that holds the names of all the states and their corresponding Capital objects 
//(State name is the key, Capital object is the value) 
//4. Prints the Name, Population, and Square mileage for each capital along with its 
//corresponding state name to the screen (hint ­ use the key set to get each capital object 
//out of the map one by one and then print each field of the Capital object to the screen) 
//5. Prints the states with capitals that have a population over a given value (this value is 
//typed in by the user of the program) to the screen (hint ­ you will have to add code to ask 
//the user for a minimum population.  Once you have this value, go through each 
//state/capital pair as you did for #4 above but only print the information for capitals that 
//have a population above the limit) 
public class StateCapital2 {
    public static void main(String[] args) {
        HashMap<String, Capital> stateMap = new HashMap<>();
        ConsoleIO io = new ConsoleIO();
        
        stateMap.put("Alabama", new Capital("Montgomery",4779736,51705));
        stateMap.put("Alaska", new Capital("Juneau",710231,300));
        stateMap.put("Arizona", new Capital("Phoenix",29248,2944));
        stateMap.put("Arkansas", new Capital("Little Rock",312323,4312));
        stateMap.put("California", new Capital("Sacramento",2393234,3233));
        stateMap.put("Colorado", new Capital("Denver",244329,3423));
        stateMap.put("Connecticut", new Capital("Hartford",242332,3423));
        stateMap.put("Delaware", new Capital("Dover",324323,342334));
        stateMap.put("Florida", new Capital("Tallahassee",3243243,32423));
        stateMap.put("Georgia", new Capital("Atlanta",3234245,7695));
        stateMap.put("Hawaii", new Capital("Honolulu",4539543,35234));
        stateMap.put("Idaho", new Capital("Boise",312943,4558));
        stateMap.put("Illinois", new Capital("Springfield",4324354,4352));
        stateMap.put("Indiana", new Capital("Indianapolis",325204,5325));
        stateMap.put("Iowa", new Capital("Des Moines",432523,5232));
        stateMap.put("Kansas", new Capital("Topeka",4325389,54423));
        stateMap.put("Kentucky", new Capital("Frankfort",75664746,674754));
        stateMap.put("Louisana", new Capital("Baton Rouge",4354565,5634));
        stateMap.put("Maine", new Capital("Augusta",32342,5435));
        stateMap.put("Maryland", new Capital("Annapolis",452435,3532));
        stateMap.put("Massachusetts", new Capital("Boston",3534554,3455));
        stateMap.put("Michigan", new Capital("Lansing",353453,7654));
        stateMap.put("Minnesota", new Capital("Saint Paul",84568,6848));
        stateMap.put("Mississippi", new Capital("Jackson",73357,7337));
        stateMap.put("Missouri", new Capital("Jefferson City",3733567,56754));
        stateMap.put("Montana", new Capital("Helena",84642,5466));
        stateMap.put("Nebraska", new Capital("Lincoln",653776,7647));
        stateMap.put("Nevada", new Capital("Carson City",245252,5633));
        stateMap.put("New Hampshire", new Capital("Concord",65373,363));
        stateMap.put("New Jersey", new Capital("Trenton",76573547,5363));
        stateMap.put("New Mexico", new Capital("Santa Fe",56363,5363));
        stateMap.put("New York", new Capital("Albany",563775,57377));
        stateMap.put("North Carolina", new Capital("Raleigh",523542,6266));
        stateMap.put("North Dakota", new Capital("Bismarck",7373537,1353));
        stateMap.put("Ohio", new Capital("Columbus",542626,6246));
        stateMap.put("Oklahoma", new Capital("Oklahoma City",735437,573));
        stateMap.put("Oregon", new Capital("Salem",46735,5356));
        stateMap.put("Pennsylvania", new Capital("Harrisburg",65363,6536));
        stateMap.put("Rhode Island", new Capital("Providence",542526,4624));
        stateMap.put("South Carolina", new Capital("Columbia",56236,642));
        stateMap.put("South Dakota", new Capital("Pierre",65373,7377));
        stateMap.put("Tennessee", new Capital("Nashville",537547,3554));
        stateMap.put("Texas", new Capital("Austin",15356457,7547));
        stateMap.put("Utah", new Capital("Salt Lake City",537734,7375));
        stateMap.put("Vermont", new Capital("Monpelier",7673557,5377));
        stateMap.put("Virginia", new Capital("Richmond",26262,2262));
        stateMap.put("Washington", new Capital("Olympia",653636,5636));
        stateMap.put("West Virginia", new Capital("Charleston",735737,3573));
        stateMap.put("Wisconsin", new Capital("Madison",5327337,5373));
        stateMap.put("Wyoming", new Capital("Cheyenne",7533753,533));     
        
                
        System.out.println("");
        System.out.println("State                     Capital                   Population  Sq. Miles");
        System.out.println("====================================================================================");
        Set<String> keys = stateMap.keySet();
        Iterator<String> iter = keys.iterator();
        String state = "";
        Capital cap = null;
        while (iter.hasNext()) {
            state = iter.next();
            cap   = stateMap.get(state);
            System.out.printf("%-25s %-25s %10d %10d\n",state,cap.getName(),
                              cap.getPopulation(),cap.getSquareMileage());
        }
        
        System.out.println("Capitals whose population are over a certain value: ");
        int populationCap = io.promptForInteger("Enter population : ");
        System.out.println("");
        System.out.println("State                     Capital                   Population  Sq. Miles");
        System.out.println("====================================================================================");
        iter = keys.iterator();
        state = "";
        int capPopulation = 0;
        cap = null;
        while (iter.hasNext()) {
            state = iter.next();
            cap = stateMap.get(state);
            if (cap.getPopulation() > populationCap) {
                System.out.printf("%-25s %-25s %10d %10d\n",state,cap.getName(),
                              cap.getPopulation(),cap.getSquareMileage());
            }
        }
        
        
    }
}
