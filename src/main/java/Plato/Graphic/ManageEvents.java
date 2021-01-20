package Plato.Graphic;

import Plato.Controller.MainPageAdminController;
import Plato.MainGraphical.MainGraphical;
import Plato.View.MainPageAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class ManageEvents {


    public TextField gameName;
    public TextField endDate;
    public TextField score;
    public TextField startDate;

    public void addEvent(ActionEvent actionEvent) throws Exception {
        if(Pattern.matches("\\d+", score.getText())){
            MainPageAdminController.getInstance().addEvent(gameName.getText(),
                    startDate.getText(), endDate.getText(), Integer.parseInt(score.getText()));
        }
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
