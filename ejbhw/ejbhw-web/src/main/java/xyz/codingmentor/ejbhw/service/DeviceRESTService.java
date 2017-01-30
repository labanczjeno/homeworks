package xyz.codingmentor.ejbhw.service;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.ejbhw.beans.Device;
import xyz.codingmentor.ejbhw.beans.DeviceDB;
import xyz.codingmentor.ejbhw.beans.UserEntity;
import xyz.codingmentor.ejbhw.exceptions.DeviceNotExistException;

/**
 *
 * @author blazefury
 * http://localhost:8080/ejbhw-web/webresources/device
 */
@Path("/device")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class DeviceRESTService implements Serializable {

    @Inject
    private DeviceDB deviceDb;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDevice(@Context HttpServletRequest request, Device device) {
        checkLogin(request);
        deviceDb.addDevice(device);
        return Response.ok(device, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteDevice(@Context HttpServletRequest request, Device device) {
        checkLogin(request);
        Device deletedDevice = deviceDb.getDevice(device.getId());
        if (deletedDevice != null) {
            deviceDb.removeDevice(device);
            return Response.ok(deletedDevice, MediaType.APPLICATION_JSON).build();
        }
        throw new DeviceNotExistException(device.getId());
    }
    
    /**
    *
    * http://localhost:8080/ejbhw-web/webresources/cart/{id}
    */
    @GET
    @Path("/{id}")
    public Response getDeviceWithID(@PathParam("id") String id) {
        return Response.ok(deviceDb.getDevice(id), MediaType.APPLICATION_JSON).build();
    }

    @GET
    public Response getAllDevice() {
        return Response.ok(deviceDb.getDeviceList(), MediaType.APPLICATION_JSON).build();
    }

    private static void checkLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity thisUser = (UserEntity) session.getAttribute(UserRESTService.USER_KEY);
        if (thisUser == null || !thisUser.isAdmin()) {
            throw new IllegalStateException("Log in please as admin");
        }
    }
}
