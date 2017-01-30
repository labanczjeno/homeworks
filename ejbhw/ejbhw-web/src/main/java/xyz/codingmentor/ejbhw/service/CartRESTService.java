package xyz.codingmentor.ejbhw.service;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.ejbhw.beans.Cart;
import xyz.codingmentor.ejbhw.beans.Device;

/**
 *
 * @author blazefury 
 * http://localhost:8080/ejbhw-web/webresources/cart
 */
@Path("/cart")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class CartRESTService implements Serializable {

    @Inject
    private Cart cart;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addToCart(@Context HttpServletRequest request, Device device) {
        checkLogin(request);
        return Response.ok(cart.addDevice(device.getCount(), device.getId()), MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeFromCart(@Context HttpServletRequest request, Device device) {
        checkLogin(request);
        return Response.ok(cart.removeDevice(device.getCount(), device.getId()), MediaType.WILDCARD_TYPE).build();
    }

    /**
     *
     * http://localhost:8080/ejbhw-web/webresources/cart/buy
     */
    @POST
    @Path("/buy")
    public Response buyCart(@Context HttpServletRequest request) {
        checkLogin(request);
        Response response = Response.ok(cart.getFullPriceOfCart(), MediaType.APPLICATION_JSON).build();
        cart.buy();
        request.getSession().invalidate();
        return response;
    }

    private static void checkLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new IllegalStateException("Login please");
        }
    }

}
