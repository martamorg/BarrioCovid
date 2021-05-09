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
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.bc.dao.PedidoDAOImplementation;
import es.upm.dit.isst.bc.model.Cliente;
import es.upm.dit.isst.bc.model.Pedido;
import es.upm.dit.isst.bc.model.Producto;

/**
 * Servlet implementation class FormRecogidaRealizada
 */
@WebServlet("/FormRecogidaRealizada")
public class FormRecogidaRealizada extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FormRecogidaRealizada() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Client client = ClientBuilder.newClient(new ClientConfig());

		int idPedido = Integer.parseInt(req.getParameter("idPedido"));
		Pedido pedido = PedidoDAOImplementation.getInstance().read(idPedido);
		if (pedido != null) {
			
			PedidoDAOImplementation.getInstance().delete(pedido);
		}


	       List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
	               .get(new GenericType<List<Pedido>>() {});
	           
	        req.getSession().setAttribute("pedidos", pedidos);
	        
			getServletContext().getRequestDispatcher("/pantallaComercio.jsp").forward(req, resp);
	}


}
