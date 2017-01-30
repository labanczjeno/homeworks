package xyz.codingmentor.ejbhw.exceptions;

public class DeviceExistException extends RuntimeException {

    public DeviceExistException(String message) {
        super(message);
    }
}
