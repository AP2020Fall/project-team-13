package Plato.Graphic;

import Plato.Controller.FriendsMenuController;
import Plato.Controller.LoginPageController;
import Plato.MainGraphical.MainGraphical;
import Plato.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Friends {

    public javafx.scene.control.TextArea TextArea;
    public TextField username;

    @FXML
    public void joinevent(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootJE);
    }

    @FXML
    public void friends(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPF);
    }

    @FXML
    public void AccountMenu(javafx.event.ActionEvent event) {
        MainGraphical.scene.setRoot(MainGraphical.rootAAM);
    }

    @FXML
    public void GameMenu(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPG);
    }

    @FXML
    public void PlayerBot(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootPB);
    }

    @FXML
    public void GamesHistory(javafx.event.ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.rootGH);
    }

    @FXML
    public void Logout(ActionEvent event)
    {
        MainGraphical.scene.setRoot(MainGraphical.root);
    }

    public void accept(ActionEvent actionEvent) {
        FriendsMenuController.getInstance().acceptFrend(username.getText());
    }

    public void decline(ActionEvent actionEvent) {
        FriendsMenuController.getInstance().declineFriend(username.getText());
    }

    public void search(ActionEvent actionEvent) {
        String user = username.getText();
        int n = ((Player)(LoginPageController.user)).getFriends().size();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(user.equals(((Player)(LoginPageController.user)).getFriends().get(i).getUsername())){
                TextArea.setText(String.valueOf(user.equals(((Player)(LoginPageController.user)).getFriends().get(i).toString())));
                flag = true;
            }
        }
        if(!flag){
            TextArea.setText("not found!");
        }
    }

    public void addFriend(ActionEvent actionEvent) {
        FriendsMenuController.getInstance().addFriend(username.getText());
    }

    public void removeFriend(ActionEvent actionEvent) {
        FriendsMenuController.getInstance().removeFriend(username.getText());
    }

    public void showRequests(ActionEvent actionEvent) {
        TextArea.setText(FriendsMenuController.getInstance().showFriendRequests());
    }
}
