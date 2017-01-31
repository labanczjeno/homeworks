package xyz.codingmentor.ejbhw.beans;

import xyz.codingmentor.ejbhw.services.DeviceDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeviceDBTest {

    private DeviceDB deviceDB;
    private Device device1;
    private Device device2;

    @Before
    public void setUp() {
        deviceDB = new DeviceDB();
        device1 = new Device.Builder()
                .manufacturer(Manufacturer.HTC)
                .type("htc")
                .price(1000)
                .color(Color.PURPLE)
                .count(2)
                .build();
        device2 = new Device.Builder()
                .manufacturer(Manufacturer.APPLE)
                .type("4")
                .price(1000)
                .color(Color.BLACK)
                .count(5)
                .build();
    }

    @Test
    public void testGetAllDevice() {
        deviceDB.addDevice(device1);
        deviceDB.addDevice(device2);
        List<Device> deviceEntities = new ArrayList<>();
        deviceEntities.add(device1);
        deviceEntities.add(device2);
        List<Device> returnedDeviceEntities = deviceDB.getDeviceList();
        Assert.assertEquals(returnedDeviceEntities, deviceEntities);
    }

    @Test
    public void testAddDevice() {
        deviceDB.addDevice(device1);
        Assert.assertEquals(device1, deviceDB.getDevice(device1.getId()));
    }

    @Test
    public void testModDevice() {
        deviceDB.addDevice(device1);
        deviceDB.addDevice(device2);
        device2.setType("5");
        device2.setPrice(7000);
        device2.setCount(3);
        Device modifiedDeviceEntity = deviceDB.modDevice(device2);
        Assert.assertEquals(modifiedDeviceEntity, device2);
    }

    @Test
    public void testGetDevice() {
        deviceDB.addDevice(device2);
        Device returnedDeviceEntity = deviceDB.getDevice(device2.getId());
        Assert.assertEquals(device2, returnedDeviceEntity);
    }

    @Test
    public void testDeleteDevice() {
        deviceDB.addDevice(device1);
        deviceDB.addDevice(device2);
        Device deletedDeviceEntity = deviceDB.removeDevice(device1);
        Assert.assertEquals(deletedDeviceEntity, device1);
    }
}
