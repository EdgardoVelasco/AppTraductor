package com.netec.entities;

public class Traduccion {
	private int id;
	private String lenguajeDetectado;
	private double score;
	private String traduccion;
	private String textoOriginal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		return "Traduccion [id=" + id + ", lenguajeDetectado=" + lenguajeDetectado + ", score=" + score
				+ ", traduccion=" + traduccion + ", textoOriginal=" + textoOriginal + "]";
	}
	
}
