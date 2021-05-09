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
        
        List<Producto> productos  = client.target(URLHelper.getURL()+ "/Productos").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Producto>>() {});
        

	    
	    //esto no va :( hace con url de rest 
	   // Cliente persona = ClienteDAOImplementation.getInstance().read(req.getParameter("IdCliente"));
        
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
        
        for(Pedido p: pedidos) {
  	  		if (idComercio.equals(p.getIdComercio()) && p.getHorario().equals(hora)) {
  	  			String idCli = p.getIdCliente();
  	  			System.out.print("AQUI MIRA SI SALE EL CLIENTE: " + idCli);

  	  			
  	  			for (Cliente c: clientes) {
  	  				if (c.getEmail().equals(idCli) && c.isType() == false) {
  	  						idRepartidor = c.getEmail();

  	  				}
  	  			}	  			  	  			
  	  		}  
   	
        }
        
        pedido.setIdRepartidor(idRepartidor);

               
        pedido.setListaProductos(listaProds);
        
		String[] cadaProd = new String[50];
		

        //ESTO NO VA:(
		
//		if (listaProds != null) {
//			cadaProd = listaProds.split(",");      
//		}
//        for (String prod: cadaProd) {
//        	for(Producto p: productos) {
//        		
//        		if(p.getNombre().equals(prod)) {
//        		        			
//        	        Producto producto = ProductoDAOImplementation.getInstance().read(prod);
//        	        
//        			producto.setIdComercio(p.getIdComercio());
//        			producto.setNombre(prod);
//        			producto.setPrecio(p.getPrecio());
//        			producto.setStock(p.getStock()-1);
//        	        ProductoDAOImplementation.getInstance().update(producto);
//        		}
//        		
//        	}
//        	
//        }

        
        
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
