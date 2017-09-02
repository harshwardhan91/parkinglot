package controller;

import service.ParkingLotServiceImpl;

import static actions.ParkingActionConstants.*;

public class InputDelegator {
    ParkingLotServiceImpl parkingLotService;

    public InputDelegator(ParkingLotServiceImpl parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public  boolean delegate(String input){
        if(input.length()<1){
            return false;
        }
        input = input.trim();
        String[] arguments = input.split("\\s+");
        return delegateAction(arguments);
    }

    private boolean delegateAction(String[] arguments) {
        String action = arguments[0];
        boolean result = true;
        switch (action) {
            case CREATE_PARKING_LOT:
                parkingLotService.createParkingLot(arguments);
                break;
            case PARK:
                parkingLotService.parkVehicle(arguments);
                break;
            case LEAVE:
                parkingLotService.leaveVehicle(arguments);
                break;
            case STATUS:
                parkingLotService.showStatus(arguments);
                break;
            case REGISTRATION_NUMBERS_WITH_COLOUR:
                parkingLotService.getRegistrationOfVehicleWithColor(arguments);
                break;
            case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                parkingLotService.getSlotNumberOfVehicleWithRegistrationNumber(arguments);
                break;
            case SLOT_NUMBERS_WITH_COLOUR:
                parkingLotService.getSlotNumbersOfVehicleWithColor(arguments);
                break;
            default:
                result = false;
                break;
        }
        return result;
    }
}
