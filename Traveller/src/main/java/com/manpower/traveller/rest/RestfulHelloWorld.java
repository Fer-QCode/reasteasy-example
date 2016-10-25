package com.manpower.traveller.rest;

import java.util.Date;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 *
 * @author FerCho
 */
@Path("/api")
public class RestfulHelloWorld {

    @GET
    @Path("/startingPage")
    @Produces("text/html")
    public Response getStartingPage() {
        String output = "<h1>Hello World!<h1>"
                + "<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
        return Response.status(200).entity(output).build();
    }

    @PermitAll
    @GET
    @Path("/users/{id}")
    public Response getUserById(@PathParam("id") int id, @Context Request req) {
        String output = "<h1>Hello World!<h1>"
                + "<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>"
                + "<p>user id: " + id + "</p><br>";
        Response.ResponseBuilder rb = Response.ok(output);
        return rb.build();
    }

    @RolesAllowed("ADMIN")
    @PUT
    @Path("/users/{id}")
    public Response updateUserById(@PathParam("id") int id) {
        String output = "<h1>Update Method!<h1>"
                + "<p>Just For Admin Roles ... <br>Ping @ " + new Date().toString() + "</p<br>"
                + "<p>user id: " + id + "</p><br>";
        Response.ResponseBuilder rb = Response.ok(output);
        return rb.build();
    }

}
