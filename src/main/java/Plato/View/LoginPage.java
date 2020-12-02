package Plato.View;

import Plato.Controller.LoginPageController;

public class LoginPage extends Page{
    private static LoginPage loginPage = new LoginPage();
    private LoginPageController loginPageController = LoginPageController.getInstance();

    public static Page getInstance() {
        return loginPage;
    }

    public Page run() {
        LoginPageController.login();
        return null;
    }
}
