package controller;

import actions.BaseParkingAction;
import exceptions.BaseException;
import service.ParkingLotServiceImpl;

import static actions.ParkingActionConstants.*;

public class InputDelegator {
    ParkingLotServiceImpl parkingLotService;

    public InputDelegator(ParkingLotServiceImpl parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    /**
     * Separates the string input into array to be treated as input array
     * @param input received from user(file or command line)
     * @return whether input operation was success or not
     */
    public  boolean delegate(String input){
        if(input.length()<1){
            return false;
        }
        input = input.trim();
        String[] arguments = input.split("\\s+");
        return delegateAction(arguments);
    }

    /**
     * Finds the correct command associated with the input
     * @param arguments received from the user
     * @return whether operation was success or not
     */
    private boolean delegateAction(String[] arguments) {
        String action = arguments[0];
        boolean result = true;
        BaseParkingAction baseParkingAction = null;
        switch (action) {
            case CREATE_PARKING_LOT:
                baseParkingAction = parkingLotService.createParkingLot(arguments);
                break;
            case PARK:
                baseParkingAction = parkingLotService.parkVehicle(arguments);
                break;
            case LEAVE:
                baseParkingAction = parkingLotService.leaveVehicle(arguments);
                break;
            case STATUS:
                baseParkingAction = parkingLotService.showStatus(arguments);
                break;
            case REGISTRATION_NUMBERS_WITH_COLOUR:
                baseParkingAction = parkingLotService.getRegistrationOfVehicleWithColor(arguments);
                break;
            case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                baseParkingAction = parkingLotService.getSlotNumberOfVehicleWithRegistrationNumber(arguments);
                break;
            case SLOT_NUMBERS_WITH_COLOUR:
                baseParkingAction = parkingLotService.getSlotNumbersOfVehicleWithColor(arguments);
                break;
            default:
                result = false;
                break;
        }
        if(result && baseParkingAction!=null){
            try {
                baseParkingAction.performAction(arguments);
            } catch (BaseException | Exception e) {
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Not valid command.");
        }
        return result;
    }
}
