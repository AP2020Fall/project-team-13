package Plato.Controller;

import Plato.Model.Player;

public class MainPagePlayerController {
    private static MainPagePlayerController mainPagePlayerController = new MainPagePlayerController();

    public static MainPagePlayerController getInstance() {
        return mainPagePlayerController;
    }

    public String showPointController(){
        Player player = (Player) LoginPageController.user;
        int score = player.getScore();
        return null;
    }
}
