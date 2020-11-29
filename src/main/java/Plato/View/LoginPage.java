package Plato.View;

import Plato.Controller.LoginPageController;

public class LoginPage extends Page{
    LoginPageController loginPageController;
    Page run() {
        LoginPageController.login();
        return null;
    }
}
