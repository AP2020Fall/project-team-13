package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Player;
import Plato.Model.User;

import java.util.Date;

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
     public String loginController(String username, String password){

         for (User allUser : User.getAllUsers()) {
             if (allUser.getUsername().equals(username))
             {
                 if (allUser.getPassword().equals(password))
                 {
                     if (allUser.isAdmin())
                     {
                         return "found admin";
                     }
                     else {
                         return "found player";
                     }
                 }
             }
         }
         return "invalid informations";
     }

    public boolean register(String username, String password, String email, String firstanme, String lastname, String phoneNumber) {
        for (User allUser : User.getAllUsers()) {
            if ((allUser.getUsername().equals(username))||(allUser.getEmail().equals(email)))
            {
                return false;
            }
        }
        if (User.isIsMainAdminJoinnt())
        {
            Date date = new Date();
            Player player = new Player();
            player.setUsername(username);
            player.setUserID(User.getAllUsers().size()+1);
            player.setFirstname(firstanme);
            player.setLastname(lastname);
            player.setPhoneNumber(phoneNumber);
            player.setPassword(password);
            player.setEmail(email);
            player.setAdmin(false);

        }
        else  {
            Date date = new Date();
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setUserID(User.getAllUsers().size()+1);
            admin.setFirstname(firstanme);
            admin.setLastname(lastname);
            admin.setPhoneNumber(phoneNumber);
            admin.setPassword(password);
            admin.setEmail(email);
            admin.setAdmin(true);
        }
        return true;
    }
    public static Player  loginSecond(String username , String password) throws Exception
    {
        for (Player player : Player.getPlayers()) {
            if (player.getUsername().equals(username))
            {
                if (player.getPassword().equals(password))
                {
                    return player;
                }
            }
        }
        Exception  exeption= new Exception();
        throw exeption;
    }
}
