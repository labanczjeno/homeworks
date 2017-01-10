
package xyz.codingmentor.carfactoryy.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *
 * @author blazefury
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface ErroneousVehicle {
    
}
