package Plato.Graphic;

import Plato.Model.Log;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import javax.swing.text.TabExpander;
import javax.swing.text.TabableView;
import javax.swing.text.TableView;
import java.awt.event.ActionEvent;

public class GameHistory {
    @FXML
    TextArea his = new TextArea();

    @FXML
    public void setHis(javafx.event.ActionEvent event)
    {
        String ss = "";
        for (Log log : Log.getLogs()) {
            ss=ss+log.getGameID();
            ss=ss+"   ";
            ss=ss+log.getPlayer1();
            ss=ss+"   ";
            ss=ss+log.getPlayer2();
            ss=ss+"   ";
            ss=ss+log.getWinner();
            ss=ss+"   ";
            ss=ss+log.getFinishTime();
            ss=ss+"\n";
        }
    }


}
