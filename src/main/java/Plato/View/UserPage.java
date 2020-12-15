package Plato.View;

import Plato.Controller.LoginPageController;
import Plato.Controller.UserPageController;
import Plato.Model.Log;
import Plato.Model.User;

import java.util.ArrayList;
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
                for (Log log : Log.getLogs()) {
                    if(LoginPageController.user.equals(log.getPlayer1()) || LoginPageController.user.equals(log.getPlayer2())){
                        if(log.getWinner() == null)
                            System.out.println("A match between " + log.getPlayer1().getUsername() +
                                    " and " + log.getPlayer2().getUsername() + " has been done and the result was a draw!" + "(" +
                                    log.getFinishTime() + ")");
                        else
                            System.out.println("A match between " + log.getPlayer1().getUsername() +
                                    " and " + log.getPlayer2().getUsername() + " has been done and " + log.getWinner().getUsername() +
                                    " won the match!" + "(" + log.getFinishTime() + ")");
                    }
                }
            }
            else if(Pattern.matches("Game statistics .+", input)){

            }
            else if(input.trim().equals("Logout")){
                return LoginPage.loginPage;
            }
            else if(input.trim().equals("back")){
                return seenPages.get(seenPages.size()-2);
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