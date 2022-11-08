package Login;

import java.sql.*;
import java.util.Scanner;

public class UserLogin implements LoginInterface{
    private String username;
    private String password;
    private boolean access;

    public boolean getAccess() {
        return access;
    }

    private void setAccess(boolean access) {
        this.access = access;
    }

     public UserLogin(){
        setUsername("");
        setPassword("");
        access = false;
    }

    public String getUsername() {
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
            String query = "select count(*) from user where Username = ? and password = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, getUsername());
            pst.setString(2, getPassword());
            ResultSet rs = pst.executeQuery();
            rs.next();
            setAccess(rs.getString(1).equals("1"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}