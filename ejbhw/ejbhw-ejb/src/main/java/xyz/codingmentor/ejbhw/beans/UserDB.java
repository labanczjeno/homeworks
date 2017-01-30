package xyz.codingmentor.ejbhw.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.ejbhw.exceptions.UserExistException;
import xyz.codingmentor.ejbhw.exceptions.UserNotExistException;
import xyz.codingmentor.ejbhw.interceptor.ValidationCheckInterceptor;

@Singleton
@Interceptors(ValidationCheckInterceptor.class)
public class UserDB implements Serializable{

    private final Map<String, UserEntity> users = new HashMap<>();

    public UserDB() {
        //empty on purpose
    }
    
    @ExcludeClassInterceptors
    public UserEntity addUser(UserEntity user) {
        if (!users.containsKey(user.getUsername())) {
            user.setRegistrationDate(Calendar.getInstance().getTime());
            user.setLastModifiedDate(user.getRegistrationDate());
            users.put(user.getUsername(), user);
            return users.get(user.getUsername());
        }
        throw new UserExistException(user.getUsername());
    }

    public UserEntity getUser(String user) {
        return users.get(user);
    }

    public boolean authenticate(String user, String pw) {
        return users.containsKey(user) && pw.equals(users.get(user).getPassword());
    }

    public UserEntity modUser(UserEntity user) {
        if (users.containsKey(user.getUsername())) {
            user.setLastModifiedDate(new Date());
            users.replace(user.getUsername(), user);
            return users.get(user.getUsername());
        }
        throw new UserNotExistException(user.getUsername());
    }

    public UserEntity deleteUser(UserEntity user) {
        return users.remove(user.getUsername());
    }

    @ExcludeClassInterceptors
    public List<UserEntity> getUserList() {
        return new ArrayList<>(users.values());
    }
}
