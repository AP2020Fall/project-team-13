package Plato.Controller;

import Plato.Model.Game;

import java.util.ArrayList;

public class GamesMenuController {
    private static GamesMenuController gamesMenuController = new GamesMenuController();

    public static GamesMenuController getInstance() {
        return gamesMenuController;
    }

    public String getGamesController(){
        ArrayList<Game> game = Game.getGames();
        return null;
    }
}
