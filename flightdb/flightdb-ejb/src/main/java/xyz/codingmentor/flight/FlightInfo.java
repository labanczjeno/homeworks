package xyz.codingmentor.flight;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author blazefury
 */
@Entity
@NamedQuery(
        name = "getAllFlightInfos",
        query = "SELECT f FROM FlightInfo f"
)
public class FlightInfo implements Serializable {

    @Id
    private String flightId;
    private String fromDestination;
    private String toDestination;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfTakeOff;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOfDown;

    public FlightInfo() {
        //empty on purpose
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public void setFromDestination(String fromDestination) {
        this.fromDestination = fromDestination;
    }

    public String getToDestination() {
        return toDestination;
    }

    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }

    public Date getTimeOfTakeOff() {
        return timeOfTakeOff;
    }

    public void setTimeOfTakeOff(Date timeOfTakeOff) {
        this.timeOfTakeOff = timeOfTakeOff;
    }

    public Date getTimeOfDown() {
        return timeOfDown;
    }

    public void setTimeOfDown(Date timeOfDown) {
        this.timeOfDown = timeOfDown;
    }

}
