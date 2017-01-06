
package xyz.codingmentor.beanvalidationhw.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AppleValidator.class)
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface Apple {
    String message() default "{Apple.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
