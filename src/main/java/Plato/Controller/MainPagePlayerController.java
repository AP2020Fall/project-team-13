package Plato.Controller;

import Plato.Model.Player;

public class MainPagePlayerController {

    public String showPointController(){
        Player player = (Player) LoginPageController.user;
        player.getScore();
        return null;
    }
}
