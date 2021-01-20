package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Player;
import Reversi.Reversi;
import Reversi.ReversiGraphic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PlayerGames {

    @FXML
    TextField username ;
    @FXML
    TextField password ;
    @FXML
    Label mes ;

    @FXML
    public void AccountMenu(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAAM);

    }

    @FXML
    public void playRev(ActionEvent event)
    {
        String u = username.getText();
        String p = password.getText();
        Player p1 = (Player) LoginPageController.user;
        Player p2 = null;
        try {
            p2 = LoginPageController.loginSecond(u,p);
            ReversiGraphic.game = new Reversi(p1, p2);
            MainGraphical.scene.setRoot(MainGraphical.rootREV);
        } catch (Exception e) {
            mes.setText("invalid information");
        }



    }

    @FXML
    public void GameMenu(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPG);
    }

    @FXML
    public void PlayerBot(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPB);
    }

    @FXML
    public void GamesHistory(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootGH);
    }

    @FXML
    public void Logout(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.root);
    }

    @FXML
    public void joinevent(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootJE);
    }

    @FXML
    public void friends(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPF);
    }


}
