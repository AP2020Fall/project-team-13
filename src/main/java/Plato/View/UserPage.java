package Plato.View;

import Plato.Controller.UserPageController;
import Plato.Model.User;

public class UserPage extends Page{
    public static UserPage userPage = new UserPage();
    private UserPageController userPageController = UserPageController.getInstance();
    public static User user ;
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
    public void setUser(User user){

    }
    public Page ViewAccountMenu(){
    return null;
    }
    private void ViewPersonalInfoView(){

    }
    private  void ChangePasswordView(String old,String new1){

    }
    private void EditView (String field , String new1){

    }
    private void ViewPlatoStaticsView(){

    }
    private void GamesHistoryView(){}
    private void GameStatics(String gameName){
    }
    private Page Logout(){
   return null;
   }
}
