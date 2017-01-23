
package xyz.codingmentor.notnullannotation.reflection;

/**
 *
 * @author blazefury
 */
public class Main {
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException{
        Example example1=new Example();
        example1.setAge(null);
        example1.setName(null);
        System.out.println(example1.getName()+" "+example1.getName());
        CheckAnnotation.checkObject(example1);
        
    }
}
