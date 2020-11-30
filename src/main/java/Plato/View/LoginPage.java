package Plato.View;

import Plato.Controller.LoginPageController;

public class LoginPage extends Page{
    LoginPageController loginPageController;
    protected Page run() {
        LoginPageController.login();
        return null;
    }
}
