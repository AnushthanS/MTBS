package Core;

import Login.UserLogin;
import UserFiles.User;
import UserFiles.UserChange;

import java.util.Scanner;

public class MovieTicketBookingSystem {
    private static void printHelpDesk(){
        System.out.println("Movie Ticket Booking CLI helpdesk!");
        System.out.println("-l or --list are used to list stuff, can be substituted");
        System.out.println("-l -m will list all the movies available to book, -l -m [movie_name] will list any locations with the matching movie running on some shows");
        System.out.println("-l -t will list the location and theatre information");
        System.out.println("-l -b -u [username] will give the booking details for the user");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(args.length >= 1){
            if(args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("--help")){
                printHelpDesk();
            } else if(args[0].equalsIgnoreCase("-l") || args[0].equalsIgnoreCase("--list")){
                System.out.println("working");
                switch (args.length){
                    case 1->{
                        System.out.println("Invalid use of the argument!");
                        printHelpDesk();
                    }
                    case 2->{

                    }
                    case 3->{

                    }
                    case 4->{}
                    default -> {}
                }
            }
        } else {
            UserLogin userLogin = new UserLogin();
            userLogin.inputPrompt();
            userLogin.authentication();

            if(userLogin.getAccess()){
                System.out.println("Successfully logged in!");
                User user = new User(userLogin);
                menu:
                while (true){
                    System.out.println("Enter 1 to view account details");
                    System.out.println("Enter 2 to modify account details");
                    System.out.println("Enter 3 to book tickets");
                    System.out.println("Enter 4 to view booked tickets");
                    System.out.println("Enter 5 to exit\n");
                    int choice = scanner.nextInt();
                    switch (choice){
                        case 1->{
                            user.printDetails();
                        }
                        case 2->{
                            UserChange userChange = new UserChange(user);
                            System.out.println("Have to fill this later");
                            break menu;
                        }
                        case 3->{

                        }
                        case 4->{
                            user.checkBookings();
                        }
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