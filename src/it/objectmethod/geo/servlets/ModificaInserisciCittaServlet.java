package it.objectmethod.geo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;

@WebServlet(value = "/inserimento")
public class ModificaInserisciCittaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String regione = request.getParameter("regione");
		String nome = request.getParameter("cittaNome");
		String popolazioneStringa = request.getParameter("popolazione");
		String codice = request.getParameter("codiceNazione");
		String risultato = "Inserito successo!";
		CittaDao cittaDao = new CittaDaoImp();
		int popolazioneInt = 0;
		if(id.compareToIgnoreCase("0")==0)//Vedi note FormInserimento + rimuovere ripetizioni codice + programmare a oggetti e usare propriamente il bean citta
		{
			if(!controlloDati(codice,regione,nome,popolazioneStringa))
			{
				risultato = "Errore";
			}
			else
			{
				try {
					popolazioneInt = Integer.parseInt(popolazioneStringa);
					cittaDao.inserisciCitta(nome, codice, regione, popolazioneInt);
				}catch(NumberFormatException e) {
					risultato = "errore";
				}
			}
		}
		else {
			if(!controlloDati(codice,regione,nome,popolazioneStringa))
			{
				risultato = "Errore";
			}
			else {
				try {
					popolazioneInt = Integer.parseInt(popolazioneStringa);
					cittaDao.modificaCitta(id, regione, nome, codice, popolazioneInt);
					risultato = "Modificato con successo!";
				}catch(NumberFormatException e) {
					risultato = "errore";
				}
			}
		}
		request.setAttribute("risultato", risultato);
		request.getRequestDispatcher("citta").forward(request, response);

	}

	boolean controlloDati(String codice, String regione, String nome, String popolazione)
	{
		boolean check = true;
		if(codice.isEmpty()||regione.isEmpty()||nome.isEmpty()||popolazione.isEmpty())
		{
			check = false;
		}
		return check;
	}
}
