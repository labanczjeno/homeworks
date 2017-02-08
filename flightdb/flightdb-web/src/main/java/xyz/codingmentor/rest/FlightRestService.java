package xyz.codingmentor.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.flight.FlightInfo;
import xyz.codingmentor.message.FlightMessageBean;
import xyz.codingmentor.service.FlightService;

/**
 * REST Web Service
 *
 * @author blazefury
 */
@Path("flightservice")
@Stateless
public class FlightRestService {

    private FlightService flightService;
    private FlightMessageBean flightMessageBean;

    public FlightRestService(){
        //empty on purpose
    }
    
    @Inject
    public FlightRestService(FlightService flightService, FlightMessageBean flightMessageBean) {
        this.flightService = flightService;
        this.flightMessageBean = flightMessageBean;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlightInfoById(@PathParam("id") String id) {
        FlightInfo flightInfo = flightService.getFlightInfoById(id);
        return Response.ok().entity(flightInfo).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFlightInfo(FlightInfo flightInfo) {
        flightService.addFlightInfo(flightInfo);
        return Response.ok().entity(flightInfo).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFlightInfo(@PathParam("id") String id) {
        flightService.deleteFlightInfoById(id);
        flightMessageBean.messageWhenDeletedTheFlightInfo(flightService.getFlightInfoById(id));
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFlightInfo(FlightInfo flightInfo) {
        flightService.editFlightInfo(flightInfo);
        flightMessageBean.messageWhenEditedTheFlightInfo(flightInfo);
        return Response.ok().entity(flightInfo).build();
    }

}
