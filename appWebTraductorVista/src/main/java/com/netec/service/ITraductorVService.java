package com.netec.service;

import java.util.List;

import com.netec.entities.Data;
import com.netec.entities.Traduccion;

public interface ITraductorVService {
	Traduccion getTraduccion(Data data);
	List<Traduccion> obtenerTodos();

}
