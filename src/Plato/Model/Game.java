package Plato.Model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Game {
    private static ArrayList<Game> games = new ArrayList<Game>();
    private String name;
    private int gameID;


    public static ArrayList<Game> getGames() {
        return games;
    }

    public static void addGame(String name, int gameID){
        Game game = new Game();
        game.setName(name);
        game.setGameID(gameID);
        games.add(game);
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

    //update the games that has been saved in file
    public static void updateGames() throws FileNotFoundException {
        int n = games.size();
        for (int i = 0; i < n; i++) {
            Map m = new LinkedHashMap(2);
            m.put("name", games.get(i).getName());
            m.put("gameID", games.get(i).getGameID());

        }
        PrintWriter pw = new PrintWriter("games.json");

        pw.flush();
        pw.close();
    }
}
