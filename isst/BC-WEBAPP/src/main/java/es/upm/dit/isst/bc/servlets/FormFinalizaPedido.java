package es.upm.dit.isst.bc.servlets;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.ClientBuilder; import javax.ws.rs.core.GenericType;
import javax.ws.rs.client.Client;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.bc.model.Cliente;
import es.upm.dit.isst.bc.model.Pedido;

/**
 * Servlet implementation class FormFinalizaPedido
 */
@WebServlet("/FormFinalizaPedido")
public class FormFinalizaPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FormFinalizaPedido() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
        Client client = ClientBuilder.newClient(new ClientConfig());
		
		String[] horarios = {"10:00", "11:00","12:00", "13:00", "17:00", "18:00", "19:00", "20:00"};
		
         
        
        List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
                 .get(new GenericType<List<Pedido>>() {});
             
        req.getSession().setAttribute("pedidos", pedidos);
        req.getSession().setAttribute("horarios", horarios);

		getServletContext().getRequestDispatcher("/finalizaPedido.jsp").forward(req, resp);
	}


}
