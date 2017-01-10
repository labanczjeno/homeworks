
package xyz.codingmentor.carfactoryy.beans;

import xyz.codingmentor.carfactoryy.constraint.ErroneousVehicle;

/**
 *
 * @author blazefury
 */
@ErroneousVehicle
public class RearViewMirror extends Parts{

    public RearViewMirror(Car car) {
        super(car);
    }

    @Override
    public void part() {
        this.part=Part.REARVIEW_MIRROR;
    }

}
