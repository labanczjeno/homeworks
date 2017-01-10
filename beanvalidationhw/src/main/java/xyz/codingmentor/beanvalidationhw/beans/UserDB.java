
package xyz.codingmentor.beanvalidationhw.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.codingmentor.beanvalidationhw.exceptions.UserExistException;
import xyz.codingmentor.beanvalidationhw.exceptions.UserNotExistException;

public class UserDB {
    
    private final Map<String, UserEntity> users = new HashMap<>();
    
    public UserEntity addUser(UserEntity user) {
        if (!users.containsKey(user.getUsername())) {
            Date now = new Date();
            user.setRegistrationDate(now);
            user.setLastModifiedDate(now);
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
    
    public UserEntity editUser(UserEntity user) {
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
    
    public List<UserEntity> getUserList() {
        return new ArrayList<>(users.values());
    }
}
