
package gamebot.dao;

import gamebot.domain.Blackjack;
import gamebot.domain.Game;
import gamebot.domain.Hangman;
import gamebot.domain.LuckySevens;
import gamebot.domain.RockPaperScissorsStep4;
import gamebot.domain.TicTacToe;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class GameLibrary {
    private ArrayList<Game> gameLibrary = new ArrayList<>();
    
    public ArrayList<Game> loadGames() {
//        Scanner in = new Scanner(new BufferedReader(new FileReader("games.txt")));
//        Game currGame;
//        while (in.hasNext()) {
//            //Class.forName(in.next());
//            currGame = new Game(in.next());
//        }
        
        LuckySevens            lucky7 = new LuckySevens();
        RockPaperScissorsStep4 rps    = new RockPaperScissorsStep4();
        Blackjack              bj     = new Blackjack();
        TicTacToe              ttt    = new TicTacToe();
        Hangman                hman   = new Hangman();
        
        gameLibrary.add(lucky7);
        gameLibrary.add(rps);
        gameLibrary.add(bj);
        gameLibrary.add(ttt);
        gameLibrary.add(hman);
        
//        System.out.println(gameLibrary.size());
        return gameLibrary;
    }
}
