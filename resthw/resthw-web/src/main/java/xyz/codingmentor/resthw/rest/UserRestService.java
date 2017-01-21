
package xyz.codingmentor.resthw.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.resthw.beans.UserEntity;
import xyz.codingmentor.resthw.exception.IdIsNotMatchingUserException;

/**
 *
 * @author blazefury
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService {
    
    private static final Map<String,UserEntity> USERMAP=new HashMap<>();
    
    /**
     *
     * http://localhost:8080/resthw-web/resthw/users
     */
    
    @GET
    public List<UserEntity> getUsers(){
        return new ArrayList(USERMAP.values());
    }
    
    /**
     *
     * http://localhost:8080/resthw-web/resthw/users
     * 
     */
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUser(UserEntity userEntity){
        userEntity.setId(UUID.randomUUID().toString());
        USERMAP.put(userEntity.getId(), userEntity);
        return userEntity;
    }
    
    /**
     *
     * http://localhost:8080/resthw-web/resthw/users/{id}
     * 
     */
    
    @GET
    @Path("/{id}")
    public UserEntity getUserFromID(@PathParam("id") String id){
        return USERMAP.get(id);
    }
    
    /**
     *
     * http://localhost:8080/resthw-web/resthw/users/{id}
     * 
     * 
     */
    
    @PUT
    @Path("/{id}")
    public UserEntity checkUserID(@PathParam("id") String id, UserEntity userEntity){
        if (!id.equals(userEntity.getId())) {
            throw new IdIsNotMatchingUserException("No such user ID");
        }
        else{
            USERMAP.replace(id, userEntity);
            return USERMAP.get(id);
        }
    }

    /**
     * http://localhost:8080/resthw-web/resthw/users/{id}
     * 
     * 
     */
    
    @DELETE
    @Path("/{id}")
    public UserEntity removeUser(@PathParam("id") String id){
        return USERMAP.remove(id);
    }    
}
