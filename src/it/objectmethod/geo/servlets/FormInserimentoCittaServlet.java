package it.objectmethod.geo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.NazioneDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.dao.impl.NazioneDaoImp;
import it.objectmethod.geo.domain.Citta;
import it.objectmethod.geo.domain.Nazione;


@WebServlet(value = "/inserisci")
public class FormInserimentoCittaServlet extends HttpServlet{

	/**
	 * NB:
	 * Carica la form dell'inserimento con tutti i dati della città da modificare!
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet Inserisci");
		List<Nazione> listaNazioni = new ArrayList<>();
		Citta city = new Citta();
		NazioneDao nazioniDao = new NazioneDaoImp();
		CittaDao cittaDao = new CittaDaoImp();
		String idStringa = request.getParameter("id");
		String nazione = request.getParameter("codiceNazione");
		Integer id = Integer.parseInt(idStringa); 
		//TODO correggere, fare parse e fare un confronto tra integer

		listaNazioni = nazioniDao.findAllNazioni();
		System.out.println("id: "+id);
		if(id!=0)
		{
		city = cittaDao.findCittaForId(id);
		}
		request.setAttribute("codiceNazione", nazione);
		request.setAttribute("citta", city);
		request.setAttribute("id", id);
		request.setAttribute("lista",listaNazioni);
		request.getRequestDispatcher("inserisci-citta.jsp").forward(request, response);
	}
}
