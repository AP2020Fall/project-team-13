package Reversi;

import Plato.Model.Player;

public class ReversiController {
    public Reversi model;
    public ReversiView view;
    public ReversiController(Reversi model, Reversi view){}
    public void showWhereToPut(){}
    public void showWhoseTurnIsIt(){}
    public void showResult(){}
    public void showScore(){}
    public void showGrid(){}
    public void showDisks(){}
    public void changeTurn(){}
    public boolean canHePlaceDisk(){return true;}
    public boolean canTheyPlaceDisk(){return true;}
    public boolean doesItObserveTheTableLimit(int x, int y){return true;}
    public boolean isTableFull(){return true;}
    public void changeTheDisksColor(int x, int y, int X, int Y){}
    public int getNumberOfBlackDisks(){return 1;}
    public int getNumberOfWhiteDisks(){return 1;}
    public void placeDisk(int x, int y){}
}
