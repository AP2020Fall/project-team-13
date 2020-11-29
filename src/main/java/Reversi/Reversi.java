package Reversi;

import Plato.Model.Player;

public class Reversi {
    private Player black;
    private Player white;
    private Table table;
    public Reversi(Player black, Player white){}
    public boolean canHePlaceDisk(Player player){return true;}
    public boolean canTheyPlaceDisk(){return true;}
    public boolean isTableFull(){return true;}
    public void changeTheDisksColor(int x, int y, int X, int Y){}
    public int getNumberOfBlackDisks(){return 1;}
    public int getNumberOfWhiteDisks(){return 1;}
    public void placeDisk(int x, int y){}
    public Player getBlack() {
        return black;
    }
    public Player getWhite() {
        return white;
    }
    public Table getTable() {
        return table;
    }
}
class Table{
    private String[][] table = new String[8][8];
    private String result;
    private String whoseTurn;
    public Table(){}
    public String getResult() {
        return result;
    }
    public String getWhoseTurn() {
        return whoseTurn;
    }
    public String[][] getTable() {
        return table;
    }
}
