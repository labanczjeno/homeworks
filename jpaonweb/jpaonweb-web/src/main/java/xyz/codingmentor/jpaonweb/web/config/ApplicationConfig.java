package xyz.codingmentor.jpaonweb.web.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author blazefury
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.jpaonweb.web.resource.ActorResource.class);
        resources.add(xyz.codingmentor.jpaonweb.web.resource.CategoryResource.class);
        resources.add(xyz.codingmentor.jpaonweb.web.resource.FilmResource.class);
        resources.add(xyz.codingmentor.jpaonweb.web.resource.TrailerResource.class);
    }

}
