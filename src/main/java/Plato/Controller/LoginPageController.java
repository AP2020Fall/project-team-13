package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Player;
import Plato.Model.User;

public class LoginPageController {
    private static LoginPageController loginPageController = new LoginPageController();
    public static User user;
    static boolean isMainAdminRegistered;

    public static LoginPageController getInstance() {
        return loginPageController;
    }

    private void registerController(){
         Player.registerModel();
     }
     public static User login(){
        user = User.login(null,null);
         return null;
     }
}
