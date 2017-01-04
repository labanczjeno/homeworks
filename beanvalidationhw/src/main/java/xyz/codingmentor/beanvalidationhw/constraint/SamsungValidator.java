
package xyz.codingmentor.beanvalidationhw.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beanvalidationhw.beans.Color;
import xyz.codingmentor.beanvalidationhw.beans.DeviceEntity;
import xyz.codingmentor.beanvalidationhw.beans.Manufacturer;

public class SamsungValidator implements ConstraintValidator<Samsung, DeviceEntity>{

    @Override
    public void initialize(Samsung a) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(DeviceEntity t, ConstraintValidatorContext cvc) {
        if (t.getManufacturer() == Manufacturer.SAMSUNG) {
             return t.getColor() != Color.GREEN;
         }
         return true;
    }  
}
