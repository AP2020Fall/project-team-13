package Reversi;

import Plato.Model.Game;
import Plato.Model.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

//controller
public class ReversiController extends Game {
    //fields
    private static ArrayList<ReversiController> matches = new ArrayList<ReversiController>();
    private Reversi model;
    private ReversiView view;

    //constructor
    public ReversiController(Player black, Player white){
        this.model = new Reversi(black, white);
        this.view = new ReversiView();
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

        //building a new game
        ReversiController game = new ReversiController(black, white);

        //getting input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        while(true){
            if(input.trim().equals("end of my turn")){
                game.changeTurn();
            }
            else if(Pattern.matches("Place disk on (//d+,//d+)", input.trim())){
                input = (input.split(" ")[3]);
                input = input.substring(1, input.length() - 1);
                int x = Integer.parseInt(input.split(",")[0]);
                int y = Integer.parseInt(input.split(",")[1]);
                game.placeDisk(x, y);
            }
            else if(input.trim().equals("show available coordinates")){
                game.showWhereToPut();
            }
            else if(input.trim().equals("show grid")){
                game.showGrid();
            }
            else if(input.trim().equals("show disks")){
                game.showDisks();
            }
            else if(input.trim().equals("Who is next?")){
                game.showWhoseTurnIsIt();
            }
            else if(input.trim().equals("show result")){
                game.showResult();
            }
            else if(input.trim().equals("show score")){
                game.showScore();
            }
        }
    }
}
