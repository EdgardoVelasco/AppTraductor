package com.netec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netec.entities.Traduccion;
import com.netec.services.ITraductorService;

@RestController
public class HomeController {
	@Autowired
	private ITraductorService servicio;
	
	@PostMapping("/traductor")
	public Traduccion getTraduccion(@RequestParam String idioma, @RequestParam String texto) {
		return servicio.getTraduccion(idioma, texto);
	}
	
	
	@GetMapping("/traductor")
	public List<Traduccion> getAllTraducciones(){
	   return servicio.getTraducciones();	
	}
	


}
