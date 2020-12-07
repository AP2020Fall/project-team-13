package Plato.Controller;

import Plato.Model.Game;
import Plato.Model.Player;
import Plato.View.GamesMenu;

import java.util.ArrayList;

public class GamesMenuController  {
    private Player player;
    private static GamesMenuController gamesMenuController = new GamesMenuController();

    public static GamesMenuController getInstance() {
        return gamesMenuController;
    }

    public String getGamesController(){
        ArrayList<Game> game = Game.getGames();
        return null;
    }
    private void setGamesMenuController (Player player){

    }
    private String getGames (){
        return null;
    }


}
