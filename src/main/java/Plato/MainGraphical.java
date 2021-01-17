package Plato;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
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



    @Override
    public void start(Stage primaryStage) throws Exception{
        String musicFile = "Megatone.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();


        stage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Plato.Graphic.sample.fxml"));
        Parent rootPM = FXMLLoader.load(getClass().getResource("Plato.Graphic.PlayerMainPage.fxml"));
        Parent rootPG = FXMLLoader.load(getClass().getResource("Plato.Graphic.PlayerGAmes.fxml"));
        Parent rootPB = FXMLLoader.load(getClass().getResource("Plato.Graphic.PlayerBot.fxml"));
        Parent rootME = FXMLLoader.load(getClass().getResource("Plato.Graphic.ManageEvents.fxml"));
        Parent rootGH = FXMLLoader.load(getClass().getResource("Plato.Graphic.GameHistory.fxml"));
        Parent rootAM = FXMLLoader.load(getClass().getResource("Plato.Graphic.AdminMainPage.fxml"));
        Parent rootAG = FXMLLoader.load(getClass().getResource("Plato.Graphic.AdminGames.fxml"));
        Parent rootAB = FXMLLoader.load(getClass().getResource("Plato.Graphic.AdminBot.fxml"));
        Parent rootAMM = FXMLLoader.load(getClass().getResource("Plato.Graphic.AccountMenu.fxml"));

        primaryStage.setScene(scene=new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
