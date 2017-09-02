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
            out.println("Sorry, parking lot is full");
            return true;
        }else{
            if(parkingSlot.getFloor()!=0) {
                out.println("Allocated slot number " + parkingSlot.getSlotNumber() + 1 + " at floor " + parkingSlot
                        .getFloor());
            }else{
                out.println("Allocated slot number " + parkingSlot.getSlotNumber() + 1);
            }
            return true;
        }
    }
}
