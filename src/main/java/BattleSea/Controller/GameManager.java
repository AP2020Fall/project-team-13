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

    public GameManager(Player firstPlayer, Player secondPlayer,int boardDimension,int numberOfShips) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        createBoard(boardDimension);
        createShips(boardDimension,numberOfShips);
    }

    public void setScore(int score,Player player){

    }

    private void createBoard(int boardDimension){
        GridManager firstPlayerGridManager=new GridManager(firstPlayer,boardDimension);
        GridManager secondPlayerGridManager=new GridManager(secondPlayer,boardDimension);

    }

    private void createShips(int boardDimension,int numberOfShips){
        ShipManager firstPlayerShipManager=new ShipManager(firstPlayer,boardDimension,numberOfShips);
        ShipManager secondPlayerShipManager=new ShipManager(secondPlayer,boardDimension,numberOfShips);

    }
}
