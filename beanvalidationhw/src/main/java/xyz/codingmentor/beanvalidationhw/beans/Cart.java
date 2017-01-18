
package xyz.codingmentor.beanvalidationhw.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.beanvalidationhw.exceptions.CountException;
import xyz.codingmentor.beanvalidationhw.exceptions.NotExistsException;

/**
 *
 * @author blazefury
 */
public class Cart {
    
    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());
    private DeviceDB deviceDB;
    private int price;
    Map<Device, Integer> devices = new HashMap<>();
    
    public void addDevice(int count, String id){
        
        Device device = deviceDB.getDevice(id);
        if (count < device.getCount()) {
            devices.put(device, count);
            device.setCount(device.getCount() - count);
            deviceDB.modDevice(device);
            price += count * device.getPrice();
        }
        throw new CountException(device.getId());   
    }
    
    public void removeDevice(int count, String id){
        
        Device device = deviceDB.getDevice(id);
        if (devices.containsKey(device)) {
            if (count < devices.get(device)) {
                price -= count * device.getPrice();
                device.setCount(device.getCount() + count);
                deviceDB.modDevice(device);
                devices.put(device, devices.get(device) - count);
            } else {
                price -= devices.get(device) * device.getPrice();
                device.setCount(device.getCount() + devices.get(device));
                deviceDB.modDevice(device);
                devices.remove(device, count);
            }
        }
        throw new NotExistsException(device.getId());    
    }
    
    public void buy(){
        
       if (devices!=null) {
        String buyMessage=" ";
        buyMessage = devices.entrySet().stream().map((entry) ->entry.getValue() + " " + entry.getKey().getManufacturer() + " " + entry.getKey().getType()).reduce(buyMessage, String::concat);
            LOGGER.log(Level.WARNING, buyMessage);
                devices.clear();
                price = 0;
        }
        devices.clear();
    }
}
