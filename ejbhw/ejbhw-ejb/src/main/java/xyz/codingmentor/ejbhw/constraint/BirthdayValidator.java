package xyz.codingmentor.ejbhw.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.ejbhw.beans.UserEntity;

public class BirthdayValidator implements ConstraintValidator<Birthday, UserEntity> {

    @Override
    public void initialize(Birthday a) {
        //it's empty becuase we don't have to initialize anything
    }

    @Override
    public boolean isValid(UserEntity userentity, ConstraintValidatorContext cvc) {
        if (userentity.getDateOfBirth() == null) {
            return true;
        }
        return userentity.getDateOfBirth().before(userentity.getRegistrationDate());
    }
}
