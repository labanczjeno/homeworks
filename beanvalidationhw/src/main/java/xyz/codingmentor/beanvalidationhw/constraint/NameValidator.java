
package xyz.codingmentor.beanvalidationhw.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beanvalidationhw.beans.UserEntity;

public class NameValidator implements ConstraintValidator<Name, UserEntity>  {

    @Override
    public void initialize(Name a) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(UserEntity t, ConstraintValidatorContext cvc) {
        if(t.getFirstname()!=null && t.getLastname()!=null) {
             return true;
        }
        return null == t.getFirstname() && null == t.getLastname();
    }
}
