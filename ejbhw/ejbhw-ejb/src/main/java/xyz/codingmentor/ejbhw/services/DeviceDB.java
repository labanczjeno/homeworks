package xyz.codingmentor.ejbhw.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.ejbhw.beans.Device;
import xyz.codingmentor.ejbhw.exceptions.DeviceExistException;
import xyz.codingmentor.ejbhw.exceptions.DeviceNotExistException;
import xyz.codingmentor.ejbhw.interceptor.ValidationCheckInterceptor;

@Singleton
@Interceptors(ValidationCheckInterceptor.class)
public class DeviceDB implements Serializable{

    private final Map<String, Device> devices = new HashMap<>();

    public DeviceDB() {
        //empty on purpose
    }
    
    @ExcludeClassInterceptors
    public Device addDevice(Device device) {
        if (!devices.containsKey(device.getId())) {
            device.setId(UUID.randomUUID().toString());
            device.setCount(10);
            devices.put(device.getId(), device);
            return devices.get(device.getId());
        }
        throw new DeviceExistException(device.getId());
    }

    public Device modDevice(Device device) {
        if (devices.containsKey(device.getId())) {
            devices.replace(device.getId(), device);
            return devices.get(device.getId());
        }
        throw new DeviceNotExistException(device.getId());
    }

    public Device getDevice(String id) {
        return devices.get(id);
    }

    public Device removeDevice(Device device) {
        return devices.remove(device.getId());
    }

    @ExcludeClassInterceptors
    public List<Device> getDeviceList() {
        return new ArrayList<>(devices.values());
    }
}
