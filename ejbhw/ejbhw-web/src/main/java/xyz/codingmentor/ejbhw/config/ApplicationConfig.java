package xyz.codingmentor.ejbhw.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author blazefury
 */
@ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.ejbhw.exceptions.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.ejbhw.exceptions.LoginExceptionMapper.class);
        resources.add(xyz.codingmentor.ejbhw.service.CartRESTService.class);
        resources.add(xyz.codingmentor.ejbhw.service.DeviceRESTService.class);
        resources.add(xyz.codingmentor.ejbhw.service.UserRESTService.class);
    }
}
