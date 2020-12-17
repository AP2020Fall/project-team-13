package Plato.View;

import Plato.Controller.LoginPageController;
import Plato.Controller.MainPagePlayerController;
import Plato.Model.*;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;

public class GamesMenu extends Page{
    public static GamesMenu gamesMenu = new GamesMenu();
    private Player player;
    public Page run() throws FileNotFoundException {
    Page.seenPages.add(GamesMenu.gamesMenu);
    System.out.print("choose one:\n" +
            "1. ");
        System.out.println(MainPagePlayerController.getInstance().reversiName());
        System.out.print("2. ");
        System.out.println(MainPagePlayerController.getInstance().battleSeaName());
        System.out.println("back"+
                "\nview account menu"+
                "\nhelp");
        Scanner scanner = new Scanner(System.in);
        String input;
        Matcher matcher;
        while (true) {
            Admin.updateAdmins();
            Player.updatePlayers();
            Game.updateGames();
            Log.updateLogs();
            Event.updateEvents();
            input = scanner.nextLine();
            if (input.equals("1")) {
                return ReversiMenu.reversiMenu;
            }
            else if (input.equals("2")) {
                return BattleSeaMenu.battleSeaMenu;
            }
            else if ((matcher = Commands.BACK.getMatcher(input)).matches())
            {
                return seenPages.get(seenPages.size()-2);
            }
            else if ((matcher = Commands.VIEW_ACCOUNT_MENU.getMatcher(input)).matches())
            {
                return UserPage.userPage;
            }
            else if ((matcher = Commands.HELP.getMatcher(input)).matches())
            {
                System.out.println("choose one:\n" +
                        "1.\n");
                System.out.println(MainPagePlayerController.getInstance().reversiName());
                System.out.println("2.");
                System.out.println(MainPagePlayerController.getInstance().battleSeaName());
                System.out.println("\nback"+
                        "\nview account menu"+
                        "\n help");
            }
            else {
                System.out.println("You should select 1(for reversi) or 2(for battle sea)!");
            }
        }
    }

}
