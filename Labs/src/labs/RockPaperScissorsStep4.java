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
public class RockPaperScissorsStep4 {

    public static int tiesCnt = 0;
    public static int userWinCnt = 0;
    public static int compWinCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        String msg = "";

        do {
            System.out.print("How many rounds would you like to play? ");
            int rounds = sc.nextInt();

            if (rounds >= 1 && rounds <= 10) {
                for (int i = 1; i <= rounds; i++) {
                    System.out.print("Rock, Paper, or Scissors? ");

                    String userStr = sc.next();
                    int userNum = rockPaperScissorsNumValue(userStr);

                    Random rGen = new Random();
                    int computerNum = rGen.nextInt(3) + 1;
                    String computerStr = rockPaperScissorsStrValue(computerNum);

                    System.out.println("computer choice : " + computerStr);
                    System.out.println(checkWinner(userNum, computerNum));

                } //end for
                displayOverallStatus();
            } else {
                System.out.println("Out of Range. 1-10 rounds only");
            }

            System.out.print("Would you like to play again [Y/N]? " );
            String ans = sc.next();
            if (ans.toUpperCase().equals("Y")) {
                play = true;
                tiesCnt = 0;
                userWinCnt = 0;
                compWinCnt = 0;
            } else {
                play = false;
            }
        } while (play);
    }

    public static int rockPaperScissorsNumValue(String str) {
        int num = 0;
        switch (str.toLowerCase()) {
            case "rock":
                num = 1;
                break;
            case "paper":
                num = 2;
                break;
            case "scissors":
                num = 3;
        }

        return num;
    }

    public static String rockPaperScissorsStrValue(int n) {
        String str = "";
        switch (n) {
            case 1:
                str = "Rock";
                break;
            case 2:
                str = "Paper";
                break;
            case 3:
                str = "Scissors";

        }
        return str;
    }

        
    public static String checkWinner(int userNum, int computerNum) {
        String result = "";
        if (userNum == computerNum) {
            result = "tie";
            tiesCnt++;
        } else if (userNum < computerNum) {
            if (userNum == 1 && computerNum == 3) {
                result = "user wins";
                userWinCnt++;
            } else {
                result = "computer wins";
                compWinCnt++;
            }
        } else if (userNum == 3 && computerNum == 1) {
            result = "computer wins";
            compWinCnt++;
        } else {
            result = "user wins";
            userWinCnt++;
        }
        return result;
    }

    public static String checkWinner1(int userNum, int computerNum) {
        String result = "";
        if (userNum == computerNum) {
            result = "tie";
            tiesCnt++;
        } else if (userNum % 3 < computerNum % 3) {
                    result = "user wins";
                    userWinCnt++; 
        } else {            
                result = "computer wins";
                compWinCnt++;                           
        }
        return result;
    }
    
    public static void displayOverallStatus() {
        System.out.println("# of ties " + tiesCnt);
        System.out.println("# of user wins " + userWinCnt);
        System.out.println("# of computer wins " + compWinCnt);
        if (userWinCnt == compWinCnt) {
            System.out.println("Overall tie");
        } else if (userWinCnt > compWinCnt) {
            System.out.println("User is overall winner");
        } else {
            System.out.println("Computer is overall winner");
        }
    }
}
