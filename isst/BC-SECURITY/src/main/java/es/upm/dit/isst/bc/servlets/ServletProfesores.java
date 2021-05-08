package es.upm.dit.isst.bc.servlets;


import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProfesores
 */
@WebServlet("/ServletComercio")
@DeclareRoles("comercio")
@ServletSecurity(@HttpConstraint(rolesAllowed="comercio"))
public class ServletProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Server de profesores").append(request.
		 * getContextPath());
		 */	
		boolean webHasRole = request.isUserInRole("comercio");
		
		if(webHasRole == true) {
			/*
			 * response.getWriter().write("\n" + "rol: alumno\n");
			 */		
			getServletContext().getRequestDispatcher("/pantallaComercio.jsp").forward(request, response);
		}
	
	}

	

}
