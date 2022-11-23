package TicketBooking;

public class TicketBookingDetails {
    private String  movieName,theatre, time, location;
    private int screen;
    private int noOfTickets;

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void printBookingDetails(){
        System.out.println("Location          : " + getLocation().toUpperCase());
        System.out.println("Movie Name        : " + getMovieName().toUpperCase());
        System.out.println("Theatre Name      : " + getTheatre().toUpperCase());
        System.out.println("Screen            : " + getScreen());
        System.out.println("Time Slot         : " + getTime().toUpperCase());
        System.out.println("Number of tickets : " +  getNoOfTickets());
    }
}
