package ar.edu.unq.sarmiento.epers.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Proyecto extends Persistible{

	private static final long serialVersionUID = 7580495859264340032L;
	private String nombre;
	private int peso;
	
	@ManyToOne
	private Developer developer;

	public Proyecto() {
	}

	public Proyecto(String nombre, int peso) {
		this.setNombre(nombre);
		this.setPeso(peso);
	}

	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}


}