package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.Controller.MainPageAdminController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Admin;
import Plato.Model.Player;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.text.Element;
import javax.swing.text.TabableView;
import javax.swing.text.View;

import java.time.LocalDate;
import java.util.*;


public class AdminBot {
    private MainPageAdminController mainPageAdminController = MainPageAdminController.getInstance();

    @FXML
     TextField botNewMessage = new TextField();
    @FXML
    TableView<String> tableOfBotMessages = new TableView<String>();

    @FXML

    public void createNewMessage()
    {
        mainPageAdminController.addbotMessage(botNewMessage.getText());
        LocalDate date = LocalDate.now();
        Admin.mesTime.add(String.valueOf(date));
    }
    @FXML
    public void showBotMessages()
    {
        ObservableList mes = FXCollections.observableArrayList();
        for (int i=0 ; i<Admin.getMessages().size();i++) {
        mes.add(Admin.getMessages().get(i));
            mes.add(Admin.mesTime.get(i));
        }
        tableOfBotMessages.setItems(mes);

    }

    @FXML
    public void AccountMenu(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAAM);
    }

    @FXML
    public void AdminGame(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAG);
    }

    @FXML
    public void ManageEvent(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootME);
    }

    @FXML
    public void AdminBot(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAB);
    }

    @FXML
    public void Logout(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.root);
    }



}
