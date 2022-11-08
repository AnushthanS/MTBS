package Test;
import Login.UserLogin;
import UserFiles.User;

public class TestUser {
    public static void main(String[] args) {
        UserLogin login = new UserLogin();
        login.inputPrompt();
        if(login.getAccess()) {
            User user = new User(login);
            user.printDetails();
        } else System.out.println("No such user");
    }
}
