import Plato.Controller.LoginPageController;
import Plato.Model.Game;
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
}
