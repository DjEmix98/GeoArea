package it.objectmethod.geo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.impl.CittaDaoImp;

@WebServlet(value = "/risultato")
public class RisultatoCittaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codice = request.getParameter("codice");
		String nome = request.getParameter("nomeCitta");
		CittaDaoImp referenceCitta = new CittaDaoImp();
		referenceCitta.inserisciCitta(nome, codice);
		request.setAttribute("code", codice);
		request.getRequestDispatcher("risultato.jsp").forward(request, response);
	}
}
