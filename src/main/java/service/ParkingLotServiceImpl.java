package service;

import actions.*;
import data.ParkingLotData;
import exceptions.BaseException;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotData parkingLotData;

    public ParkingLotServiceImpl() {
        parkingLotData = new ParkingLotData();
    }

    @Override
    public CreateParkingLotAction createParkingLot(String[] args) {
        return new CreateParkingLotAction(parkingLotData);
    }

    @Override
    public ParkVehicleAction parkVehicle(String[] args) {
        return new ParkVehicleAction(parkingLotData);
    }

    @Override
    public ShowStatusAction showStatus(String[] args) {
        return new ShowStatusAction(parkingLotData);
    }

    @Override
    public LeaveParkingAction leaveVehicle(String[] args) {
        return new LeaveParkingAction(parkingLotData);
    }

    @Override
    public GetVehiclesRegNumberWithColorAction getRegistrationOfVehicleWithColor(String[] args) {
        return new GetVehiclesRegNumberWithColorAction(parkingLotData);
    }

    @Override
    public GetSlotsForVehiclesWithColorAction getSlotNumbersOfVehicleWithColor(String[] args) {
        return new GetSlotsForVehiclesWithColorAction(parkingLotData);
    }

    @Override
    public GetSlotNumberForRegistrationNumberAction getSlotNumberOfVehicleWithRegistrationNumber(String[] args) {
        return new GetSlotNumberForRegistrationNumberAction(parkingLotData);
    }
}
