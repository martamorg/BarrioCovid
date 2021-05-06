package es.upm.dit.isst.bc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;


/**
 * Servlet implementation class anadirProductoServlet
 */
@WebServlet("/anadirProductoServlet")
public class anadirProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public anadirProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String listaProds = req.getParameter("listaProds");
		String productoSel = req.getParameter("productoSel");
		
		if (listaProds == "") {
			
			listaProds = productoSel;
			
		} else {
			
			listaProds = listaProds + "," + productoSel;
			
		}		
		        
        System.out.print(productoSel);
        System.out.print("lista: "+ listaProds);

        req.getSession().setAttribute("listaProds", listaProds);   
        
		getServletContext().getRequestDispatcher("/pantallaCliente2.jsp").forward(req, resp);

		 
		
	}

	
	

}
