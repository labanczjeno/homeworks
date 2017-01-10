
package xyz.codingmentor.carfactoryy.beans;

/**
 *
 * @author blazefury
 */
public class Shifter extends Parts{

    public Shifter(Car car) {
        super(car);
    }

    @Override
    public void part() {
        this.part=Part.SHIFTER;
    }

}
