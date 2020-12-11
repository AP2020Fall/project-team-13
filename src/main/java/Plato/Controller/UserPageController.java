package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Player;
import Plato.Model.User;
import Plato.View.Page;

public class UserPageController extends Page {
    public static User user;
    private static UserPageController userPageController = new UserPageController();

    public static UserPageController getInstance() {
        return userPageController;
    }
    public void changePasswordController(String old, String newPassword){
        if(LoginPageController.user.getPassword() != old)
            System.out.println("the old password isn't true!");
        else
            LoginPageController.user.editInformation(LoginPageController.user.getUserID(),"password",newPassword);
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
    public void setUserController(User user) {

    }
    public String ViewAccountMenuController(){
        return null;
    }
    private String ViewPersonalInfoViewController(){
        return null;
    }
    private void ChangePasswordViewController(String old,String new1){

    }
    private void EditViewController(String field ,String new1){

    }
    private String ViewPlatoStatisticsViewController(){
        return null;
    }
    private String GamesHistoryViewController(){
        return null;
    }
    private String GameStatisticsController(String gameName){
       return null;
    }
    private Page LogoutController(){
        return null;
    }
    public Page run() {
        return null;
    }
}
