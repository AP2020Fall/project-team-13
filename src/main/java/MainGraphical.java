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









    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("src/main/java/Plato/Graphic/sample.fxml").toURI().toURL();
        stage=primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("Plato.Graphic.sample.fxml"));
        //Parent root1 = FXMLLoader.load(getClass().getResource("Plato.Graphic.AdminBot.fxml"));
        //root=root1;
        Parent root = FXMLLoader.load(url);
        primaryStage.setScene(scene=new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
