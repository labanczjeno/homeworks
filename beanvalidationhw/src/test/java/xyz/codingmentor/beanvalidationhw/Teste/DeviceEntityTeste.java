
package xyz.codingmentor.beanvalidationhw.Teste;

import java.util.Set;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import xyz.codingmentor.beanvalidationhw.beans.DeviceEntity;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import org.junit.Assert;
import xyz.codingmentor.beanvalidationhw.beans.Color;
import xyz.codingmentor.beanvalidationhw.beans.Manufacturer;

public class DeviceEntityTeste {
    private static ValidatorFactory vf;
    private static Validator validator;
    private DeviceEntity t = new DeviceEntity.Builder()
                .id(UUID.randomUUID().toString())
                .manufacturer(Manufacturer.APPLE)
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
        t.setManufacturer(Manufacturer.APPLE);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badManufacturer() {
        t.setManufacturer(null);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void goodType() {
        t.setType("xyz");
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badType() {
        t.setType("s7");
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("s7", violations.iterator().next().getInvalidValue());
    }

    @Test
    public void goodPrice() {
        t.setPrice(1);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badPrice() {
        t.setPrice(0);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(0, violations.iterator().next().getInvalidValue());
    }
    @Test
    public void goodSamsung() {
        t.setManufacturer(Manufacturer.SAMSUNG);
        t.setColor(Color.BLACK);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badSamsung() {
        t.setManufacturer(Manufacturer.SAMSUNG);
        t.setColor(Color.GREEN);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(1, violations.size());
    }
    @Test
    public void goodColor() {
        t.setColor(Color.GREEN);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badColor() {
        t.setColor(null);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void goodApple() {
        t.setManufacturer(Manufacturer.APPLE);
        t.setColor(Color.WHITE);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badApple() {
        t.setManufacturer(Manufacturer.APPLE);
        t.setColor(Color.BLUE);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(t);
        Assert.assertEquals(1, violations.size());
    }  

}
