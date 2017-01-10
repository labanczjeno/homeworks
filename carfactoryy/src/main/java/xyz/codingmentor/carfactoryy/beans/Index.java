
package xyz.codingmentor.carfactoryy.beans;

import xyz.codingmentor.carfactoryy.constraint.ErroneousVehicle;

/**
 *
 * @author blazefury
 */
@ErroneousVehicle
public class Index extends Parts{

    public Index(Car car) {
        super(car);
    }

    @Override
    public void part() {
        this.part=Part.INDEX;
    }

}
