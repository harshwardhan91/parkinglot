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

public class GetVehiclesRegNumberWithColorActionTest {
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
        GetVehiclesRegNumberWithColorAction getVehiclesRegNumberWithColorAction = new GetVehiclesRegNumberWithColorAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[1] = "red";
        getVehiclesRegNumberWithColorAction.performAction(args);
        assertEquals("KA-03\n",outContent.toString());
    }

    @Test(expected = InvalidArgumentException.class)
    public void performAction_invalidArgument() throws Exception, BaseException {
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        GetVehiclesRegNumberWithColorAction getVehiclesRegNumberWithColorAction = new GetVehiclesRegNumberWithColorAction(parkingLotData);
        String[] args = new String[1];
        args[0] = ParkingActionConstants.REGISTRATION_NUMBERS_WITH_COLOUR;
        getVehiclesRegNumberWithColorAction.performAction(args);
    }
}