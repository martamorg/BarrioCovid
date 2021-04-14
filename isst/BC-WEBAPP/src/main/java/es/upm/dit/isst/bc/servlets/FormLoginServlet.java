
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
import es.upm.dit.isst.bc.dao.ClienteDAOImplementation;
import es.upm.dit.isst.bc.dao.ComercioDAOImplementation;

  
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
  
	Cliente cliente = ClienteDAOImplementation.getInstance().login(email, password);
	Comercio comercio = ComercioDAOImplementation.getInstance().login(email, password);

	
  // autenticacion1 (root root)
  
  if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
  req.getSession().setAttribute("admin", true);
  List<Cliente> clientes = client.target(URLHelper.getURL())
  .request().accept(MediaType.APPLICATION_JSON)
  .get(new GenericType<List<Cliente>>() {});
  req.setAttribute("clientes", clientes);
  getServletContext().getRequestDispatcher("/Admin.jsp")
  .forward(req,resp);
  return;
  
  }else if (null != cliente ){
	  
	req.getSession().setAttribute("cliente",ClienteDAOImplementation.getInstance().read(cliente.getEmail()));
	getServletContext().getRequestDispatcher("/pantallaCliente.jsp").forward(req,resp);
	
  }else if (null != comercio ){
	  
	req.getSession().setAttribute("comercio",ComercioDAOImplementation.getInstance().read(comercio.getEmail()));
	getServletContext().getRequestDispatcher("/pantallaComercio.jsp").forward(req,resp);
	
  }
  
  
 
  
  getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
  
  }
  
  }
 