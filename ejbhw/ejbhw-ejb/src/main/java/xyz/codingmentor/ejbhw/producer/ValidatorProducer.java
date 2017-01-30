
package xyz.codingmentor.ejbhw.producer;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.ejbhw.constraint.ValidatorQualifier;

/**
 *
 * @author blazefury
 */
public class ValidatorProducer {

    @Produces @ValidatorQualifier
    public Validator produceValidator(){
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }
    
}
