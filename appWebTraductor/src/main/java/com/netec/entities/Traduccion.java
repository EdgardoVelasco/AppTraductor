package com.netec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="traducciones")
public class Traduccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lenguajeDetectado;
	private double score;
	private String traduccion;
	private String textoOriginal;
	
	public String getLenguajeDetectado() {
		return lenguajeDetectado;
	}
	public void setLenguajeDetectado(String lenguajeDetectado) {
		this.lenguajeDetectado = lenguajeDetectado;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getTraduccion() {
		return traduccion;
	}
	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}
	public String getTextoOriginal() {
		return textoOriginal;
	}
	public void setTextoOriginal(String textoOriginal) {
		this.textoOriginal = textoOriginal;
	}
	@Override
	public String toString() {
		return "Traduccion [lenguajeDetectado=" + lenguajeDetectado + ", score=" + score + ", traduccion=" + traduccion
				+ ", textoOriginal=" + textoOriginal + "]";
	}

}
