package it.objectmethod.geo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;

@WebServlet(value = "/elimina")
public class EliminaCittaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Elimina");
		CittaDao city = new CittaDaoImp();
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		System.out.println("Codice: "+id);
		city.eliminaCitta(id);
		request.getRequestDispatcher("citta").forward(request, response);
	} 
}
