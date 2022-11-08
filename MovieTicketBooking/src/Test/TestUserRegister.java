package Test;

import Login.UserRegister;

public class TestUserRegister {
    public static void main(String[] args) {


        UserRegister register = new UserRegister();
        register.inputPrompt();
        register.dataEntry();
    }
}