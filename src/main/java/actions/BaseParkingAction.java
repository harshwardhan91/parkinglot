package actions;

import data.ParkingLotData;
import exceptions.BaseException;

public abstract class BaseParkingAction {
    protected final ParkingLotData parkingLotData;

    public BaseParkingAction(ParkingLotData parkingLotData) {
        this.parkingLotData = parkingLotData;
    }

    /**
     * Performs given action associated with the operation
     * @param args arguments input from the user
     * @return if operation was successful
     * @throws BaseException any application level exception occurred
     */
    abstract public boolean performAction(String[] args) throws BaseException;
}
