package exceptions;

public class BaseException extends Throwable{
    private String message;
    private int messageCode;

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(String message, int messageCode) {
        this.message = message;
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageCode() {
        return messageCode;
    }
}
