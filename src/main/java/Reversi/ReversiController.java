package Reversi;

import Plato.Model.*;
import Plato.View.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static javafx.application.Application.launch;

//controller
public class ReversiController extends Game {
    //fields
    public static ReversiController reversiController = new ReversiController();
    private Reversi model;
    private ReversiView view;

    //constructor
    public ReversiController(Player player1, Player player2) {
        if (player1 != null && player2 != null) {
            this.model = new Reversi(player1, player2);
            this.view = new ReversiView();
        }
    }

    public ReversiController() {

    }


    //getter methods
    public ReversiView getView() {
        return view;
    }
    public Reversi getModel() {
        return model;
    }

    //relating to view
    public void showWhoseTurnIsIt() {
        view.showWhoseTurnIsIt(this);
    }

    public void showResult() {
        view.showResult(this);
    }

    public void showScore() {
        view.showScore(this);
    }

    public void showDisks() {
        view.showDisks(this);
    }

    //relating to model
    public void placeDisk(int x, int y) {
        model.placeDisk(x, y);
    }

    public void changeTurn() {
        model.changeTurn();
    }

    public void showAvailableCoordinates() {
        model.printAvailableCoordinates();
    }

    //runs the game
    public static Page run(Player black, Player white) throws FileNotFoundException {

        //build a new game
        ReversiController game = new ReversiController(black, white);

        //getting input
        Scanner scanner = new Scanner(System.in);
        String input;

        //title
        System.out.println("Reversi game :");

        //the menu while playing
        while (!game.getModel().isTableFull() && game.getModel().canAnyoneMove() || !game.getModel().doAllOfTheDisksHaveSameColor()) {
            Admin.updateAdmins();
            Player.updatePlayers();
            Game.updateGames();
            Log.updateLogs();
            Event.updateEvents();
            input = scanner.nextLine();
            if (input.trim().equals("end of my turn")) {
                game.changeTurn();
            }
            else if (Pattern.matches("Place disk on .\\d+,\\d+.", input.trim())) {
                input = (input.split(" ")[3]);
                input = input.substring(1, input.length() - 1);
                int x = Integer.parseInt(input.split(",")[0]);
                int y = Integer.parseInt(input.split(",")[1]);
                game.placeDisk(x, y);
            }
            else if (input.trim().equals("show available coordinates")) {
                game.showAvailableCoordinates();
            }
            else if (input.trim().equals("show disks")) {
                game.showDisks();
            }
            else if (input.trim().equals("Who is next?")) {
                game.showWhoseTurnIsIt();
            }
            else if (input.trim().equals("show score")) {
                game.showScore();
            }
            else if (input.trim().equals("back")) {
                return GamesMenu.gamesMenu;
            }
            else if (input.trim().equals("View account menu")) {
                return UserPage.userPage;
            }
            else if (input.trim().equals("help")) {
                System.out.println("1. end of my turn\n" +
                        "2. Place disk on (x,y)\n" +
                        "3. show available coordinates\n" +
                        "4. show disks\n" +
                        "5. Who is next?\n" +
                        "6. show score\n" +
                        "7. back\n" +
                        "8. View account menu\n" +
                        "9. help\n");
            }
            else {
                System.out.println("invalid command!");
            }
        }

        if (game.getModel().getWinner() != null) {
            System.out.println("match just finished and the winner is: " + game.getModel().getWinner() + "!");
            game.getModel().getWinner().addScore();
            game.getModel().getWinner().addReversiPoints();
            game.getModel().getWinner().addReversiWins();
            game.getModel().getLooser().addReversiLosses();
        }
        else {
            System.out.println("match just finished and the result is draw!");
            game.getModel().getWhite().addReversiDraws();
            game.getModel().getBlack().addReversiDraws();
        }
        game.getModel().getBlack().addReversiPlayedCount();
        game.getModel().getWhite().addReversiPlayedCount();
        Log.addLog(1, black, white, game.getModel().getWinner());

        //the menu after playing
        while (true) {
            input = scanner.nextLine();
            if (input.trim().equals("show result")) {
                game.showResult();
            }
            else if (input.trim().equals("show score")) {
                game.showScore();
            }
            else if (input.trim().equals("back")) {
                return ReversiMenu.reversiMenu;
            }
            else if (input.trim().equals("View account menu")) {
                return UserPage.userPage;
            }
            else if (input.trim().equals("help")) {
                System.out.println("1. show result\n" +
                        "2. show score\n" +
                        "3. back\n" +
                        "4. View account menu\n" +
                        "5. help");
            }
            else {
                System.out.println("invalid command!");
            }
        }
    }
}
