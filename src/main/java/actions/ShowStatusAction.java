package actions;

import data.ParkingLotData;
import exceptions.BaseException;

/**
 * Defines the action associated with showing status of the Parking lot
 */
public class ShowStatusAction extends BaseParkingAction {
    public ShowStatusAction(ParkingLotData parkingLotData) {
        super(parkingLotData);
    }

    @Override
    public boolean performAction(String[] args) throws BaseException {
        String parkingLotStatus = parkingLotData.getParkingLotStatus();
        if(parkingLotStatus==null || parkingLotStatus.isEmpty()){
            System.out.println("Parking lot empty");
            return true;
        }else{
            System.out.println(parkingLotStatus);
            return true;
        }
    }
}
