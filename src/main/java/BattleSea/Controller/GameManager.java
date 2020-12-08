package BattleSea.Controller;

import Plato.Model.Player;

import java.util.ArrayList;

public class GameManager {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private Player turn;
    private int firstPlayerScore;
    private int secondPlayerScore;
    //private ArrayList<String> gameLogs;
    GridManager firstPlayerGridManager;
    GridManager secondPlayerGridManager;
    ShipManager firstPlayerShipManager;
    ShipManager secondPlayerShipManager;

    public GameManager(Player firstPlayer, Player secondPlayer, int boardDimension, int numberOfShips) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        createBoard(boardDimension);
        createShips(boardDimension, numberOfShips);
        turn = firstPlayer;
        firstPlayerScore = 0;
        secondPlayerScore = 0;
    }

    public void addScore(int score, Player player) {
        if (player.equals(firstPlayer)) firstPlayerScore += score;
        else if (player.equals(secondPlayer)) secondPlayerScore += score;
    }

    private void createBoard(int boardDimension) {
        firstPlayerGridManager = new GridManager(firstPlayer, boardDimension);
        secondPlayerGridManager = new GridManager(secondPlayer, boardDimension);
    }

    private void createShips(int boardDimension, int numberOfShips) {
        firstPlayerShipManager = new ShipManager(firstPlayer, boardDimension, numberOfShips);
        secondPlayerShipManager = new ShipManager(secondPlayer, boardDimension, numberOfShips);
    }

    public String bombLocationByPlayer(int xAxis, int yAxis) {
        if (firstPlayerGridManager.getPlayerGrid().getDimension() < xAxis || firstPlayerGridManager.getPlayerGrid().getDimension() < yAxis)
            return "Please Choose a Location Inside The Game Board";
        if (turn.equals(firstPlayer)) {
            if (firstPlayerGridManager.bombLocation(xAxis, yAxis, turn, firstPlayerShipManager)) {
                if (secondPlayerGridManager.bombLocation(xAxis, yAxis, turn, secondPlayerShipManager)) {
                    addScore(1, turn);
                    if (secondPlayerShipManager.isAnyShipDestroyed(secondPlayerGridManager)) {
                        addScore(5, turn);
                        return "You Destroyed Your Opponent's Ship";
                    }
                    return "Your Bomb Hit The Opponent's Ship";
                } else {
                    turn = secondPlayer;
                    return "You Missed Your Shot";
                }
            } else return "You Have Already Bombed This Location! Choose Another Location";
        } else {
            if (secondPlayerGridManager.bombLocation(xAxis, yAxis, turn, secondPlayerShipManager)) {
                if (firstPlayerGridManager.bombLocation(xAxis, yAxis, turn, firstPlayerShipManager)) {
                    addScore(1, turn);
                    return "Your Bomb Hit The Opponent's Ship";
                } else {
                    turn = firstPlayer;
                    return "You Missed Your Shot";
                }
            } else return "You Have Already Bombed This Location! Choose Another Location";
        }
    }

    public String changeLocationOfShip(int shipCode, int xAxis, int yAxis) {
        try {
            if (turn.equals(firstPlayer)) {
                if (firstPlayerGridManager.changeLocationOfShip(firstPlayerShipManager.getShipByShipCode(shipCode), xAxis, yAxis)) {
                    return "The Ship " + shipCode + " Has Been Moved To The New Location Successfully";
                } else return "Cannot Move The Ship To The Requested Location! Try A New Location";
            } else {
                if (secondPlayerGridManager.changeLocationOfShip(secondPlayerShipManager.getShipByShipCode(shipCode), xAxis, yAxis)) {
                    return "The Ship " + shipCode + " Has Been Moved To The New Location Successfully";
                } else return "Cannot Move The Ship To The Requested Location! Try A New Location";
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return "You Cannot Move The Ship To This Location! Because Part Of Ship Will Be Out Of The Board. Try A New Location Or Rotate The Ship First";
        }
    }
}
