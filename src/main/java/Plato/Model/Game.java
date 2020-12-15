package Plato.Model;

import BattleSea.Controller.BattleSea;
import Reversi.ReversiController;
import java.util.ArrayList;

public class Game {
    private static ArrayList<Game> games = new ArrayList<Game>();
    private String name;
    private int gameID;
    {
        ReversiController.reversiController.setGameID(1);
        ReversiController.reversiController.setName("reversi");
        BattleSea.battleSea.setGameID(2);
        BattleSea.battleSea.setName("battleSea");
        if(!(games.contains(ReversiController.reversiController) && games.contains(BattleSea.battleSea))){
            games.add(ReversiController.reversiController);
            games.add(BattleSea.battleSea);
        }
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public String getName() {
        return name;
    }

    public int getGameID() {
        return gameID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
}
