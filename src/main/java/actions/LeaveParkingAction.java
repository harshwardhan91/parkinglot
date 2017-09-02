package actions;

import data.ParkingLotData;
import exceptions.BaseException;
import exceptions.InvalidArgumentException;

public class LeaveParkingAction extends BaseParkingAction {
    public LeaveParkingAction(ParkingLotData parkingLotData) {
        super(parkingLotData);
    }

    @Override
    public boolean performAction(String[] args) throws BaseException {
        try {
            if (args.length < 2) {
                throw new InvalidArgumentException("Insufficient arguments");
            }
            int slotNumber = Integer.parseInt(args[1]);
            if(slotNumber<1){
                throw new InvalidArgumentException("Slot number not valid");
            }
            if(parkingLotData.leaveVehicleAtSlot(slotNumber-1)){
                System.out.println("Slot number " + slotNumber + " is free");
                return true;
            }
            return false;
        }catch (NumberFormatException ex){
            throw new InvalidArgumentException("Arguments expected as integer");
        }
    }
}
