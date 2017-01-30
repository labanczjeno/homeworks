package xyz.codingmentor.ejbhw.exceptions;

public class DeviceNotExistException extends RuntimeException {

    public DeviceNotExistException(String message) {
        super(message);
    }
}
