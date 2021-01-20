package Plato.MainGraphical;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class MainGraphical extends Application {
    public static Scene scene;
    public  static Stage stage;
    public  static Parent root;
    public  static Parent rootPM;
    public  static Parent rootPB;
    public  static Parent rootPG;
    public  static Parent rootME;
    public  static Parent rootGH;
    public  static Parent rootAM;
    public  static Parent rootAG;
    public  static Parent rootAB;
    public  static Parent rootAAM;
    public  static Parent rootJE;
    public  static Parent rootPF;




    @Override
    public void start(Stage primaryStage) throws Exception{
        /*String musicFile = "Megatone.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();*/


        stage=primaryStage;
        URL url = new File("src/main/java/Plato/MainGraphical/fxml/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        /*Parent root = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));
        Parent rootPM = FXMLLoader.load(getClass().getResource("fxml/PlayerMainPage.fxml"));
        Parent rootPG = FXMLLoader.load(getClass().getResource("fxml/PlayerGAmes.fxml"));
        Parent rootPB = FXMLLoader.load(getClass().getResource("fxml/PlayerBot.fxml"));
        Parent rootME = FXMLLoader.load(getClass().getResource("fxml/ManageEvents.fxml"));
        Parent rootGH = FXMLLoader.load(getClass().getResource("fxml/GameHistory.fxml"));
        Parent rootAM = FXMLLoader.load(getClass().getResource("fxml/AdminMainPage.fxml"));
        Parent rootAG = FXMLLoader.load(getClass().getResource("fxml/AdminGames.fxml"));
        Parent rootAB = FXMLLoader.load(getClass().getResource("fxml/AdminBot.fxml"));
        Parent rootAMM = FXMLLoader.load(getClass().getResource("fxml/AccountMenu.fxml"));
        Parent rootJE = FXMLLoader.load(getClass().getResource("fxml/JoinEvent.fxml"));
        Parent rootPF = FXMLLoader.load(getClass().getResource("fxml/Friends.fxml"));*/

        primaryStage.setScene(scene=new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
