package Test;
import Login.UserLogin;
import UserFiles.User;
import UserFiles.UserChange;

public class TestUser {
    public static void main(String[] args) {
        UserLogin login = new UserLogin();
        login.inputPrompt();
        if(login.getAccess()) {
            User user = new User(login);
            user.printDetails();
            UserChange userChange = new UserChange(user);
            userChange.changeName("Rishabh");
            userChange.changePassword("Jha");
            userChange.changePhoneNo("1122334455");
        } else System.out.println("No such user");
    }
}
