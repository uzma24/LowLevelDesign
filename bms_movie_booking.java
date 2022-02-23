//base class
class BMSService{
    List<CinemaHalls> cinemas;
    
    public List<Movie> getMovies(String city, Date date);
    public List<CinemaHalls> getCinemaHalls(String city);
}

class cinemaHall{
    int cinemaHallId;
    String cinemaHallName;
    Address address;

    List<Audi> audiList;

    public Map<Date, Movie> getMovies(List<Date> dateList);
    public Map<Date, Show> getShows(List<Date> dateList);
} 

class Addres{

}

class Audi{
    int audiId;
    String audiName;
    int totalSeats;

    List<Show> shows;
}

class Show{
    int showId;
    Movie movie;
    Date startTime;
    Date endTime;
    CinemaHall cinemaPlayedAt;
    List<Seat> seats; //even though list of seats are part of audi, but price of show is dependant on seats available, hence it shd be part of show directly
}

class Seats{
    int seatId;
    SeatType seatType;
    SeatStatus seatStatus;
    Double price;
}

public enum seatType{
    DELUX, VIP, ECONOMY, OTHER;
}

public enum SeatStatus{
    BOOKED,AVAILABLE, RESERVED, NOT_AVAILABLE;
}

class Movie{
    String movieName;
    String movieId;
    int durationInMinutes;
    String language;
    Genre genre;
    Date releseDate;
    Map<String, List<Show>> cityShowMap; //city as key. list of shows as value
}

public enum Genre{
    SCI_FI, ROMCOM;
}

//lets start with actors of system 
//Actors: users,admin
// Users: (1) guestUser-> will be able to search and not book
// (2) registered user-> book and search


class User{
    int userId;
    Search searchObj;
}
class SystemMemebr extends User{
    Account account;
    String name;
    String email;
    Address addres;

}

class Member extends SystemMemebr{
    public Booking makeBooking(Booking booking);
    Public List<Booking> getAllBooking();
}

class Admin extends SystemMemebr{
    public boolean addMovie(Movie movie);
    public boolean addShow(Show show);
}

class Account{
    String userName;
    String password;
}

class Search{
    public List<Movie> searchMovieByName(String name);
    public List<Movie> searchMovieByGenre(String genre);
    public List<Movie> searchMovieByLanguage(String language);
    public List<Movie> searchMovieByDate(Date date);
}