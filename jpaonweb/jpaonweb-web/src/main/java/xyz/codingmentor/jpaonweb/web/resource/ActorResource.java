package xyz.codingmentor.jpaonweb.web.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaonweb.ejb.entity.Actor;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.service.ActorService;

/**
 * REST Web Service
 *
 * @author blazefury
 */
@Path("actor")
@Produces(MediaType.APPLICATION_JSON)
public class ActorResource {

    @Inject
    private ActorService actorService;

    @GET
    @Path("/{id}")
    public Response getActorById(@PathParam("id") int id) throws RepositoryException {
        Actor actor = actorService.getActorById(id);
        if (null != actor) {
            return Response.ok(actor).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createActor(Actor actor) throws RepositoryException {
        actorService.addActor(actor);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateActor(Actor actor) throws RepositoryException {
        actorService.editActor(actor);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeActorById(@PathParam("id") int id) throws RepositoryException {
        if (null != actorService.getActorById(id)) {
            actorService.removeActor(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/actorsName")
    public Response selectActorsByName(@QueryParam("firtName") String firstName, @QueryParam("lastname") String lastName) throws RepositoryException {
        List<Actor> actors = actorService.selectActorByHisName(firstName, lastName);
        return Response.ok(actors).build();
    }
    
    @GET
    @Path("/actorsNat")
    public Response selectActorsByNationality(@QueryParam("nationality") String nationality) throws RepositoryException {
        List<Actor> actors = actorService.selectActorByHisNationality(nationality);
        return Response.ok(actors).build();
    }
    
    @GET
    @Path("/actorFilms")
    public Response selectActorsByHisFilms(@QueryParam("title") String title) throws RepositoryException {
        List<Actor> actors = actorService.selectActorByHisFilms(title);
        return Response.ok(actors).build();
    }
}
