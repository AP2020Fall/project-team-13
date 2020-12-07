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
    public Reversi(Player player1, Player player2){
        this.table = new Table();
        Random random = new Random();
        int rand = random.nextInt(2);
        if(rand == 0) {
            this.black = player1;
            this.white = player2;
        }
        else {
            this.black = player2;
            this.white = player1;
        }
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

    //check some of the needed conditions and changing the color of disks in order to place a disk correctly
    public static boolean doesItObserveTheTableLimit(int x, int y){
        if(x <= 8 && x >= 1 && y <= 8 && y >= 1)
            return true;
        return false;
    }
    public boolean canHePlaceDisk(int x, int y){
        String theOtherPlayer;
        String thisPlayer;
        if(this.getTable().getWhoseTurn().equals("white")){
            theOtherPlayer = "B";
            thisPlayer = "W";
        }
        else{
            theOtherPlayer = "W";
            thisPlayer = "B";
        }
        if(this.getTable().getTable()[x - 1][y - 1].equals("E")) {
            //checking right
            int i = 1;
            for ( ; doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(thisPlayer) && i != 1)
                return true;
            //checking left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(thisPlayer) && i != 1)
                return true;
            //checking upside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(thisPlayer) && i != 1)
                return true;
            //checking downside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(thisPlayer) && i != 1)
                return true;
            //checking up right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(thisPlayer) && i != 1)
                return true;
            //checking down left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(thisPlayer) && i != 1)
                return true;
            //checking up left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(thisPlayer) && i != 1)
                return true;
            //checking down right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(thisPlayer) && i != 1)
                return true;
        }
        return false;
    }
    public void placeDisk(int x, int y){
        if(!doesItObserveTheTableLimit(x, y))
            System.out.println("Coordinates must be inside the table");
        else if(!canHePlaceDisk(x, y))
            System.out.println("You cannot place the disk on this Coordinates");
        else if(this.getTable().getHasHePlayed())
            System.out.println("You have placed disk before. You should change the turn.");
        else{
            String theOtherPlayer;
            String thisPlayer;
            if(this.getTable().getWhoseTurn().equals("white")){
                theOtherPlayer = "B";
                thisPlayer = "W";
            }
            else{
                theOtherPlayer = "W";
                thisPlayer = "B";
            }
            //checking right
            int i = 1;
            for ( ; doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y + i) && this.getTable().getTable()[x - 1][y + i - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x, y + i);
            //checking left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x, y - i) && this.getTable().getTable()[x - 1][y - i - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x, y - i);
            //checking upside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y) && this.getTable().getTable()[x + i - 1][y - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x + i, y);
            //checking downside
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y) && this.getTable().getTable()[x - i - 1][y - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x - i, y);
            //checking up right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y + i) && this.getTable().getTable()[x + i - 1][y + i - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x + i, y + i);
            //checking down left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y - i) && this.getTable().getTable()[x - i - 1][y - i - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x - i, y - i);
            //checking up left
            i = 1;
            for ( ; doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x + i, y - i) && this.getTable().getTable()[x + i - 1][y - i - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x + i, y - i);
            //checking down right
            i = 1;
            for ( ; doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(theOtherPlayer); i++);
            if(doesItObserveTheTableLimit(x - i, y + i) && this.getTable().getTable()[x - i - 1][y + i - 1].equals(thisPlayer) && i != 1)
                changeTheDisksColor(x, y, x - i, y + i);

            this.getTable().setHasHePlayed(true);
        }
    }
    public void changeTheDisksColor(int x, int y, int X, int Y){


        String thisPlayer;
        if(this.getTable().getWhoseTurn().equals("white"))
            thisPlayer = "W";
        else
            thisPlayer = "B";


        if(x == X){
            if(y > Y){
                int tmp = y;
                y = Y;
                Y = tmp;
            }
            for (int i = y; i <= Y; i++)
                this.table.setColor(x, i, thisPlayer);
        }
        else if(y == Y){
            if(x > X){
                int tmp = x;
                x = X;
                X = tmp;
            }
            for (int i = x; i <= X; i++)
                this.table.setColor(i, y, thisPlayer);
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
                this.table.setColor(i, i - sub, thisPlayer);
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
                this.table.setColor(i, sum - i, thisPlayer);
        }
    }

    //print the places that the players can place disk
    public void printAvailableCoordinates(){
        Table table = new Table(this.getTable());
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if(canHePlaceDisk(i, j))
                    table.setColor(i, j, "A");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(table.getTable()[i][j] + " ");
            }
            System.out.println();
        }
    }

    //change the turn
    public void changeTurn(){
        if(this.table.getWhoseTurn().equals("white")) {
            if(this.getTable().getHasHePlayed() && canHePlaceDisk(black)) {
                this.table.setWhoseTurn("black");
                this.getTable().setHasHePlayed(false);
            }
            else if(this.getTable().getHasHePlayed() && !canHePlaceDisk(black)){
                this.getTable().setHasHePlayed(false);
            }
            else if(!this.getTable().getHasHePlayed()){
                System.out.println("in your turn you should place the disk");
            }
        }
        else if(this.table.getWhoseTurn().equals("black")){
            if(this.getTable().getHasHePlayed()) {
                this.table.setWhoseTurn("white");
                this.getTable().setHasHePlayed(false);
            }
            else if(this.getTable().getHasHePlayed() && !canHePlaceDisk(white)){
                this.getTable().setHasHePlayed(false);
            }
            else if(!this.getTable().getHasHePlayed()){
                System.out.println("in your turn you should place the disk");
            }
        }
    }

    //checks if a player can place disk at all.
    public boolean canHePlaceDisk(Player player){
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if(this.canHePlaceDisk(i, j))
                    return true;
            }
        }
        return false;
    }

    //checks if the table is full.
    public boolean isTableFull(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if(this.table.getTable()[i][j].equals("E"))
                    return false;
        return true;
    }

    //returns the entity of input color in the table
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

    //checks if all of the disks have a same color
    public boolean doAllOfTheDisksHaveSameColor(){
        return (getNumberOfInputColorDisks("W") == 0 || getNumberOfInputColorDisks("B") == 0);
    }

    //checks if anyone can move at all.
    public boolean canAnyoneMove(){
        return (canHePlaceDisk(black) || canHePlaceDisk(white));
    }

    //returns the winner
    public Player getWinner(){
        if(getNumberOfInputColorDisks("W") > getNumberOfInputColorDisks("B"))
            return white;
        else if(getNumberOfInputColorDisks("W") < getNumberOfInputColorDisks("B"))
            return black;
        return null;
    }

    //white if W and black if B
    public Player getPlayerByWhoseTurn(){
        if(this.table.getWhoseTurn().equals("white"))
            return white;
        else
            return black;
    }

}

class Table{
    //fields
    private String[][] table = new String[8][8];
    private String whoseTurn;
    private boolean hasHePlayed;

    //constructor
    public Table(){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                table[i][j] = "E";
        table[3][3] = "W";
        table[4][4] = "W";
        table[3][4] = "B";
        table[4][3] = "B";
        whoseTurn = "black";
        hasHePlayed = false;
    }

    //copy constructor
    public Table(Table table){
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                this.table[i][j] = table.getTable()[i][j];
        this.whoseTurn = table.getWhoseTurn();
        this.hasHePlayed = table.getHasHePlayed();
    }

    //getter methods
    public String getWhoseTurn() {
        return whoseTurn;
    }
    public String[][] getTable() {
        return table;
    }
    public boolean getHasHePlayed(){
        return hasHePlayed;
    }

    //setter methods
    public void setWhoseTurn(String whoseTurn) {
        this.whoseTurn = whoseTurn;
    }
    public void setColor(int x, int y, String arg){
        table[x - 1][y - 1] = arg;
    }
    public void setHasHePlayed(boolean hasHePlayed) {
        this.hasHePlayed = hasHePlayed;
    }
}
