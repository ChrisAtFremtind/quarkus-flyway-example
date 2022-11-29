package no.chris;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/api")
public class GreetingResource {

    @Inject
    DAO DAO;

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response user() throws SQLException {
        List<User> userList = DAO.getUsers();

        return Response.ok(userList).build();
    }

    @GET
    @Path("/book")
    @Produces(MediaType.APPLICATION_JSON)
    public Response books() throws SQLException {
        return Response.ok(DAO.listBooks()).build();
    }

    @GET
    @Path("/book/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response book(@PathParam("id") String id) throws SQLException {
        return Response.ok(DAO.getBook(id)).build();
    }

}