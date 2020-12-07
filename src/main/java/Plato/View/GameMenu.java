package Plato.View;

import Plato.Controller.GameMenuController;
import Plato.Controller.GamesMenuController;
import Plato.Model.Player;

public class GameMenu extends Page{
    public Player player;
    public String game;
    public static GameMenu gameMenu = new GameMenu();
    private GameMenuController gameMenuController = GameMenuController.getInstance();
    public Page run() {
        gameMenuController.showScoreBoard();
        return null;
    }
  public void setPlayer (Player player){

  }
  private void showScoreboard(){

  }
  private void details(){

  }
  private void showLog(){

  }
  private void showWinsCount(){

  }
  private void showPlaydCount(){

  }
  private void addToFavorites(){

  }
  private void showPoints(){
  }
  private void runGame(){

  }
}
