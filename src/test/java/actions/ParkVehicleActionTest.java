package actions;

import data.ParkingLotData;
import data.entity.Vehicle;
import exceptions.BaseException;
import exceptions.DataNotExistException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParkVehicleActionTest {
    private ParkingLotData parkingLotData;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setup(){
        parkingLotData = new ParkingLotData();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void performAction_success() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        assertEquals("Allocated slot number 1\n",outContent.toString());
    }
    @Test
    public void performAction_noSlot() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(1);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-04";
        args[2] = "white";
        parkVehicleAction.performAction(args);
        assertEquals("Sorry, parking lot is full\n",outContent.toString());
    }

}