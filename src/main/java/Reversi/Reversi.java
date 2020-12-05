package Reversi;

import Plato.Model.Player;

import java.util.Random;

//model
public class Reversi {
    //fields
    private Player black;
    private Player white;
    private Table table;

    //constructor
    public Reversi(Player black, Player white){
        this.table = new Table();
        this.black = black;
        this.white = white;
    }

    //getter methods
    public Player getBlack() {
        return black;
    }
    public Player getWhite() {
        return white;
    }
    public Table getTable() {
        return table;
    }

    //these four methods are for checking some of the needed conditions and changing the color of disks in order to place a disk correctly
    public static boolean doesItObserveTheTableLimit(int x, int y){
        if(x <= 8 && x >= 1 && y <= 8 && y >= 1)
            return true;
        return false;
    }
    public boolean canHePlaceDisk(int x, int y){
        String theOtherPlayer;
        if(this.getTable().getWhoseTurn().equals("W"))
            theOtherPlayer = "B";
        else
            theOtherPlayer = "W";
        if(this.getTable().getTable()[x][y].equals("E")) {
            //checking right
            int i = 1;
            for ( ; doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
            //checking left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
            //checking upside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
            //checking downside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
            //checking up right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
            //checking down left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
            //checking up left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
            //checking down right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                return true;
        }
        return false;
    }
    public void placeDisk(int x, int y){
        if(!doesItObserveTheTableLimit(x, y))
            System.out.println("Coordinates must be inside the table");
        else if(!canHePlaceDisk(x, y))
            System.out.println("You cannot place the disk on this Coordinates");
        else{
            String theOtherPlayer;
            if(this.getTable().getWhoseTurn().equals("W"))
                theOtherPlayer = "B";
            else
                theOtherPlayer = "W";
            //checking right
            int i = 1;
            for ( ; doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x, y + i);
            //checking left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x, y - i);
            //checking upside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x + i, y);
            //checking downside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x - i, y);
            //checking up right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x + i, y + i);
            //checking down left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x - i, y - i);
            //checking up left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x + i, y - i);
            //checking down right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(this.getTable().getWhoseTurn()) && i != 1)
                changeTheDisksColor(x, y, x - i, y + i);
        }
        }
    public void changeTheDisksColor(int x, int y, int X, int Y){
        if(x == X){
            if(y > Y){
                int tmp = y;
                y = Y;
                Y = tmp;
            }
            for (int i = y; i <= Y; i++)
                this.table.setColor(x, i);
        }
        else if(y == Y){
            if(x > X){
                int tmp = x;
                x = X;
                X = tmp;
            }
            for (int i = x; i <= X; i++)
                this.table.setColor(i, y);
        }
        else if ((x - y) == (X - Y)){
            int sub = x - y;
            if(x > X){
                int tmp = x;
                x = X;
                X = tmp;
                tmp = y;
                y = Y;
                Y = tmp;
            }
            for (int i = x; i <= X ; i++)
                this.table.setColor(i, i - sub);
        }
        else if((x + y) == (X + Y)){
            int sum = x + y;
            if(x > X){
                int tmp = x;
                x = X;
                X = tmp;
                tmp = y;
                y = Y;
                Y = tmp;
            }
            for (int i = x; i <= X; i++)
                this.table.setColor(i, sum - i);
        }
    }


    public boolean isTableFull(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if(this.table.getTable()[i][j].equals("E"))
                    return false;
        return true;
    }
    public void changeTurn(){
        if(this.table.getWhoseTurn().equals("W")) {
            if(this.getTable().getHasHePlayed()) {
                this.table.setWhoseTurn("B");
                this.getTable().setHasHePlayed(false);
            }
            else{
                System.out.println("in your turn you should place the disk");
            }
        }
        else if(this.table.getWhoseTurn().equals("B")){
            if(this.getTable().getHasHePlayed()) {
                this.table.setWhoseTurn("W");
                this.getTable().setHasHePlayed(false);
            }
            else{
                System.out.println("in your turn you should place the disk");
            }
        }
    }
    public int getNumberOfInputColorDisks(String color){
        int number = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.table.getTable()[i][j].equals(color))
                    number++;
            }
        }
        return number;
    }
    public Player getPlayerByWhoseTurn(){
        if(this.table.getWhoseTurn().equals("W"))
            return white;
        else
            return black;
    }
    public boolean isItHisTurn(Player player){
        if(player.equals(getPlayerByWhoseTurn()))
            return true;
        return false;
    }
    public boolean isEmpty(int x, int y){
        return this.getTable().getTable()[x - 1][y - 1].equals("E");
    }
}
class Table{
    private String[][] table = new String[8][8];
    private String result;
    private String whoseTurn;
    private boolean hasHePlayed;
    public Table(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                table[i][j] = "E";
        table[3][3] = "W";
        table[4][4] = "W";
        table[3][4] = "B";
        table[4][3] = "B";
        result = "playing";
        Random random = new Random();
        int rand = random.nextInt(2);
        if(rand == 0)
            whoseTurn = "black";
        else
            whoseTurn = "white";
        hasHePlayed = false;
    }
    public Table(Table table){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                this.table[i][j] = table.getTable()[i][j];
        this.whoseTurn = table.getWhoseTurn();
        this.result = table.getResult();
        this.hasHePlayed = table.getHasHePlayed();
    }
    public String getResult() {
        return result;
    }
    public String getWhoseTurn() {
        return whoseTurn;
    }
    public String[][] getTable() {
        return table;
    }
    public boolean getHasHePlayed(){
        return hasHePlayed;
    }
    public void setWhoseTurn(String whoseTurn) {
        this.whoseTurn = whoseTurn;
    }
    public void setColor(int x, int y){
        table[x - 1][y - 1] = getWhoseTurn();
    }
    public void setHasHePlayed(boolean hasHePlayed) {
        this.hasHePlayed = hasHePlayed;
    }
}
