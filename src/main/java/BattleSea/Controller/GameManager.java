package BattleSea.Controller;

import Plato.Model.Player;

import java.util.ArrayList;

public class GameManager {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player turn;
    private int firstPlayerScore;
    private int secondPlayerScore;
    private ArrayList<String> gameLogs;

    public GameManager(Player firstPlayer, Player secondPlayer,int boardXDimension,int boardYDimension,int numberOfShips) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        createBoard(boardXDimension,boardYDimension);
        createShips(boardXDimension,boardYDimension,numberOfShips);
    }

    public void setScore(int score,Player player){

    }

    private void createBoard(int boardXDimension,int boardYDimension){

    }

    private void createShips(int boardXDimension,int boardYDimension,int numberOfShips){

    }
}
