package Core;

import AdminFiles.Admin;
import Login.AdminLogin;
import Login.UserLogin;
import Login.UserRegister;
import TicketBooking.TicketBooking;
import UserFiles.User;
import UserFiles.UserChange;

import java.sql.*;
import java.util.Scanner;

public class MovieTicketBookingSystem {
    private static void printHelpDesk(){
        System.out.println("Movie Ticket Booking CLI helpdesk!");
        System.out.println("-l or --list are used to list stuff, can be substituted");
        System.out.println("-l -m will list all the movies available to book, -l -m [movie_name] will list any locations with the matching movie running on some shows");
        System.out.println("-l -t will list the location and theatre information");
        System.out.println("-l -b -u [username] will give the booking details for the user");
    }
    private static void printAdminFunctions(){
        System.out.println("-a -p to enter a menu style database printing function");
        System.out.println("-a -m to enter a menu style database modifying function");
    }
    public static void main(String[] args) {
        DataImport dataImport = new DataImport();
        dataImport.refresh();
        Scanner scanner = new Scanner(System.in);
        if(args.length >= 1){
            if(args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("--help")){
                printHelpDesk();
            } else if(args[0].equalsIgnoreCase("-l") || args[0].equalsIgnoreCase("--list")){
                switch (args.length){
                    case 1->{
                        System.out.println("Invalid use of the argument!");
                        printHelpDesk();
                    }
                    case 2->{
                        if(args[1].equals("-m")){
                            try{
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
                                String query = "select distinct movie_name from movieInfo;";
                                Statement st = con.createStatement();
                                ResultSet rs = st.executeQuery(query);
                                System.out.println("Movies:\n");
                                while(rs.next()){
                                    System.out.println(rs.getString("movie_name"));
                                }
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        } else if(args[1].equals("-t")){
                            try{
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
                                String query = "select * from theatreInfo;";
                                PreparedStatement pst = con.prepareStatement(query);
                                ResultSet rs = pst.executeQuery();
                                while(rs.next()){
                                    System.out.println("Location          : "+rs.getString("location"));
                                    System.out.println("Theatre           : "+rs.getString("theatre"));
                                    System.out.println("Screen            : "+rs.getString("screen"));
                                    System.out.println("Number of tickets : "+rs.getString("no_of_tickets"));
                                    System.out.println();
                                }
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        } else System.out.println("Invalid argument");
                    }
                    case 3->{
                        if(args[1].equalsIgnoreCase("-m")){
                            try{
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
                                String query = "select distinct movie_id from movieInfo where movie_name like '%"+args[2]+"%';";
                                PreparedStatement pst = con.prepareStatement(query);
                                ResultSet rs = pst.executeQuery();

                                int movieId;
                                if(rs.next()){
                                    movieId = rs.getInt("movie_id");
                                    query = "select distinct theatre_id from showInfo where movie_id = "+movieId+";";
                                    pst = con.prepareStatement(query);
                                    rs = pst.executeQuery();
                                    while (rs.next()){
                                        String subquery = "select distinct location, theatre from theatreInfo where theatreId = "+rs.getInt("theatre_id")+";";
                                        PreparedStatement subpst = con.prepareStatement(subquery);
                                        ResultSet subrs = subpst.executeQuery();
                                        while(subrs.next()){
                                            System.out.println("Location          : "+subrs.getString("location"));
                                            System.out.println("Theatre           : "+subrs.getString("theatre"));
                                            System.out.println();
                                        }
                                    }
                                } else System.out.println("No such movie exists in the database");
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                    case 4->{
                        if(args[1].equalsIgnoreCase("-b") && args[2].equalsIgnoreCase("-u")){
                            try {
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
                                String query = "select username from userInfo where username like '%"+args[3]+"%';";
                                PreparedStatement pst = con.prepareStatement(query);
                                ResultSet rs = pst.executeQuery();
                                if(rs.next()){
                                    User tempUser = new User(rs.getString("username"));
                                    tempUser.checkBookings();
                                } else System.out.println("Invalid username");
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        } else System.out.println("Unknown arguments");
                    }
                    default -> {}
                }
            } else if(args[0].equalsIgnoreCase("-a")){
                AdminLogin login;
                Admin admin = new Admin();
                switch (args.length) {
                    case 1 -> printAdminFunctions();
                    case 2 -> {
                        login = new AdminLogin();
                        login.inputPrompt();
                        login.authentication();
                        if (login.getAccess()) {
                            System.out.println("Admin logged in");
                            if (args[1].equalsIgnoreCase("-p")) {
                                menu:
                                while (true) {
                                    System.out.println("Enter 1 to view Admins");
                                    System.out.println("Enter 2 to view Users");
                                    System.out.println("Enter 3 to view Theatres");
                                    System.out.println("Enter 4 to view Movies");
                                    System.out.println("Enter 5 to view show Timings");
                                    System.out.println("Enter 6 to view Bookings");
                                    System.out.println("Enter 7 to exit\n");
                                    int show = scanner.nextInt();
                                    switch (show) {
                                        case 1 -> admin.showAdmins();
                                        case 2 -> admin.showUsers();
                                        case 3 -> admin.showTheatres();
                                        case 4 -> admin.showMovies();
                                        case 5 -> admin.showTimings();
                                        case 6 -> admin.showBookings();
                                        case 7 -> {
                                            break menu;
                                        }
                                        default -> System.out.println("Invalid choice");
                                    }
                                }
                            } else if (args[1].equalsIgnoreCase("-m")) {
                                menu:
                                while (true) {
                                    System.out.println("Enter 1 to change name of user");
                                    System.out.println("Enter 2 to change password of user");
                                    System.out.println("Enter 3 to change phone number of user");
                                    System.out.println("Enter 4 to delete user");
                                    System.out.println("Enter 5 to add movie");
                                    System.out.println("Enter 6 to delete movie");
                                    System.out.println("Enter 7 to delete booking");
                                    System.out.println("Enter 8 to exit\n");
                                    int modify = scanner.nextInt();
                                    switch (modify) {
                                        case 1 -> {
                                            System.out.println("Enter the username of user:");
                                            String userName = scanner.next();
                                            System.out.println("Enter the new/modified name of user:");
                                            String newName = scanner.next();
                                            admin.changeName(userName, newName);
                                        }
                                        case 2 -> {
                                            System.out.println("Enter the username of user:");
                                            String userName = scanner.next();
                                            System.out.println("Enter the new/modified password of user:");
                                            String newPass = scanner.next();
                                            admin.changePassword(userName, newPass);
                                        }
                                        case 3 -> {
                                            System.out.println("Enter the username of user:");
                                            String userName = scanner.next();
                                            System.out.println("Enter the new/modified phone number of user:");
                                            String newPhoneNo = scanner.next();
                                            admin.changePhoneNo(userName, newPhoneNo);
                                        }
                                        case 4 -> {
                                            System.out.println("Enter the username of user to be deleted:");
                                            String userName = scanner.next();
                                            admin.deleteUser(userName);
                                        }
                                        case 5 -> {
                                            System.out.println("Enter the movie ID of the movie to be added:");
                                            String movieID = scanner.next();
                                            System.out.println("Enter the movie name of the movie to be added:");
                                            String movieName = scanner.next();
                                            System.out.println("Enter the rating of the movie to be added:");
                                            String rating = scanner.next();
                                            System.out.println("Enter the genre of the movie to be added:");
                                            String genre = scanner.next();
                                            System.out.println("Enter the language of the movie to be added:");
                                            String language = scanner.next();
                                            System.out.println("Enter the theatre ID of the movie to be added:");
                                            String theatreID = scanner.next();
                                            admin.addMovie(movieID, movieName, rating, genre, language, theatreID);
                                        }
                                        case 6 -> {
                                            System.out.println("Enter the movie ID of movie to be deleted:");
                                            String movieID = scanner.next();
                                            admin.deleteMovie(movieID);
                                        }
                                        case 7 -> {
                                            System.out.println("Enter the username and movie ID of the booking to be deleted:");
                                            String userName = scanner.next();
                                            String movieID = scanner.next();
                                            admin.deleteBooking(userName, movieID);
                                        }
                                        case 8 -> {
                                            break menu;
                                        }
                                        default -> System.out.println("Invalid choice");
                                    }
                                }
                            }
                        } else System.out.println("Invalid login credentials");
                    }
                }
            }
        } else {
            boolean checkNew = false;
            System.out.println("Enter 1 for new user, 2 for existing, anything else to quit");
            int flag = scanner.nextInt();
            if(flag == 1) checkNew = true;
            if(checkNew){
                UserRegister userRegister = new UserRegister();
                userRegister.dataEntry();
            }
            UserLogin userLogin = new UserLogin();
            userLogin.inputPrompt();
            userLogin.authentication();

            if(userLogin.getAccess()){
                System.out.println("Successfully logged in!");
                menu:
                while (true){
                    User user = new User(userLogin);
                    System.out.println("Enter 1 to view account details");
                    System.out.println("Enter 2 to modify account details");
                    System.out.println("Enter 3 to book tickets");
                    System.out.println("Enter 4 to view booked tickets");
                    System.out.println("Enter 5 to exit\n");
                    int choice = scanner.nextInt();
                    switch (choice){
                        case 1-> user.printDetails();
                        case 2->{
                            UserChange userChange = new UserChange(user);
                            System.out.println("Enter 1 to change name");
                            System.out.println("Enter 2 to change password");
                            System.out.println("Enter 3 to change phone number");
                            System.out.println("Enter anything else to exit\n");

                            int change = scanner.nextInt();
                            switch (change){
                                case 1->{
                                    System.out.println("Enter the new name");
                                    String newName = scanner.next();
                                    userChange.changeName(newName);
                                }
                                case 2->{
                                    System.out.println("Enter the new password");
                                    String newPass = scanner.next();
                                    userChange.changePassword(newPass);
                                }
                                case 3->{
                                    System.out.println("Enter the new phone number");
                                    String newPhoneNo = scanner.next();
                                    userChange.changePhoneNo(newPhoneNo);
                                }
                                default -> {}
                            }
                        }
                        case 3->{
                            TicketBooking booking = new TicketBooking(user.getUsername());
                            booking.startBooking();
                        }
                        case 4-> user.checkBookings();
                        case 5->{
                            break menu;
                        }
                        default -> System.out.println("Invalid choice\n");
                    }
                }
            } else System.out.println("Invalid login details!");
        }
    }
}