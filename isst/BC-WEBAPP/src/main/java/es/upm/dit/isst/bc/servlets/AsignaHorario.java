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

import es.upm.dit.isst.bc.dao.ProductoDAOImplementation;
import es.upm.dit.isst.bc.model.Cliente;
import es.upm.dit.isst.bc.model.Comercio;
import es.upm.dit.isst.bc.model.Pedido;
import es.upm.dit.isst.bc.model.Producto;

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
	    String idComercio = req.getParameter("idComercio");
	    String hora = req.getParameter("hora");
	    String listaProds = req.getParameter("listaProds");
	    
        List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Pedido>>() {});
        int size = pedidos.size();
        
        List<Cliente> clientes  = client.target(URLHelper.getURL()+ "/Clientes").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Cliente>>() {});
        
        


        
        int idUltimoPedido = 0;
        if(size != 0) {
            idUltimoPedido = pedidos.get(size-1).getIdPedido();	

        }
        String idRepartidor = "";

        
        Pedido pedido = new Pedido();
        pedido.setIdPedido(idUltimoPedido +1);
        pedido.setHorario(hora);
        pedido.setIdCliente(req.getParameter("idCliente"));
        pedido.setIdComercio(idComercio);
        pedido.setIdRepartidor(idRepartidor);               
        pedido.setListaProductos(listaProds);
        
        for(Pedido p: pedidos) {
  	  		if (idComercio.equals(p.getIdComercio()) && p.getHorario().equals(hora)) {
  	  			String idCli = p.getIdCliente();

  	  			
  	  			for (Cliente c: clientes) {
  	  				if (c.getEmail().equals(idCli) && c.isType() == false) {
  	  						idRepartidor = c.getEmail();
  	  			        pedido.setIdRepartidor(idRepartidor);               


  	  				}
  	  			}	  			  	  			
  	  		}  
   	
        }
        client.target(URLHelper.getURL()+ "/Pedidos").request()
                .post(Entity.entity(pedido, MediaType.APPLICATION_JSON));
        

        
		String[] cadaProd = new String[50];
		
		if (listaProds != null) {
			cadaProd = listaProds.split(",");      
		}
		
  	    System.out.println("print 1");

		for (String prod: cadaProd) {			
			Producto producto = null;
			  try {
			         producto = client.target(URLHelper.getURL() + "/Productos/" + prod)
			              .request().accept(MediaType.APPLICATION_JSON).get(Producto.class);
			  } catch(Exception e) {}
		  	  System.out.println("print 2");

			  if (producto != null) {
			  	  System.out.println("print 3");

				producto.setIdComercio(producto.getIdComercio());
      			producto.setNombre(prod);
      			producto.setPrecio(producto.getPrecio());
      			producto.setStock(producto.getStock()-1);
      			
      	    Response r =  client.target(URLHelper.getURL() + "/Productos/" + prod)
              .request()
              .post(Entity.entity(producto, MediaType.APPLICATION_JSON), Response.class);
      	    
      	    System.out.print(r);
				  
			  }
			  
		}
		
        List<Producto> productos  = client.target(URLHelper.getURL()+ "/Productos").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Producto>>() {});
        req.getSession().setAttribute("productos", productos);

	    
        List<Pedido> pedidos2  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Pedido>>() {});
        req.getSession().setAttribute("pedidos", pedidos2);
        
        //AQUI
        
        req.getSession().removeAttribute("listaProds");

        getServletContext().getRequestDispatcher("/pantallaCliente.jsp").forward(req,resp);

		
	}



}
