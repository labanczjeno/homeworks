
package xyz.codingmentor.beanvalidationhw.interceptor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import xyz.codingmentor.beanvalidationhw.constraint.Check;
import xyz.codingmentor.beanvalidationhw.exceptions.ValidationException;

/**
 *
 * @author blazefury
 */
@Interceptor
@ValidationInterceptorBinding
public class ValidationCheckInterceptor {
    
    @Inject
    private Validator validator;
    
    @AroundInvoke
     public Object beanValidator(InvocationContext ic) throws Exception {
        validateAnnotatedParameters(ic.getParameters());
        return ic.proceed();
    }
 
    private void validateAnnotatedParameters(Object[] parameters) {
        Arrays.asList(parameters).stream().filter(p -> p.getClass().isAnnotationPresent(Check.class)).forEach(p -> validateBean(p));
    }
 
    private void validateBean(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        Optional<String> message = violations.stream().map((ConstraintViolation<Object> e) -> e.getMessage()).reduce(String::concat);
        if (message.isPresent()) {
            throw new ValidationException(message.get());
        }
    }
}
