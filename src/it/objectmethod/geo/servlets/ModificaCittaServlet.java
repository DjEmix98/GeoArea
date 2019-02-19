package it.objectmethod.geo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.impl.CittaDaoImp;

@WebServlet(value = "/modifica")
public class ModificaCittaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String regione = request.getParameter("regione");
		String nome = request.getParameter("nomeCitta");
		String popolazioneString = request.getParameter("popolazione");
		String code = request.getParameter("nazione");
		String risultato = "Modificato con successo!";
		CittaDaoImp referenceCitta = new CittaDaoImp();
		int popolazioneInt = 0;
		if(id.isEmpty()||regione.isEmpty()||nome.isEmpty()||popolazioneString.isEmpty())
		{
			risultato = "Errore";
		}
		else
		{
			System.out.println("Modifico...");
			popolazioneInt = Integer.parseInt(popolazioneString);
			System.out.println("ID: "+id+" regione: "+regione+" nome: "+nome+ " popolazione: "+popolazioneString);
			referenceCitta.modificaCitta(id, regione, nome,code,popolazioneInt);
		}
		request.setAttribute("risultato", risultato);
		request.getRequestDispatcher("risultato.jsp").forward(request, response);
	}
}
