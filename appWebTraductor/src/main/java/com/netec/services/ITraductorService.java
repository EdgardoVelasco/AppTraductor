package com.netec.services;

import java.util.List;

import com.netec.entities.Traduccion;

public interface ITraductorService {
	
	Traduccion getTraduccion(String idioma, String texto);
	
	List<Traduccion> getTraducciones();

}
