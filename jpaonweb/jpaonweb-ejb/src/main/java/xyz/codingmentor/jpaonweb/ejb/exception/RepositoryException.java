
package xyz.codingmentor.jpaonweb.ejb.exception;

/**
 *
 * @author blazefury
 */


public class RepositoryException extends Exception{

    public RepositoryException(){
        //empty on purpose
    }
    
    public RepositoryException(String message) {
        super(message);
    }
    
}
