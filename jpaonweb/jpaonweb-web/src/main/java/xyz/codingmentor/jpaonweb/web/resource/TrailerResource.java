package xyz.codingmentor.jpaonweb.web.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaonweb.ejb.entity.Trailer;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.service.TrailerService;

/**
 * REST Web Service
 *
 * @author blazefury
 */
@Path("Trailer")
@Produces(MediaType.APPLICATION_JSON)
public class TrailerResource {

    @Inject
    private TrailerService trailerService;

    @GET
    @Path("/{id}")
    public Response getTrailerById(@PathParam("id") int id) throws RepositoryException {
        Trailer trailer = trailerService.getTrailerById(id);
        if (null != trailer) {
            return Response.ok(trailer).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrailer(Trailer trailer) throws RepositoryException {
        trailerService.addTrailer(trailer);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTrailer(Trailer trailer) throws RepositoryException {
        trailerService.editTrailer(trailer);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeTrailerById(@PathParam("id") int id) throws RepositoryException {
        if (null != trailerService.getTrailerById(id)) {
            trailerService.removeTrailer(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/trailerFilm")
    public Response selectTrailerByFilm(@QueryParam("titleofFilm") String titleOfFilm) throws RepositoryException {
        List<Trailer> trailers = trailerService.selectTrailerByFilm(titleOfFilm);
        return Response.ok(trailers).build();
    }

}
