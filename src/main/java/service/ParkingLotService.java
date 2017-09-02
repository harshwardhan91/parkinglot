package service;

public interface ParkingLotService {
    /**
     * Create a new Parking lot
     */
    void createParkingLot(String[] args);

    /**
     * Park a given vehicle in the parking lot
     */
    void parkVehicle(String[] args);

    /**
     * Show status of the parking lot
     */
    void showStatus(String[] args);

    /**
     * Leave a vehicle in the parking lot given a slot
     */
    void leaveVehicle(String[] args);

    /**
     * All registration numbers of vehicle with given color
     */
    void getRegistrationOfVehicleWithColor(String[] args);

    /**
     * All slot numbers of vehicle with given color
     */
    void getSlotNumbersOfVehicleWithColor(String[] args);

    /**
     * All slot number  of vehicle with given slot number
     */
    void getSlotNumberOfVehicleWithRegistrationNumber(String[] args);
}
