package Plato.View;

import Plato.Controller.UserPageController;

public class UserPage extends Page{
    private static UserPage userPage = new UserPage();
    private UserPageController userPageController = UserPageController.getInstance();
    public static UserPage getInstance(){
        return userPage;
    }
    public Page run() {
        userPageController.changePasswordController(null,null);
        return null;
    }

    private void deleteAccount(){
        userPageController.deleteAccount();
    }
}
