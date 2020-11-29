package Plato.Model;

import java.util.ArrayList;

public class Game {
    private static ArrayList<Game> games = new ArrayList<Game>();
    private String name;
    private int gameID;

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
