package xyz.codingmentor.ejbhw.exceptions;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String message) {
        super(message);
    }
}
