package it.objectmethod.geo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.impl.CittaDaoImp;

@WebServlet(value = "/risultato")
public class RisultatoInserisciCittaServlet extends HttpServlet {

	/**
	 * 
	 */
	//commento js
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Risultato");
		String codice = request.getParameter("nazione");
		String nome = request.getParameter("nomeCitta");
		String regione = request.getParameter("regione");
		String popolazioneStringa = request.getParameter("popolazione");
		String id = request.getParameter("id");
		int popolazioneInt = 0;
		String risultato = "Inserimento riuscito!";
		String forward = null;
		CittaDaoImp referenceCitta = new CittaDaoImp();
		if(id.isEmpty())
		{
			forward = "risultato.jsp";
		if(codice.isEmpty() || nome.isEmpty() || regione.isEmpty() || popolazioneStringa.isEmpty())
		{
			risultato = "Errore";
		}
		else
		{
			try {
			popolazioneInt = Integer.parseInt(popolazioneStringa);
			referenceCitta.inserisciCitta(nome,codice,regione,popolazioneInt);
			}catch(NumberFormatException exe)
			{
				risultato = "Errore, non puoi inserire lettere nel campo della popolazione!";
			}
		}
		}
		else
		{
			forward = "modifica";
		}
		request.setAttribute("risultato", risultato);
		request.getRequestDispatcher(forward).forward(request, response);
	}
}
