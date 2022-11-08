import Booking.Booking;
import Login.UserLogin;
import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String username;

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String password;
    private boolean change;
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String name;
    private String phoneNo;
    private ArrayList<Booking> bookings;
    public User(UserLogin obj){
        this.username = obj.getUsername();
        fillDetails();
    }

    public void changeName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new name: ");
        String newName = sc.next();
        this.setName(newName);
    }

    public void changePassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new name: ");
        String newPassword = sc.next();
        this.setPassword(newPassword);
    }

    public void fillDetails(){
        try{
            //connection


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
