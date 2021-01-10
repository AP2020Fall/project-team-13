package BattleSea.View;

import BattleSea.Controller.GameManager;
import Plato.Model.Log;
import Plato.Model.Player;

import java.util.Scanner;


public class InGameMenu {
    private final GameManager gameManager;
    private static boolean isGameEnded;
    private final Scanner scanner;


    public InGameMenu(GameManager gameManager, Scanner scanner) {
        this.gameManager = gameManager;
        this.scanner = scanner;
        isGameEnded = false;
    }

    public static void gameHasEnded() {
        InGameMenu.isGameEnded = true;
    }

    public void run() {
        while (!isGameEnded) {
            try {
                System.out.print("enter the number of one of these inputs to continue\n" +
                        "0- show turn\n" +
                        "1- change location of a ship\n" +
                        "2- change direction of a ship\n" +
                        "3- bomb a location\n" +
                        "4- see your ships \n" +
                        "5- see locations you bombed\n" +
                        "6- see your board\n" +
                        "7- see opponents board\n" +
                        "8- see scores\n" +
                        "9- clear screen\n" +
                        "10- withdraw and quit the game\n" +
                        "choose an option:");
                int input = Integer.parseInt(scanner.nextLine().trim().toLowerCase());
                if (input == 0) {
                    showTurn();
                } else if (input == 1) {
                    System.out.print("enter the ship's number:");
                    int shipCode = Integer.parseInt(scanner.nextLine().trim());
                    if (shipCode < 1 || shipCode > gameManager.getShips(1).size())
                        System.out.println("invalid ship number");
                    else {
                        System.out.print("enter x axis of destination:");
                        int xDestination = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("enter y axis of destination:");
                        int yDestination = Integer.parseInt(scanner.nextLine().trim());
                        changeLocation(shipCode, xDestination, yDestination);
                    }
                } else if (input == 2) {
                    System.out.print("enter the ship's number:");
                    int shipCode = Integer.parseInt(scanner.nextLine().trim());
                    if (shipCode < 1 || shipCode > gameManager.getShips(1).size())
                        System.out.println("invalid ship number");
                    else {
                        System.out.print("1-north \n2-east \n3-south \n4-west \nenter the direction:");
                        int direction = Integer.parseInt(scanner.nextLine().trim().toLowerCase());
                        if (direction == 1) {
                            changeDirection(shipCode, 'n');
                        } else if (direction == 2) {
                            changeDirection(shipCode, 'e');
                        } else if (direction == 3) {
                            changeDirection(shipCode, 's');
                        } else if (direction == 4) {
                            changeDirection(shipCode, 'w');
                        } else System.out.println("you entered an invalid number");
                    }
                } else if (input == 3) {
                    System.out.print("enter x axis of bombing location:");
                    int xAxis = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("enter y axis of bombing location:");
                    int yAxis = Integer.parseInt(scanner.nextLine().trim());
                    if (gameManager.getTurnsOwnBoard().getDimension() < xAxis ||
                            gameManager.getTurnsOwnBoard().getDimension() < yAxis ||
                            xAxis < 1 || yAxis < 1)
                        System.out.println("Please Choose a Location Inside The Game Board");
                    else {
                        bombLocation(xAxis, yAxis);
                    }
                } else if (input == 4) {
                    System.out.print("1-all ships " +
                            "\n2-functional ships (ships that are not damaged) " +
                            "\n3-damaged ships " +
                            "\n4-destroyed ships" +
                            "\nchoose an option:");
                    int option = Integer.parseInt(scanner.nextLine().trim());
                    if (option < 0 || option > 5) System.out.println("you entered an invalid number");
                    else showShips(option);
                } else if (input == 5) {
                    System.out.print("1-all bombs " +
                            "\n2-missed bombs" +
                            "\n3-hit bombs " +
                            "\nchoose an option:");
                    int option = Integer.parseInt(scanner.nextLine().trim());
                    if (option < 0 || option > 3) System.out.println("you entered an invalid number");
                    else showBombardLocations(option);
                } else if (input == 6) {
                    showPlayerGameBoard();
                } else if (input == 7) {
                    showOpponentGameBoard();
                } else if (input == 8) {
                    showScores();
                } else if (input == 9) {
                    clearScreen();
                } else if (input == 10) {
                    withdraw();
                } else System.out.println("invalid input.\n to see the input options enter \"help\"");
            } catch (NumberFormatException e) {
                System.out.println("you must enter the number for that option");
            }
        }
        finalizingTheGame();
    }

    private void finalizingTheGame() {
        Player firstPlayer = gameManager.getFirstPlayer();
        Player secondPlayer = gameManager.getSecondPlayer();
        int firstPlayerScore = gameManager.getFirstPlayerScore();
        int secondPlayerScore = gameManager.getSecondPlayerScore();
        firstPlayer.addBattleSeaPlayedCount();
        secondPlayer.addBattleSeaPlayedCount();
        firstPlayer.addBattleSeaPoints(firstPlayerScore);
        secondPlayer.addBattleSeaPoints(secondPlayerScore);
        if (firstPlayerScore == secondPlayerScore) {
            firstPlayer.addBattleSeaDraws();
            secondPlayer.addBattleSeaDraws();
            Log.addLog(2, firstPlayer, secondPlayer, secondPlayer);
        } else if (firstPlayerScore > secondPlayerScore) {
            firstPlayer.addBattleSeaWins();
            secondPlayer.addBattleSeaLosses();
            Log.addLog(2, firstPlayer, secondPlayer, firstPlayer);
        } else {
            firstPlayer.addBattleSeaLosses();
            secondPlayer.addBattleSeaWins();
            Log.addLog(2, firstPlayer, secondPlayer, secondPlayer);
        }
    }

    private void withdraw() {
        gameManager.withdraw();
    }

    public void clearScreen() {
        /*try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }*/
    }

    private void showTurn() {
        System.out.println("It's " + gameManager.getTurn().getUsername() + "'s turn");
    }

    private void changeDirection(int shipCode, char direction) {
        int result = gameManager.changeDirectionOfShip(shipCode, direction);
        if (result == 0) {
            System.out.println("This Ship Cannot Rotate Because It Is Partially Damaged or Completely destroyed");
        } else if (result == 1) {
            System.out.println("The Ship " + shipCode + " Has Been Rotated To The New Direction Successfully");
        } else if (result == 2) {
            System.out.println("Cannot Rotate The Ship To The Requested Direction!");
        } else
            System.out.println("You Cannot Move The Ship To This Location! Because Part Of Ship Will Be Out Of The Board!");

    }

    private void changeLocation(int shipCode, int xDestination, int yDestination) {
        int result = gameManager.changeLocationOfShip(shipCode, xDestination, yDestination);
        if (result == 0) {
            System.out.println("This Ship Cannot Move Because It Is Partially Damaged or Completely destroyed");
        } else if (result == 1) {
            System.out.println("The Ship " + shipCode + " Has Been Moved To The New Location Successfully");
        } else if (result == 2) {
            System.out.println("Cannot Move The Ship To The Requested Location!");
        } else
            System.out.println("You Cannot Move The Ship To This Location Because Part Of Ship Will Be Out Of The Board!");

    }

    private void bombLocation(int xAxis, int yAxis) {
        int result = gameManager.bombLocation(xAxis, yAxis);
        if (result == 0) {
            System.out.println("You Missed Your Shot");
            changeTurn();
        } else if (result == 1) {
            System.out.println("Your Bomb Hit The Opponent's Ship");
        } else if (result == 2) {
            System.out.println("You Destroyed Your Opponent's Ship");
        } else if (result == 3) {
            System.out.println("You Have Already Bombed This Location!");
        }
    }

    public void showPlayerGameBoard() {
        for (int i = 1; i < gameManager.getTurnsOwnBoard().getDimension() + 1; i++) {
            System.out.print("|");
            for (int j = 1; j < gameManager.getTurnsOwnBoard().getDimension() + 1; j++) {
                if (gameManager.getTurnsOwnBoard().getLocation(i, j).getContent().equalsIgnoreCase(""))
                    System.out.print(" " + "|");
                else System.out.print(gameManager.getTurnsOwnBoard().getLocation(i, j).getContent() + "|");
            }
            System.out.println();
        }
    }

    public void showOpponentGameBoard() {
        for (int i = 1; i < gameManager.getTurnsOpponentBoard().getDimension() + 1; i++) {
            System.out.print("|");
            for (int j = 1; j < gameManager.getTurnsOpponentBoard().getDimension() + 1; j++) {
                if (gameManager.getTurnsOpponentBoard().getLocation(i, j).getContent().equalsIgnoreCase(""))
                    System.out.print(" " + "|");
                else System.out.print(gameManager.getTurnsOpponentBoard().getLocation(i, j).getContent() + "|");
            }
            System.out.println();
        }
    }

    public void showShips(int option) {
        for (String ship : gameManager.getShips(option)) {
            System.out.println(ship);
        }
    }

    public void showBombardLocations(int option) {
        for (int i = 1; i < gameManager.getTurnsOpponentBoard().getDimension() + 1; i++) {
            for (int j = 1; j < gameManager.getTurnsOpponentBoard().getDimension() + 1; j++) {
                if (option == 1 && !gameManager.getTurnsOpponentBoard().getLocation(i, j).getContent().equals("")) {
                    System.out.println("X:" + gameManager.getTurnsOpponentBoard().getLocation(i, j).getXAxis() +
                            "\t" + "Y:" + gameManager.getTurnsOpponentBoard().getLocation(i, j).getYAxis());
                }
                if (option == 2 && gameManager.getTurnsOpponentBoard().getLocation(i, j).getContent().equals("-")) {
                    System.out.println("X:" + gameManager.getTurnsOpponentBoard().getLocation(i, j).getXAxis() +
                            "\t" + "Y:" + gameManager.getTurnsOpponentBoard().getLocation(i, j).getYAxis());
                }
                if (option == 3) {
                    if (gameManager.getTurnsOpponentBoard().getLocation(i, j).getContent().equals("+") ||
                            gameManager.getTurnsOpponentBoard().getLocation(i, j).getContent().equals("*")) {
                        System.out.println("X:" + gameManager.getTurnsOpponentBoard().getLocation(i, j).getXAxis() +
                                "\t" + "Y:" + gameManager.getTurnsOpponentBoard().getLocation(i, j).getYAxis());
                    }
                }
            }
        }
    }

    public void showScores() {
        System.out.println(gameManager.getFirstPlayer().getUsername() + " : " + gameManager.getFirstPlayerScore() +
                "\t" + gameManager.getSecondPlayer().getUsername() + " : " + gameManager.getSecondPlayerScore());
    }

    public void showWinner() {
        if (gameManager.getFirstPlayerScore() > gameManager.getSecondPlayerScore()) {
            System.out.println(gameManager.getFirstPlayer().getUsername() + " won");
        } else if (gameManager.getFirstPlayerScore() < gameManager.getSecondPlayerScore()) {
            System.out.println(gameManager.getSecondPlayer().getUsername() + " won");
        } else System.out.println("it was a draw!");
    }

    public void changeTurn() {
        System.out.println("Next Player's Turn!");
    }

    public void changeTurn(boolean t) {
        if (t) gameManager.changeTurn();
    }

}
