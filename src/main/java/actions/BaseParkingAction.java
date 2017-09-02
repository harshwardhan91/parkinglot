package actions;

import data.ParkingLotData;
import exceptions.BaseException;

public abstract class BaseParkingAction {
    protected final ParkingLotData parkingLotData;

    public BaseParkingAction(ParkingLotData parkingLotData) {
        this.parkingLotData = parkingLotData;
    }

    abstract public boolean performAction(String[] args) throws BaseException;
}
