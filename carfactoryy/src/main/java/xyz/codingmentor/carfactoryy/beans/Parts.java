
package xyz.codingmentor.carfactoryy.beans;

/**
 *
 * @author blazefury
 */
public abstract class Parts {
    protected Part part;
    private final Car car;
    private boolean erroneouspart;

    public Parts(Car car) {
        this.car = car;
    }
    
    public Car getCar() {
        return car;
    }

    public boolean isErroneousPart() {
        return erroneouspart;
    }

    public void erroneousPart(boolean erroneouspart) {
        this.erroneouspart = erroneouspart;
    }
    
    public abstract void part();

    @Override
    public String toString() {
        return "Parts{" + "part=" + part + ", car=" + car + ", faultyPart=" + erroneouspart + '}';
    }

}
