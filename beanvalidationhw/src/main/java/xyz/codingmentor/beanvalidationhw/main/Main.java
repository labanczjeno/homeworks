
package xyz.codingmentor.beanvalidationhw.main;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.beanvalidationhw.beans.Cart;
import xyz.codingmentor.beanvalidationhw.beans.Device;
import xyz.codingmentor.beanvalidationhw.beans.DeviceDB;
import xyz.codingmentor.beanvalidationhw.beans.UserDB;
import xyz.codingmentor.beanvalidationhw.beans.UserEntity;

public class Main {
    
    private static DeviceDB deviceDB;
    private static UserDB userDB;
    private static Weld weld;
    private static WeldContainer container;
    
    private Main(){
        //hiding public constructor
    }
    
    public static void main(String[] args) throws IOException{       
        
        List<UserEntity> listOfUsers = null;
        List<Device> listOfDevices = null;
        ObjectMapper mapper = new ObjectMapper();
        JavaType userType = mapper.getTypeFactory().constructCollectionType(List.class, UserEntity.class);
        JavaType deviceType = mapper.getTypeFactory().constructCollectionType(List.class, Device.class);

        try {
            listOfDevices = mapper.readValue(new File("device.json"), deviceType);
            listOfUsers = mapper.readValue(new File("users.json"), userType);
            userDB = container.instance().select(UserDB.class).get();
            for (UserEntity user : listOfUsers) {
                userDB.addUser(user);
            }
            deviceDB = container.instance().select(DeviceDB.class).get();
            for (Device device : listOfDevices) {
                deviceDB.addDevice(device);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        weld = new Weld();
        container = weld.initialize();
        Cart cart = container.instance().select(Cart.class).get();
        cart.addDevice(2, "HTC");
        cart.removeDevice(1, "APPLE");
        cart.getFullPriceOfCart();
        cart.buy();
        weld.shutdown();
    }
}

