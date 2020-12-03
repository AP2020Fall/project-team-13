package Reversi;

import Plato.Model.Game;
import Plato.Model.Player;

public class ReversiController extends Game {
    public Reversi model;
    public ReversiView view;
    public ReversiController(Reversi model, ReversiView view){
        this.model = model;
        this.view = view;
    }
    public void showWhereToPut(){
        view.showWhereToPut(model.getTable());
    }
    public void showWhoseTurnIsIt(){
        view.showWhoseTurnIsIt(model.getTable());
    }
    public void showResult(){
        view.showResult(model.getTable());
    }
    public void showScore(){
        view.showScore(model.getBlack(), model.getWhite());
    }
    public void showGrid(){
        view.showGrid();
    }
    public void showDisks(){
        view.showDisks(model.getTable());
    }
    public void placeDisk(int x, int y){
        model.placeDisk(x, y);
    }
    public void changeTurn(){
        model.changeTurn();
    }
}
