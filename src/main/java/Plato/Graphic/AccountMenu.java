package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.Model.Admin;
import Plato.Model.Player;
import Plato.Model.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;


public class AccountMenu {
    @FXML
    TextField nvalue = new TextField();
    @FXML
    ChoiceBox box = new ChoiceBox(FXCollections.observableArrayList("firstname", "lastname", "email","password","phone number"));


@FXML
    public void mainPage(javafx.event.ActionEvent event) {
        if (LoginPageController.user.isAdmin())
        {

        }
        else {

        }
    }

    @FXML
    public void edit(javafx.event.ActionEvent event)
    {
        String neValue = nvalue.getText();


    }
    @FXML public void delete(javafx.event.ActionEvent event)
    {
        boolean isDone=false;
        if (LoginPageController.user.isAdmin())
        {
            Admin admin = (Admin) LoginPageController.user;
            for (Admin admin1 : Admin.getAdmins()) {
                if (admin1.equals(admin))
                {
                    Admin.getAdmins().remove(admin);
                    User.getAllUsers().remove(LoginPageController.user);
                    isDone=true;
                }
            }
        }
        else {
            Player player = (Player) LoginPageController.user;
            for (Player player1 : Player.getPlayers()) {
                if (player1.equals(player))
                {
                    Player.getPlayers().remove(player);
                    User.getAllUsers().remove(LoginPageController.user);
                    isDone=true;
                }
            }
        }


    }
}
