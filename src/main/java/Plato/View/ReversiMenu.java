package Plato.View;

import Plato.Model.Player;

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

            }
            else if( input.trim().equals("Show log")){

            }
            else if( input.trim().equals("Show wins count")){

            }
            else if( input.trim().equals("Show played count")){

            }
            else if( input.trim().equals("Add to favorites")){

            }
            else if( input.trim().equals("Run game")){

            }
            else if( input.trim().equals("Show point")) {

            }
        }
    }
    public void setPlayer (Player player){


      }

    public static Player getPlayer() {
        return null;
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
