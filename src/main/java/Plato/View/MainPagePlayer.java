package Plato.View;

import Plato.Controller.MainPagePlayerController;

public class MainPagePlayer extends Page{
    public static MainPagePlayer mainPagePlayer = new MainPagePlayer();
    private MainPagePlayerController mainPagePlayerController = MainPagePlayerController.getInstance();
    public Page run() {
        mainPagePlayerController.showPointController();
        return null;
    }
    private void showPoints(){
        String point;
        point=mainPagePlayerController.showPointController();
        System.out.println(point);

    }
    private void viewFavoriteGames(){
        String favorites;
        favorites=mainPagePlayerController.viewFavoriteGames();
        System.out.println(favorites);
    }
    private void platobotMessages(){
        String messages;
        messages=mainPagePlayerController.platobotMessages();
        System.out.println(messages);
    }

}
