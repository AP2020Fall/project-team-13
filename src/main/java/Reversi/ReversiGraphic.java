package Reversi;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReversiGraphic{
    //fields

    //board
    public GridPane board;
    //images
    public static BufferedImage black;
    static {
        try {
            black = ImageIO.read(new File("src/main/java/Reversi/images/black.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static BufferedImage white;
    static {
        try {
            white = ImageIO.read(new File("src/main/java/Reversi/images/white.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static BufferedImage green;
    static {
        try {
            green = ImageIO.read(new File("src/main/java/Reversi/images/green.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static BufferedImage blue;
    static {
        try {
            blue = ImageIO.read(new File("src/main/java/Reversi/images/blue.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //places
    public Pane Zero_Zero;
    public ImageView zero_zero;
    public Pane Zero_One;
    public ImageView zero_one;
    public Pane Zero_Two;
    public ImageView zero_two;
    public Pane Zero_Three;
    public ImageView zero_three;
    public Pane Zero_Four;
    public ImageView zero_four;
    public Pane Zero_Five;
    public ImageView zero_five;
    public Pane Zero_Six;
    public ImageView zero_six;
    public Pane Zero_Seven;
    public ImageView zero_seven;
    public Pane One_Zero;
    public ImageView one_zero;
    public Pane One_One;
    public ImageView one_one;
    public Pane One_Two;
    public ImageView one_two;
    public Pane One_Three;
    public ImageView one_three;
    public Pane One_Four;
    public ImageView one_four;
    public Pane One_Five;
    public ImageView one_five;
    public Pane One_Six;
    public ImageView one_six;
    public Pane One_Seven;
    public ImageView one_seven;
    public Pane Two_Zero;
    public ImageView two_zero;
    public Pane Two_One;
    public ImageView two_one;
    public Pane Two_Two;
    public ImageView two_two;
    public Pane Two_Three;
    public ImageView two_three;
    public Pane Two_Four;
    public ImageView two_four;
    public Pane Two_Five;
    public ImageView two_five;
    public Pane Two_Six;
    public ImageView two_six;
    public Pane Two_Seven;
    public ImageView two_seven;
    public Pane Three_Zero;
    public ImageView three_zero;
    public Pane Three_One;
    public ImageView three_one;
    public Pane Three_Two;
    public ImageView three_two;
    public Pane Three_Three;
    public ImageView three_three;
    public Pane Three_Four;
    public ImageView three_four;
    public Pane Three_Five;
    public ImageView three_five;
    public Pane Three_Six;
    public ImageView three_six;
    public Pane Three_Seven;
    public ImageView three_seven;
    public Pane Four_Zero;
    public ImageView four_zero;
    public Pane Four_One;
    public ImageView four_one;
    public Pane Four_Two;
    public ImageView four_two;
    public Pane Four_Three;
    public ImageView four_three;
    public Pane Four_Four;
    public ImageView four_four;
    public Pane Four_Five;
    public ImageView four_five;
    public Pane Four_Six;
    public ImageView four_six;
    public Pane Four_Seven;
    public ImageView four_seven;
    public Pane Five_Zero;
    public ImageView five_zero;
    public Pane Five_One;
    public ImageView five_one;
    public Pane Five_Two;
    public ImageView five_two;
    public Pane Five_Three;
    public ImageView five_three;
    public Pane Five_Four;
    public ImageView five_four;
    public Pane Five_Five;
    public ImageView five_five;
    public Pane Five_Six;
    public ImageView five_six;
    public Pane Five_Seven;
    public ImageView five_seven;
    public Pane Six_Zero;
    public ImageView six_zero;
    public Pane Six_One;
    public ImageView six_one;
    public Pane Six_Two;
    public ImageView six_two;
    public Pane Six_Three;
    public ImageView six_three;
    public Pane Six_Four;
    public ImageView six_four;
    public Pane Six_Five;
    public ImageView six_five;
    public Pane Six_Six;
    public ImageView six_six;
    public Pane Six_Seven;
    public ImageView six_seven;
    public Pane Seven_Zero;
    public ImageView seven_zero;
    public Pane Seven_One;
    public ImageView seven_one;
    public Pane Seven_Two;
    public ImageView seven_two;
    public Pane Seven_Three;
    public ImageView seven_three;
    public Pane Seven_Four;
    public ImageView seven_four;
    public Pane Seven_Five;
    public ImageView seven_five;
    public Pane Seven_Six;
    public ImageView seven_six;
    public Pane Seven_Seven;
    public ImageView seven_seven;
    //buttons
    public Button back;
    public Button viewAccountMenu;
    //model
    public static Reversi game;
    //labels
    public Label turn;
    public Label result;
    public static ArrayList<ReversiGraphic> reversiGraphics = new ArrayList<>();

    //methods

    public ReversiGraphic(){
        reversiGraphics.add(this);
    }
    //place disk
    public void placeDisk(MouseEvent mouseEvent) {
        int x = (int) ((mouseEvent.getSceneY() / 60));
        int y = (int) ((mouseEvent.getSceneX() / 60));
        x++;
        y++;
        if(!Reversi.doesItObserveTheTableLimit(x, y))
            System.out.println("Coordinates must be inside the table");
        else if(!game.canHePlaceDisk(x, y))
            System.out.println("You cannot place the disk on this Coordinates");
        else if(game.getTable().getHasHePlayed())
            System.out.println("You have placed disk before. You should change the turn.");
        else {
            String theOtherPlayer;
            String thisPlayer;
            if (game.getTable().getWhoseTurn().equals("white")) {
                theOtherPlayer = "B";
                thisPlayer = "W";
            } else {
                theOtherPlayer = "W";
                thisPlayer = "B";
            }
            //checking right
            int i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x, y + i) && game.getTable().getTable()[x - 1][y + i - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x, y + i) && game.getTable().getTable()[x - 1][y + i - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x, y + i);
            //checking left
            i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x, y - i) && game.getTable().getTable()[x - 1][y - i - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x, y - i) && game.getTable().getTable()[x - 1][y - i - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x, y - i);
            //checking upside
            i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x + i, y) && game.getTable().getTable()[x + i - 1][y - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x + i, y) && game.getTable().getTable()[x + i - 1][y - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x + i, y);
            //checking downside
            i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x - i, y) && game.getTable().getTable()[x - i - 1][y - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x - i, y) && game.getTable().getTable()[x - i - 1][y - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x - i, y);
            //checking up right
            i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x + i, y + i) && game.getTable().getTable()[x + i - 1][y + i - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x + i, y + i) && game.getTable().getTable()[x + i - 1][y + i - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x + i, y + i);
            //checking down left
            i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x - i, y - i) && game.getTable().getTable()[x - i - 1][y - i - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x - i, y - i) && game.getTable().getTable()[x - i - 1][y - i - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x - i, y - i);
            //checking up left
            i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x + i, y - i) && game.getTable().getTable()[x + i - 1][y - i - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x + i, y - i) && game.getTable().getTable()[x + i - 1][y - i - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x + i, y - i);
            //checking down right
            i = 1;
            for (; Reversi.doesItObserveTheTableLimit(x - i, y + i) && game.getTable().getTable()[x - i - 1][y + i - 1].equals(theOtherPlayer); i++)
                ;
            if (Reversi.doesItObserveTheTableLimit(x - i, y + i) && game.getTable().getTable()[x - i - 1][y + i - 1].equals(thisPlayer) && i != 1)
                game.changeTheDisksColor(x, y, x - i, y + i);

            game.getTable().setLastMove(x - 1, y - 1);
            game.getTable().setHasHePlayed(true);
            game.changeTurn();
            turn.setText(game.getTable().getWhoseTurn() + "(" + game.getPlayerByWhoseTurn().getUsername() + ")");
            result.setText("black " + game.getNumberOfInputColorDisks("B") + "   -   " +
                    game.getNumberOfInputColorDisks("W") + " white");
            update();
        }
    }
    //back
    public void back(ActionEvent actionEvent) {
    }
    //update
    public void update(){
        Image blue = SwingFXUtils.toFXImage(ReversiGraphic.blue, null );
        Image green = SwingFXUtils.toFXImage(ReversiGraphic.green, null );
        Image black = SwingFXUtils.toFXImage(ReversiGraphic.black, null );
        Image white = SwingFXUtils.toFXImage(ReversiGraphic.white, null );
        Table table = new Table(game.getTable());
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if(game.canHePlaceDisk(i, j))
                    table.setColor(i, j, "A");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(j == 0){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            zero_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            zero_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            zero_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            zero_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            zero_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            zero_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            zero_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            zero_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            zero_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            zero_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            zero_seven.setImage(blue);
                        }
                    }
                }
                else if(j == 1){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            one_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            one_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            one_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            one_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            one_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            one_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            one_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            one_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            one_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            one_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            one_seven.setImage(blue);
                        }
                    }
                }
                else if(j == 2){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            two_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            two_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            two_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            two_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            two_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            two_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            two_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            two_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            two_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            two_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            two_seven.setImage(blue);
                        }
                    }
                }
                else if(j == 3){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            three_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            three_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            three_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            three_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            three_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            three_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            three_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            three_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            three_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            three_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            three_seven.setImage(blue);
                        }
                    }
                }
                else if(j == 4){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            four_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            four_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            four_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            four_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            four_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            four_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            four_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            four_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            four_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            four_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            four_seven.setImage(blue);
                        }
                    }
                }
                else if(j == 5){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            five_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            five_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            five_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            five_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            five_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            five_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            five_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            five_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            five_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            five_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            five_seven.setImage(blue);
                        }
                    }
                }
                else if(j == 6){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            six_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            six_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            six_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            six_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            six_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            six_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            six_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            six_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            six_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            six_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            six_seven.setImage(blue);
                        }
                    }
                }
                else if(j == 7){
                    if(i == 0){
                        if(table.getTable()[i][j].equals("W")){
                            seven_zero.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_zero.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_zero.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_zero.setImage(blue);
                        }
                    }
                    else if(i == 1){
                        if(table.getTable()[i][j].equals("W")){
                            seven_one.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_one.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_one.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_one.setImage(blue);
                        }
                    }
                    else if(i == 2){
                        if(table.getTable()[i][j].equals("W")){
                            seven_two.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_two.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_two.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_two.setImage(blue);
                        }
                    }
                    else if(i == 3){
                        if(table.getTable()[i][j].equals("W")){
                            seven_three.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_three.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_three.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_three.setImage(blue);
                        }
                    }
                    else if(i == 4){
                        if(table.getTable()[i][j].equals("W")){
                            seven_four.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_four.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_four.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_four.setImage(blue);
                        }
                    }
                    else if(i == 5){
                        if(table.getTable()[i][j].equals("W")){
                            seven_five.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_five.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_five.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_five.setImage(blue);
                        }
                    }
                    else if(i == 6){
                        if(table.getTable()[i][j].equals("W")){
                            seven_six.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_six.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_six.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_six.setImage(blue);
                        }
                    }
                    else if(i == 7){
                        if(table.getTable()[i][j].equals("W")){
                            seven_seven.setImage(white);
                        }
                        else if(table.getTable()[i][j].equals("B")){
                            seven_seven.setImage(black);
                        }
                        else if(table.getTable()[i][j].equals("E")){
                            seven_seven.setImage(green);
                        }
                        else if(table.getTable()[i][j].equals("A")){
                            seven_seven.setImage(blue);
                        }
                    }
                }
            }
        }
    }
    //view account menu
    public void viewAccountMenu(ActionEvent actionEvent) {
    }
}
