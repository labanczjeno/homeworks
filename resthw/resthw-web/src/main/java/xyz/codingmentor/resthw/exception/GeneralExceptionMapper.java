
package xyz.codingmentor.resthw.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author blazefury
 */
public class GeneralExceptionMapper implements ExceptionMapper<IdIsNotMatchingUserException> {

    private static final Logger LOG = Logger.getLogger(GeneralExceptionMapper.class.getName());
    
    @Override
    public Response toResponse(IdIsNotMatchingUserException exception) {
        LOG.log(Level.SEVERE,"General Exception",exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ErrorDTO(exception.getMessage() + " " + exception.getCause())).type(MediaType.APPLICATION_JSON).build();
    }
}
