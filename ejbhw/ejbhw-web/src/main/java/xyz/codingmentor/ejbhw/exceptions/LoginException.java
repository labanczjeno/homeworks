
package xyz.codingmentor.ejbhw.exceptions;

import java.io.Serializable;

/**
 *
 * @author blazefury
 */
public class LoginException extends RuntimeException implements Serializable{

    public LoginException(String message){
        super(message);
    }
    
}
