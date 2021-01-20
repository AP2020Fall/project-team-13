package Plato.Graphic;


import Plato.MainGraphical.MainGraphical;
import Plato.Model.Game;
import javafx.event.ActionEvent;
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
