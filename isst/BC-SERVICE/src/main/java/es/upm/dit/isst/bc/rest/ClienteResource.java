package es.upm.dit.isst.bc.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.dit.isst.bc.dao.ClienteDAOImplementation;
import es.upm.dit.isst.bc.model.Cliente;


@Path("/Clientes")
public class ClienteResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> readAll () {
	        return ClienteDAOImplementation.getInstance().readAll();

	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Cliente tnew) throws URISyntaxException {
	    Cliente t = ClienteDAOImplementation.getInstance().create(tnew);
	    if (t != null) {
	            URI uri = new URI("/BC-SERVICE/rest/Clientes/" + t.getEmail());
	            return Response.created(uri).build();
	    }
	    return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        Cliente t = ClienteDAOImplementation.getInstance().read(id);
        if (t == null)
          return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(t, MediaType.APPLICATION_JSON).build();

    }       


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") String id, Cliente t) {
            System.out.println("Update request for" + id + " " + t.toString());
        Cliente told = ClienteDAOImplementation.getInstance().read(id);
        if ((told == null) || (! told.getEmail().contentEquals(t.getEmail())))
          return Response.notModified().build();
        ClienteDAOImplementation.getInstance().update(t);
        return Response.ok().build();                

    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String  id) {
        Cliente rold = ClienteDAOImplementation.getInstance().read(id);
        if (rold == null)
            return Response.notModified().build();
        ClienteDAOImplementation.getInstance().delete(rold);
        return Response.ok().build();

    }
}
