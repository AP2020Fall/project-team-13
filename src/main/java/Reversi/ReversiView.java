package Reversi;

//view
public class ReversiView {
    public void showWhoseTurnIsIt(ReversiController controller){
        System.out.println("It is " + controller.getModel().getTable().getWhoseTurn() + "'s turn with username " +
                controller.getModel().getPlayerByWhoseTurn().getUsername());
    }
    public void showResult(ReversiController controller){
        if(controller.getModel().getWinner() != null)
            System.out.println(controller.getModel().getWinner().getUsername() + "has won this match.");
    }
    public void showScore(ReversiController controller){
        System.out.println("Player black named " + controller.getModel().getBlack().getFirstname() + " " + controller.getModel().getBlack().getLastname() + " has "
                + controller.getModel().getBlack().getScore() + " score(s).");
        System.out.println("Player white named " + controller.getModel().getWhite().getFirstname() + " " + controller.getModel().getWhite().getLastname() + " has "
                + controller.getModel().getWhite().getScore() + " score(s).");
    }
    public void showGrid(){}////////
    public void showDisks(ReversiController controller){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(controller.getModel().getTable().getTable()[i][j].equals("E"))
                    System.out.print("\u001B[36m" + "E" + "\u001B[0m" +  " ");
                else if(controller.getModel().getTable().getTable()[i][j].equals("W"))
                    System.out.print("\u001B[30m" + "W" + "\u001B[0m" +  " ");
                else if(controller.getModel().getTable().getTable()[i][j].equals("B"))
                    System.out.print("\u001B[37m" + "B" + "\u001B[0m" +  " ");
            }
            System.out.println();

        }
    }
}
