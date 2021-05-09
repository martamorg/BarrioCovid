package es.upm.dit.isst.bc.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import es.upm.dit.isst.bc.model.Comercio;
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
        String comercio = req.getParameter("comercio");
        
        List<Pedido> pedidos  = client.target(URLHelper.getURL() + "/Pedidos").request().accept(MediaType.APPLICATION_JSON)
                 .get(new GenericType<List<Pedido>>() {});
        List<Cliente> clientes  = client.target(URLHelper.getURL() + "/Clientes").request().accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Cliente>>() {});
        
		ArrayList<String> horarios = new ArrayList<String>();
		horarios.add("10:00");
		horarios.add("11:00");
		horarios.add("12:00");
		horarios.add("13:00");
		horarios.add("17:00");
		horarios.add("18:00");
		horarios.add("19:00");
		horarios.add("20:00");


			
		ArrayList<String> horariosDisp = new ArrayList<String>();
		ArrayList<String> horariosRec = new ArrayList<String>();
  		
  		for (Pedido p: pedidos) {
	  			System.out.print("AQUI MIRA SI SALE EL COMERCIO: " + comercio);

  			
  			// si el pedido es del comercio en cuestion
  	  		if (comercio.equals(p.getIdComercio())) {
  	  			String idCli = p.getIdCliente();
  	  			System.out.print("AQUI MIRA SI SALE EL CLIENTE: " + idCli);

  	  			
  	  			for (Cliente c: clientes) {
  	  				 // y si el cliente de ese pedido es NO vulnerable (para q no me muestre dos veces el mismo horario si esta asignada una recogida a ese horario)
  	  				if (c.getEmail().equals(idCli) && c.isType() == false) {
  	  					//meto ese horario a horariosRec
  	    	  			horariosRec.add(p.getHorario());
  	    	  			System.out.print("AQUI MIRA SI SALE EL HORARIO: " + p.getHorario());

  	  				}
  	  			}	  			  	  			
  	  		}  	  		
  	  		
  		}
  		
		    System.out.print(horariosRec);

		
	  		for (int i = 0; i < horarios.size(); i++) {
  	  		    boolean igual=false;
  	  		     for (int j = 0; j < horariosRec.size() & !igual; j++) {
  	  		         if(horarios.get(i).equals(horariosRec.get(j))) 
  	  		                 igual=true;
  	  		     }
  	  		    if(!igual)horariosDisp.add(horarios.get(i));
  	  		    System.out.print("hola canete");
  	  		}
  	  		 	
		    System.out.print("LO HACE?:"+ horariosDisp);

         

             
        req.getSession().setAttribute("pedidos", pedidos);
        req.getSession().setAttribute("horarios", horarios);
        req.getSession().setAttribute("horariosRec", horariosRec);
        req.getSession().setAttribute("horariosDisp", horariosDisp);


		getServletContext().getRequestDispatcher("/finalizaPedido.jsp").forward(req, resp);
	}


}
