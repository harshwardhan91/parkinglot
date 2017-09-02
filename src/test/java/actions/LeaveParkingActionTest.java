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

public class LeaveParkingActionTest {
    private ParkingLotData parkingLotData;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    @Before
    public void setup(){
        parkingLotData = new ParkingLotData();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @Test(expected = InvalidArgumentException.class)
    public void performAction_invalidArgument() throws Exception, BaseException {
        LeaveParkingAction leaveParkingAction = new LeaveParkingAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.LEAVE;
        args[1] = "KA-03";
        leaveParkingAction.performAction(args);
    }
    @Test(expected = DataNotExistException.class)
    public void performAction_noParkingLot() throws Exception, BaseException {
        LeaveParkingAction leaveParkingAction = new LeaveParkingAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.LEAVE;
        args[1] = "2";
        args[2] = "red";
        leaveParkingAction.performAction(args);
    }
    @Test
    public void performAction_success() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        LeaveParkingAction leaveParkingAction = new LeaveParkingAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[0] = ParkingActionConstants.LEAVE;
        args[1] = "1";
        leaveParkingAction.performAction(args);
        assertEquals("Slot number 1 is free\n",outContent.toString());
    }
    @Test(expected = DataNotExistException.class)
    public void performAction_slotNotExist() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        LeaveParkingAction leaveParkingAction = new LeaveParkingAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[0] = ParkingActionConstants.LEAVE;
        args[1] = "4";
        leaveParkingAction.performAction(args);
        assertEquals("No Parking slot found\n",outContent.toString());
    }
    @Test(expected = DataNotExistException.class)
    public void performAction_noCarFound() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        LeaveParkingAction leaveParkingAction = new LeaveParkingAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[0] = ParkingActionConstants.LEAVE;
        args[1] = "2";
        leaveParkingAction.performAction(args);
        assertEquals("No Parking slot found\n",errContent.toString());
    }
    @Test(expected = InvalidArgumentException.class)
    public void performAction_invalidSlot() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(2);
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        LeaveParkingAction leaveParkingAction = new LeaveParkingAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        parkVehicleAction.performAction(args);
        outContent.reset();
        args[0] = ParkingActionConstants.LEAVE;
        args[1] = "0";
        leaveParkingAction.performAction(args);
        assertEquals("Slot number not valid\n",errContent.toString());
    }
}