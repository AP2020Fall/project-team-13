package Plato.Model;

import BattleSea.Controller.BattleSea;
import Reversi.ReversiController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Game {
    private static ArrayList<Game> games = new ArrayList<Game>();
    private String name;
    private int gameID;
    {
        games.add(ReversiController.reversiController);
        games.add(BattleSea.battleSea);

    }
    private void play(){

    }

    public void giveScore(int playerID){

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
}
