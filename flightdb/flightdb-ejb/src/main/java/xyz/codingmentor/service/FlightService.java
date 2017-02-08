package xyz.codingmentor.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.flight.FlightInfo;
import xyz.codingmentor.repository.FlightRepository;
import xyz.codingmentor.api.FlightServiceGiver;

/**
 *
 * @author blazefury
 */
@Stateless
public class FlightService implements FlightServiceGiver {

    private FlightRepository flightRepository;

    public FlightService() {
        //empty on purpose
    }

    @Inject
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightInfo getFlightInfoById(String id) {
        return flightRepository.find(id);
    }

    @Override
    public void addFlightInfo(FlightInfo flightInfo) {
        flightRepository.persist(flightInfo);
    }

    @Override
    public void deleteFlightInfoById(String id) {
        flightRepository.remove(id);
    }

    @Override
    public FlightInfo editFlightInfo(FlightInfo flightInfo) {
       return flightRepository.update(flightInfo);
    }
    
    public List<FlightInfo> getAllFlightInfos(){
        return flightRepository.getAllFlightInfo();
    }

}
