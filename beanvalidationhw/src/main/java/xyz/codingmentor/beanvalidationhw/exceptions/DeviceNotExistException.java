
package xyz.codingmentor.beanvalidationhw.exceptions;

public class DeviceNotExistException extends RuntimeException{
    
    public DeviceNotExistException(String message) {
        super(message);
    }

    public DeviceNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceNotExistException(Throwable cause) {
        super(cause);
    }

    public DeviceNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
