/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labs;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many rounds would you like to play?");
        int rounds = sc.nextInt();
        int tiesCnt = 0;
        int userWinCnt = 0;
        int compWinCnt = 0;
         
        if (rounds >= 1 && rounds <= 10) {
            for (int i = 1; i <= rounds; i++) {
                System.out.println("Rock, Paper, or Scissors?");

                String userStr = sc.next();
                int userNum = 0;
        
                switch (userStr) {
                    case "Rock" :
                        userNum = 1;
                        break;
                    case "Paper" :
                        userNum = 2;
                        break;
                    case "Scissors" :
                        userNum = 3;                
                }
                Random rGen = new Random();
                int computerNum = rGen.nextInt(3) + 1;
                String computerStr = "";               
                
                switch (computerNum) {
                    case 1 :
                        computerStr = "Rock";
                        break;
                    case 2 :
                        computerStr = "Paper";
                        break;
                    case 3 :
                        computerStr = "Scissors";
                      
                }
                 System.out.println("computer choice : "+computerStr);
                if (userNum == computerNum) {
                    System.out.println("tie");
                    tiesCnt++;
                } else if (userNum < computerNum) {
                    if (userNum == 1 && computerNum == 3) {
                        System.out.println("user wins");
                        userWinCnt++;
                    } else {
                        System.out.println("computer wins");
                        compWinCnt++;
                    }
                } else if (userNum == 3 && computerNum == 1) {
                    System.out.println("computer wins");;
                    compWinCnt++;
                } else {
                    System.out.println("user wins");
                    userWinCnt++;
                }
            } //end for
            System.out.println("# of ties "+tiesCnt);
            System.out.println("# of user wins "    +userWinCnt);
            System.out.println("# of computer wins "+compWinCnt);
            if (userWinCnt == compWinCnt) {
                System.out.println("Overall tie");
            } else if (userWinCnt > compWinCnt) {
                System.out.println("User is overall winner");
            } else {
               
                System.out.println("Computer is overall winner");
            }
        } else {
            System.out.println("Out of Range. 1-10 rounds only");
        }
    }
    
}
