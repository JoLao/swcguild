/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamebot.domain;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class TicTacToe implements Game {
    private final  String name = "Tic-Tac-Toe";
    
    private static char[][] board = new char[3][3];

    @Override
    public String getNameOfGame() {
        return this.name;
    }

    
    @Override
    public void execute() {
        Scanner keyboard = new Scanner(System.in);
        int rowO, colO;
        int rowX, colX;
        boolean hasSpace = false;
        char winner = ' ';

        initBoard();
        displayBoard();

        do {
            System.out.print("'O', choose your location (row, column): ");
            rowO = keyboard.nextInt();
            colO = keyboard.nextInt();
            if (board[rowO][colO] == ' ') {
                board[rowO][colO] = 'O';
                displayBoard();
            }

            hasSpace = checkForSpace();

            if (checkForWinner('O')) {
                winner = 'O';
            }

            if (hasSpace) {
                if (winner != 'O') {
                    System.out.print("'X', choose your location (row, column): ");
                    rowX = keyboard.nextInt();
                    colX = keyboard.nextInt();
                    if (board[rowX][colX] == ' ') {
                        board[rowX][colX] = 'X';
                    }
                    displayBoard();
                }
            }

            hasSpace = checkForSpace();

            if (checkForWinner('X')) {
                winner = 'X';
            }

        } while (hasSpace && winner == ' ');

        switch (winner) {
            case 'O':
                System.out.println("'O' wins!");
                break;
            case 'X':
                System.out.println("'X' wins!");
                break;
            default:
                System.out.println("The game is a tie.");
        }
    }

    public static void initBoard() {
        // fills up the board with blanks
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    public static void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    public static void displayBoard2() {
        for (int r = 0; r < 3; r++) {
            System.out.print("\t" + r + " ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("\t  0 1 2 ");
    }

    public static boolean checkForSpace() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //    System.out.println("board["+i+"]["+j+"] : "+ board[i][j] );
                if (board[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkForWinner(char who) {
        boolean winSW = false;
        int numTimes = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == who) {
                    numTimes++;
                }
            }
            if (numTimes == 3) {
                return true;
            } else {
                numTimes = 0;
            }
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (board[i][j] == who) {
                    numTimes++;
                }
            }
            if (numTimes == 3) {
                return true;
            } else {
                numTimes = 0;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == who) {
                numTimes++;
            }
        }
        if (numTimes == 3) {
            return true;
        }
        if (board[0][2] == who
                && board[1][1] == who
                && board[2][0] == who) {
            return true;
        }
        return false;
    }
}
