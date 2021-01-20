package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class PlayerGraphicalMainPageController {
    @FXML
    Label age = new Label();
    @FXML
    Label friends = new Label();
    @FXML
    Label username = new Label();
    @FXML
    javafx.scene.control.TextArea status = new javafx.scene.control.TextArea();

    @FXML
    public void updateShow(ActionEvent event)
    {
        Player player =(Player)LoginPageController.user;
        age.setText(String.valueOf(player.getDaysPassedRegister()));
        username.setText(player.getUsername());
        friends.setText(String.valueOf(player.getFriends().size()));
        if (status.getText().equals(null))
        {
            status.setText(player.status);
        }
        else {
            player.status=status.getText();
        }
    }

    @FXML
    public void AccountMenu(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAAM);

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
