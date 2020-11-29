package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Player;
import Plato.Model.User;

public class LoginPageController {
    static boolean isMainAdminRegistered;
     private void registerController(){
         Player.registerModel();
     }
     public static User login(){
         User user = User.login(null,null);
         return null;
     }
}
