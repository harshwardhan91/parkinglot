package actions;

import data.ParkingLotData;
import exceptions.BaseException;
import exceptions.InvalidArgumentException;

import java.util.List;

public class GetSlotNumberForRegistrationNumber extends BaseParkingAction {
    public GetSlotNumberForRegistrationNumber(ParkingLotData parkingLotData) {
        super(parkingLotData);
    }

    @Override
    public boolean performAction(String[] args) throws BaseException {
        if (args.length < 2) {
            throw new InvalidArgumentException("Insufficient arguments");
        }
        String regNumber = args[1];
        int slotNumber = parkingLotData.getSlotForVehiclesWithRegistrationNumber(regNumber);
        if(slotNumber==-1){
            System.out.println("Not found");
            return true;
        }else{
            System.out.println(slotNumber);
            return true;
        }
    }
}
