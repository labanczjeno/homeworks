
package xyz.codingmentor.ejbhw.dto;

/**
 *
 * @author blazefury
 */
public class ErrorDTO {
    
    String errorMessage;

    public ErrorDTO() {
        //empty on purpose
    }

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
