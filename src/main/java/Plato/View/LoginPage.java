package Plato.View;

import Plato.Controller.LoginPageController;
import Plato.Model.*;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;

public class LoginPage extends Page{
    public static LoginPage loginPage = new LoginPage();
    private static LoginPageController loginPageController = LoginPageController.getInstance();
    public static Page getInstance() {
        return loginPage;
    }

    public Page run() throws FileNotFoundException {
        Matcher matcher;
        String input;
        seenPages.add(LoginPage.loginPage);

        while (true)
        {
            Admin.updateAdmins();
            Player.updatePlayers();
            Game.updateGames();
            Log.updateLogs();
            Event.updateEvents();
            input=scanner.nextLine();
            if ((matcher = Commands.REGISTER.getMatcher(input)).matches())
            {
                System.out.println("enter email");
                String email = scanner.nextLine();
                System.out.println("enter firstname");
                String firstname = scanner.nextLine();
                System.out.println("enter lastname");
                String lastname = scanner.nextLine();
                System.out.println("enter phone number");
                String phoneNumber = scanner.nextLine();
                loginPage.register(matcher.group(1),matcher.group(2),email,firstname,lastname,phoneNumber);

            }
            else if ((matcher = Commands.LOGIN.getMatcher(input)).matches())
            {
                System.out.println("enter password");
                String password = scanner.nextLine();
                Page page =loginPage.login(matcher.group(1),password);
                return page;
            }
            else if ((matcher = Commands.HELP.getMatcher(input)).matches())
            {
                System.out.println("login\nregister\nhelp");
            }
        }

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
