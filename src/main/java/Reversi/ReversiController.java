package Reversi;

import Plato.Model.Game;
import Plato.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;

//controller
public class ReversiController extends Game {
    //fields
    private static ArrayList<ReversiController> matches = new ArrayList<ReversiController>();
    private Reversi model;
    private ReversiView view;

    //constructor
    public ReversiController(Reversi model, ReversiView view){
        this.model = model;
        this.view = view;
    }

    //getter methods
    public ReversiView getView() {
        return view;
    }
    public Reversi getModel() {
        return model;
    }
    public static ArrayList<ReversiController> getMatches() {
        return matches;
    }

    //the methods that relates to view
    public void showWhereToPut(){
        view.showWhereToPut(this);
    }
    public void showWhoseTurnIsIt(){
        view.showWhoseTurnIsIt(this);
    }
    public void showResult(){
        view.showResult(this);
    }
    public void showScore(){
        view.showScore(this);
    }
    public void showGrid(){
        view.showGrid();
    }
    public void showDisks(){
        view.showDisks(this);
    }

    //the methods that relates to model
    public void placeDisk(int x, int y){
        model.placeDisk(x, y);
    }
    public void changeTurn(){
        model.changeTurn();
    }
    /*public static ReversiController getMatchByPlayer(Player player){
        int n = matches.size();
        for (int i = 0; i < n; i++) {
            if (matches.get(i).getModel().getBlack().equals(player) || matches.get(i).getModel().getWhite().equals(player))
                return matches.get(i);
        }
        return null;
    }*/

    //runs the game
    public static void run(Player black, Player white){
        Scanner scanner = new Scanner(System.in);
        String input;
        while((input = scanner.nextLine()).equals("end of my turn")){

        }
    }
}
