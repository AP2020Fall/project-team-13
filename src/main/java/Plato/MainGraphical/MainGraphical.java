package Plato.MainGraphical;

import Reversi.ReversiGraphic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
    public  static Parent rootREV;



    @Override
    public void start(Stage primaryStage) throws Exception{




        /*String musicFile = "Megatone.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();*/


        stage=primaryStage;
        URL url = new File("src/main/java/Plato/MainGraphical/fxml/sample.fxml").toURI().toURL();
        URL url1 = new File("src/main/java/Plato/MainGraphical/fxml/PlayerMainPage.fxml").toURI().toURL();
        URL url2 = new File("src/main/java/Plato/MainGraphical/fxml/PlayerGAmes.fxml").toURI().toURL();
        URL url3 = new File("src/main/java/Plato/MainGraphical/fxml/PlayerBot.fxml").toURI().toURL();
        URL url4 = new File("src/main/java/Plato/MainGraphical/fxml/ManageEvents.fxml").toURI().toURL();
        URL url5 = new File("src/main/java/Plato/MainGraphical/fxml/GameHistory.fxml").toURI().toURL();
        URL url6 = new File("src/main/java/Plato/MainGraphical/fxml/AdminMainPage.fxml").toURI().toURL();
        URL url7 = new File("src/main/java/Plato/MainGraphical/fxml/AdminGames.fxml").toURI().toURL();
        URL url8 = new File("src/main/java/Plato/MainGraphical/fxml/AdminBot.fxml").toURI().toURL();
        URL url9 = new File("src/main/java/Plato/MainGraphical/fxml/AccountMenu.fxml").toURI().toURL();
        URL url10 = new File("src/main/java/Plato/MainGraphical/fxml/JoinEvent.fxml").toURI().toURL();
        URL url11 = new File("src/main/java/Plato/MainGraphical/fxml/Friends.fxml").toURI().toURL();
        URL url12 = new File("src/main/java/Reversi/fxml/Reversi.fxml").toURI().toURL();


         root = FXMLLoader.load(url);
         rootPM = FXMLLoader.load(url1);
         rootPG = FXMLLoader.load(url2);
         rootPB = FXMLLoader.load(url3);
         rootME = FXMLLoader.load(url4);
         rootGH = FXMLLoader.load(url5);
         rootAM = FXMLLoader.load(url6);
         rootAG = FXMLLoader.load(url7);
         rootAB = FXMLLoader.load(url8);
         rootAAM = FXMLLoader.load(url9);
         rootJE = FXMLLoader.load(url10);
         rootPF = FXMLLoader.load(url11);
         rootREV = FXMLLoader.load(url12);



        ColumnConstraints columnConstraints = new ColumnConstraints(60);
        RowConstraints rowConstraints = new RowConstraints(60);
        for (int i = 0; i < 8; i++)
            ((GridPane) rootREV).getColumnConstraints().add(columnConstraints);
        for (int i = 0; i < 9; i++)
            ((GridPane) rootREV).getRowConstraints().add(rowConstraints);
        ReversiGraphic.reversiGraphics.get(ReversiGraphic.reversiGraphics.size() - 1).turn.setText("black");



        primaryStage.setScene(scene=new Scene(root, 900, 825));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
