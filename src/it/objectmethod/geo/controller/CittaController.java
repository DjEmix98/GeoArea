package it.objectmethod.geo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.domain.Citta;
@Controller
public class CittaController {

	@RequestMapping("/citta")
	public String nazioni(@RequestParam("codiceNazione") String continente, ModelMap model,HttpServletRequest request)
	{
		CittaDao cittaDao = new CittaDaoImp();
		String codiceNazione = request.getParameter("codiceNazione");
		HttpSession session = request.getSession();
		if(codiceNazione==null)
		{
			codiceNazione = (String) session.getAttribute("codiceNazione");
		}
		List<Citta> listaCitta = cittaDao.findCittaForCode(codiceNazione);
		session.setAttribute("codiceNazione", codiceNazione);
		model.addAttribute("list",listaCitta);
		return "citta";
	}
}
