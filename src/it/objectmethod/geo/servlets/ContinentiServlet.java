package it.objectmethod.geo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.geo.dao.NazioneDao;
import it.objectmethod.geo.dao.impl.NazioneDaoImp;
import it.objectmethod.geo.domain.Nazione;

@WebServlet(value = "/continenti")
public class ContinentiServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NazioneDao referenceZone = new NazioneDaoImp();
		List<String> listaZone = referenceZone.findContinenti();
		List<Nazione> listaNazioni = referenceZone.findAllNazioni();
		request.setAttribute("list", listaZone);
		request.setAttribute("lista", listaNazioni);
		request.getRequestDispatcher("continenti.jsp").forward(request, response);
	}
}
