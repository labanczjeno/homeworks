
package xyz.codingmentor.notnullannotation.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author blazefury
 */
public class CheckAnnotation {
    
    public static void checkField(Class<?> clazz){
        
        for (Field field:clazz.getDeclaredFields()) {
            NotNullWithException annotationField=field.getAnnotation(NotNullWithException.class);
            if (annotationField==null) {
                throw new FieldCantBeNullException("Field cant be null.");
            }
        }
    }   
}
