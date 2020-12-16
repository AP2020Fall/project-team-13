package BattleSea.View;

import BattleSea.Controller.GameManager;
import Plato.Model.Player;
import Plato.View.Page;

public class StartingPage extends Page {
    Player firstPlayer;
    Player secondPlayer;
    GameManager gameManager;
    InGameMenu inGameMenu;

    public StartingPage(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        seenPages.add(this);
    }

    public Page run() {
        System.out.println("Welcome to battle sea\n" +
                "now one of the players will choose the dimensions of the board\n" +
                "and the other on the number of ships");
        boolean isBoardOptionDecided = false;
        while (!isBoardOptionDecided) {
            System.out.println("1-10*10\n" +
                    "2-15*15\n" +
                    "3-20*20\n" +
                    "choose one options:");
            int boardOption = Integer.parseInt(scanner.nextLine().trim());
            if (boardOption < 1 || boardOption > 3) System.out.println("invalid input");
            else {
                isBoardOptionDecided = true;
                boolean isNumberOfShipsDecided = false;
                int numberOfShips;
                while (!isNumberOfShipsDecided) {
                    if (boardOption == 1) {
                        System.out.println("1- 4 ships\n" +
                                "2- 5 ships\n" +
                                "3- 6 ships\n" +
                                "chose one option:");
                        numberOfShips = Integer.parseInt(scanner.nextLine().trim());
                        if (numberOfShips < 1 || numberOfShips > 3) System.out.println("invalid input");
                        else {
                            isNumberOfShipsDecided = true;
                            if (numberOfShips==1) gameManager=new GameManager(firstPlayer,secondPlayer,10,4);
                            else if (numberOfShips==2) gameManager=new GameManager(firstPlayer,secondPlayer,10,5);
                            else gameManager=new GameManager(firstPlayer,secondPlayer,10,6);
                        }
                    } else if (boardOption == 2) {
                        System.out.println("1- 6 ships\n" +
                                "2- 7 ships\n" +
                                "3- 8 ships" +
                                "chose one option:");
                        numberOfShips = Integer.parseInt(scanner.nextLine().trim());
                        if (numberOfShips < 1 || numberOfShips > 3) System.out.println("invalid input");
                        else {
                            isNumberOfShipsDecided = true;
                            if (numberOfShips==1) gameManager=new GameManager(firstPlayer,secondPlayer,15,6);
                            else if (numberOfShips==2) gameManager=new GameManager(firstPlayer,secondPlayer,15,7);
                            else gameManager=new GameManager(firstPlayer,secondPlayer,15,8);
                        }
                    } else {
                        System.out.println("1- 8 ships\n" +
                                "2- 9 ships\n" +
                                "3- 10 ships" +
                                "chose one option:");
                        numberOfShips = Integer.parseInt(scanner.nextLine().trim());
                        if (numberOfShips < 1 || numberOfShips > 3) System.out.println("invalid input");
                        else {
                            isNumberOfShipsDecided = true;
                            if (numberOfShips==1) gameManager=new GameManager(firstPlayer,secondPlayer,20,8);
                            else if (numberOfShips==2) gameManager=new GameManager(firstPlayer,secondPlayer,20,9);
                            else gameManager=new GameManager(firstPlayer,secondPlayer,20,10);
                        }
                    }
                }
            }
        }
        inGameMenu=new InGameMenu(gameManager,scanner);
        System.out.println("let's see first player's game board!");
        inGameMenu.showPlayerGameBoard();
        System.out.println("if you want another random board enter \"n\" \n" +
                "but if you want to continue enter anything else");
        while (scanner.nextLine().trim().equalsIgnoreCase("n")){
            inGameMenu.clearScreen();
            gameManager.putTheShipsOnBoardRandomly(gameManager.getFirstPlayerGridManager(),
                    gameManager.getFirstPlayerShipManager(),
                    gameManager.getTurnsOwnBoard().getDimension());
            inGameMenu.showPlayerGameBoard();
        }
        inGameMenu.clearScreen();
        inGameMenu.changeTurn(true);
        inGameMenu.changeTurn();
        System.out.println("now its second player's turn to see their board");
        inGameMenu.showPlayerGameBoard();
        System.out.println("if you want another random board enter \"n\" \n" +
                "but if you want to continue enter anything else");
        while (scanner.nextLine().trim().equalsIgnoreCase("n")){
            inGameMenu.clearScreen();
            gameManager.putTheShipsOnBoardRandomly(gameManager.getSecondPlayerGridManager(),
                    gameManager.getSecondPlayerShipManager(),
                    gameManager.getTurnsOwnBoard().getDimension());
            inGameMenu.showPlayerGameBoard();
        }
        inGameMenu.clearScreen();
        inGameMenu.changeTurn(true);
        System.out.println("now it's time to play the game");
        inGameMenu.run();
        return null;
    }
}
