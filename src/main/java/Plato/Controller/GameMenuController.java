package Plato.Controller;

import Plato.Model.Game;
import Plato.Model.Log;
import Plato.Model.Player;

public class GameMenuController {
    public Player player;
    public String game;
    private static GameMenuController gameMenuController = new GameMenuController();
    private int gameID;

    public static GameMenuController getInstance() {
        return gameMenuController;
    }
    public void setGameName(int gameID1){
        this.gameID=gameID1;
    }
    public String showScoreBoard(){
        Player player = (Player) LoginPageController.user;
        Log log = player.getLog(gameID);
        return null;
    }
    public void setPlayerController(Player player){

    }
    private String showScoreboardController(){
    return null;
    }
    private String detailsController(){
    return null;
    }
    private String showLogController(){
        return null;
    }
    private String showWinsController(){
        return null;
    }
    private String showPlayedController(){
        return null;
    }
    private void addToFavoritesController(){

    }
    private String showPointsController(){
        return null;
    }
    private Game runGameController(){
        return null;
    }



}
