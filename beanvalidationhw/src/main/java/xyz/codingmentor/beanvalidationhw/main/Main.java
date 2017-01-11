
package xyz.codingmentor.beanvalidationhw.main;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.beanvalidationhw.beans.Device;
import xyz.codingmentor.beanvalidationhw.beans.UserEntity;

public class Main {

    public Main() {
        //hiding default constructor
    }

    public static void main(String[] args) {
        
        List<UserEntity> listOfUsers = null;
        List<Device> listOfDevices = null;
        ObjectMapper mapper = new ObjectMapper();
        JavaType userType = mapper.getTypeFactory().constructCollectionType(List.class, UserEntity.class);
        JavaType deviceType = mapper.getTypeFactory().constructCollectionType(List.class, Device.class);

        try {
            listOfDevices = mapper.readValue(new File("device.json"), deviceType);
            listOfUsers = mapper.readValue(new File("users.json"), userType);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
