
package xyz.codingmentor.notnull.jeno.beans;

import xyz.codingmentor.notnull.jeno.constraint.NotNullWithException;

/**
 *
 * @author blazefury
 */
public class CustomClass {

    String name;
    @NotNullWithException
    int age;

    public CustomClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
