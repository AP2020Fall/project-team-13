package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.Model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import javax.swing.text.TabableView;
import java.awt.event.ActionEvent;

public class PlayerBot {
    @FXML
    TableView<String> botMessage = new TableView<>();

    public void showmes(javafx.event.ActionEvent event) {
        Player player = (Player) LoginPageController.user;
        ObservableList mes = FXCollections.observableArrayList();
        for (String message : player.getMessages()) {
            mes.add(message);
        }
        botMessage.setItems(mes);
    }
}
