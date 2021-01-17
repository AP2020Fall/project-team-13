package Reversi;

import Plato.Model.Player;
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
public class ReversiGraphicRun extends Application {
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("src/main/java/Reversi/fxml/Reversi.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        ColumnConstraints columnConstraints = new ColumnConstraints(60);
        RowConstraints rowConstraints = new RowConstraints(60);
        for (int i = 0; i < 8; i++)
            ((GridPane) root).getColumnConstraints().add(columnConstraints);
        for (int i = 0; i < 9; i++)
            ((GridPane) root).getRowConstraints().add(rowConstraints);
        primaryStage.setTitle("Reversi");
        primaryStage.setScene(new Scene(root, 480, 600));
        ReversiGraphic.reversiGraphics.get(ReversiGraphic.reversiGraphics.size() - 1).turn.setText(
                ReversiGraphic.game.getTable().getWhoseTurn() + "(" + ReversiGraphic.game.getPlayerByWhoseTurn().getUsername() + ")");
        primaryStage.show();
    }

    public static void main(String[] args){
        Player p1 = new Player();
        Player p2 = new Player();
        p1.setUsername("mehdi");
        p2.setUsername("ali");
        ReversiGraphic.game = new Reversi(p1, p2);
        launch(args);
    }
}
