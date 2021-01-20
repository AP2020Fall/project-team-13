package Plato.Graphic;

import Plato.Controller.MainPagePlayerController;
import Plato.MainGraphical.MainGraphical;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

import static Plato.Model.Event.getEvents;

public class JoinEvent {
    public TextArea textArea;
    public TextField eventId;

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

    public void joinEvent(ActionEvent actionEvent) {
        if(Pattern.matches("\\d+",eventId.getText())){
            MainPagePlayerController.getInstance().joinEvent(Integer.parseInt(eventId.getText()));
        }
    }

    @FXML
    public void showEvents(ActionEvent actionEvent){
        String events = "";
        int n = getEvents().size();
        for (int i = 0; i < n; i++) {
            events = events.concat(getEvents().get(i).toString());
            events = events + "\n";
        }
        textArea.setText(events);
    }
}
