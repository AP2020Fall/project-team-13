package Reversi;

import Plato.Model.Player;

import java.util.Random;

public class Reversi {
    private Player black;
    private Player white;
    private Table table;
    public Reversi(Player black, Player white){
        this.table = new Table();
        this.black = black;
        this.white = white;
    }
    public Player getBlack() {
        return black;
    }
    public Player getWhite() {
        return white;
    }
    public Table getTable() {
        return table;
    }
    public boolean doesItObserveTheTableLimit(int x, int y){
        if(x <= 8 && x >= 1 && y <= 8 && y >= 1)
            return true;
        return false;
    }
    public boolean canHePlaceDisk(Player player){return true;}///////////
    public boolean canTheyPlaceDisk(){
        return (canHePlaceDisk(black) && canHePlaceDisk(white));
    }
    public boolean isTableFull(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if(this.table.getTable()[i][j].equals("E"))
                    return false;
        return true;
    }
    public void placeDisk(int x, int y){
        if(!doesItObserveTheTableLimit(x, y))
            System.out.println("Coordinates must be inside the table");
        else if(!canHePlaceDisk(getPlayerByWhoseTurn()))
            System.out.println("You cannot place the disk on this Coordinates");
        else{
            //...
            changeTurn();
        }
    }///////
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
                this.table.setColor(x, x - sub);
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
                this.table.setColor(x, sum - x);
        }
    }
    public void changeTurn(){
        if(this.table.getWhoseTurn().equals("W"))
            this.table.setWhoseTurn("B");
        else
            this.table.setWhoseTurn("W");
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
}
class Table{
    private String[][] table = new String[8][8];
    private String result;
    private String whoseTurn;
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
    }
    public Table(Table table){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                this.table[i][j] = table.getTable()[i][j];
        this.whoseTurn = table.getWhoseTurn();
        this.result = table.getResult();
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
    public void setWhoseTurn(String whoseTurn) {
        this.whoseTurn = whoseTurn;
    }
    public void setColor(int x, int y){
        table[x - 1][y - 1] = getWhoseTurn();
    }
}
