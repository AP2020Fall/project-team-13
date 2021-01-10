package Plato.View;

import Plato.Controller.LoginPageController;
import Plato.Model.*;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserPage extends Page{
    public static UserPage userPage = new UserPage();
    public static User user ;
    public static UserPage getInstance(){
        return userPage;
    }
    public Page run() throws FileNotFoundException {
        String input;
        Scanner scanner = new Scanner(System.in);
        seenPages.add(UserPage.userPage);
        System.out.println("User page :");
        while(true){
            Admin.updateAdmins();
            Player.updatePlayers();
            Game.updateGames();
            Log.updateLogs();
            Event.updateEvents();
            input = scanner.nextLine();
            if(input.trim().equals("View personal info")){
                System.out.println("firstname: " + LoginPageController.user.getFirstname() +
                        "\nlastname: " + LoginPageController.user.getLastname() +
                        "\nusername: " + LoginPageController.user.getUsername() +
                        "\nemail: " + LoginPageController.user.getEmail() +
                        "\nphone number: " + LoginPageController.user.getPhoneNumber());
            }
            else if(Pattern.matches("Change password .+ .+", input)){
                String oldPass = input.split(" ")[2];
                String newPass = input.split(" ")[3];
                if(!oldPass.equals(((Player)LoginPageController.user).getPassword()))
                    System.out.println("the old password isn't true!");
                else{
                    ((Player)LoginPageController.user).setPassword(newPass);
                    System.out.println("The password successfully changed!");
                }
            }
            else if(Pattern.matches("Edit .+ .+", input)){
                if(input.split(" ")[1].equals("firstname") || input.split(" ")[1].equals("lastname") ||
                        input.split(" ")[1].equals("username") || input.split(" ")[1].equals("email") ||
                        input.split(" ")[1].equals("phoneNumber")) {
                    LoginPageController.user.editInformation(input.split(" ")[1], input.split(" ")[2]);
                }
                else
                    System.out.println("You should enter firstname, lastname, username, email, phoneNumber as field!");
            }
            else if(input.equals("View plato statistics")){
                System.out.println("you have " + ((Player)LoginPageController.user).getFriends().size() + " friend(s)!\n" +
                        "you have won " + ((Player)LoginPageController.user).getReversiWins() + " time(s) in reversi and " +
                        ((Player)LoginPageController.user).getBattleSeaWins() + " time(s) in battle sea!\n" +
                        "it is " + ((Player)LoginPageController.user).getDaysPassedRegister() + " day(s) that you have registered!");
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
                if(input.split(" ")[2].equals("battleSea") || input.split(" ")[2].equals("reversi")){
                    if(input.split(" ")[2].equals("battleSea"))
                        System.out.println("level: " + ((Player)LoginPageController.user).getBattleSeaLevel() +
                                "\ngames: " + ((Player)LoginPageController.user).getBattleSeaPlayedCount() +
                                "\nwins: " + ((Player)LoginPageController.user).getBattleSeaWins() +
                                "\ndraws: " + ((Player)LoginPageController.user).getBattleSeaDraws() +
                                "\nlosses: " + ((Player)LoginPageController.user).getBattleSeaLosses());
                    else if(input.split(" ")[2].equals("reversi")){
                        System.out.println("level: " + ((Player)LoginPageController.user).getReversiLevel() +
                                "\ngames: " + ((Player)LoginPageController.user).getReversiPlayedCount() +
                                "\nwins: " + ((Player)LoginPageController.user).getReversiWins() +
                                "\ndraws: " + ((Player)LoginPageController.user).getReversiDraws() +
                                "\nlosses: " + ((Player)LoginPageController.user).getReversiLosses());
                    }
                }
                else{
                    System.out.println("You should enter battleSea or reversi as game name!");
                }
            }
            else if(input.trim().equals("Logout")){
                return LoginPage.loginPage;
            }
            else if(input.trim().equals("back")){
                return seenPages.get(seenPages.size()-2);
            }
            else if(input.equals("help")){
                System.out.println("1. View personal info\n" +
                        "2. Change password [current_password] [new_password]\n" +
                        "3. Edit [field(firstname, lastname, username, email, phoneNumber)] [new_value]\n" +
                        "4. View plato statistics\n" +
                        "5. Game history\n" +
                        "6. Game statistics [game_name(battleSea, reversi)]\n" +
                        "7. Logout\n" +
                        "8. back\n" +
                        "9. help");
            }
        }
    }
}