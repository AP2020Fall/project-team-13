package Reversi;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

//view
public class ReversiView {
    public void showWhoseTurnIsIt(ReversiController controller){
        System.out.println("It is " + controller.getModel().getTable().getWhoseTurn() + "'s turn with username " +
                controller.getModel().getPlayerByWhoseTurn().getUsername());
    }
    public void showResult(ReversiController controller){
        if(controller.getModel().getWinner() != null)
            System.out.println(controller.getModel().getWinner().getUsername() +
                    " has won this match.");
        else
            System.out.println("no one won the match, it's been a draw!");
    }
    public void showScore(ReversiController controller){
        System.out.println("Player black named " + controller.getModel().getBlack().getUsername() +
                " has " + controller.getModel().getNumberOfInputColorDisks("B") + " score(s).");
        System.out.println("Player white named " + controller.getModel().getWhite().getUsername() +
                " has " + controller.getModel().getNumberOfInputColorDisks("W") + " score(s).");
    }
    public void showDisks(ReversiController controller){
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
                if(controller.getModel().getTable().getTable()[i][j].equals("E"))
                    System.out.print("\u001B[36m" + "E" + "\u001B[0m" +  " ");
                else if(controller.getModel().getTable().getTable()[i][j].equals("W")) {
                    if(!controller.getModel().isLastMove(i, j))
                        System.out.print("\u001B[30m" + "W" + "\u001B[0m" + " ");
                    else
                        System.out.print("\u001B[31m" + "W" + "\u001B[0m" + " ");
                }
                else if(controller.getModel().getTable().getTable()[i][j].equals("B")) {
                    if(!controller.getModel().isLastMove(i, j))
                        System.out.print("\u001B[37m" + "B" + "\u001B[0m" + " ");
                    else
                        System.out.print("\u001B[31m" + "B" + "\u001B[0m" + " ");
                }
            }
            System.out.println();

        }
    }

}
