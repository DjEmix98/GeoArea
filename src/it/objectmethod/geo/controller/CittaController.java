package it.objectmethod.geo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.geo.checkparam.OperatorValue;
import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.domain.Citta;
@Controller
public class CittaController {

	private final String ERROR = "Errore, non puoi inserire un numero negativo o una lettera";
	@RequestMapping("/citta")
	public String citta(@PathParam("codiceNazione") String codiceNazione, ModelMap model,HttpServletRequest request)
	{
		CittaDao cittaDao = new CittaDaoImp();
		HttpSession session = request.getSession();
		if(codiceNazione==null)
		{
			codiceNazione = (String) session.getAttribute("codiceNazione");
		}
		List<Citta> listaCitta = cittaDao.findCittaByCode(codiceNazione);
		session.setAttribute("codiceNazione", codiceNazione);
		model.addAttribute("list",listaCitta);
		return "citta";
	}

	@RequestMapping("/ricerca")
	public String ricercaCitta(@PathParam("codiceNazione") String codiceNazione,@PathParam("operatore") String operatore,HttpServletRequest request, ModelMap model)
	{
		CittaDao cittaDao = new CittaDaoImp();
		List<Citta> listaCitta = new ArrayList<Citta>();
		String popolazoneString = request.getParameter("popolazione");
		String errore = null;
		int popolazione;
		if(popolazoneString.isEmpty())
		{
			popolazione=0;
		}
		else {
			try {
				popolazione = Integer.parseInt(popolazoneString);
			}catch(java.lang.NumberFormatException ex) {
				popolazione = -1;
			}
		}
		if(popolazione<0)
		{
			errore = ERROR;
		}
		else
		{
			Citta city = new Citta();
			city.setNome("%"+ request.getParameter("ricercaCity")+"%");
			city.setCountryCode(codiceNazione);
			city.setPopulation(popolazione);
			boolean bOperatore = OperatorValue.valoreOperatore(operatore);
			listaCitta = cittaDao.findCittaByCityandFlag(city, bOperatore);
		}
		model.addAttribute("lista", listaCitta);
		model.addAttribute("error", errore);
		return "ricerca-citta";
	}
}
