
package xyz.codingmentor.notnullannotation.reflection;


/**
 *
 * @author blazefury
 */
public class Example {
    @NotNullWithException
    public String name;
    @NotNullWithException
    public String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    
    
}
