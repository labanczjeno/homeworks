
package xyz.codingmentor.notnullannotation.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author blazefury
 */
public class CheckAnnotation {
    
    public static void checkField(Class<?> clazz) throws IllegalArgumentException, IllegalAccessException{
        for (Field field:clazz.getDeclaredFields()) {
            if (field.getDeclaredAnnotations().equals(NotNullWithException.class)) {
                field.get(field);
                if (null == field) {
                    throw new FieldCantBeNullException("field cant be null");
                }
            }
        } 
    }  
}
