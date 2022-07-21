package com.netec.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.netec.dao.ITraduccionDAO;
import com.netec.entities.Traduccion;

@Service
public class TraduccionServiceImpl implements ITraductorService{
	
	@Autowired
	private  ITraduccionDAO dao;
	private static final Logger LOG=LoggerFactory.getLogger(TraduccionServiceImpl.class);

	@Override
	public Traduccion getTraduccion(String idioma, String texto) {
	    WebClient client = WebClient.builder()
	            .baseUrl("https://traductorenvf.cognitiveservices.azure.com/")
	            .build();


	    String responseSpec = client.post()
	    	
	    		.uri(t->t.path("/translator/text/v3.0/translate").queryParam("to", idioma)
	    		.build())
	            .headers(h -> h.add("Ocp-Apim-Subscription-Key", "5feabf01e64346afb296a6ff34629e07"))
	            .headers(h->h.add("Ocp-Apim-Subscription-Region", "eastus"))
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(BodyInserters.fromValue("[{'Text': '"+texto+"'}]"))
	            .exchange()
	            .flatMap(clientResponse -> {
	                if (clientResponse.statusCode().is5xxServerError()) {
	                    clientResponse.body((clientHttpResponse, context) -> {
	      	                  LOG.info("return 1");
	                        return clientHttpResponse.getBody();
	                    });
	                        LOG.info("return 2");
	                    return clientResponse.bodyToMono(String.class);
	                }
	                else
	                	LOG.info("return 3");
	               
	                    
	                    return clientResponse.bodyToMono(String.class);
	            })
	            .block();
	   
	    String subs=responseSpec.substring(responseSpec.indexOf("["),  responseSpec.length()-1);
	    String sub2=subs.substring(responseSpec.indexOf("{"), subs.length()-1);
	    String [] arr=sub2.split("},");
	    LOG.info("salida original");
	    LOG.info(responseSpec);
	    LOG.info("-..-.-.salida.--.-.");
	    Traduccion tr=new Traduccion();
	    String datos1=arr[0].substring(21, arr[0].length());
	    String datos2=arr[1].substring(17, arr[1].length()-3).split(",")[0];
	    //tr.setLenguajeDetectado(datos1.split(",")[0].split(":")[1].replace('"', ' ').strip());
	    tr.setLenguajeDetectado(idioma);
	    tr.setScore(Double.parseDouble(datos1.split(",")[1].split(":")[1].strip()));
	    tr.setTraduccion(datos2.split(":")[1].replace('"', ' ').strip());
	    tr.setTextoOriginal(texto);
	    
	    dao.save(tr);
	    LOG.info("SE ha insertado correctamente objeto");
	    LOG.info(tr.toString());
	    LOG.info("0: "+arr[0].substring(21, arr[0].length()));
	    LOG.info("1: "+arr[1].substring(17, arr[1].length()-3));
	    LOG.info("separando cadena: "+sub2);
	    
	    return tr;
	}

	@Override
	public List<Traduccion> getTraducciones() {
		
		return (List<Traduccion>)dao.findAll();
	}
	
	

}
