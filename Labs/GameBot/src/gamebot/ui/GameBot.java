package gamebot.ui;

import gamebot.dao.GameLibrary;
import gamebot.domain.Game;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class GameBot {

    private GameLibrary gameLib = new GameLibrary();
    private ArrayList<Game> games;

    private ConsoleIO io = new ConsoleIO();

    public static void main(String[] args) {
        GameBot gb = new GameBot();
        gb.run();
    }

    private void run() {
        String  gameChosen = "";
        boolean gameFound  = false;
        
        games = gameLib.loadGames();
        
        
        while (!gameChosen.equalsIgnoreCase("quit")) {            
            displayMenu();
            gameChosen = io.promptForString("Please choose what game you want to play: ");
            System.out.println("");
            for (int i = 0; i < games.size(); i++) {
                if (games.get(i).getNameOfGame().equalsIgnoreCase(gameChosen)) {
                    gameFound = true;
                    games.get(i).execute();
                }
            }
            if (!gameFound) {
                System.out.println("Game entered not found in the list.");
            }
            gameFound = false;
        }
       
    }

    private void displayMenu() {
        System.out.println("");
        System.out.println("List of Available Games: ");
        System.out.println("");
        
        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i).getNameOfGame());
        }
        System.out.println("Enter 'quit' to exit");
    }

}
