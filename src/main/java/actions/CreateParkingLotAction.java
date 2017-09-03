package actions;

import data.ParkingLotData;
import exceptions.BaseException;
import exceptions.InvalidArgumentException;

import static java.lang.System.out;

/**
 * Defines the action associated with creating a new Parking lot
 */
public class CreateParkingLotAction extends BaseParkingAction {
    public CreateParkingLotAction(ParkingLotData parkingLotData) {
        super(parkingLotData);
    }

    @Override
    public boolean performAction(String[] args) throws BaseException {
        try {
            int numberOfSlots = 0;
            int numberOfFloors = 0;
            if(args.length<2){
                throw new InvalidArgumentException("Insufficient arguments");
            }
            numberOfSlots = Integer.parseInt(args[1]);
            if (args.length > 2) {
                numberOfFloors = Integer.parseInt(args[2]);
            }
            if (numberOfFloors != 0) {
                parkingLotData.createNewParkingLot(numberOfFloors, numberOfSlots);
                out.println("Created a parking lot with " + numberOfFloors + " floors and "+numberOfSlots +
                        "slots.");
            } else {
                parkingLotData.createNewParkingLot(numberOfSlots);
                out.println("Created a parking lot with " + numberOfSlots + " slots.");
            }
            return true;
        }catch (NumberFormatException numberFormatException){
            throw new InvalidArgumentException("Arguments expected as integer");
        }catch (Exception exception){
            throw new BaseException("Error occurred during creating new parking lot");
        }
    }
}
