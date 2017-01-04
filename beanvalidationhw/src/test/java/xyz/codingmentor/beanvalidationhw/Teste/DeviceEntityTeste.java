
package xyz.codingmentor.beanvalidationhw.Teste;

import java.util.Set;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import xyz.codingmentor.beanvalidationhw.beans.Device;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import org.junit.Assert;
import xyz.codingmentor.beanvalidationhw.beans.Color;
import xyz.codingmentor.beanvalidationhw.beans.Manufacturer;

public class DeviceEntityTeste {
    private static ValidatorFactory vf;
    private static Validator validator;
    private Device device = new Device.Builder()
                .id(UUID.randomUUID().toString())
                .manufacturer(Manufacturer.HTC)
                .type("Right")
                .price(8800)
                .color(Color.BLACK)
                .count(5)
                .build();
    
    @BeforeClass
    public static void buildClass() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }
    
    @AfterClass
    public static void closeClass() {
        vf.close();
    }

    @Test
    public void goodManufacturer() {
        device.setManufacturer(Manufacturer.APPLE);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badManufacturer() {
        device.setManufacturer(null);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void goodType() {
        device.setType("xyz");
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badType() {
        device.setType("s7");
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("s7", violations.iterator().next().getInvalidValue());
    }

    @Test
    public void goodPrice() {
        device.setPrice(1);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badPrice() {
        device.setPrice(0);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(0, violations.iterator().next().getInvalidValue());
    }
    @Test
    public void goodSamsung() {
        device.setManufacturer(Manufacturer.SAMSUNG);
        device.setColor(Color.BLACK);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badSamsung() {
        device.setManufacturer(Manufacturer.SAMSUNG);
        device.setColor(Color.GREEN);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
    }
    @Test
    public void goodColor() {
        device.setColor(Color.GREEN);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badColor() {
        device.setColor(null);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void goodApple() {
        device.setManufacturer(Manufacturer.APPLE);
        device.setColor(Color.WHITE);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badApple() {
        device.setManufacturer(Manufacturer.APPLE);
        device.setColor(Color.BLUE);
        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
    }  
}
