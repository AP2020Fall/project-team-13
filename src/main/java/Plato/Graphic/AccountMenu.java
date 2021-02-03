package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Admin;
import Plato.Model.Player;
import Plato.Model.User;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class AccountMenu {
    @FXML
    TextField nvalue = new TextField();
    @FXML
    ChoiceBox box = new ChoiceBox(FXCollections.observableArrayList("firstname", "lastname", "email","password","phone number"));
    @FXML
    Label fname = new Label();
    @FXML
    Label lname = new Label();
    @FXML
    Label email = new Label();
    @FXML
    Label pn = new Label();



@FXML
    public void mainPage(javafx.event.ActionEvent event) {
        if (LoginPageController.user.isAdmin())
        {
            MainGraphical.scene.setRoot(MainGraphical.rootAM);
        }
        else {
            MainGraphical.scene.setRoot(MainGraphical.rootPM);

        }
    }

    @FXML
    public void edit(javafx.event.ActionEvent event)
    {
        String neValue = nvalue.getText();
        String field =  box.getValue().toString();
        if (field.equals("firstname"))
        {
            LoginPageController.user.setFirstname(neValue);
        }
        else if (field.equals("lastname"))
        {
            LoginPageController.user.setLastname(neValue);
        }
        else if (field.equals("email"))
        {
            LoginPageController.user.setEmail(neValue);
        }
        else if (field.equals("phone number"))
        {
            LoginPageController.user.setPhoneNumber(neValue);
        }

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

    @FXML
    public void viewPersonal(javafx.event.ActionEvent event)
    {
        fname.setText(LoginPageController.user.getFirstname());
        lname.setText(LoginPageController.user.getLastname());
        email.setText(LoginPageController.user.getEmail());
        pn.setText(LoginPageController.user.getPhoneNumber());
        ObservableList aa = FXCollections.observableArrayList("firstname","lastname","email","phone number");



        box.setItems(aa);



        }
}
