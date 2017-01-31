package xyz.codingmentor.ejbhw.services;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.ejbhw.beans.Device;
import xyz.codingmentor.ejbhw.beans.UserEntity;

/**
 *
 * @author blazefury
 */
@Singleton
@Startup
public class JsonFileReader {

    private static final Logger LOG = Logger.getLogger(JsonFileReader.class.getName());

    @Inject
    private UserDB userDb;
    @Inject
    private DeviceDB deviceDb;
    private List<UserEntity> userList = null;
    private List<Device> deviceList = null;
    private ObjectMapper mapper;
    private JavaType userType;
    private JavaType deviceType;

    @PostConstruct
    private void initialize() {
        mapper = new ObjectMapper();
        userType = mapper.getTypeFactory().constructCollectionType(List.class, UserEntity.class);
        deviceType = mapper.getTypeFactory().constructCollectionType(List.class, Device.class);
        readJsonFiles();
        fill();
        LOG.info("initializing is done");
    }

    private void readJsonFiles() {
        try {
            userList = mapper.readValue(new File(getClass().getClassLoader().getResource("users.json").getFile()), userType);
            deviceList = mapper.readValue(new File(getClass().getClassLoader().getResource("devices.json").getFile()), deviceType);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    private void fill() {
        int count;
        for (Device device : deviceList) {
            count = device.getCount();
            deviceDb.addDevice(device);
            device.setCount(count);
        }
        for (UserEntity user: userList) {
            userDb.addUser(user);
        }
    }

}
