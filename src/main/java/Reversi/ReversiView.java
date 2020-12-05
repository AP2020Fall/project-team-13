package Reversi;

import Plato.Model.Player;

//view
public class ReversiView {
    public void showWhoseTurnIsIt(ReversiController controller){
        System.out.println("It is " + controller.getModel().getTable().getWhoseTurn() + "'s turn.");
    }
    public void showResult(ReversiController controller){
        System.out.println(controller.getModel().getTable().getResult());
    }
    public void showScore(ReversiController controller){
        System.out.println("Player black named " + controller.getModel().getBlack().getFirstname() + " " + controller.getModel().getBlack().getLastname() + " has "
                + controller.getModel().getBlack().getScore() + "score(s).");
        System.out.println("Player white named " + controller.getModel().getWhite().getFirstname() + " " + controller.getModel().getWhite().getLastname() + " has "
                + controller.getModel().getWhite().getScore() + "score(s).");
    }
    public void showGrid(){}////////
    public void showDisks(ReversiController controller){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(controller.getModel().getTable().getTable()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
