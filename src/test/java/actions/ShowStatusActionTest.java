package actions;

import data.ParkingLotData;
import exceptions.BaseException;
import exceptions.DataNotExistException;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ShowStatusActionTest {

    private ParkingLotData parkingLotData;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setup(){
        parkingLotData = new ParkingLotData();
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void performAction_success() throws Exception, BaseException {
        parkingLotData.createNewParkingLot(1);
        ShowStatusAction showStatusAction = new ShowStatusAction(parkingLotData);
        String[] args = new String[3];
        args[0] = ParkingActionConstants.PARK;
        args[1] = "KA-03";
        args[2] = "red";
        ParkVehicleAction parkVehicleAction = new ParkVehicleAction(parkingLotData);
        parkVehicleAction.performAction(args);
        outContent.reset();
        showStatusAction.performAction(args);
        assertEquals("Slot\tRegistaration Number\tColor\n" +
                "1\tKA-03\t\tred\n",outContent.toString());
    }

}