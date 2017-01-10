
package xyz.codingmentor.beanvalidationhw.exceptions;

public class DeviceExistException extends RuntimeException{

    public DeviceExistException(String message) {
        super(message);
    }

    public DeviceExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceExistException(Throwable cause) {
        super(cause);
    }

    public DeviceExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
