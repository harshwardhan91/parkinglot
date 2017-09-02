package data.entity;

public class ParkingSlot {

    private ParkingSpaceType parkingSlotType;
    private Vehicle parkedVehicle;
    public ParkingSlot() {
        parkingSlotType = ParkingSpaceType.GENERAL;
    }

    public ParkingSlot(ParkingSpaceType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(parkedVehicle!=null){
            return false;
        }else{
            //todo: can check vehicle space type and add additional checks
            parkedVehicle = vehicle;
            return true;
        }
    }

    public ParkingSpaceType getParkingSlotType() {
        return parkingSlotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
