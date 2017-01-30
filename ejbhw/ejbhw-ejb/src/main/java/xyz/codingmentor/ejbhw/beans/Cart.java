package xyz.codingmentor.ejbhw.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;
import xyz.codingmentor.ejbhw.exceptions.CountException;
import xyz.codingmentor.ejbhw.exceptions.NotExistsException;

/**
 *
 * @author blazefury
 */
@Stateful
public class Cart implements Serializable{

    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());
    @Inject
    private DeviceDB deviceDB;
    private int price;
    private Map<Device, Integer> devices = new HashMap<>();

    public Cart() {
        //empty on purpose
    }
    
    public Device addDevice(int count, String id) {

        Device device = deviceDB.getDevice(id);
        if (count < device.getCount()) {
            devices.put(device, count);
            device.setCount(device.getCount() - count);
            deviceDB.modDevice(device);
            price += count * device.getPrice();
        }
        throw new CountException(device.getId());
    }

    public Device removeDevice(int count, String id) {

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

    public int getFullPriceOfCart() {
        return price;
    }

    @Remove
    public void buy() {

        if (devices != null) {
            String buyMessage = " ";
            buyMessage = devices.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey().getManufacturer() + " " + entry.getKey().getType()).reduce(buyMessage, String::concat);
            LOGGER.log(Level.WARNING, buyMessage);
            devices.clear();
            price = 0;
        }
        devices.clear();
    }
}
