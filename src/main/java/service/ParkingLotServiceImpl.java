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
        ShowStatusAction showStatusAction = new ShowStatusAction(parkingLotData);
        try {
            showStatusAction.performAction(args);
        }  catch (BaseException | Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void leaveVehicle(String[] args) {
        LeaveParkingAction leaveParkingAction = new LeaveParkingAction(parkingLotData);
        try {
            leaveParkingAction.performAction(args);
        }  catch (BaseException | Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getRegistrationOfVehicleWithColor(String[] args) {
        GetVehiclesRegNumberWithColorAction getVehiclesRegNumberWithColorAction = new
                GetVehiclesRegNumberWithColorAction(parkingLotData);
        try{
            getVehiclesRegNumberWithColorAction.performAction(args);
        } catch (BaseException | Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getSlotNumbersOfVehicleWithColor(String[] args) {
        GetSlotsForVehiclesWithColorAction getSlotsForVehiclesWithColorAction = new
                GetSlotsForVehiclesWithColorAction(parkingLotData);
        try{
            getSlotsForVehiclesWithColorAction.performAction(args);
        } catch (BaseException | Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getSlotNumberOfVehicleWithRegistrationNumber(String[] args) {
        GetSlotNumberForRegistrationNumber getSlotNumberForRegistrationNumber = new
                GetSlotNumberForRegistrationNumber(parkingLotData);
        try{
            getSlotNumberForRegistrationNumber.performAction(args);
        } catch (BaseException | Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }
}
