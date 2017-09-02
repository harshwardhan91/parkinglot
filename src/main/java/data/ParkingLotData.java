package data;

import data.entity.ParkingLot;

public class ParkingLotData {

    private static ParkingLot parkingLotInstance;

    public ParkingLotData() {
    }

    public ParkingLotData(int numberOfFloors,int numberOfSlots){
        parkingLotInstance = new ParkingLot(numberOfFloors,numberOfSlots);
    }
    public ParkingLotData(int numberOfSlots){
        parkingLotInstance = new ParkingLot(numberOfSlots);
    }

    public static ParkingLot getParkingLotInstance() {
        return parkingLotInstance;
    }

}
