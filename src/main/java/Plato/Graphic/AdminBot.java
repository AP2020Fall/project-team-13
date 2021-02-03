package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.Controller.MainPageAdminController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Admin;
import Plato.Model.Player;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import javax.swing.text.Element;
import javax.swing.text.TabableView;
import javax.swing.text.View;

import java.time.LocalDate;



public class AdminBot {
    private MainPageAdminController mainPageAdminController = MainPageAdminController.getInstance();

    @FXML
     TextField botNewMessage = new TextField();
    @FXML
    TextArea mesBox = new TextArea();


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
        String mes="";
        for (int i=0 ; i<Admin.getMessages().size();i++) {
        mes=mes+Admin.getMessages().get(i);
        mes = mes + "   ";
            mes = mes+Admin.mesTime.get(i);
            mes = mes + "\n \n";
        }

        mesBox.setText(mes);

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
