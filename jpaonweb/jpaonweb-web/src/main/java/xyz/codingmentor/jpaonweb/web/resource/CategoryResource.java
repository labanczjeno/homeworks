package xyz.codingmentor.jpaonweb.web.resource;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jpaonweb.ejb.entity.Category;
import xyz.codingmentor.jpaonweb.ejb.exception.RepositoryException;
import xyz.codingmentor.jpaonweb.ejb.service.CategoryService;

/**
 * REST Web Service
 *
 * @author blazefury
 */
@Path("Category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    private CategoryService categoryService;

    @GET
    @Path("/{id}")
    public Response getCategoryById(@PathParam("id") int id) throws RepositoryException {
        Category category = categoryService.getCategoryById(id);
        if (null != category) {
            return Response.ok(category).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(Category category) throws RepositoryException {
        categoryService.addCategory(category);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(Category category) throws RepositoryException {
        categoryService.editCategory(category);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCategoryById(@PathParam("id") int id) throws RepositoryException {
        if (null != categoryService.getCategoryById(id)) {
            categoryService.removeCategory(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }
}
