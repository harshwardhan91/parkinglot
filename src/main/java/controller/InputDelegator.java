package controller;

public class InputDelegator {

    public static boolean validate(String input){
        if(input.length()<1){
            return false;
        }
        input = input.trim();
        String[] arguments = input.split("\\s+");
        delegateCommand(arguments);
        return false;
    }

    private static void delegateCommand(String[] arguments) {

    }
}
