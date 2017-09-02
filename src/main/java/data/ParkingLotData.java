package data;

import data.entity.ParkingLot;
import data.entity.ParkingSlot;
import data.entity.Vehicle;
import exceptions.BaseException;
import exceptions.DataNotExistException;

import java.util.ArrayList;
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

    public ParkingSlot parkVehicle(Vehicle vehicle) throws DataNotExistException{
        if(parkingLotInstance == null){
            throw new DataNotExistException("No Parking lot found");
        }
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

    public String getParkingLotStatus(){
        if(parkingLotInstance == null || parkingLotInstance.getParkingSlots()==null || parkingLotInstance
                .getParkingSlots().isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        boolean printFloor= false;
        if(parkingLotInstance.getParkingSlots().size()==1){
            builder.append("Slot").append("\tRegistaration Number").append("\tColor");
        }else{
            printFloor = true;
            builder.append("Floor").append("\tSlot").append("\tRegistaration Number").append("\tColor");
        }
        List<List<ParkingSlot>> parkingSlots = parkingLotInstance.getParkingSlots();
        for (int i = 0; i < parkingSlots.size(); i++) {
            List<ParkingSlot> parkingSlotsOnFloor = parkingSlots.get(i);
            for (int i1 = 0; i1 < parkingSlotsOnFloor.size(); i1++) {
                ParkingSlot parkingSlot = parkingSlotsOnFloor.get(i1);
                if(parkingSlot.getParkedVehicle()!=null){
                    builder.append("\n");
                    if (printFloor) {
                        builder.append(i+1).append("\t").append(i1+1).append("\t");
                    } else {
                        builder.append(i1+1).append("\t");
                    }
                    builder.append(parkingSlot.getParkedVehicle().getRegistrationNumber()).append("\t").append("\t").append
                                (parkingSlot.getParkedVehicle().getColor());
                }
            }
        }
        return builder.toString();
    }

    public boolean leaveVehicleAtSlot(int slot) throws DataNotExistException{
        if(parkingLotInstance == null){
            throw new DataNotExistException("No Parking lot found");
        }
        List<List<ParkingSlot>> parkingSlots = parkingLotInstance.getParkingSlots();
        if(parkingSlots.isEmpty()){
            throw new DataNotExistException("No Parking floor found");
        }else if(parkingSlots.get(0).size()>slot){
            ParkingSlot parkingSlot = parkingSlots.get(0).get(slot);
            if(parkingSlot.getParkedVehicle()==null){
                throw new DataNotExistException("No Car found at slot " + slot);
            }else{
                parkingSlot.leaveVehicle();
                return true;
            }
        }else{
            throw new DataNotExistException("No Parking slot found");
        }
    }

    public List<String> getVehiclesRegNumberWithColor(String color)  throws DataNotExistException{
        if(parkingLotInstance == null){
            throw new DataNotExistException("No Parking lot found");
        }

        List<String> resultList = new ArrayList<>();
        List<List<ParkingSlot>> parkingSlots = parkingLotInstance.getParkingSlots();
        for (List<ParkingSlot> parkingSlotsOnFloor : parkingSlots) {
            for (ParkingSlot parkingSlot : parkingSlotsOnFloor) {
                if(parkingSlot.getParkedVehicle()!=null && parkingSlot.getParkedVehicle().getColor().equalsIgnoreCase(color)){
                    resultList.add(parkingSlot.getParkedVehicle().getRegistrationNumber());
                }
            }
        }
        return resultList;
    }

    public List<String> getSlotsForVehiclesWithColor(String color)  throws DataNotExistException{
        if(parkingLotInstance == null){
            throw new DataNotExistException("No Parking lot found");
        }

        List<String> resultList = new ArrayList<>();
        List<List<ParkingSlot>> parkingSlots = parkingLotInstance.getParkingSlots();
        for (List<ParkingSlot> parkingSlotsOnFloor : parkingSlots) {
            for (ParkingSlot parkingSlot : parkingSlotsOnFloor) {
                if(parkingSlot.getParkedVehicle()!=null && parkingSlot.getParkedVehicle().getColor().equalsIgnoreCase(color)){
                    resultList.add(Integer.toString(parkingSlot.getSlotNumber()+1));
                }
            }
        }
        return resultList;
    }
    public int getSlotForVehiclesWithRegistrationNumber(String registrationNumber)  throws
            DataNotExistException{
        if(parkingLotInstance == null){
            throw new DataNotExistException("No Parking lot found");
        }

        int slotNumber = -1;
        List<List<ParkingSlot>> parkingSlots = parkingLotInstance.getParkingSlots();
        for (List<ParkingSlot> parkingSlotsOnFloor : parkingSlots) {
            for (ParkingSlot parkingSlot : parkingSlotsOnFloor) {
                if(parkingSlot.getParkedVehicle()!=null && parkingSlot.getParkedVehicle().getRegistrationNumber()
                        .equalsIgnoreCase(registrationNumber)){
                    slotNumber = parkingSlot.getSlotNumber()+1;
                    break;
                }
            }
            if(slotNumber!=-1){
                break;
            }
        }
        return slotNumber;
    }
}
