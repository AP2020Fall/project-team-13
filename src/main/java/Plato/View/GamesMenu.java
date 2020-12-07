package Plato.View;

import Plato.Controller.GamesMenuController;
import Plato.Model.Player;

public class GamesMenu extends Page{
    private Player player;
    private static GamesMenu gamesMenu = new GamesMenu();
    private GamesMenuController gamesMenuController = GamesMenuController.getInstance();
    public Page run() {
        gamesMenuController.getGamesController();
        return null;
    }
    private void setPlayer(Player player){

    }
    public Page openGame (String name){
        return null;
    }

}
