package it.objectmethod.geo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.domain.Citta;

@WebServlet(value = "/cittaz")
public class CittaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//commento citta
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet citta");
		CittaDao cittaDao = new CittaDaoImp();
		String code = request.getParameter("codiceNazione");
		HttpSession session = request.getSession();
		if(code==null)
		{
			code = (String) session.getAttribute("codiceNazione");
		}
		List<Citta> listaCitta = cittaDao.findCittaForCode(code);
		session.setAttribute("codiceNazione", code);
		request.setAttribute("list", listaCitta);
		request.getRequestDispatcher("citta.jsp").forward(request, response);
	}

}
