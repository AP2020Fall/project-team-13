package Plato.View;

import Plato.Controller.LoginPageController;

public class LoginPage extends Page{
    public static LoginPage loginPage = new LoginPage();
    private static LoginPageController loginPageController = LoginPageController.getInstance();
    public static Page getInstance() {
        return loginPage;
    }

    public Page run() {
        LoginPageController.login();
        return null;
    }
    private void register(String username , String password){

    }
    private Page login(String username,String password){
        String found=loginPageController.loginController(username,password);
        if (found.equals("found player"))
        {
            return MainPagePlayer.mainPagePlayer;
        }
        else if (found.equals("found admin"))
        {
            return MainPageAdmin.mainPageAdmin;
        }
        else {
            System.out.println("invalid informations");
            return LoginPage.loginPage;
        }
    }
    private void register(String username,String password,String email,String firstanme,String lastname,String phoneNumber)
    {
        boolean validInformation = loginPageController.register(username,password,email,firstanme,lastname,phoneNumber);
        if (validInformation)
        {
            System.out.println("account created succesfully");
        }
        else {
            System.out.println("invalid information");
        }
    }

}
