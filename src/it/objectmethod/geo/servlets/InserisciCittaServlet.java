package it.objectmethod.geo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.impl.NazioneDaoImp;
import it.objectmethod.geo.domain.Nazione;


@WebServlet(value = "/inserisci")
public class InserisciCittaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Nazione> listaNazioni = new ArrayList<>();
		String id = request.getParameter("id");
		NazioneDaoImp referenceNazioni = new NazioneDaoImp();
		listaNazioni = referenceNazioni.findAllNazioni();
		request.setAttribute("id", id);
		request.setAttribute("lista", listaNazioni);
		request.getRequestDispatcher("inserisci-citta.jsp").forward(request, response);
	}
}
