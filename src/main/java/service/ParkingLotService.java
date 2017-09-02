package service;

import actions.BaseParkingAction;

public interface ParkingLotService {
    /**
     * Create a new Parking lot
     */
    BaseParkingAction createParkingLot(String[] args);

    /**
     * Park a given vehicle in the parking lot
     */
    BaseParkingAction parkVehicle(String[] args);

    /**
     * Show status of the parking lot
     */
    BaseParkingAction showStatus(String[] args);

    /**
     * Leave a vehicle in the parking lot given a slot
     */
    BaseParkingAction leaveVehicle(String[] args);

    /**
     * All registration numbers of vehicle with given color
     */
    BaseParkingAction getRegistrationOfVehicleWithColor(String[] args);

    /**
     * All slot numbers of vehicle with given color
     */
    BaseParkingAction getSlotNumbersOfVehicleWithColor(String[] args);

    /**
     * All slot number  of vehicle with given slot number
     */
    BaseParkingAction getSlotNumberOfVehicleWithRegistrationNumber(String[] args);
}
