package actions;

import data.ParkingLotData;
import data.entity.ParkingSlot;
import data.entity.Vehicle;
import exceptions.BaseException;
import exceptions.InvalidArgumentException;

import static java.lang.System.out;

public class ParkVehicleAction extends BaseParkingAction {
    public ParkVehicleAction(ParkingLotData parkingLotData) {
        super(parkingLotData);
    }

    @Override
    public boolean performAction(String[] args) throws BaseException {
        if(args.length < 3){
            throw new InvalidArgumentException("Insufficient arguments");
        }
        String regNumber = args[1];
        String color = args[2];
        ParkingSlot parkingSlot = parkingLotData.parkVehicle(new Vehicle(regNumber, color));
        if(parkingSlot==null){
            out.println("No parking slot found empty");
            return true;
        }else{
            out.println("Allocated slot number " + parkingSlot.getSlotNumber() + " at floor " + parkingSlot.getFloor());
            return true;
        }
    }
}
