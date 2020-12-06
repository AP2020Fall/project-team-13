package BattleSea.Controller;

import Plato.Model.Player;

import java.util.ArrayList;

public class GameManager {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private Player turn;
    private int firstPlayerScore;
    private int secondPlayerScore;
    private ArrayList<String> gameLogs;
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
            if (firstPlayerGridManager.bombLocation(xAxis, yAxis, turn)) {
                if (secondPlayerGridManager.bombLocation(xAxis, yAxis, turn)) {
                    addScore(1,turn);
                    return "Your Bomb Hit The Opponent's Ship";
                }
                else {
                    turn = secondPlayer;
                    return "You Missed Your Shot";
                }
            } else return "You Have Already Bombed This Location! Choose Another Location";
        } else {
            if (secondPlayerGridManager.bombLocation(xAxis, yAxis, turn)) {
                if (firstPlayerGridManager.bombLocation(xAxis, yAxis, turn)){
                    addScore(1,turn);
                    return "Your Bomb Hit The Opponent's Ship";
                }
                else {
                    turn = firstPlayer;
                    return "You Missed Your Shot";
                }
            } else return "You Have Already Bombed This Location! Choose Another Location";
        }
    }

    public String changeDirectionOfShip(int shipCode,String Direction){
        return  "";
    }
}
