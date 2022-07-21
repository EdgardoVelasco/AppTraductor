package com.netec.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.netec.entities.Data;
import com.netec.service.ITraductorVService;

@Controller
public class HomeController {
	private static final Logger log= LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ITraductorVService servicio;
	@GetMapping("/")
	public String inicio(Model model) {
	    model.addAttribute("traducciones", servicio.obtenerTodos());
		return "formulario_traductor";
	}
	
	@PostMapping("/salvar")
	public String accion(Data data) {
		log.info("Datos: "+data);
	    servicio.getTraduccion(data);
		return "redirect:/";
	}

}
