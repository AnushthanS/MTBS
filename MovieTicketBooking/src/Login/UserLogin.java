package Login;

import java.sql.*;
import java.util.Scanner;

public class UserLogin implements LoginInterface{
    private String username;
    private String password;

    private String getUsername() {
        return this.username;
    }

    private String getPassword() {
        return this.password;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void inputPrompt(){
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        setUsername(scanner.next());

        System.out.print("Enter password: ");
        setPassword(scanner.next());
        authentication();
    }

    @Override
    public void authentication() {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
