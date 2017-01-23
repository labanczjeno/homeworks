
package xyz.codingmentor.notnullannotation.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author blazefury
 */
public class CheckAnnotation {
//    public static void checkObject(final Class<?> clazz) throws IllegalArgumentException, IllegalAccessException {
//            for (Field f : clazz.getFields()) {
//                if (f.isAnnotationPresent(NotNullWithException.class) && f.get(clazz)==null) {
//                        throw new FieldCantBeNullException("field cant be null");
//                }
//            }
//    }
    
    
    
    public static <T> T checkObject(T t) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        for (Field field: t.getClass().getFields()) {
            if (field.isAnnotationPresent(NotNullWithException.class)) {
                Object value = field.get(t);
                if (value==null) {
                    throw new FieldCantBeNullException("field cant be null");
                }
            }
        }
        return t;
    } 
}
