
package xyz.codingmentor.beanvalidationhw.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beanvalidationhw.beans.UserEntity;

public class BirthdayValidator implements ConstraintValidator<Birthday, UserEntity>{

    @Override
    public void initialize(Birthday a) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(UserEntity t, ConstraintValidatorContext cvc) {
        if(t.getDateOfBirth()==null) {
              return true;
        }
        return t.getDateOfBirth().before(t.getRegistrationDate());
    }
}
