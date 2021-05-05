package es.upm.dit.isst.bc.servlets;

import java.io.IOException;
import java.util.List;

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

import es.upm.dit.isst.bc.model.Comercio;
import es.upm.dit.isst.bc.model.Pedido;
import es.upm.dit.isst.bc.model.Producto;

@WebServlet("/FormAccedeTienda")
public class FormAccedeTienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
    Client client = ClientBuilder.newClient(new ClientConfig());
    String idComercio = req.getParameter("idComercio");
    
    Comercio elComercio = null;
    
    try { elComercio = client.target(URLHelper.getURL() + "/Comercios/" + idComercio)
                .request().accept(MediaType.APPLICATION_JSON).get(Comercio.class);
		 }catch (Exception e) {
		 }
    if ( null != elComercio ) {                                                        
        	
            req.getSession().setAttribute("comercio", elComercio);
            
            
            List<Producto> productos  = client.target(URLHelper.getURL() + "/Productos").request().accept(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Producto>>() {});
                
             req.getSession().setAttribute("productos", productos);
             
             List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Pedido>>() {});
                
             req.getSession().setAttribute("pedidos", pedidos);
             
          getServletContext().getRequestDispatcher("/pantallaCliente2.jsp")
                             .forward(req,resp);
           return;
           
        }
   }
    
}


