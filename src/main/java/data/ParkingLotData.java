package data;

import data.entity.ParkingLot;
import data.entity.ParkingSlot;
import data.entity.Vehicle;

import java.util.List;

public class ParkingLotData {

    private static ParkingLot parkingLotInstance;

    public ParkingLotData() {
    }

    public void createNewParkingLot(int numberOfFloors,int numberOfSlots){
        parkingLotInstance = new ParkingLot(numberOfFloors,numberOfSlots);
    }
    public void createNewParkingLot(int numberOfSlots){
        parkingLotInstance = new ParkingLot(numberOfSlots);
    }

    public ParkingSlot parkVehicle(Vehicle vehicle){
        List<List<ParkingSlot>> parkingSlots = parkingLotInstance.getParkingSlots();
        ParkingSlot parkedSlot = null;
        for (List<ParkingSlot> parkingSlotsOnFloor : parkingSlots) {
            for (ParkingSlot parkingSlot : parkingSlotsOnFloor) {
                if (parkingSlot.parkVehicle(vehicle)) {
                    parkedSlot = parkingSlot;
                    break;
                }
            }
            if (parkedSlot != null) {
                break;
            }
        }
        return parkedSlot;
    }
}
