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

/**
 * Servlet implementation class FormRegistroCliente
 */
@WebServlet("/FormRegistroCliente")
public class FormRegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	  boolean type = false;
	  if (req.getParameter("type").equals("vulnerable")) {
	  type = true; }
	  else if (req.getParameter("type").equals("noVulnerable") ) {
		  type = false;
	  }
	 
	        
                Cliente cliente = new Cliente();
                cliente.setEmail(req.getParameter("email"));
                cliente.setPassword(req.getParameter("password"));
                cliente.setLocation(req.getParameter("location"));
                cliente.setClient_name(req.getParameter("name"));
                cliente.setType(type);
                
                Client client = ClientBuilder.newClient(new ClientConfig());
                Response r = client.target(URLHelper.getURL()+ "/Clientes").request()
                        .post(Entity.entity(cliente, MediaType.APPLICATION_JSON)
                       , Response.class);
				
				  if (r.getStatus() == 201) {
					  req.getSession().setAttribute("cliente",cliente); 
					  getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
					  return; 
					  }
				 
        //getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
	}
}
