package UserFiles;

import Login.UserLogin;

import java.sql.*;

public class User {
    private String username;
    private String password;
    private String name;
    private String phoneNo;

    public User(UserLogin obj){
        this.username = obj.getUsername();
        fillDetails();
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
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

    private String getPhoneNo() {
        return phoneNo;
    }

    private void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
    }
    public void fillDetails(){
        try{
            Connection con = getConnection();
            String query = "select * from User where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, getUsername());
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                setName(resultSet.getString("Name"));
                setPhoneNo(resultSet.getString("phone_number"));
                setPassword(resultSet.getString("password"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void printDetails(){
        System.out.println("Name     : "+getName());
        System.out.println("Username : "+getUsername());
        System.out.println("Phone    : "+getPhoneNo());
    }
}
