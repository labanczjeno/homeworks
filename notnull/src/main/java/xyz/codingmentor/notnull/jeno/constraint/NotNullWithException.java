
package xyz.codingmentor.notnull.jeno.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author blazefury
 */
@Constraint(validatedBy = NotNullValidator.class)
@Target({ElementType.FIELD})
@Retention(RUNTIME)
public @interface NotNullWithException {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
