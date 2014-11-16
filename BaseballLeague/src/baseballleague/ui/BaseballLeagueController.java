/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague.ui;

import baseballleague.dao.BaseballLeague;
import baseballleague.domain.Player;
import baseballleague.domain.Team;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BaseballLeagueController {

    ConsoleIO cIO = new ConsoleIO();
    BaseballLeague league = new BaseballLeague();
    Player player = new Player();
    Team team = new Team();
    Scanner userInput = new Scanner(System.in);

    public void run() {
        loadDataFromFile();
        do {
            switch (cIO.promptString(" ________________________________________________________\n"
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
                case "1":
                    createNewTeam();
                    break;
                case "2":
                    addPlayer();
                    break;
                case "3":
                    listTeams();
                    break;
                case "4":
                    listPlayers();
                    break;
                case "5":
                    tradePlayer();
                    break;
                case "6":
                    deletePlayer();
                    break;
                case "7":
                    saveDataToFile();
                    break;
                default:
                    quit();
            }
        } while (true);

    }

    private void loadDataFromFile() {
        try {
            league.loadDataFromFile();
        } catch (FileNotFoundException fnf) {
            cIO.displayMessage("File not found " + fnf.getMessage());
        }
    }

    private void createNewTeam() {
        String teamName = "";
        String coachName = "";
        teamName = cIO.promptStringNotNull("Team Name: ");
        coachName = cIO.promptStringNotNull("Coach's Name: ");
        team = new Team(teamName, coachName);
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

        do {
            teamName = cIO.promptStringNotNull("Player's Team: ");
            if (!league.doesTeamExists(teamName.toUpperCase())) {
                cIO.displayMessage("Please enter a team name from the list below");
                listTeams();
                teamName = cIO.promptString("Or press M to go to the main menu to create a new team.");

                if (teamName.equalsIgnoreCase("m")) {
                    break;
                }
            }
        } while (!league.doesTeamExists(teamName.toUpperCase()));

        if (league.doesTeamExists(teamName.toUpperCase())) {
            player.setTeamName(teamName.toUpperCase());

            playerName = cIO.promptStringNotNull("Player's Name: ");
            //if (league.isPlayerOnThisTeam == true) {
            //    cIO.displayMessage("This player is already assigned to the " + teamName);
            //}
            player.setName(playerName);

            do {
                playerNumber = cIO.integerPrompt("Player's Jersey Number: ");
                if (team.isJerseyNumberAlreadyTaken(playerNumber))  {
                    cIO.displayMessage("Jersey number already taken.");
                }
            } while (team.isJerseyNumberAlreadyTaken(playerNumber));
            player.setJerseyNumber(playerNumber);

            do {
                playerPosition = cIO.promptStringNotNull("Please enter a position from the list below:");
                if (!player.isPositionValid(playerPosition.toUpperCase())) {
                    cIO.displayMessage("Please enter a valid position.");
                }
            } while (!player.isPositionValid(playerPosition.toUpperCase()));

            // String[] positions = {"Pitcher", "Catcher", "1st Base", "2nd Base", "Shortstop",
            //  "3rd Base", "Left Field", "Center Field", "Right Field"};
            if (player.isPositionValid(playerPosition.toUpperCase())) {
                player.setPosition(playerPosition);
            }

            do {
                battingHand = cIO.promptStringNotNull("Player's Batting Hand: (enter R or L)");
                if (!(battingHand.equalsIgnoreCase("R") || battingHand.equalsIgnoreCase("L"))) {
                    cIO.displayMessage("Please enter either R or L.");
                }
            } while (!(battingHand.equalsIgnoreCase("R") || battingHand.equalsIgnoreCase("L")));
            player.setBattingHand(battingHand.toUpperCase());

            do {
                throwingHand = cIO.promptStringNotNull("Player's Throwing Hand: (enter R or L)");
                if (!(throwingHand.equalsIgnoreCase("R") || throwingHand.equalsIgnoreCase("L"))) {
                    cIO.displayMessage("Please enter either R or L.");
                }
            } while (!(throwingHand.equalsIgnoreCase("R") || throwingHand.equalsIgnoreCase("L")));
            player.setThrowingHand(throwingHand.toUpperCase());

            playerBirthday = cIO.promptStringNotNull("Player Birthday: (enter MMDDYYYY format)");
            playerPhoneNumber = cIO.promptStringNotNull("Player Phone Number: (enter in (###) ### - #### format)");

            league.addPlayer(team, player);
        }
    }

    private void listTeams() {
        Team[] teams = league.listAllTeamsInTheLeague();
        cIO.displayMessage("");
        for (int i = 0; i < teams.length; i++) {
            cIO.displayMessage(teams[i].getName());
        }
    }

    private void listPlayers() {
        String teamName;

        cIO.displayMessage("Please select a team from the list below: ");
        league.listAllTeamsInTheLeague();

        do {
            teamName = cIO.promptString("Team Name :");
            if (!league.doesTeamExists(teamName)) {
                cIO.displayMessage("Team does not exist.");
            }
        } while (!league.doesTeamExists(teamName));

        displayPlayers(teamName);
    }

    private void displayPlayers(String teamName) {
        Player[] players = league.listAllPlayersInATeam(teamName);

        for (Player p : players) {
            cIO.displayMessage("----------------------------------------");
            cIO.displayMessage("Name          : " + p.getName());
            cIO.displayMessage("Position      : " + p.getPosition());
            cIO.displayMessage("Batting Hand  : " + p.getBattingHand());
            cIO.displayMessage("Throwing Hand : " + p.getThrowingHand());
            cIO.displayMessage("Phone         : " + p.getPhone());
            cIO.displayMessage("Birthday      : " + p.getBirthday());
        }
    }

    private void tradePlayer() {

        String teamName1;
        String teamName2;
        String playerName1;
        String playerName2;
        
        Team   team1;
        Team   team2;
        Player player1 = new Player();
        Player player2 = new Player();
        boolean cannotTrade = false;

        cIO.displayMessage("Please select player 1's team from the list below: ");
        listTeams();

        do {
            teamName1 = cIO.promptStringNotNull("Team Name : ");
            if (!league.doesTeamExists(teamName1.toUpperCase())) {
                cIO.displayMessage("Team does not exist. Please select from the list.");
            }
        } while (!league.doesTeamExists(teamName1.toUpperCase()));

        cIO.displayMessage("Please select a player from the list below: ");
        displayPlayers(teamName1);

        do {
            playerName1 = cIO.promptStringNotNull("Player : ");
            if (!league.getTeam(teamName1).isPlayerOnThisTeam(playerName1)) {
                cIO.displayMessage("Player is not on team " + teamName1 + ". Please choose again.");
            }
        } while (!league.getTeam(teamName1).isPlayerOnThisTeam(playerName1));

        cIO.displayMessage("Please select player 2's team from the list below: ");

        do {
            teamName2 = cIO.promptStringNotNull("Team Name : ");
            if (!league.doesTeamExists(teamName2.toUpperCase())) {
                cIO.displayMessage("Team does not exist. Please select from the list.");
            }
            if (teamName2.equalsIgnoreCase(teamName1)) {
                cIO.displayMessage("You entered the same team.");
            }
        } while (!league.doesTeamExists(teamName2.toUpperCase()) || teamName2.equalsIgnoreCase(teamName1));

        cIO.displayMessage("Please select a player from the list below: ");
        displayPlayers(teamName2);

        do {
            playerName2 = cIO.promptStringNotNull("Player : ");
            if (!league.getTeam(teamName2).isPlayerOnThisTeam(playerName2)) {
                cIO.displayMessage("Player is not on team " + teamName2 + ". Please choose again.");
            }
        } while (!league.getTeam(teamName2).isPlayerOnThisTeam(playerName2));

        team1 = league.getTeam(teamName1);
        team2 = league.getTeam(teamName1);
        
        if (team2.isJerseyNumberAlreadyTaken(player1.getJerseyNumber())) {
            cIO.displayMessage("Please reassigne player "+player1.getName()+"'s jersey number first.");
            cannotTrade = true;
        }
        if (team1.isJerseyNumberAlreadyTaken(player2.getJerseyNumber())) {
            cIO.displayMessage("Please reassigne player "+player2.getName()+"'s jersey number first.");
            cannotTrade = true;
        }
        if (!cannotTrade) {       
            league.tradePlayers(team1, player1, team2, player2);
        }
   }

    private void deletePlayer() {
        cIO.displayMessage("This functionality is not yet available.");
//       Team team = new Team();
//        Player player = new Player();
//        league.deletePlayer(team, player);
    }

    private void saveDataToFile() {
        try {
            cIO.displayMessage("This functionality is not yet available.");
            league.saveDataToFile();
//      cIO.displayMessage("Your work has been saved.");
        } catch (IOException ioe) {
            cIO.displayMessage("Application error." + ioe.getMessage());
        }
    }

    private void quit() {
        if (cIO.promptString("Do you want to save your current work? [Y]es or [N]o").equalsIgnoreCase("y")) {
            saveDataToFile();
        } else {
            cIO.displayMessage("This order has not been saved.");
        }
        if (cIO.promptString("Are you sure you want to quit? [Y]es or [N]o").equalsIgnoreCase("y")) {
            cIO.displayMessage("Thank you, goodbye!");
            System.exit(0);
        }
    }
}
