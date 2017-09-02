package data.entity;

public class Vehicle {

    private String registrationNumber;
    private String color;
    private ParkingSpaceType parkingSpaceType;

    public Vehicle(String registrationNumber, String color, ParkingSpaceType parkingSpaceType) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.parkingSpaceType = parkingSpaceType;
    }

    public Vehicle(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.parkingSpaceType = ParkingSpaceType.GENERAL;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ParkingSpaceType getParkingSpaceType() {
        return parkingSpaceType;
    }

    public void setParkingSpaceType(ParkingSpaceType parkingSpaceType) {
        this.parkingSpaceType = parkingSpaceType;
    }
}
