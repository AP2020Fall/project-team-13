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
                System.out.println("Board\n" +
                        "Reversi is a 2 players game, played on a board of 64 squares arranged in an 8x8 rows and columns. The game begins with four discs already placed on the board:\n" +
                        "\n" +
                        "A set of 64 identical pieces is shared by both players. Each piece is a disc that is black on one side and white on the other.\n" +
                        "Object of Game\n" +
                        "The object of Reverze is to flip the most discs to your color by the end of the game. If both players have the same number of discs of their color up, the game is a draw.\n" +
                        "\n" +
                        "Sina Nikdel, [10.12.20 14:15]\n" +
                        "Placing Pieces\n" +
                        "Players are designated Black and White at the start of the game. Beginning with Black, each player in turn places one disc onto a vacant square on the board.\n" +
                        "Once placed, a disc never moves, though it may be \"flipped\" when captured so that it changes color.\n" +
                        "To place a disc, simply tap on a legal square. A move is legal if it captures one or more of the opponent's discs. You can see which moves are legal by the small opaque circles on the board:\n" +
                        "\n" +
                        "Capturing\n" +
                        "A disc, or an unbroken line of discs of the same color, is captured when it becomes flanked on opposite ends by two opposing pieces, one of which must be the disc that was just placed on the board.\n" +
                        "For example, in the example below if the Black player is about to place a black disc in the space with the yellow dot:\n" +
                        "\n" +
                        "Doing so will capture and flip the horizontal white discs to black, resulting in:\n" +
                        "\n" +
                        "Captures may be made along ranks (horizontal rows of squares), files (vertical rows of squares), or diagonals.\n" +
                        "Endgame\n" +
                        "A player who cannot make a legal move loses his or her turn. The game continues until neither side can move; usually, this does not happen until the board is entirely filled.\n" +
                        "The player whose color is up on more of the discs at the end is the winner (you'll see the score next to each player's name). If both players have the same number of discs of their color up, the game is a draw.");
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
            else if( input.trim().equals("Show points")) {
                System.out.println("the player with username "
                        + ((Player)LoginPageController.user).getUsername() + " has gained "
                        + ((Player)LoginPageController.user).getReversiPoints() + " points from Reversi.");
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
