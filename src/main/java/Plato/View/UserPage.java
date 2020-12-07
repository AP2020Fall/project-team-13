package Plato.View;

import Plato.Controller.UserPageController;
import Plato.Model.User;

public class UserPage extends Page{
    private static UserPage userPage = new UserPage();
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
    private void ViewPersonallnfoView(){

    }
    private  void ChangePasswordView(String old,String new1){

    }
    private void EditView (String field , String new1){

    }
    private void ViewPlatoStisticsView(){

    }
    private void GamesHistoryView(){}
   private void GameStatisitics(String gameName){
   }
   private Page Logout(){
   return null;
   }
}
