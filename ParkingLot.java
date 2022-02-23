class ParkingLot{
    Address address;
    String parkingLotName;

    List<ParkingFloor> parkingFloors;
    List<Entrance> entrances;
    List<Exit> exit;

    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle);
    public boolean updateParkingAttendant(ParkingAttendnt parkingAttendant, int gateId);

}

class ParkingFloor{
    int levelId;
    boolean isFull;
    DisplayBoard displayBoard;
    List<ParkingSpaces> parkingSpaces;
}

class Gate{
    int gateId;
    ParkingAttendnt parkingAttendant;
}

class Entrance extends Gate{
    public ParkingTicket getParkingTicket(Vehicle vehicle);
}

class Exit extends Gate{
    public ParkingTicket payForParking(ParkingTicket parkingTicket, PaymentType paymentType);
}

class Address{
    String counry;
    String state;
    String city;
    String street;
    String pinCode;
}

class ParkingSpace{
    int spaceId;
    boolean isFree;
    double costPerHour;
    Vehicle vehicle;
    ParkingSpaceType parkingSpaceType;
    //int levelId; //not required because we are already calling it from ParkingFloor Class
}

class DisplayBoard{
    Map<ParkingSpaceType, Integer> freeParkingSpaveAvailableMap;
    public void updateFreeSpotsAvailable(ParkingSpaceType parkingSpaceType, int spaces);
}

class Account{
    String name;
    String email;
    String password;
    String empId;
    Address address;
}

class Admin extends Account{
    public boolean addParkingFloor(ParkingLot parkingLot, ParkingFloor parkingFloor);
    public boolean addParkingSpace(ParkingFloor floor, ParkingSpace parkingSpace);
    public boolean addDisplayBoard(ParkingFloor floor, DisplayBoard displayBoard);
}

class ParkingAttendnt extends Account{
    int attendantId;
    int gateId;
    int FloorId;
    Payment paymentService; //bcz attendant is responsible for payment

    public boolean processVehicleEntry(Vehicle vehicle);
    public PaymentInfo processPayment(ParkingTicket parkingTicket, PaymentType paymentType);
}

class Vehicle{
    String licenseNumber;
    VehicleType vehicleType;
    ParkingTicket parkingTicket;
    PaymentInfo paymentInfo;
}

class ParkingTicket{
    int ticketId;
    int levelId;
    int spaceId;
    Date vehicleEntryDateTime;
    Date vehicleExitDateTime;
    ParkingSpacetype parkingSpaceType;
    double totalCost;
    ParkingTicketStatus parkingTicketStatus;

    //all above data point will be filled while vehicle is on entry gate, except 
    //total cost and exit time, for which we need to expose these APIs below.
    public void updateTotalCost();
    public void updateVehicleExitTime(Date vehicleExitDateTime);
}

class Payment{
    public PaymentInfo makePayment(ParkingTicket parkingTicket, PaymentType paymentType);
}

class PaymentInfo{
    double Amount;
    Date paymentDate;
    int transactionId;
    ParkingTicket parkingTicket;
    PaymentStatus paymentStatus;
}

public enum VehicleType{
    BIKE, CAR, TRUCK;
}

public enum PaymentType{
    CASH,CREDIT_CARD, DEBIT_CARD, UPI;
}

public enum ParkingSpace{
    BIKE_PARKING, CAR_PARKING, TRUCK_PARKING;
}

public enum ParkingTicketStatus{
    PAID,ACTIVE;
}

public enum PaymentStatus{
    UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;
}
