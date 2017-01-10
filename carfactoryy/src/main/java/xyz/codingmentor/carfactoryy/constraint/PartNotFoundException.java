
package xyz.codingmentor.carfactoryy.constraint;

/**
 *
 * @author blazefury
 */
public class PartNotFoundException extends RuntimeException{

    public PartNotFoundException() {
    }

    public PartNotFoundException(String message) {
        super(message);
    }

    public PartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PartNotFoundException(Throwable cause) {
        super(cause);
    }

    public PartNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
