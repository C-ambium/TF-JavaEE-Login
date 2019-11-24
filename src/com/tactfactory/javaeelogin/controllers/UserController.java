package com.tactfactory.javaeelogin.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tactfactory.javaeelogin.entities.User;


/** USER Controller CLASS
 * @author Colin Cerveaux @C-ambium
 *
 */
@Path("/user")
public class UserController {

    private final ServletContext servletContext;

    private final Map<Integer, User> users;

    private static final String CONTEXT = "UserList";

    private int incrementId = 0;

    /**
     * Constructor of User controller.
     * @param servletContext Injected Servlet Context.
     */
    @SuppressWarnings("unchecked")
    public UserController(@Context final ServletContext servletContext) {
        // Store injected ServletContext.
        this.servletContext = servletContext;

        // Check if Map of Users exist, if not create it.
        if (this.servletContext.getAttribute(CONTEXT) == null) {
            this.servletContext.setAttribute(CONTEXT, initFixture());
        }

        // Store context of users.
        this.users = (Map<Integer, User>) this.servletContext.getAttribute(CONTEXT);
    }

    /**
     * Retrieve the collection resource of User in the response body.
     * @return Collection of User.
     */
    @GET
    public Response getAll() {
        final Collection<User> result = users.values();

        return Response.ok(result).build();
    }

    /**
     * Retrieve a User resource in the response body.
     * @param id Identifier of User.
     * @return User data.
     */
    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") final Integer id) {
        Response result;
        final User user = users.get(id);
        System.out.println("Je suis passé par là ! ");

        if (user != null) {
            result = Response.ok(user).build();
        } else {
            result = Response.noContent().build();
        }

        return result;
    }

    /**
     * Create a User. The URI of the created member resource is automatically assigned and returned in the response
     * Location header field.
     * @param id Identifier of User.
     * @param user User data to store.
     * @return User data updated.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/add/{id}")
    public Response createOne(@PathParam("id") final Integer id, final User user) {

        String output = String.format("Le User %s à bien été crée !", user.getUsername());
        System.out.println(output);

        if (user.getId() == 0) {
            user.setId(++incrementId);
        }

        users.put(user.getId(), user);

        return Response.ok(user).build();
    }

    /**
     * Create a collection of Users. The URI of the created member resource is automatically assigned and returned in the response
     * Location header field.
     * @param usersParam Collection of Users
     * @return Users data updated.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(final List<User> usersParam) {

        for (User user : usersParam) {
            if (user.getId() == 0) {
                user.setId(++incrementId);
            }

            users.put(user.getId(), user);
        }

        return Response.ok(usersParam).build();
    }

    /**
     * Update User or create it if not exist.
     * @param id Identifier of User.
     * @param user User data.
     * @return User data updated.
     */
    @POST
    @Path("/edit/{id}")
    public Response update(@PathParam("id") final Integer id, final User user) {
        users.replace(id, user);

        return Response.ok(user).build();
    }

    /**
     * Delete User by ID.
     * @param id Identifier of User.
     * @return Response ok .
     */
    @POST
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") final Integer id) {
        users.remove(id);

        return Response.ok().build();
    }

    /** Function to create initals data in users map.
     * @return Hashmap of objects "User"
     */
    private HashMap<Integer, User> initFixture() {

        HashMap<Integer, User> users = new HashMap<>();

        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            User user = new User(i + 1, "u- " + rand.nextInt(500), "Simone " + i, "Weil",
                    rand.nextInt(99) + " bld de Metz 35000 RENNES", "06" + rand.nextInt(99) + "6711" + rand.nextInt(99),
                    "usw" + rand.nextInt(100) + "@me.fr", "a-" + (rand.nextInt(56) + 1) + ".jpg");
            users.put(user.getId(), user);
        }
        return users;
    }
}
