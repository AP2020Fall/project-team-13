package Reversi;

import Plato.Model.Game;
import Plato.Model.Player;
import java.util.Scanner;
import java.util.regex.Pattern;

//controller
public class ReversiController extends Game {
    //fields
    private Reversi model;
    private ReversiView view;

    //constructor
    public ReversiController(Player player1, Player player2){
        this.model = new Reversi(player1, player2);
        this.view = new ReversiView();
    }

    //getter methods
    public ReversiView getView() {
        return view;
    }
    public Reversi getModel() {
        return model;
    }

    //relating to view
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

    //relating to model
    public void placeDisk(int x, int y){
        model.placeDisk(x, y);
    }
    public void changeTurn(){
        model.changeTurn();
    }
    public void showAvailableCoordinates(){
        model.printAvailableCoordinates();
    }

    //runs the game
    public static void run(Player black, Player white){

        //build a new game
        ReversiController game = new ReversiController(black, white);

        //getting input
        Scanner scanner = new Scanner(System.in);
        String input;

        //the menu while playing
        while(!game.getModel().isTableFull() && game.getModel().canAnyoneMove() || !game.getModel().doAllOfTheDisksHaveSameColor()){
            input = scanner.nextLine();
            if(input.trim().equals("end of my turn")){
                game.changeTurn();
            }
            else if(Pattern.matches("Place disk on .\\d+,\\d+.", input.trim())){
                input = (input.split(" ")[3]);
                input = input.substring(1, input.length() - 1);
                int x = Integer.parseInt(input.split(",")[0]);
                int y = Integer.parseInt(input.split(",")[1]);
                game.placeDisk(x, y);
            }
            else if(input.trim().equals("show available coordinates")){
                game.showAvailableCoordinates();
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
            else if(input.trim().equals("show score")){
                game.showScore();
            }
            else if(input.trim().equals("help")){
                System.out.println("1. end of my turn\n" +
                        "2. Place disk on (x,y)\n" +
                        "3. show available coordinates\n" +
                        "4. show grid\n" +
                        "5. show disks\n" +
                        "6. Who is next?\n" +
                        "7. show score\n" +
                        "8. help\n" +
                        "9. exit");
            }
            else if(input.trim().equals("exit")){
                return;
            }
            else{
                System.out.println("invalid command!");
            }
        }

        game.getModel().getWinner().addScore();

        //the menu after playing
        while(true){
            input = scanner.nextLine();
            if(input.trim().equals("show result")){
                game.showResult();
            }
            else if(input.trim().equals("help")){
                System.out.println("1. show result\n" +
                        "2. help\n" +
                        "3. exit");
            }
            else if(input.trim().equals("exit")){
                return;
            }
            else{
                System.out.println("invalid command!");
            }
        }

    }

}
