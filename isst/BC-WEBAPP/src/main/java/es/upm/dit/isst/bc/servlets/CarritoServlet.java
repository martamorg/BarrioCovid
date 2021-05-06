package es.upm.dit.isst.bc.servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.bc.model.Producto;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
		Client client = ClientBuilder.newClient(new ClientConfig());

		float precioTotal = 0;
		String listaProds = req.getParameter("listaProds");
		String[] cadaProd = new String[50];
		
		if (listaProds != null) {
			cadaProd = listaProds.split(",");      
		}
		
        System.out.println(listaProds);

        
        List<Producto> productos  = client.target(URLHelper.getURL() + "/Productos").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Producto>>() {});
        
        for (Producto p: productos) {
            for (String p2: cadaProd) {

	        	if (p.getNombre().equals(p2)) {
	        		float estePrecio = p.getPrecio();
	        		precioTotal = precioTotal + estePrecio;	        		
	        	}
            }
        }
        
        req.getSession().setAttribute("precioTotal", precioTotal);
        req.getSession().setAttribute("productos", productos);
        req.getSession().setAttribute("listaProds", listaProds);
        req.getSession().setAttribute("cadaProd", cadaProd);

        
		getServletContext().getRequestDispatcher("/pago.jsp").forward(req, resp);
	
	}



}
