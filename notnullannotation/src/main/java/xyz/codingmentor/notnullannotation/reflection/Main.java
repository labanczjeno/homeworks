
package xyz.codingmentor.notnullannotation.reflection;

/**
 *
 * @author blazefury
 */
public class Main {
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Example example1=new Example("asd",0);
        CheckAnnotation.checkField(Example.class);
    }
    
}
