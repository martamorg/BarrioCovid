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
 * Servlet implementation class ServletAlumnos
 */
@WebServlet("/ServletCliente")
@DeclareRoles("cliente")
@ServletSecurity(@HttpConstraint(rolesAllowed="cliente"))
public class ServletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Server de alumnos").append(request.
		 * getContextPath());
		 */	
		
		boolean webHasRole = request.isUserInRole("cliente");
		
		if(webHasRole == true) {
			/*
			 * response.getWriter().write("\n" + "rol: alumno\n");
			 */		
			getServletContext().getRequestDispatcher("/pantallaCliente.jsp").forward(request, response);
		}
	}


}
