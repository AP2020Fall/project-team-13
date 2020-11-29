package Plato.View;

import Plato.Controller.UserPageController;

public class UserPage extends Page{
    UserPageController userPageController;
    Page run() {
        userPageController.changePasswordController(null,null);
        return null;
    }
}
