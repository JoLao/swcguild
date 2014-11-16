/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.baseballleague.ui;

import com.swcguild.baseballleague.dao.BaseballLeague;
import com.swcguild.baseballleague.dao.BaseballLeagueImpl;
import com.swcguild.baseballleague.domain.Player;
import com.swcguild.baseballleague.domain.Team;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class BaseballLeagueController {

    ConsoleIO cIO = new ConsoleIO();
    Scanner userInput = new Scanner(System.in);
    BaseballLeague league;

//    public BaseballLeagueController(BaseballLeagueImpl league) {
//        this.league = league;
//    }

    public void setcIO(ConsoleIO cIO) {
        this.cIO = cIO;
    }

    public void setLeague(BaseballLeague league) {
        this.league = league;
    }

    
    public void run() {
        int choice = -1;
        loadDataFromFile();
        do {
            switch (choice = cIO.promptForInteger(" ________________________________________________________\n"
                    + "|                                                        |\n"
                    + "|    Please make your selection from the menu below:     |\n"
                    + "|                                                        |\n"
                    + "|         1. Create New Team                             |\n"
                    + "|         2. Add New Players                             |\n"
                    + "|         3. List All Teams in League                    |\n"
                    + "|         4. List All Players on a Team                  |\n"
                    + "|         5. Trade a Player                              |\n"
                    + "|         6. Delete a Player                             |\n"
                    + "|         7. Save Data to File                           |\n"
                    + "|         8. Quit                                        |\n"
                    + "|________________________________________________________|\n")) {
                case 1:
                    createNewTeam();
                    break;
                case 2:
                    addPlayer();
                    break;
                case 3:
                    listTeams();
                    break;
                case 4:
                    listPlayers();
                    break;
                case 5:
                    tradePlayer();
                    break;
                case 6:
                    deletePlayer();
                    break;
                case 7:
                    saveDataToFile();
                    break;
                default:
                    quit();
            }
        } while (choice != 8);

    }

    private void loadDataFromFile() {
        try {
            league.loadDataFromFile();
        } catch (FileNotFoundException fnf) {
            cIO.printStringLn("File not found " + fnf.getMessage());
        }
    }

    private void createNewTeam() {
        String teamName = "";
        String coachName = "";
        teamName = cIO.promptForString("Team Name: ");
        coachName = cIO.promptForString("Coach's Name: ");
        Team team = new Team(teamName, coachName);
        league.createNewTeam(team);
    }

    private void addPlayer() {
        String teamName = "";
        String playerName = "";
        int playerNumber = 0;
        String playerPosition;
        String battingHand;
        String throwingHand;
        String playerBirthday = "";
        String playerPhoneNumber;
        String userInput = "";
        Team team = new Team();
        Player player = new Player();

        do {
            teamName = cIO.promptForString("Player's Team: ");
            if (!league.doesTeamExists(teamName.toUpperCase())) {
                cIO.printStringLn("Please enter a team name from the list below");
                listTeams();
                teamName = cIO.promptForString("Or press M to go to the main menu to create a new team.");

                if (teamName.equalsIgnoreCase("m")) {
                    break;
                }
            }
        } while (!league.doesTeamExists(teamName.toUpperCase()));

        if (league.doesTeamExists(teamName.toUpperCase())) {
            player.setTeamName(teamName.toUpperCase());

            playerName = cIO.promptForString("Player's Name: ");
            Team team1 = league.isPlayerOnATeam(playerName);
            if (!team1.getName().equals("")) {
                cIO.printStringLn("This player is already assigned to the " + team1.getName());
            }
            player.setName(playerName);

            do {
                playerNumber = cIO.promptForInteger("Player's Jersey Number: ");
                if (team.isJerseyNumberAlreadyTaken(playerNumber)) {
                    cIO.printStringLn("Jersey number already taken.");
                }
            } while (team.isJerseyNumberAlreadyTaken(playerNumber));
            player.setJerseyNumber(playerNumber);

            do {
                playerPosition = cIO.promptForString("Please enter a position from the list below:");
                if (!player.isPositionValid(playerPosition.toUpperCase())) {
                    cIO.printStringLn("Please enter a valid position.");
                }
            } while (!player.isPositionValid(playerPosition.toUpperCase()));

            // String[] positions = {"Pitcher", "Catcher", "1st Base", "2nd Base", "Shortstop",
            //  "3rd Base", "Left Field", "Center Field", "Right Field"};
            if (player.isPositionValid(playerPosition.toUpperCase())) {
                player.setPosition(playerPosition);
            }

            do {
                battingHand = cIO.promptForString("Player's Batting Hand: (enter R or L)");
                if (!(battingHand.equalsIgnoreCase("R") || battingHand.equalsIgnoreCase("L"))) {
                    cIO.printStringLn("Please enter either R or L.");
                }
            } while (!(battingHand.equalsIgnoreCase("R") || battingHand.equalsIgnoreCase("L")));
            player.setBattingHand(battingHand.toUpperCase());

            do {
                throwingHand = cIO.promptForString("Player's Throwing Hand: (enter R or L)");
                if (!(throwingHand.equalsIgnoreCase("R") || throwingHand.equalsIgnoreCase("L"))) {
                    cIO.printStringLn("Please enter either R or L.");
                }
            } while (!(throwingHand.equalsIgnoreCase("R") || throwingHand.equalsIgnoreCase("L")));
            player.setThrowingHand(throwingHand.toUpperCase());

            playerBirthday = cIO.promptForString("Player Birthday: (enter MMDDYYYY format)");
            playerPhoneNumber = cIO.promptForString("Player Phone Number: (enter in (###) ### - #### format)");

            league.addPlayer(team, player);
        }
    }

    private void listTeams() {
        Team[] teams = league.listAllTeamsInTheLeague();
        cIO.printStringLn("");
        for (int i = 0; i < teams.length; i++) {
            cIO.printStringLn(teams[i].getName());
        }
    }

    private void listPlayers() {
        String teamName;

        cIO.printStringLn("Please select a team from the list below: ");
        league.listAllTeamsInTheLeague();

        do {
            teamName = cIO.promptForString("Team Name :");
            if (!league.doesTeamExists(teamName)) {
                cIO.printStringLn("Team does not exist.");
            }
        } while (!league.doesTeamExists(teamName));

        displayPlayers(teamName);
    }

    private void displayPlayers(String teamName) {
        Player[] players = league.listAllPlayersInATeam(teamName);

        for (Player p : players) {
            cIO.printStringLn("----------------------------------------");
            cIO.printStringLn("Name          : " + p.getName());
            cIO.printStringLn("Jersey Number : " + p.getJerseyNumber());
            cIO.printStringLn("Position      : " + p.getPosition());
            cIO.printStringLn("Batting Hand  : " + p.getBattingHand());
            cIO.printStringLn("Throwing Hand : " + p.getThrowingHand());
            cIO.printStringLn("Phone         : " + p.getPhone());
            cIO.printStringLn("Birthday      : " + p.getBirthday());
        }
    }

    private void tradePlayer() {

        String teamName1;
        String teamName2;
        String playerName1;
        String playerName2;

        Team team1;
        Team team2;
        Player player1 = new Player();
        Player player2 = new Player();
        boolean cannotTrade = false;

        cIO.printStringLn("Please select player 1's team from the list below: ");
        listTeams();

        do {
            teamName1 = cIO.promptForString("Team Name : ");
            if (!league.doesTeamExists(teamName1)) {
                cIO.printStringLn("Team does not exist. Please select from the list.");
            }
        } while (!league.doesTeamExists(teamName1));

        cIO.printStringLn("Please select a player from the list below: ");
        displayPlayers(teamName1);

        do {
            playerName1 = cIO.promptForString("Player : ");
            if (!league.getTeam(teamName1).isPlayerOnThisTeam(playerName1)) {
                cIO.printStringLn("Player is not on team " + teamName1 + ". Please choose again.");
            }
        } while (!league.getTeam(teamName1).isPlayerOnThisTeam(playerName1));

        cIO.printStringLn("Please select player 2's team from the list below: ");

        do {
            teamName2 = cIO.promptForString("Team Name : ");
            if (!league.doesTeamExists(teamName2)) {
                cIO.printStringLn("Team does not exist. Please select from the list.");
            }
            if (teamName2.equalsIgnoreCase(teamName1)) {
                cIO.printStringLn("You entered the same team.");
            }
        } while (!league.doesTeamExists(teamName2) || teamName2.equalsIgnoreCase(teamName1));

        cIO.printStringLn("Please select a player from the list below: ");
        displayPlayers(teamName2);

        do {
            playerName2 = cIO.promptForString("Player : ");
            if (!league.getTeam(teamName2).isPlayerOnThisTeam(playerName2)) {
                cIO.printStringLn("Player is not on team " + teamName2 + ". Please choose again.");
            }
        } while (!league.getTeam(teamName2).isPlayerOnThisTeam(playerName2));

        team1 = league.getTeam(teamName1);
        team2 = league.getTeam(teamName2);
        player1 = team1.getPlayer(playerName1);
        player2 = team2.getPlayer(playerName2);

        if (player1.getJerseyNumber() != player2.getJerseyNumber()) {
            if (team2.isJerseyNumberAlreadyTaken(player1.getJerseyNumber())) {
                cIO.printStringLn("Please reassign player " + player1.getName() + "'s jersey number first.");
                cannotTrade = true;
            }
            if (team1.isJerseyNumberAlreadyTaken(player2.getJerseyNumber())) {
                cIO.printStringLn("Please reassign player " + player2.getName() + "'s jersey number first.");
                cannotTrade = true;
            }
        }
        if (!cannotTrade) {
            league.tradePlayers(team1, player1, team2, player2);
            cIO.printStringLn("Players traded.");
        }
    }

    private void deletePlayer() {
        String teamName = "";
        String playerName = "";
        Team team = new Team();

        boolean quitDelete = false;

        do {
            playerName = cIO.promptForString("Player's Name or m to return to main menu: ");
            if (playerName.equalsIgnoreCase("m")) {
                quitDelete = true;
                break;
            }
            team = league.isPlayerOnATeam(playerName);            
            if (team.getName().equals("")) {
                cIO.promptForString("Player not found in ay team.");
            }
        } while (team.getName().equals(""));

        if (!quitDelete) {
            team.removePlayer(playerName);
            cIO.printStringLn("Player removed from the league and team.");
        }
    }

    private void saveDataToFile() {
        try {
            league.saveDataToFile();
            cIO.printStringLn("Your work has been saved.");
        } catch (IOException ioe) {
            cIO.printStringLn("Application error." + ioe.getMessage());
        }
    }

    private void quit() {
        if (cIO.promptForString("Do you want to save your current work? [Y]es or [N]o ").equalsIgnoreCase("y")) {
            saveDataToFile();
        } else {
            cIO.printStringLn("This order has not been saved.");
        }
        if (cIO.promptForString("Are you sure you want to quit? [Y]es or [N]o ").equalsIgnoreCase("y")) {
            cIO.printStringLn("Thank you, goodbye!");
//            System.exit(0);
        }
    }
}
