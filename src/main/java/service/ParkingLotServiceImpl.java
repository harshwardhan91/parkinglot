package service;

import actions.CreateParkingLotAction;
import actions.ParkVehicleAction;
import data.ParkingLotData;
import exceptions.BaseException;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotData parkingLotData;

    public ParkingLotServiceImpl() {
        parkingLotData = new ParkingLotData();
    }

    @Override
    public void createParkingLot(String[] args) {
        CreateParkingLotAction createParkingLotAction = new CreateParkingLotAction(parkingLotData);
        try {
            createParkingLotAction.performAction(args);
        } catch (BaseException | Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void parkVehicle(String[] args) {
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        try {
            parkVehicleAction.performAction(args);
        } catch (BaseException | Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void showStatus(String[] args) {

    }

    @Override
    public void leaveVehicle(String[] args) {

    }

    @Override
    public void getRegistrationOfVehicleWithColor(String[] args) {

    }

    @Override
    public void getSlotNumbersOfVehicleWithColor(String[] args) {

    }

    @Override
    public void getSlotNumberOfVehicleWithRegistrationNumber(String[] args) {

    }
}
