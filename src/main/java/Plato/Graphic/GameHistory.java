package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.Model.Log;
import Plato.Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import javax.swing.text.TabExpander;
import javax.swing.text.TabableView;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameHistory {
    @FXML
    TextArea his = new TextArea();
    @FXML
    Label sw ;
    @FXML
    Label sp ;
    @FXML
    Label sl ;
    @FXML
    Label rw ;
    @FXML
    Label rp ;
    @FXML
    Label rl ;


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
        Player player = (Player) LoginPageController.user;
        rw.setText(String.valueOf(player.getReversiWins()));
        rp.setText(String.valueOf(player.getReversiDraws()));
        rl.setText(String.valueOf(player.getReversiLosses()));
        sw.setText(String.valueOf(player.getBattleSeaWins()));
        sp.setText(String.valueOf(player.getBattleSeaPlayedCount()));
        sl.setText(String.valueOf(player.getBattleSeaLosses()));
    }


}
