
package com.mycompany.library;

public class TheBookIsBorrowedException extends RuntimeException{

    public TheBookIsBorrowedException() {
        //The name tells everything about it.
    }
    public TheBookIsBorrowedException(String message) {
        super(message);
    }
    public TheBookIsBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }
    public TheBookIsBorrowedException(Throwable cause) {
        super(cause);
    }
    public TheBookIsBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    } 
}
