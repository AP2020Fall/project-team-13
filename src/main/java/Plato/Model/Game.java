package Plato.Model;

import BattleSea.Controller.BattleSea;
import Reversi.ReversiController;
import java.util.ArrayList;

public class Game {
    private static ArrayList<Game> games = new ArrayList<Game>();
    private String name;
    private int gameID;


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
