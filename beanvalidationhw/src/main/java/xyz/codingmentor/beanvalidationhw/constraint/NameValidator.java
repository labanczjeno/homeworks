
package xyz.codingmentor.beanvalidationhw.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beanvalidationhw.beans.UserEntity;

public class NameValidator implements ConstraintValidator<Name, UserEntity>  {

    @Override
    public void initialize(Name a) {
        //it's empty becuase we don't have to initialize anything
    }

    @Override
    public boolean isValid(UserEntity user, ConstraintValidatorContext cvc) {
        boolean bothNameFilled=user.getFirstname()!=null && user.getLastname()!=null;
        boolean nothingFilled=user.getFirstname()==null && user.getLastname()==null;
        return bothNameFilled||nothingFilled;
    }
}