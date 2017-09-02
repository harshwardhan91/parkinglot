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

public class GetSlotNumberForRegistrationNumberActionTest {
    private ParkingLotData parkingLotData;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setup(){
        parkingLotData = new ParkingLotData();
        System.setOut(new PrintStream(outContent));
    }
    @Test(expected = DataNotExistException.class)
    public void performAction_noParkingLot() throws Exception, BaseException {
        GetSlotNumberForRegistrationNumberAction getSlotNumberForRegistrationNumberAction = new GetSlotNumberForRegistrationNumberAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER;
        args[1] = "KA-03";
        args[2] = "red";
        getSlotNumberForRegistrationNumberAction.performAction(args);
    }

    @Test
    public void performAction_success() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        GetSlotNumberForRegistrationNumberAction getSlotNumberForRegistrationNumberAction = new GetSlotNumberForRegistrationNumberAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[0] = ParkingActionConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER;
        args[1] = "KA-03";
        getSlotNumberForRegistrationNumberAction.performAction(args);
        assertEquals("1\n",outContent.toString());
    }
    @Test
    public void performAction_noResult() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        GetSlotNumberForRegistrationNumberAction getSlotNumberForRegistrationNumberAction = new GetSlotNumberForRegistrationNumberAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[0] = ParkingActionConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER;
        args[1] = "KA-04";
        getSlotNumberForRegistrationNumberAction.performAction(args);
        assertEquals("Not found\n",outContent.toString());
    }

    @Test(expected = InvalidArgumentException.class)
    public void performAction_invalidArgument() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        GetSlotNumberForRegistrationNumberAction getSlotNumberForRegistrationNumberAction = new GetSlotNumberForRegistrationNumberAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        String[] args1 = new String[1];
        args1[0] = ParkingActionConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER;
        getSlotNumberForRegistrationNumberAction.performAction(args1);
        assertEquals("Not found\n",outContent.toString());
    }

}