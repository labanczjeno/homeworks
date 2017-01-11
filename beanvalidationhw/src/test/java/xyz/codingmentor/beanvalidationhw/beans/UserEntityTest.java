
package xyz.codingmentor.beanvalidationhw.beans;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserEntityTest {
    
    private static ValidatorFactory vf;
    private static Validator validator;
    private Calendar birthDayCalendar;
    private Calendar redDayCalendar= new GregorianCalendar();
    private Date birthDay;
    private Date regDay= redDayCalendar.getTime();
    private Date modDay= regDay;
    private UserEntity user = new UserEntity.Builder()
                .username("labanczjeno")
                .password("Xyz111")
                .address("1041 Bp")
                .phone("+36304221771")
                .email("labanczjeno@gmail.com")
                .gender(Gender.MALE)
                .registrationDate(regDay)
                .lastModifiedDate(modDay)
                .dateOfBirth(birthDay)
                .admin(false)
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
    
    @Before
    public void example() {
        redDayCalendar = new GregorianCalendar();
        redDayCalendar.add(Calendar.SECOND, -1);
        regDay = redDayCalendar.getTime();
        modDay = regDay;
        user = new UserEntity.Builder()
                .username("labanczjeno")
                .password("Xyz111")
                .address("1041 Bp")
                .phone("+36304221771")
                .email("labanczjeno@gmail.com")
                .gender(Gender.MALE)
                .registrationDate(regDay)
                .lastModifiedDate(modDay)
                .dateOfBirth(birthDay)
                .admin(false)
                .build();
    }
    
    @Test
    public void goodUser() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badUser() {
        user.setUsername("xyz");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("xyz", violations.iterator().next().getInvalidValue());
    }
    
    @Test
    public void goodRegDate() {
        Calendar goodOne = new GregorianCalendar(2015, 2, 10);
        Date validRegistrationDate = goodOne.getTime();
        user.setRegistrationDate(validRegistrationDate);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badRegDate() {
        Calendar badOne = new GregorianCalendar();
        badOne.add(Calendar.DAY_OF_MONTH, 1);
        Date badDate = badOne.getTime();
        user.setRegistrationDate(badDate);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(badDate, violations.iterator().next().getInvalidValue());
    }
    
    
    @Test
    public void goodBirthday() {
        user.setDateOfBirth(null);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badBirthday() {
        birthDayCalendar = new GregorianCalendar();
        birthDayCalendar.add(Calendar.MONTH, 3);
        birthDay = birthDayCalendar.getTime();
        user.setDateOfBirth(birthDay);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{Birthday.message}", violations.iterator().next().getMessageTemplate());
    }
    
    @Test
    public void goodPword() {
        user.setPassword("Xyz123+");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badPword() {
        user.setPassword("xyz123");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("xyz123", violations.iterator().next().getInvalidValue());
    }
    
    @Test
    public void goodName() {
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());        
    }
    
    @Test
    public void badName() {
        user.setLastname("xyz");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("{Name.message}", violations.iterator().next().getMessageTemplate());
    }
    
    @Test
    public void goodAddress() {
        user.setAddress(null);
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());      
    }
    
    @Test
    public void badAddress() {
        user.setAddress("xyz");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("xyz", violations.iterator().next().getInvalidValue()); 
    }
    
    @Test
    public void goodPhone() {
        user.setPhone("+36303214356");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badPhone() {
        user.setPhone("+363021222111111");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("+363021222111111", violations.iterator().next().getInvalidValue());
                
    }
    
    @Test
    public void goodEmail() {
        user.setEmail("labanczjeno@gmail.hu");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(0, violations.size());
    }
    
    @Test
    public void badEmail() {
        user.setEmail("asdqwe.gmail.hu");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("asdqwe.gmail.hu", violations.iterator().next().getInvalidValue());
    }
}
