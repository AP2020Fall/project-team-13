package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Player;
import Plato.Model.User;

public class UserPageController {
    private static UserPageController userPageController = new UserPageController();

    public static UserPageController getInstance() {
        return userPageController;
    }

    public void changePasswordController(String old, String newPassword){
    LoginPageController.user.editinformation(LoginPageController.user.getUserID(),"password",newPassword);

    }

    public void deleteAccount() {
        User.deleteUserAccount(LoginPageController.user.getUserID());
        if (LoginPageController.user.isAdmin())
        {
            Admin.deleteAdminAccount(LoginPageController.user.getUserID());
        }
        else {
            Player.deletePlayerAccount(LoginPageController.user.getUserID());
        }
    }
}
