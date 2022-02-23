//base class

//always try to decouple two classes so that updating one class oesnt have other class dpedency like here 
//updating location shall be done separately.
//solid principle: Single responsiblity
class Hotel{
    String name;
    int hotelId;
    Location hotelLocation;
    List<Room> roomList;   
}

class Location{
    String country;
    String state;
    String city;
    String street;
    String pin;
}

class Room{
    String roomNumber;
    RoomStyle roomStyle;
    RoomStatus roomStatus;
    Double bokingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLog> houseKeepingLogs; 
}

public enum RoomStyle{
    STANDARD, DELUX, SUITE;
}

public enum RoomStaus{
    AVAILABLE, RESERVED, NOT_AVAILABLE, OCCUPIED, SERVICE_IN_PROGRESS, 
}

class RoomKey{
    String keyId;
    String barCode;
    Date issuedAt;
    Boolean isActive;
    Boolean isMaster;

    public void assignRoom(Room room); // whenever a key is initialised, it also assigns a particular room to it.

}

class HouseKeepingLog{
    String description;
    Date startDate;
    int duration;
    HouseKeeper houseKeeper;

    public void addRoom(Room room);
}

//lets go to actors defined in use-case diagram
//out of 5 actors, 4 are of type person and hence will use inheritance for this 

abstract class Person{
    String name;
    Account accountDetails;
    String phone;
}

public class Account{
    String userName;
    String password;
    AccontStatus accountStatus;
}

public enum AccontStatus{
    ACTIVE, CLOSED, BLOCKED;
}

class houseKeeper extends Person{
    public List<Rooms> getRoomServiced(Date date); // in a given date, give al the rooms which is serviced by this houskeeper
}

class Guest extends Person{
    Search searchObj;
    Booking bookingObj;

    public List<Room> getAllBokings();
}

class Receptionist extends Person{
    Search searchObj;
    Booking bookingObj;

    public void checkInGuest(Guest guest, RoomBooking bookingInfo);
    public void checkOutGuest(Guest guest, RoomBooking bookingInfo);
}

class Admin extends Person{
    public void addRoom(Room roomDetails);
    public void deleteRoom(String roomNumber);
    public void editRoom(Room roomDetails);
}

class Search{
    public List<Room> serachRoom(RoomStyle roomStyle, Date searchDate, int duration);
}

class Booking{
    public RoomBooking createBooking(Guest guestInfo);
    public RoomBooking cancelBooking(int bookingId);
}

class RoomBooking{
    String bookingId;
    Date startDate;
    int durationInDays;
    BookingStatus bookingStatus;
    List<Guest> guestList;
    List<Room> roomList;
    BaseRoomCharge totalRoomCharges;
}

public enum BookingStatus{

}

/*
Decorator pattern to add up new chages on top of base charges
*/

interface BaseRoomCharge{
    Double getCost();
}

class RoomCharge implements BaseRoomCharge{
    double cost;
    double getCost(){
        return cost;
    }
    void setCost(double cost){
        this.cost = cost;
    }
}

class RoomServiceCharge implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    Double getCost(){
        doubt newCost = baseRoomCharge.getCost() + cost;
        baseRoomCharge.setCost(newCost);
        return baseRoomCharge.getCost();
    } 
}

class InRoomPurchaseCharges implements BaseRoomCharge{
    double cost;
    BaseRoomCharge baseRoomCharge;
    Double getCost(){
        doubt newCost = baseRoomCharge.getCost() + cost;
        baseRoomCharge.setCost(newCost);
        return baseRoomCharge.getCost();
    } 
}
