package com.netec.entities;

public class Data {
   private String idioma;
   private String texto;
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Data [idioma=" + idioma + ", texto=" + texto + "]";
	}
	
   
}
