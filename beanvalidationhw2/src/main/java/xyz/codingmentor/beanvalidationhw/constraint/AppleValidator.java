
package xyz.codingmentor.beanvalidationhw.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beanvalidationhw.beans.Color;
import xyz.codingmentor.beanvalidationhw.beans.DeviceEntity;
import xyz.codingmentor.beanvalidationhw.beans.Manufacturer;

public class AppleValidator implements ConstraintValidator<Apple, DeviceEntity> {

    @Override
    public void initialize(Apple a) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(DeviceEntity t, ConstraintValidatorContext cvc) {
         if (t.getManufacturer()==Manufacturer.APPLE) {
             return t.getColor()==Color.BLACK || t.getColor()==Color.WHITE;
         }
         return true;
    }
    
}
