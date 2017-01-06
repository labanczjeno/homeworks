
package xyz.codingmentor.beanvalidationhw.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DeviceDB {
    private final Map<String, Device> devices = new HashMap<>();
    
    public Device addDevice(Device device) {
            device.setId(UUID.randomUUID().toString());
            device.setCount(0);
            devices.put(device.getId(), device);
            return devices.get(device.getId());
    }

    public Device modDevice(Device device) {
            devices.replace(device.getId(), device);
            return devices.get(device.getId());
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
