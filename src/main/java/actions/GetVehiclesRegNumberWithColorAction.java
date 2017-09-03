package actions;

import data.ParkingLotData;
import exceptions.BaseException;
import exceptions.InvalidArgumentException;

import java.util.Iterator;
import java.util.List;

/**
 * Defines the action associated with getting all registration numbers with given color
 */
public class GetVehiclesRegNumberWithColorAction extends BaseParkingAction {
    public GetVehiclesRegNumberWithColorAction(ParkingLotData parkingLotData) {
        super(parkingLotData);
    }

    @Override
    public boolean performAction(String[] args) throws BaseException {
        if (args.length < 2) {
            throw new InvalidArgumentException("Insufficient arguments");
        }
        String color = args[1];
        List<String> vehiclesRegNumberWithColor = parkingLotData.getVehiclesRegNumberWithColor(color);
        if(vehiclesRegNumberWithColor==null ||vehiclesRegNumberWithColor.isEmpty()){
            System.out.println("No vehicle found with color " + color);
            return true;
        }else{
            Iterator<String> it = vehiclesRegNumberWithColor.iterator();
            if (it.hasNext()) {
                System.out.print(it.next());
            }
            while (it.hasNext()) {
                System.out.print(", " + it.next());
            }
            System.out.println();
            return true;
        }
    }
}
