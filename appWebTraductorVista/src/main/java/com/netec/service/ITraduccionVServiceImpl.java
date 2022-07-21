package com.netec.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.netec.entities.Data;
import com.netec.entities.Traduccion;

@Service
public class ITraduccionVServiceImpl  implements ITraductorVService{
	private final static Logger log=LoggerFactory.getLogger(ITraductorVService.class);

	@Override
	public List<Traduccion> obtenerTodos() {
		  WebClient client = WebClient.builder()
		            .baseUrl("http://localhost:9091/traductor")
		            .build();


		    List<Traduccion> responseSpec = client.get()
		    		.accept(MediaType.APPLICATION_JSON)
		    		.retrieve()
		    		.bodyToMono(new ParameterizedTypeReference<List<Traduccion>>() {})
		    		.block();
		    		
		   for(Traduccion t : responseSpec) {
			   log.info("objeto: "+t);
		   }     	            
		           
		
		return responseSpec;
	}

	@Override
	public Traduccion getTraduccion(Data data) {
		  WebClient client = WebClient.builder()
		            .baseUrl("http://localhost:9091/traductor")
		            .build();


		    Traduccion responseSpec = client.post()
		    	
		    		.uri(t->t.queryParam("idioma", data.getIdioma())
		    				.queryParam("texto", data.getTexto())
		    		.build())
		            .contentType(MediaType.APPLICATION_JSON)
		            .retrieve()
		            .bodyToMono(Traduccion.class).block();
		    return responseSpec;
	}
	

	
}
