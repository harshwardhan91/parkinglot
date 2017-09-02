package exceptions;

public class DataNotExistException extends BaseException {
    public static final int DATA_NOT_FOUND = 10002;
    public DataNotExistException(String message) {
        super(message,DATA_NOT_FOUND);
    }

}
