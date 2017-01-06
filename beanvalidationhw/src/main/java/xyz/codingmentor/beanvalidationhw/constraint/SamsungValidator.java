
package xyz.codingmentor.beanvalidationhw.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beanvalidationhw.beans.Color;
import xyz.codingmentor.beanvalidationhw.beans.Device;
import xyz.codingmentor.beanvalidationhw.beans.Manufacturer;

public class SamsungValidator implements ConstraintValidator<Samsung, Device>{

    @Override
    public void initialize(Samsung a) {
        //it's empty becuase we don't have to initialize anything
    }

    @Override
    public boolean isValid(Device device, ConstraintValidatorContext cvc) {
        if (device.getManufacturer() == Manufacturer.SAMSUNG) {
             return device.getColor() != Color.GREEN;
         }
         return true;
    }  
}
