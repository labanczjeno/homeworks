package xyz.codingmentor.ejbhw.service;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import xyz.codingmentor.ejbhw.beans.UserDB;
import xyz.codingmentor.ejbhw.beans.UserEntity;
import xyz.codingmentor.ejbhw.exceptions.LoginException;
import xyz.codingmentor.ejbhw.exceptions.UserExistException;

/**
 *
 * @author blazefury
 * http://localhost:8080/ejbhw-web/webresources/user
 */
@Path("/user")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserRESTService implements Serializable {

    private static final Logger LOG = Logger.getLogger(UserRESTService.class.getName());

    public static final String USER_KEY = "user";
    @Inject
    private UserDB userDB;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(@Context HttpServletRequest request, UserEntity user) {
        checkLogin(request);
        userDB.addUser(user);
        return Response.ok(user, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeUser(@Context HttpServletRequest request, UserEntity user) {
        checkLogin(request);
        UserEntity thisUser = userDB.getUser(user.getUsername());
        if (thisUser != null) {
            userDB.deleteUser(thisUser);
            return Response.ok(thisUser, MediaType.APPLICATION_JSON).build();
        }
        throw new UserExistException(user.getUsername());
    }

    /**
     * http://localhost:8080/ejbhw-web/webresources/user/{username}
     */
    @GET
    @Path("/{username}")
    public Response getUserWithName(@PathParam("username") String userName) {
        return Response.ok(userDB.getUser(userName)).build();
    }

    @GET
    public Response getListOfUsers() {
        return Response.ok(userDB.getUserList(), MediaType.APPLICATION_JSON).build();
    }
    
    /**
     * http://localhost:8080/ejbhw-web/webresources/user/login
     */
    @POST
    @Path("/login")
    @Consumes
    public Response login(@Context HttpServletRequest request, UserEntity user) {
        if (userDB.authenticate(user.getUsername(), user.getPassword())) {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(500);
            session.setAttribute(USER_KEY, userDB.getUser(user.getUsername()));
            LOG.log(Level.INFO, "Successful login: {0}", user.getUsername());
            return Response.ok(userDB.getUser(user.getUsername()), MediaType.APPLICATION_JSON).build();
        }
        throw new LoginException(user.getUsername());
    }

    /**
     * http://localhost:8080/ejbhw-web/webresources/user/logout
     */
    @POST
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity thisUser = (UserEntity) session.getAttribute(UserRESTService.USER_KEY);
        request.getSession().invalidate();
        return Response.ok(thisUser, MediaType.APPLICATION_JSON).build();
    }

    private static void checkLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity thisUser = (UserEntity) session.getAttribute(UserRESTService.USER_KEY);
        if (thisUser == null || !thisUser.isAdmin()) {
            throw new IllegalStateException("Log in please as admin");
        }
    }
}
