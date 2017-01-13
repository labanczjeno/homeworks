
package xyz.codingmentor.notnull.jeno.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.notnull.jeno.beans.CustomClass;
import xyz.codingmentor.notnull.jeno.exceptions.FieldCantBeNullException;

/**
 *
 * @author blazefury
 */
public class NotNullValidator implements ConstraintValidator<NotNullWithException, CustomClass>{

    @Override
    public void initialize(NotNullWithException notnull) {
        //empty beacuse we dont have to initalize anything.
    }

    @Override
    public boolean isValid(CustomClass value, ConstraintValidatorContext context) {
        if (value!=null) {
            return true;
        } 
        else {
            throw new FieldCantBeNullException("field cant be null");
        }
    }
}
