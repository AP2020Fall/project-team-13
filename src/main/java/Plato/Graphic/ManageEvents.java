package Plato.Graphic;

import Plato.Controller.MainPageAdminController;
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
}
