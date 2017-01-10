
package xyz.codingmentor.carfactoryy.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.carfactoryy.constraint.PartNotFoundException;

/**
 *
 * @author blazefury
 */
public class CarFactory {
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private CarFactory() {
        //default constructor hide
    }

    public static Parts create(Part part, Car car) {
        Parts make;
        switch (part) {
            case SHIFTER:
                make = new Shifter(car);
                break;
            case ELECTRIC_WINDOW:
                make = new ElectricWindow(car);
                break;
            case REARVIEW_MIRROR:
                make = new RearViewMirror(car);
                break;
            case INDEX:
                make = new Index(car);
                break;
            default:
                throw new PartNotFoundException();
        }
        LOGGER.log(Level.INFO, "Created: {0}", make.toString());
        return make;
    }
}
