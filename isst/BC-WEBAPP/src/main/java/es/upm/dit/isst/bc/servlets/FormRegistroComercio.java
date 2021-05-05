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

import es.upm.dit.isst.bc.model.Comercio;

/**
 * Servlet implementation class FormRegistroComercio
 */
@WebServlet("/FormRegistroComercio")
public class FormRegistroComercio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        
                Comercio comercio = new Comercio();
                comercio.setEmail(req.getParameter("email"));
                comercio.setPassword(req.getParameter("password"));
                comercio.setLocation(req.getParameter("location"));
                comercio.setShop_name(req.getParameter("shop_name"));
                comercio.setPhone(req.getParameter("phone"));
                
                Client client = ClientBuilder.newClient(new ClientConfig());
               Response r = client.target(URLHelper.getURL()+ "/Comercios").request()
                        .post(Entity.entity(comercio, MediaType.APPLICATION_JSON)
                       , Response.class);
               
System.out.print(r);
				
				  if (r.getStatus() == 201) {
					  req.getSession().setAttribute("comercio", comercio); 
					  getServletContext().getRequestDispatcher("/index.html").forward(req, resp); 
					  return; 
					  }
				 
       // getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
	}
}
