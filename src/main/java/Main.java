import Plato.Controller.LoginPageController;
import Plato.Model.*;
import Plato.View.LoginPage;
import Plato.View.Page;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        Page page = LoginPage.getInstance();

        //update and read resourses shoud add in this line

        LoginPageController.addTheGames();

        while (page != null) {
            page = page.run();
        }
    }

    //update everything saved in files
    public static void update() throws FileNotFoundException {
        Admin.updateAdmins();
        Player.updatePlayers();
        Game.updateGames();
        Log.updateLogs();
        Event.updateEvents();
    }
}
