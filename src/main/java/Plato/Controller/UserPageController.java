package Plato.Controller;

public class UserPageController {
    private static UserPageController userPageController = new UserPageController();

    public static UserPageController getInstance() {
        return userPageController;
    }

    public void changePasswordController(String old, String newPassword){
    LoginPageController.user.editinformation(LoginPageController.user.getUserID(),"password",newPassword);

    }
}
