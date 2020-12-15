package Plato.View;

import Plato.Controller.UserPageController;
import Plato.Model.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserPage extends Page{
    public static UserPage userPage = new UserPage();
    private UserPageController userPageController = UserPageController.getInstance();
    public static User user ;
    public static UserPage getInstance(){
        return userPage;
    }
    public Page run() {
        String input;
        Scanner scanner = new Scanner(System.in);
        while(true){
            input = scanner.nextLine();
            if(input.trim().equals("View personal info")){

            }
            else if(Pattern.matches("Change password .+, .+", input)){

            }
            else if(Pattern.matches("Change password .+, .+", input)){

            }
            else if(Pattern.matches("Edit .+, .+", input)){

            }
            else if(input.equals("View plato statistics")){

            }
            else if(input.trim().equals("Games history")){

            }
            else if(Pattern.matches("Game statistics .+", input)){

            }
            else if(input.trim().equals("Logout")){

            }
            else if(input.trim().equals("back")){

            }
        }
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
    private void GamesHistoryView(){

    }
    private void GameStatics(String gameName){

    }
    private Page Logout(){
   return null;
   }
}