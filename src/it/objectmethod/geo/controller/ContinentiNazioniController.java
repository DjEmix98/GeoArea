package it.objectmethod.geo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.geo.dao.NazioneDao;
import it.objectmethod.geo.dao.impl.NazioneDaoImp;
import it.objectmethod.geo.domain.Nazione;



@Controller
public class ContinentiNazioniController {

	@RequestMapping("/continenti")
	public String continenti(ModelMap model) {
		NazioneDao nazioneDao = new NazioneDaoImp();
		List<String> listaContinenti = nazioneDao.findContinenti();
		List<Nazione> listaNazioni = nazioneDao.findAllNazioni();
		model.addAttribute("list",listaContinenti);
		model.addAttribute("lista",listaNazioni);
		return "continenti";		
	}
	
	@RequestMapping("/nazioni")
	public String nazioni(@PathParam("continente") String continente,ModelMap model,HttpServletRequest request)
	{
		NazioneDao nazioneDao = new NazioneDaoImp();
		HttpSession session = request.getSession();
		System.out.println("Sessione: "+session);
		if(continente==null)
		{
			continente = (String) session.getAttribute("continente");
		}
		List<Nazione> listaNazioni = nazioneDao.findNazioni(continente);
		session.setAttribute("continente",continente);
		model.addAttribute("list",listaNazioni);
		return "nazioni";
	}
	
	
}
