package TicketBooking;

import java.sql.*;
import java.util.*;

public class TicketBooking {
    private final Scanner scanner;
    private boolean bStatus;
    private ArrayList<String> location, timings;
    private String locationChoice, timingChoice;

    public String getTimingChoice() {
        return timingChoice;
    }

    public void setTimingChoice(String timingChoice) {
        this.timingChoice = timingChoice;
    }

    private int movieId;
    private int theatreId;
    private int noOfTickets;
    private TicketBookingDetails bookingDetails;
    private String userName;

    public String getLocationChoice() {
        return locationChoice;
    }

    public void setLocationChoice(String locationChoice) {
        this.locationChoice = locationChoice;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public TicketBooking(String userName){
        location = new ArrayList<>();
        timings = new ArrayList<>();
        bookingDetails = new TicketBookingDetails();
        scanner = new Scanner(System.in);
        bStatus = false;
        this.userName = userName;
    }

    public void checkLocation(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select distinct location from TheatreInfo;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter location number to choose:");
            int i = 0;
            while(rs.next()){
                String loc = rs.getString("Location");
                System.out.println(i + 1+"." + " " + loc);
                location.add(loc);
                i++;
            }
            int choice = scanner.nextInt();
            if(choice > 0 && choice <= location.size()){
                setLocationChoice(location.get(choice - 1));
                bookingDetails.setLocation(getLocationChoice());
                checkMovies();
            } else System.out.println("Invalid location choice");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkMovies(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query = "select distinct movie_id , movie_name from MovieInfo;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter the movie id:");
            System.out.println("MovieID \t Movie Name");
            while (rs.next()){
                String title = rs.getString("movie_name").replace("_", " ");
                int id = rs.getInt("movie_id");
                System.out.println(id + "." + "\t\t\t " + title);
            }

            int choice = scanner.nextInt();
            query = "select movie_id, movie_name from movieInfo where movie_id = "+choice+";";
            st = con.createStatement();
            rs = st.executeQuery(query);

            if(rs.next()){
                setMovieId(choice);
                bookingDetails.setMovieName(rs.getString("movie_name"));
                checkTheatres();
            } else System.out.println("Invalid choice for movie");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkTheatres(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select distinct theatre_id, theatre from TheatreInfo where location like '" + getLocationChoice() + "'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter the theatre number:");
            System.out.println("Theatre number \t Theatre Name");
            while (rs.next()){
                String title = rs.getString("theatre").replace("_", " ");
                int id = rs.getInt("theatre_id");
                System.out.println(id + "." + "\t\t\t " + title);
            }
            int choice = scanner.nextInt();
            query = "select theatre_id, theatre, screen from theatreInfo where theatre_id = "+choice+";";
            st = con.createStatement();
            rs = st.executeQuery(query);

            if(rs.next()){
                setTheatreId(choice);
                bookingDetails.setTheatre(rs.getString("theatre"));
                bookingDetails.setScreen(rs.getInt("screen"));
                checkTimeSlots();
            } else System.out.println("Invalid choice for theatre");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkTimeSlots(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select time from showInfo where movie_id = '"+getMovieId()+"' and theatre_id = '"+getTheatreId()+"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Select a time slot to book tickets for:");
            int i = 0;
            while(rs.next()){
                String timeSlot = rs.getString("time");
                System.out.println(i + 1+"." + " " + timeSlot);
                timings.add(timeSlot);
                i++;
            }
            int choice = scanner.nextInt();
            if(choice > 0 && choice <= timings.size()){
                setTimingChoice(timings.get(choice - 1));
                bookingDetails.setTime(getTimingChoice());
                selectNoOfTickets();
            } else System.out.println("Invalid time choice");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectNoOfTickets(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "Update theatreInfo set No_of_Tickets = No_of_Tickets - ? where theatre_id like ? && screen like ? ;";

            System.out.println("Enter the number of tickets to book:");
            int choice = scanner.nextInt();

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, choice);
            pst.setInt(2, getTheatreId());
            pst.setInt(3, bookingDetails.getScreen());
            setNoOfTickets(choice);
            pst.executeUpdate();
            bookingDetails.setNoOfTickets(getNoOfTickets());
            this.bStatus = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startBooking(){
        checkLocation();
        if(bStatus) {
            bookingDetails.printBookingDetails();
            addBooking();
        }
    }

    public void addBooking(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "insert into BookingInfo value(? , ? , ? , ?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1 , userName);
            pst.setString(2, getTimingChoice());
            pst.setInt(3 , getMovieId());
            pst.setInt(4 , getTheatreId());

            pst.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
