package data.entity;

public class ParkingSlot {

    private ParkingSpaceType parkingSlotType;
    private Vehicle parkedVehicle;
    private int floor;
    private int slotNumber;
    public ParkingSlot(int floor,int slotNumber) {
        parkingSlotType = ParkingSpaceType.GENERAL;
        this.floor = floor;
        this.slotNumber = slotNumber;
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

    public int getFloor() {
        return floor;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
