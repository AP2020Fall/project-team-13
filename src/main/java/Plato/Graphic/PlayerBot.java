package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Admin;
import Plato.Model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerBot {
    @FXML
    TextArea mesBox = new TextArea();
    @FXML
    ImageView image = new ImageView();


    @FXML
    public void AccountMenu(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootAAM);

    }

    @FXML
    public void GameMenu(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPG);
    }

    @FXML
    public void PlayerBot(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPB);
    }

    @FXML
    public void GamesHistory(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootGH);
    }

    @FXML
    public void Logout(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.root);
    }


    public void showmes(ActionEvent event) {
        Player player = (Player) LoginPageController.user;
        String mes = "";
    for (String message : player.getMessages()) {
            mes = mes +message;
            mes = mes + "\n \n";
        }
        for (int i=0 ; i<Admin.getMessages().size();i++) {
            mes=mes+Admin.getMessages().get(i);
            mes = mes + "   ";
            mes = mes+Admin.mesTime.get(i);
            mes = mes + "\n \n";
        }
mesBox.setText(mes);
        image = new ImageView(player.imageUrl);
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
