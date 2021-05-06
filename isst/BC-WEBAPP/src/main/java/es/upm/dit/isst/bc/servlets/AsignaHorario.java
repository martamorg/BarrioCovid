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


import es.upm.dit.isst.bc.model.Cliente;
import es.upm.dit.isst.bc.model.Pedido;

/**
 * Servlet implementation class AsignaHorario
 */
@WebServlet("/AsignaHorario")
public class AsignaHorario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsignaHorario() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	    Client client = ClientBuilder.newClient(new ClientConfig());
	    
	    String hora = req.getParameter("hora");
        List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Pedido>>() {});
        int size = pedidos.size();
        
        List<Cliente> clientes  = client.target(URLHelper.getURL()+ "/Clientes").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Cliente>>() {});
        

	    
	    //esto no va :( hace con url de rest 
	   // Cliente persona = ClienteDAOImplementation.getInstance().read(req.getParameter("IdCliente"));
	    
        Pedido pedido = new Pedido();
        pedido.setIdPedido(size +1);
        pedido.setHorario(hora);
        pedido.setIdCliente(req.getParameter("idCliente"));
        pedido.setIdComercio(req.getParameter("idComercio"));
        
        for(Cliente c: clientes) {
        	if (c.getEmail().equals(req.getParameter("idCliente"))) {
                if (c.isType() == true) {
                    pedido.setIdRepartidor(req.getParameter("idRepartidor"));
                } else { 
                	pedido.setIdRepartidor("");
                }                
        	}        	
        }
               
        pedido.setListaProductos(req.getParameter("listaProds"));

        
        
       Response r = client.target(URLHelper.getURL()+ "/Pedidos").request()
                .post(Entity.entity(pedido, MediaType.APPLICATION_JSON)
               , Response.class);
       
		System.out.print(r);
		
//		  if (r.getStatus() == 201) {
//			  req.getSession().setAttribute("pedido", pedido); 
//			  getServletContext().getRequestDispatcher("/index.html").forward(req, resp); 
//			  return; 
//			  }
	    
        List<Pedido> pedidos2  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Pedido>>() {});
        req.getSession().setAttribute("pedidos", pedidos2);

        getServletContext().getRequestDispatcher("/pantallaCliente.jsp").forward(req,resp);

		
	}



}
