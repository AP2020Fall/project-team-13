package Plato.View;

import Plato.Controller.GameMenuController;
import Plato.Model.Player;

public class GameMenu extends Page{
      public static Player player;
      public static int gameID;
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
      private void showPlayedCount(){

      }
      private void addToFavorites(){

      }
      private void showPoints(){
      }
      private void runGame(){

      }
      public static int getGameID() {
        return gameID;
    }
      public static void setGameID(int gameID) {
        GameMenu.gameID = gameID;
    }
}
