package es.upm.dit.isst.bc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormProductoServlet
 */
@WebServlet("/FormProductoServlet")
public class FormProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String idComercio = req.getParameter("idComercio");

        req.getSession().setAttribute("tienda", idComercio);

	    
	    getServletContext().getRequestDispatcher("/nuevoProducto.jsp").forward(req, resp);

	}

	

}
