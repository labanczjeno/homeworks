
package xyz.codingmentor.beanvalidationhw.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import xyz.codingmentor.beanvalidationhw.exceptions.DeviceExistException;
import xyz.codingmentor.beanvalidationhw.exceptions.DeviceNotExistException;
import xyz.codingmentor.beanvalidationhw.interceptor.ValidationCheckInterceptor;

@Interceptors(ValidationCheckInterceptor.class)
public class DeviceDB {
    private final Map<String, Device> devices = new HashMap<>();
    
    @ExcludeClassInterceptors
    public Device addDevice(Device device) {
        if (!devices.containsKey(device.getId())) {
            device.setId(UUID.randomUUID().toString());
            device.setCount(0);
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
    
    public List<Device> getDeviceList() {
        return new ArrayList<>(devices.values());
    }
}
