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
import xyz.codingmentor.jpaonweb.ejb.entity.Film;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.service.FilmService;

/**
 * REST Web Service
 *
 * @author blazefury
 */
@Path("Film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmResource {

    @Inject
    private FilmService filmService;

    @GET
    @Path("/{id}")
    public Response getFilmById(@PathParam("id") int id) throws RepositoryException {
        Film film = filmService.getFilmById(id);
        if (null != film) {
            return Response.ok(film).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFilm(Film film) throws RepositoryException {
        filmService.addFilm(film);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFilm(Film film) throws RepositoryException {
        filmService.editFilm(film);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeFilmById(@PathParam("id") int id) throws RepositoryException {
        if (null != filmService.getFilmById(id)) {
            filmService.removeFilm(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/filmCategory")
    public Response selectFilmByCategory(@QueryParam("categoryId") int categoryId) throws RepositoryException {
        List<Film> films = filmService.selectFilmByCategory(categoryId);
        return Response.ok(films).build();
    }

    @GET
    @Path("/filmTitle")
    public Response selectFilmByTitle(@QueryParam("title") String title) throws RepositoryException {
        List<Film> films = filmService.selectFilmByTitle(title);
        return Response.ok(films).build();
    }

}
