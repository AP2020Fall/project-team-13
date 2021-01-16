package Plato.Graphic;


import Plato.Model.Game;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AdminGames {
    @FXML
    TextArea reversi = new TextArea();
    @FXML
    TextArea battlesea = new TextArea();
    @FXML
    public void changeReversi()
    {
        for (Game game : Game.getGames()) {
            if (game.getGameID()==1)
            {
                game.setName(reversi.getText());
            }
        }
    }
    @FXML
    public void changeBattleSea()
    {
        for (Game game : Game.getGames()) {
            if (game.getGameID()==2)
            {
                game.setName(battlesea.getText());
            }
        }
    }



}
