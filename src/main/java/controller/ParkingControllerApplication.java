package controller;

import service.ParkingLotServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ParkingControllerApplication {
    private  static  ParkingLotServiceImpl parkingLotService;
    private  static  InputDelegator inputDelegator;
    public static void main(String[] args) {
        parkingLotService = new ParkingLotServiceImpl();
        inputDelegator = new InputDelegator(parkingLotService);
        if(args!=null && args.length>0){
            readFile(args[0]);
        }else {
            readFromArguments();
        }
    }

    private static void readFromArguments() {
        Scanner scanner = new Scanner(System.in);
        String s;
        while ((s = scanner.nextLine()) != null && s.length() > 0 && !s.equalsIgnoreCase("exit")) {
            inputDelegator.delegate(s);
        }
    }

    private static void readFile(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(s ->inputDelegator.delegate(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
