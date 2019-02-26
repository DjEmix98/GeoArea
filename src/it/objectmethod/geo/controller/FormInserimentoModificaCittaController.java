package it.objectmethod.geo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.geo.controllodati.ControlloDati;
import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.NazioneDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;
import it.objectmethod.geo.dao.impl.NazioneDaoImp;
import it.objectmethod.geo.domain.Citta;
import it.objectmethod.geo.domain.Nazione;

@Controller
public class FormInserimentoModificaCittaController {

	private static final String ERRORE = "errore";
	private static final String SUCCESS = "Operazione riuscita!";
	private static final String MAPPING_INSERISCI = "inserisci"; 
	private static final String MAPPING_CITTA = "citta"; 

	@RequestMapping("/inserisci")
	public String formInserimento(@PathParam("codiceNazione") String codiceNazione,@RequestParam("id") String idStringa,ModelMap model) {
		List<Nazione> listaNazioni = new ArrayList<>();
		Citta city = new Citta();
		NazioneDao nazioniDao = new NazioneDaoImp();
		CittaDao cittaDao = new CittaDaoImp();
		Integer id=0;
		if(idStringa!=null)
		{
			id = Integer.parseInt(idStringa);
		}
		listaNazioni = nazioniDao.findAllNazioni();
		city = cittaDao.findCittaById(id);
		System.out.println("regione: "+city.getDistrict());
		model.addAttribute("codiceNazione",codiceNazione);
		model.addAttribute("citta", city);
		model.addAttribute("id", id);
		model.addAttribute("lista",listaNazioni);
		return "inserisci-citta";		
	}
	@RequestMapping("/inserimento")
	public void inserimentoOrModifica(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		CittaDao cittaDao = new CittaDaoImp();
		Citta citta = new Citta();
		String idStringa = request.getParameter("id");
		String regione = request.getParameter("regione");
		String nome = request.getParameter("cittaNome");
		String popolazioneStringa = request.getParameter("popolazione");
		String codiceNazione = request.getParameter("codiceNazione");
		String risultato = SUCCESS;
		String pagina = MAPPING_CITTA;
		int popolazioneInt = 0;
		int id = Integer.parseInt(idStringa);
		try {
			popolazioneInt = Integer.parseInt(popolazioneStringa);
		}catch(NumberFormatException e) {
			risultato = ERRORE;
			pagina = MAPPING_INSERISCI;;
		}
		citta.setCountryCode(codiceNazione);
		citta.setDistrict(regione);
		citta.setId(id);
		citta.setNome(nome);
		citta.setPopulation(popolazioneInt);
		if(!ControlloDati.controlloDati(citta)|| risultato.compareTo(ERRORE)==0)
		{
			risultato = ERRORE;
			pagina = MAPPING_INSERISCI;
		}
		else { 
			if(id==0) {
				cittaDao.inserisciCitta(citta);
			}
			else {
				cittaDao.modificaCitta(citta);
			}
		}
		request.setAttribute("risultato", risultato);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}
