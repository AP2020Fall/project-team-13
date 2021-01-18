package Plato.Graphic;

import Plato.Controller.LoginPageController;
import Plato.MainGraphical.MainGraphical;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Controller {
    @FXML
    Button close = new Button();
    @FXML
     Label message =new Label();
    @FXML
    Label error = new Label();
    @FXML
    DialogPane berror = new DialogPane();
    @FXML
     TextField fusername = new TextField() ;
    @FXML
     TextField femail = new TextField();
    @FXML
     TextField ffname = new TextField();
    @FXML
     TextField flname = new TextField();
    @FXML
     TextField fpnumber = new TextField();
    @FXML
     PasswordField fpassword = new PasswordField();




    @FXML
    public void register(ActionEvent event) {
        boolean result = LoginPageController.loginPageController.register(fusername.getText(),fpassword.getText(),femail.getText(),ffname.getText(),flname.getText(),fpnumber.getText());
        if (!result)
        {
            berror.setVisible(true);
            error.setText("username is used");
            error.setVisible(true);
            close.setVisible(true);

        }
        else {
            message.setText("you are succesfully registered");
            message.setVisible(true);
        }
        String musicFile = "Megatone.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    @FXML
    public void login(ActionEvent event) {
        String result = LoginPageController.loginPageController.loginController(fusername.getText(),fpassword.getText());
        if (result.equalsIgnoreCase("invalid information"))
        {
            berror.setVisible(true);
            error.setText("invalid information");
            error.setVisible(true);
            close.setVisible(true);

        }
        else if (result.equalsIgnoreCase("found admin")){
            MainGraphical.scene.setRoot(MainGraphical.rootAM);
        }
        else if (result.equalsIgnoreCase("found player"))
        {
            MainGraphical.scene.setRoot(MainGraphical.rootPM);
        }
    }
    @FXML
    public void setClose(ActionEvent event)
    {
        berror.setVisible(false);
        error.setVisible(false);
        close.setVisible(false);
    }
}
