
package xyz.codingmentor.carfactoryy.beans;

/**
 *
 * @author blazefury
 */
public class ElectricWindow extends Parts{

    public ElectricWindow(Car car) {
        super(car);
    }

    @Override
    public void part() {
        this.part=Part.ELECTRIC_WINDOW;
    }
}
