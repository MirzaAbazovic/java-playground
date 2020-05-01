package ba.programiraj.spring.aop.exception;

public class CustomAppException extends RuntimeException {

    public CustomAppException() {
        super();
    }

    public CustomAppException(String message) {
        super(message);
    }

    public CustomAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomAppException(Throwable cause) {
        super(cause);
    }

    protected CustomAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
