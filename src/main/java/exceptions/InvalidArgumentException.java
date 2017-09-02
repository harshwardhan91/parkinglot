package exceptions;

public class InvalidArgumentException extends BaseException {
    public static final int INVALID_ARGUMENT = 10001;
    public InvalidArgumentException(String message) {
        super(message,INVALID_ARGUMENT);
    }
}
