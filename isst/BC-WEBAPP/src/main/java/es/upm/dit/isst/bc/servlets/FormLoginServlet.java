
  package es.upm.dit.isst.bc.servlets;
  
  import java.io.IOException; import java.util.List;
  
  import javax.servlet.ServletException; import
  javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse; import javax.ws.rs.client.Client;
  import javax.ws.rs.client.ClientBuilder; import javax.ws.rs.core.GenericType;
  import javax.ws.rs.core.MediaType;
  
  import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.bc.model.Cliente;
import es.upm.dit.isst.bc.model.Comercio;
import es.upm.dit.isst.bc.model.Pedido;
import es.upm.dit.isst.bc.model.Producto;


@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private final String ADMIN_EMAIL = "root";
        private final String ADMIN_PASSWORD = "root";        
        
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                           throws ServletException, IOException {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            Client client = ClientBuilder.newClient(new ClientConfig());
            // autenticacion admin
            if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {        
                 req.getSession().setAttribute("admin", true);
                 
                 List<Cliente> clientes  = client.target(URLHelper.getURL()+ "/Clientes").request().accept(MediaType.APPLICATION_JSON)
                        .get(new GenericType<List<Cliente>>() {});
                 
                 req.setAttribute("clientes", clientes);
                 
                 List<Comercio> comercios  = client.target(URLHelper.getURL() + "/Comercios").request().accept(MediaType.APPLICATION_JSON)
                         .get(new GenericType<List<Comercio>>() {});
              
                  req.getSession().setAttribute("comercios", comercios);
                  
               getServletContext().getRequestDispatcher("/Admin.jsp")
                                  .forward(req,resp);
                return;
            }
            
            //autenticacion cliente
            
            Cliente elCliente = null;
            try { elCliente = client.target(URLHelper.getURL() + "/Clientes/" + email)
	                    .request().accept(MediaType.APPLICATION_JSON).get(Cliente.class);
				 }catch (Exception e) {
				 }
            if ( null != elCliente ) {                                                        
	            if( elCliente.getEmail().equals(email) && elCliente.getPassword().equals(password) ) {    
	            	
	                req.getSession().setAttribute("cliente", elCliente);
	                
	                //req session lista de comercios, habra q pasar tmb pedidos y no se si productos o eso ya en vista cliente 2
	                List<Comercio> comercios  = client.target(URLHelper.getURL() + "/Comercios").request().accept(MediaType.APPLICATION_JSON)
	                        .get(new GenericType<List<Comercio>>() {});
	                
	                 req.getSession().setAttribute("comercios", comercios);
	
	                List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
	                        .get(new GenericType<List<Pedido>>() {});
		                
	                 req.getSession().setAttribute("pedidos", pedidos);
	                 
	                 
		            List<Cliente> clientes  = client.target(URLHelper.getURL() + "/Clientes").request().accept(MediaType.APPLICATION_JSON)
		                        .get(new GenericType<List<Cliente>>() {});
			                
		             req.getSession().setAttribute("clientes", clientes);
	                 
	              getServletContext().getRequestDispatcher("/pantallaCliente.jsp")
	                                 .forward(req,resp);
	               return;
	               
	            }
           }
            
            //autenticacion comercio
            
            Comercio elComercio = null;
            try { elComercio = client.target(URLHelper.getURL() + "/Comercios/" + email)
	                    .request().accept(MediaType.APPLICATION_JSON).get(Comercio.class);
				 }catch (Exception e) {
				 }
            if ( null != elComercio ) {                                                        

	            if( elComercio.getEmail().equals(email) && elComercio.getPassword().equals(password) ) {    
	            	
	                req.getSession().setAttribute("comercio", elComercio);
	                
	                
	                List<Producto> productos  = client.target(URLHelper.getURL() + "/Productos").request().accept(MediaType.APPLICATION_JSON)
	                        .get(new GenericType<List<Producto>>() {});
	                    
	                 req.getSession().setAttribute("productos", productos);
	                 
	                List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
	                        .get(new GenericType<List<Pedido>>() {});
		                
	                 req.getSession().setAttribute("pedidos", pedidos);
	                 
	              getServletContext().getRequestDispatcher("/pantallaComercio.jsp")
	                                 .forward(req,resp);
	               return;
	               
	            }
           }
            
      
      
            getServletContext().getRequestDispatcher("/index.html").forward(req,resp);

        }

}

  
/*
 * @WebServlet("/FormLoginServlet")
 * 
 * public class FormLoginServlet extends HttpServlet {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * private final String ADMIN_EMAIL = "root";
 * 
 * private final String ADMIN_PASSWORD = "root";
 * 
 * 
 * 
 * @Override
 * 
 * protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
 * ServletException, IOException { String email = req.getParameter("email");
 * String password = req.getParameter("password"); Client client =
 * ClientBuilder.newClient(new ClientConfig());
 * 
 * Cliente cliente = ClienteDAOImplementation.getInstance().login(email,
 * password); Comercio comercio =
 * ComercioDAOImplementation.getInstance().login(email, password);
 * 
 * 
 * // autenticacion1 (root root)
 * 
 * if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
 * req.getSession().setAttribute("admin", true); List<Cliente> clientes =
 * client.target(URLHelper.getURL())
 * .request().accept(MediaType.APPLICATION_JSON) .get(new
 * GenericType<List<Cliente>>() {}); req.setAttribute("clientes", clientes);
 * getServletContext().getRequestDispatcher("/Admin.jsp") .forward(req,resp);
 * return;
 * 
 * }else if (null != cliente ){
 * 
 * req.getSession().setAttribute("cliente",ClienteDAOImplementation.getInstance(
 * ).read(cliente.getEmail()));
 * getServletContext().getRequestDispatcher("/pantallaCliente.jsp").forward(req,
 * resp);
 * 
 * }else if (null != comercio ){
 * 
 * req.getSession().setAttribute("comercio",ComercioDAOImplementation.
 * getInstance().read(comercio.getEmail()));
 * getServletContext().getRequestDispatcher("/pantallaComercio.jsp").forward(req
 * ,resp);
 * 
 * }
 * 
 * 
 * 
 * 
 * getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
 * 
 * }
 * 
 * }
 */