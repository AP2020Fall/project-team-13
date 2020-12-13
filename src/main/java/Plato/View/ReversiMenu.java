package Plato.View;

import Plato.Controller.LoginPageController;
import Plato.Model.Log;
import Plato.Model.Player;
import Reversi.ReversiController;
import java.util.ArrayList;
import java.util.Scanner;

public class ReversiMenu extends Page{
      public static ReversiMenu reversiMenu = new ReversiMenu();
      private static final int gameID = 1;
      public Page run() {
          String input;
          Scanner scanner = new Scanner(System.in);
          while(true){
              input = scanner.nextLine();
              if(input.trim().equals("Show scoreboard")){
                  ArrayList<Player> playersThatHasPlayedReversi = new ArrayList<>();
                  for (Player player : Player.getPlayers()) {
                      if(player.getReversiPlayedCount() > 0)
                          playersThatHasPlayedReversi.add(player);
                  }
                  playersThatHasPlayedReversi = Player.sortForReversiMenu(playersThatHasPlayedReversi);
                  int n = playersThatHasPlayedReversi.size();
                  for (int i = n - 1; i >= 0; i--) {
                      System.out.println("1." + playersThatHasPlayedReversi.get(i).getUsername() + " point: " +
                              playersThatHasPlayedReversi.get(i).getReversiPoints() +
                              " wins: " + playersThatHasPlayedReversi.get(i).getReversiWins() +
                              " draws: " + playersThatHasPlayedReversi.get(i).getReversiDraws() +
                              " losses: " + playersThatHasPlayedReversi.get(i).getReversiLosses());
                  }
              }
              else if(input.trim().equals("Details")){
                System.out.println("Board\n" +
                        "Reversi is a 2 players game, played on a board of 64 squares arranged in an 8x8 rows and columns. The game begins with four discs already placed on the board:\n" +
                        "\n" +
                        "A set of 64 identical pieces is shared by both players. Each piece is a disc that is black on one side and white on the other.\n" +
                        "Object of Game\n" +
                        "The object of Reverze is to flip the most discs to your color by the end of the game. If both players have the same number of discs of their color up, the game is a draw.\n" +
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
              else if(input.trim().equals("Show log")){
                  for (Log log : Log.getLogs()) {
                      if(log.getGameID() == 1){
                          System.out.println("a match between " + log.getPlayer1().getUsername() + " and " +
                                  log.getPlayer2().getUsername() + " has been done and " + log.getWinner().getUsername() +
                                  " has won this match." + "(" + log.getFinishTime() + ")");
                      }
                  }
              }
              else if(input.trim().equals("Show wins count")){
                System.out.println("player with username " + LoginPageController.user.getUsername() +
                        " has won " + ( (Player)LoginPageController.user).getReversiWins() + " time(s) in Reversi.");
            }
              else if(input.trim().equals("Show played count")){
                System.out.println("player with username " + LoginPageController.user.getUsername() +
                        " has played " + ( (Player)LoginPageController.user).getReversiPlayedCount() + " time(s) in Reversi.");
            }
              else if(input.trim().equals("Add to favorites")){
                ((Player)LoginPageController.user).addFavorite(1);
            }
              else if(input.trim().equals("Run game")){
                  System.out.println("please enter username:");
                  String username = scanner.nextLine();
                  System.out.println("please enter password:");
                  String password = scanner.nextLine();
                  try {

                      Player secondPlayer = LoginPageController.loginSecond(username,password);
                      ReversiController.run(((Player)LoginPageController.user), secondPlayer);
                  } catch (Exception e) {
                      System.out.println("invalid information for second player");
                  }


            }
              else if(input.trim().equals("Show points")) {
                System.out.println("the player with username "
                        + ((Player)LoginPageController.user).getUsername() + " has gained "
                        + ((Player)LoginPageController.user).getReversiPoints() + " points from Reversi.");
            }
              else if(input.trim().equals("View account menu")){
                  return UserPage.userPage;
              }
              else if(input.trim().equals("Back")){
                  return GamesMenu.gamesMenu;
              }
              else if(input.trim().equals("Help")){
                  System.out.println("1. Show scoreboard\n" +
                          "2. Details\n" +
                          "3. Show log\n" +
                          "4. Show wins count\n" +
                          "5. Show played count\n" +
                          "6. Add to favorites\n" +
                          "7. Run game\n" +
                          "8. Show points\n" +
                          "9. View account menu\n" +
                          "10. Back\n" +
                          "11. Help");
              }
              else{
                  System.out.println("invalid command!");
              }
          }
    }
}
