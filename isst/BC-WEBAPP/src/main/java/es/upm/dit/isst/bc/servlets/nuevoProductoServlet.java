package es.upm.dit.isst.bc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.bc.model.Cliente;
import es.upm.dit.isst.bc.model.Comercio;
import es.upm.dit.isst.bc.model.Producto;

/**
 * Servlet implementation class nuevoProductoServlet
 */
@WebServlet("/nuevoProductoServlet")
public class nuevoProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nuevoProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	    String idComercio = req.getParameter("idComercio");

	    
		
		Producto producto = new Producto();
		producto.setNombre(req.getParameter("nombre"));
		producto.setPrecio(Float.parseFloat(req.getParameter("precio")));
		producto.setStock(Integer.parseInt(req.getParameter("stock")));
		producto.setIdComercio(idComercio);

        
       Client client = ClientBuilder.newClient(new ClientConfig());
       Response r = client.target(URLHelper.getURL()+ "/Productos").request()
                .post(Entity.entity(producto, MediaType.APPLICATION_JSON)
               , Response.class);
       
		/* req.getSession().setAttribute("producto", producto); */
		
getServletContext().getRequestDispatcher("/pantallaComercio.jsp").forward(req, resp);
	}

	

}




