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
	//commento js
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codice = request.getParameter("nazione");
		String nome = request.getParameter("nomeCitta");
		String regione = request.getParameter("regione");
		String popolazioneStringa = request.getParameter("popolazione");
		String id = request.getParameter("id");
		long popolazioneLong = 0;
		String risultato = "Inserimento riuscito!";
		String forward = null;
		CittaDaoImp referenceCitta = new CittaDaoImp();
		if(id.isEmpty())
		{
			forward = "ModificaCittaServlet";
		if(codice.isEmpty() || nome.isEmpty() || regione.isEmpty() || popolazioneStringa.isEmpty())
		{
			risultato = "Errore";
		}
		else
		{
			popolazioneLong = Long.parseLong(popolazioneStringa);
			referenceCitta.inserisciCitta(nome,codice,regione,popolazioneLong);
		}
		}
		else
		{
			forward = "risultato.jsp";
		}
		request.setAttribute("risultato", risultato);
		request.getRequestDispatcher(forward).forward(request, response);
	}
}
