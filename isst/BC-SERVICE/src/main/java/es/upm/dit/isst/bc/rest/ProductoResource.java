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

import es.upm.dit.isst.bc.dao.ProductoDAOImplementation;
import es.upm.dit.isst.bc.model.Producto;


@Path("/Productos")
public class ProductoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> readAll () {
	        return ProductoDAOImplementation.getInstance().readAll();

	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Producto tnew) throws URISyntaxException {
	    Producto t = ProductoDAOImplementation.getInstance().create(tnew);
	    if (t != null) {
	            URI uri = new URI("/BC-SERVICE/rest/Productos/" + t.getNombre());
	            return Response.created(uri).build();
	    }
	    return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
        Producto t = ProductoDAOImplementation.getInstance().read(id);
        if (t == null)
          return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(t, MediaType.APPLICATION_JSON).build();

    }       


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") String id, Producto t) {
            System.out.println("Update request for" + id + " " + t.toString());
        Producto told = ProductoDAOImplementation.getInstance().read(id);
        if ((told == null) || (! told.getNombre().contentEquals(t.getNombre())))
          return Response.notModified().build();
        ProductoDAOImplementation.getInstance().update(t);
        return Response.ok().build();                

    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String  id) {
        Producto rold = ProductoDAOImplementation.getInstance().read(id);
        if (rold == null)
            return Response.notModified().build();
        ProductoDAOImplementation.getInstance().delete(rold);
        return Response.ok().build();

    }
}