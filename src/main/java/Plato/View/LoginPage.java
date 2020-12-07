package Plato.View;

import Plato.Controller.LoginPageController;

public class LoginPage extends Page{
    public static LoginPage loginPage = new LoginPage();
    private LoginPageController loginPageController = LoginPageController.getInstance();
    private boolean isMainAdminRegistered;
    public static Page getInstance() {
        return loginPage;
    }

    public Page run() {
        LoginPageController.login();
        return null;
    }
    private void register(String username , String password){

    }
    private Page login(String username){
        return null;
    }

}
