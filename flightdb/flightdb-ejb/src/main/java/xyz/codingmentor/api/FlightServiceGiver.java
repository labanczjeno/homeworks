
package xyz.codingmentor.api;

import xyz.codingmentor.flight.FlightInfo;

/**
 *
 * @author blazefury
 */
public interface FlightServiceGiver {

    FlightInfo getFlightInfoById(String id);
    
    void addFlightInfo(FlightInfo flightInfo);
    
    void deleteFlightInfoById(String id);
    
    FlightInfo editFlightInfo(FlightInfo flightInfo);
    
}
