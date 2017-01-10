
package xyz.codingmentor.beanvalidationhw.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.codingmentor.beanvalidationhw.beans.Gender;
import xyz.codingmentor.beanvalidationhw.beans.UserDB;
import xyz.codingmentor.beanvalidationhw.beans.UserEntity;

public class UserDBTest {
    
    private UserDB userDB;
    private UserEntity firstUser;
    private UserEntity secondUser;
    
    private Calendar birthdays;
    private Calendar registrations;
    
    private Date dateOfBirth;
    private Date registrationDate;
    private Date lastModifiedDate;
    
    @Before
    public void setUpTests() {
        userDB = new UserDB();
        birthdays = new GregorianCalendar(1993, 1, 2, 3, 4);
        dateOfBirth = birthdays.getTime();
        registrations = new GregorianCalendar();
        registrations.add(Calendar.SECOND, -5);
        registrationDate = registrations.getTime();
        lastModifiedDate = registrationDate;
        firstUser = new UserEntity.Builder()
                .username("labanczjeno")
                .password("Xyz345")
                .address("1041 Bp")
                .phone("+36304221267")
                .email("labanczjeno@gmail.com")
                .gender(Gender.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(lastModifiedDate)
                .dateOfBirth(dateOfBirth)
                .admin(true)
                .build();
        secondUser = new UserEntity.Builder()
                .username("eszete")
                .password("Xyz456")
                .address("1034 Bp")
                .phone("06304112345")
                .email("eszete@gmail.com")
                .gender(Gender.FEMALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(lastModifiedDate)
                .dateOfBirth(dateOfBirth)
                .admin(false)
                .build();
    }
    
    @Test
    public void loginTest() {
        userDB.addUser(firstUser);
        Assert.assertEquals(true, userDB.authenticate("labanczjeno", "Xyz345"));
    }
    
    @Test
    public void modUserTest() {
        UserDB userdb=new UserDB();
        
        UserEntity user = new UserEntity.Builder()
                .username("labanczjeno")
                .password("Xyz123")
                .firstname("Labancz")
                .lastname("Jeno")
                .address("1041Bp")
                .phone("06304235678")
                .email("labanczjeno@gmail.com")
                .gender(Gender.MALE)
                .registrationDate(registrationDate)
                .lastModifiedDate(lastModifiedDate)
                .dateOfBirth(dateOfBirth)
                .build();

        userDB.addUser(user);
        boolean isUser = userDB.authenticate("labanczjeno", "Xyz123");
        Assert.assertEquals(true, isUser);
    }
    
    @Test
    public void rmUserTest() {
        userDB.addUser(firstUser);
        userDB.addUser(secondUser);
        UserEntity deletedUserEntity = userDB.deleteUser(firstUser);
        Assert.assertEquals(deletedUserEntity, firstUser);
    }
    
    @Test
    public void getUserListTest() {
        userDB.addUser(firstUser);
        userDB.addUser(secondUser);
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(firstUser);
        userEntities.add(secondUser);
        List<UserEntity> returnedUserEntities = userDB.getUserList();
        Assert.assertEquals(returnedUserEntities, userEntities);
    }
    
    @Test
    public void testAddUser() {
        userDB.addUser(firstUser);
        Assert.assertEquals(firstUser, userDB.getUser("labanczjeno"));
    }
    
    @Test
    public void testGetUser() {
        userDB.addUser(secondUser);
        UserEntity returnedUserEntity = userDB.getUser(secondUser.getUsername());
        Assert.assertEquals(returnedUserEntity, secondUser);
    }
}
