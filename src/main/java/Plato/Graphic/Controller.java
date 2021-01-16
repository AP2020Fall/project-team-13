package Plato.Graphic;

import Plato.Controller.LoginPageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
     Label message =new Label();
    @FXML
     TextField fusername ;
    @FXML
     TextField femail ;
    @FXML
     TextField ffname ;
    @FXML
     TextField flname;
    @FXML
     TextField fpnumber ;
    @FXML
     PasswordField fpassword;




    @FXML
    public void register(ActionEvent event) {
        boolean result = LoginPageController.loginPageController.register(fusername.getText(),fpassword.getText(),femail.getText(),ffname.getText(),flname.getText(),fpnumber.getText());
        if (!result)
        {
            message.setText("username is used");
            message.setVisible(true);

        }
        else {
            message.setText("you are succesfully registered");
            message.setVisible(true);
        }
    }

    @FXML
    public void login(ActionEvent event) {
        String result = LoginPageController.loginPageController.loginController(fusername.getText(),fpassword.getText());
        if (result.equalsIgnoreCase("invalid information"))
        {
            message.setText("invalid information");
            message.setVisible(true);

        }
        else if (result.equalsIgnoreCase("found admin")){

        }
        else if (result.equalsIgnoreCase("found player"))
        {

        }
    }
}
