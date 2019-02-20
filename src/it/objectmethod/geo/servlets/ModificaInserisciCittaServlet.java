package it.objectmethod.geo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.domain.Citta;

@WebServlet(value = "/inserimento")
public class ModificaInserisciCittaServlet extends HttpServlet {

	private static final String ERRORE = "errore";
	private static final String SUCCESS = "Operazione riuscita!";
	private static final String sInserisci = "inserisci"; //Servlet inserisci
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CittaDao cittaDao = new CittaDaoImp();
		Citta citta = new Citta();
		String idStringa = request.getParameter("id");
		String regione = request.getParameter("regione");
		String nome = request.getParameter("cittaNome");
		String popolazioneStringa = request.getParameter("popolazione");
		String codiceNazione = request.getParameter("codiceNazione");
		String risultato = SUCCESS;
		String servlet = "citta";
		int popolazioneInt = 0;
		int id = Integer.parseInt(idStringa);
		try {
			popolazioneInt = Integer.parseInt(popolazioneStringa);
		}catch(NumberFormatException e) {
			risultato = ERRORE;
			servlet = sInserisci;
		}
		citta.setCountryCode(codiceNazione);
		citta.setDistrict(regione);
		citta.setId(id);
		citta.setNome(nome);
		citta.setPopulation(popolazioneInt);
		if(!controlloDati(citta)|| risultato.compareTo(ERRORE)==0)
		{
			risultato = ERRORE;
			servlet = sInserisci;
		}
		else { //Vedi note FormInserimento + rimuovere ripetizioni codice + programmare a oggetti e usare propriamente il bean citta
			if(id==0) {
				cittaDao.inserisciCitta(nome, codiceNazione, regione, popolazioneInt);
			}
			else {
				cittaDao.modificaCitta(id, regione, nome, codiceNazione, popolazioneInt);
			}
		}

		request.setAttribute("risultato", risultato);
		request.getRequestDispatcher(servlet).forward(request, response);

	}

	boolean controlloDati(Citta citta)
	{
		boolean check = true;

		if(citta.getCountryCode().isEmpty()
				||citta.getDistrict().isEmpty()||citta.getNome().isEmpty())
		{
			check = false;
		}
		return check;
	}
}
