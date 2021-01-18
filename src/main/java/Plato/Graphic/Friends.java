package Plato.Graphic;

import Plato.MainGraphical;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Friends {

    public javafx.scene.control.TextArea TextArea;
    public TextField username;

    @FXML
    public void joinevent(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootJE);
    }

    @FXML
    public void friends(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPF);
    }

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

    public void accept(ActionEvent actionEvent) {
    }

    public void decline(ActionEvent actionEvent) {
    }

    public void search(ActionEvent actionEvent) {
    }

    public void addFriend(ActionEvent actionEvent) {
    }

    public void removeFriend(ActionEvent actionEvent) {
    }

    public void showRequests(ActionEvent actionEvent) {
    }
}
