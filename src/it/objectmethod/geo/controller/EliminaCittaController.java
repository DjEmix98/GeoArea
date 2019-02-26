package it.objectmethod.geo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.geo.dao.CittaDao;
import it.objectmethod.geo.dao.impl.CittaDaoImp;

@Controller
public class EliminaCittaController {
	@RequestMapping("/elimina")
	public void elimina(@RequestParam("id")int id,HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		CittaDao city = new CittaDaoImp();
		city.eliminaCitta(id);
		request.getRequestDispatcher("citta").forward(request, response);
	}
}
