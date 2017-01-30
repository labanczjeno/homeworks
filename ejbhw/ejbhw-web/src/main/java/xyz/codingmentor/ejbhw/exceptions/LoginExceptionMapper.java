package xyz.codingmentor.ejbhw.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.ejbhw.dto.ErrorDTO;

/**
 *
 * @author blazefury
 */
@Provider
public class LoginExceptionMapper implements ExceptionMapper<LoginException> {

    private static final Logger LOG = Logger.getLogger(LoginExceptionMapper.class.getName());

    @Override
    public Response toResponse(LoginException exception) {
        LOG.log(Level.SEVERE, "Authentatication Exception", exception);
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorDTO(exception.getMessage() + " - " + exception.getCause()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
