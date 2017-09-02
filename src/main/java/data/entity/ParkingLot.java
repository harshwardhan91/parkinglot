package data.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    int numberOfFloors;

    int numberOfSlots;

    List<List<ParkingSlot>> parkingSlots;

    public ParkingLot(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        this.numberOfFloors = 1;
        parkingSlots = new ArrayList<>();
        parkingSlots.add(new ArrayList<>());
        for (int i = 0; i < this.numberOfSlots; i++) {
            parkingSlots.get(0).add(new ParkingSlot(ParkingSpaceType.GENERAL));
        }
    }

    public ParkingLot(int numberOfFloors, int numberOfVehicle) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlots = numberOfVehicle;
        parkingSlots = new ArrayList<>();
        for (int j = 0; j < numberOfFloors; j++) {
            parkingSlots.add(new ArrayList<>());
            for (int i = 0; i < numberOfSlots; i++) {
                parkingSlots.get(j).add(new ParkingSlot(ParkingSpaceType.GENERAL));
            }
        }
    }
}
