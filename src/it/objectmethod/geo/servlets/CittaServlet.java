package it.objectmethod.geo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.domain.Citta;

@WebServlet(value = "/citta")
public class CittaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CittaDao referenceZone = new CittaDaoImp();
		String code = request.getParameter("codice");
		System.out.println("codice: "+code);
		List<Citta> listaZone = referenceZone.findCittaForCode(code);
		request.setAttribute("code", code);
		request.setAttribute("codec", code);
		request.setAttribute("list", listaZone);
		request.getRequestDispatcher("citta.jsp").forward(request, response);
	}

}
