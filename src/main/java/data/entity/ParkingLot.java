package data.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int numberOfFloors;
    private int numberOfSlots;
    private List<List<ParkingSlot>> parkingSlots;

    public ParkingLot(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        this.numberOfFloors = 1;
        parkingSlots = new ArrayList<>();
        parkingSlots.add(new ArrayList<>());
        for (int i = 0; i < this.numberOfSlots; i++) {
            parkingSlots.get(0).add(new ParkingSlot(0,i));
        }
    }

    public ParkingLot(int numberOfFloors, int numberOfVehicle) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlots = numberOfVehicle;
        parkingSlots = new ArrayList<>();
        for (int j = 0; j < numberOfFloors; j++) {
            parkingSlots.add(new ArrayList<>());
            for (int i = 0; i < numberOfSlots; i++) {
                parkingSlots.get(j).add(new ParkingSlot(j,i));
            }
        }
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public List<List<ParkingSlot>> getParkingSlots() {
        return parkingSlots;
    }
}
