package Login;

import java.sql.*;
import java.util.Scanner;
public class UserRegister implements RegisterInterface{

    private String username;
    private String password;
    private String name;
    private String phoneNo;
    public String getUsername() {
        return username;
    }
    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    private void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public void inputPrompt(){
        System.out.print("Enter your Name: ");
        Scanner scanner = new Scanner(System.in);
        setName(scanner.next());

        System.out.print("Enter username/email: ");
        setUsername(scanner.next());

        System.out.print("Enter password: ");
        setPassword(scanner.next());

        System.out.print("Enter phoneNo: ");
        setPhoneNo(scanner.next());
    }

    @Override
    public void dataEntry(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "insert into User values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, getName());
            pst.setString(2, getUsername());
            pst.setString(3, getPassword());
            pst.setString(4, getPhoneNo());

            if(pst.executeUpdate() > 0){
                System.out.println("New User Added");
            }
        }catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Username already registered");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
