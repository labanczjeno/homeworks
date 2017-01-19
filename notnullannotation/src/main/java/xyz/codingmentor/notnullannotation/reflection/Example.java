
package xyz.codingmentor.notnullannotation.reflection;


/**
 *
 * @author blazefury
 */
public class Example {
    private String name;
    @NotNullWithException
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
