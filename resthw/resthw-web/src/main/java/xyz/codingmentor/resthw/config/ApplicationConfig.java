
package xyz.codingmentor.resthw.config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author blazefury
 */
@ApplicationPath("/resthw")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(xyz.codingmentor.resthw.rest.UserRestService.class);
        resources.add(xyz.codingmentor.resthw.exception.GeneralExceptionMapper.class);
    }
    
}
