package Plato.View;

import Plato.Controller.LoginPageController;
import Plato.Model.Player;
import Reversi.ReversiController;

import java.util.Scanner;

public class ReversiMenu extends Page{
      private static int gameID = 1;
      public Page run() {
          String input = new String();
          Scanner scanner = new Scanner(System.in);
          input = scanner.nextLine();
        while(true){
            if(input.trim().equals("Show scoreboard")){

            }
            else if( input.trim().equals("Details")){
                System.out.println();
            }
            else if( input.trim().equals("Show log")){

            }
            else if( input.trim().equals("Show wins count")){
                System.out.println("player with username " + LoginPageController.user.getUsername() +
                        " has won " + ( (Player)LoginPageController.user).getReversiWins() + " time(s) in Reversi.");
            }
            else if( input.trim().equals("Show played count")){
                System.out.println("player with username " + LoginPageController.user.getUsername() +
                        " has played " + ( (Player)LoginPageController.user).getReversiPlayedCount() + " time(s) in Reversi.");
            }
            else if( input.trim().equals("Add to favorites")){
                ((Player)LoginPageController.user).addFavorite(new ReversiController(null, null));
            }
            else if( input.trim().equals("Run game")){
                //hasannnnnnnnnn!!!!
                Player hasan = new Player();
                hasan.setUsername("hasan");
                ReversiController.run(((Player)LoginPageController.user), hasan);
            }
            else if( input.trim().equals("Show point")) {

            }
        }
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
        ReversiMenu.gameID = gameID;
      }
}
