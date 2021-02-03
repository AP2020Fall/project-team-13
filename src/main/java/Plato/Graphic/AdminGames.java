package Plato.Graphic;


import BattleSea.Controller.BattleSea;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Game;
import Plato.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class AdminGames {
    @FXML
    TextArea reversi = new TextArea();
    @FXML
    TextArea battlesea = new TextArea();
    @FXML
    TextArea sugest = new TextArea();
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
    public void showSugest(ActionEvent event)
    {
        String sug = "";
        Player player = Player.getPlayers().get(0);
        for (Game suggestedGame : player.getSuggestedGames()) {
            sug= sug +suggestedGame.getName();
            sug = sug +"\n";
        }
        sugest.setText(sug);
    }
    @FXML
    public void addSea(ActionEvent event)
    {
        boolean isSug=false;
        for (Player player : Player.getPlayers()) {
            for (Game suggestedGame : player.getSuggestedGames()) {
                if (suggestedGame.getName().equals("battle sea"))
                {
                    isSug=true;
                }
            }
            if (!isSug)
            {
                player.getSuggestedGames().add(BattleSea.battleSea);
            }


        }
    }

    @FXML
    public void addRev(ActionEvent event)
    {
        boolean isSug=false;
        for (Player player : Player.getPlayers()) {
            for (Game suggestedGame : player.getSuggestedGames()) {
                if (suggestedGame.getName().equals("reversi"))
                {
                    isSug=true;
                }
            }
            if (!isSug)
            {
                player.getSuggestedGames().add(BattleSea.battleSea);
            }

        }
    }

    @FXML
    public void removeRev(ActionEvent event)
    {
        boolean isSug=false;
        for (Player player : Player.getPlayers()) {
            for (Game suggestedGame : player.getSuggestedGames()) {
                if (suggestedGame.getName().equals("reversi"))
                {
                    isSug=true;
                }
            }
            if (isSug)
            {
                player.getSuggestedGames().remove(BattleSea.battleSea);
            }

        }
    }

    @FXML
    public void removeSea(ActionEvent event)
    {
        boolean isSug=false;
        for (Player player : Player.getPlayers()) {
            for (Game suggestedGame : player.getSuggestedGames()) {
                if (suggestedGame.getName().equals("reversi"))
                {
                    isSug=true;
                }
            }
            if (isSug)
            {
                player.getSuggestedGames().remove(BattleSea.battleSea);
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
