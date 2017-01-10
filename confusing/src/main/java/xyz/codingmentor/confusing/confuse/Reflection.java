
package xyz.codingmentor.confusing.confuse;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflection {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private Reflection() {
        //empty on purpose
    }

    public static void analyze(final Class<?> clazz) {
        Confusion annotationClass = clazz.getAnnotation(Confusion.class);
        if (annotationClass!=null) {
            LOGGER.log(Level.INFO, "Class name: {0}, Package: {1}, Super class: {2}, Methods: ", new Object[]{clazz.getName(), clazz.getPackage(), clazz.getSuperclass()});
        }

        for (final Method method : clazz.getDeclaredMethods()) {
            Confusion annotation = method.getAnnotation(Confusion.class);
            if (annotation!=null) {
                LOGGER.log(Level.INFO, "name: {0}, parameters: {2}, return type: {2}", new Object[]{method.getName(), method.getParameterCount(), method.getReturnType()});
            }
        }
    }
}
