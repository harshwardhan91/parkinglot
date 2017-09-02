package actions;

import data.ParkingLotData;
import exceptions.BaseException;
import exceptions.DataNotExistException;
import exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GetSlotsForVehiclesWithColorActionTest {
    private ParkingLotData parkingLotData;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setup(){
        parkingLotData = new ParkingLotData();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void performAction_success() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(3);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        GetSlotsForVehiclesWithColorAction getSlotsForVehiclesWithColorAction = new GetSlotsForVehiclesWithColorAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        args[1] = "KA-04";
        args[2] = "white";
        parkVehicleAction.performAction(args);
        args[1] = "KA-04";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[1] = "red";
        getSlotsForVehiclesWithColorAction.performAction(args);
        assertEquals("1, 3\n",outContent.toString());
    }
    @Test(expected = InvalidArgumentException.class)
    public void performAction_invalidArgument() throws Exception, BaseException {
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        GetSlotsForVehiclesWithColorAction getSlotsForVehiclesWithColorAction = new GetSlotsForVehiclesWithColorAction(parkingLotData);
        String[] args = new String[1];
        args[0] = ParkingActionConstants.SLOT_NUMBERS_WITH_COLOUR;
        getSlotsForVehiclesWithColorAction.performAction(args);
    }

}