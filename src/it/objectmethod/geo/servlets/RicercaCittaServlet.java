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
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.domain.Citta;

@WebServlet(value = "/ricerca")
public class RicercaCittaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CittaDao referenceCitta = new CittaDaoImp();
		List<Citta> listaCitta = new ArrayList<Citta>();
		String textCity ="%"+ request.getParameter("ricercaCity")+"%";
		String popolazione = request.getParameter("nPopolazione");
		String operatore = request.getParameter("operatore");
		String codiceNazione = request.getParameter("nazione");
		String error = null;
		int nPopolazione = convertiStringa(popolazione);
		if(nPopolazione<0)
		{
			error = "Errore, non puoi inserire un numero negativo o una lettera";
		}
		else
		{
			boolean bOperatore = valoreOperatore(operatore);
			listaCitta = referenceCitta.findCittaForFilter(textCity, codiceNazione, nPopolazione, bOperatore);
		}
		System.out.println(listaCitta.size());
		request.setAttribute("lista", listaCitta);
		request.setAttribute("error",error);
		request.getRequestDispatcher("ricerca-citta.jsp").forward(request, response);
	}

	int convertiStringa(String daConvertire)
	{
		int stringaConvertita;
		try {
			stringaConvertita = Integer.parseInt(daConvertire);
			return stringaConvertita;
		}catch(NumberFormatException e)
		{
			if(daConvertire.isEmpty())
			{
				return stringaConvertita = 0;
			}
			return stringaConvertita= -1;
		}
	}

	boolean valoreOperatore(String operatore) //true se è maggiore false se è minore
	{
		boolean bOperatore = true;
		try {
		if(operatore.compareToIgnoreCase("minore")==0)
		{
			return bOperatore = false;
		}
		}catch(java.lang.NullPointerException ex) {
			return bOperatore;
		}
		return bOperatore;
	}
}
