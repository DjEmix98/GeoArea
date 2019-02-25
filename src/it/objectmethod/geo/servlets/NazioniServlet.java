package it.objectmethod.geo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.geo.dao.NazioneDao;
import it.objectmethod.geo.dao.impl.NazioneDaoImp;
import it.objectmethod.geo.domain.Nazione;

@WebServlet(value = "/nazionic")
public class NazioniServlet  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NazioneDao nazioneDao = new NazioneDaoImp();
		String continente = request.getParameter("nazioni");
		HttpSession session = request.getSession();
		if(continente==null)
		{
			continente = (String) session.getAttribute("nazioni");
		}
		List<Nazione> listaNazioni = nazioneDao.findNazioni(continente);
		session.setAttribute("nazioni", continente);
		request.setAttribute("list", listaNazioni);
		request.getRequestDispatcher("nazioni.jsp").forward(request, response);
	}
}
