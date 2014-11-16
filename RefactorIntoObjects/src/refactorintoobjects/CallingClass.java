/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package refactorintoobjects;

/**
 *
 * @author apprentice
 */
public class CallingClass {
    public static void main(String[] args) {
        Factorizer fact = new Factorizer();
        fact.execute();
        
        System.out.println("");
        InterestCalculator interest = new InterestCalculator();
        interest.execute();
        
        System.out.println("");
        LuckySevens luck = new LuckySevens();
        luck.execute();
        
        System.out.println("");
        RockPaperScissorsStep4 rps = new RockPaperScissorsStep4();
        rps.execute();
        
        System.out.println("");
        Blackjack bj = new Blackjack();
        bj.execute();
    }
}
