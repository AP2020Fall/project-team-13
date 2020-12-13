package Plato.Model;

import BattleSea.Controller.BattleSea;
import Reversi.ReversiController;
import java.util.ArrayList;

public class Game {
    private static ArrayList<Game> games = new ArrayList<Game>();
    private String name;
    private int gameID;
    {
        if(!(games.contains(ReversiController.reversiController) && games.contains(BattleSea.battleSea))){
            games.add(ReversiController.reversiController);
            games.add(BattleSea.battleSea);
        }
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
