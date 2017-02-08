package xyz.codingmentor.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.flight.FlightInfo;

/**
 *
 * @author blazefury
 */
@Stateless
public class FlightRepository {

    @PersistenceContext(name = "flightdbPU")
    private EntityManager entityManager;

    public FlightRepository() {
        //empty on purpose
    }

    public List<FlightInfo> getAllFlightInfo() {
        return entityManager.createNamedQuery("getAllFlightInfos").getResultList();
    }

    public void persist(FlightInfo flightInfo) {
        entityManager.persist(flightInfo);
    }

    public FlightInfo find(String id) {
        return entityManager.find(FlightInfo.class, id);
    }

    public void remove(String id) {
        entityManager.remove(find(id));
    }

    public FlightInfo update(FlightInfo flightInfo) {
        return entityManager.merge(flightInfo);
    }

}
