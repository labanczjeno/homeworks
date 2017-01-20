
package xyz.codingmentor.resthw.exception;

/**
 *
 * @author blazefury
 */
public class ErrorDTO {
    
    private String errorMessage;

    public ErrorDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
