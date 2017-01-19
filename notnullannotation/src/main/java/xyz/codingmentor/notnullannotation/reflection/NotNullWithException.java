
package xyz.codingmentor.notnullannotation.reflection;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 *
 * @author blazefury
 */

@Retention(RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface NotNullWithException {

}
