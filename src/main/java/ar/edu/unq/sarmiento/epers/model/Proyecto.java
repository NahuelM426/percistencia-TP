package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Proyecto extends Persistible{

	private static final long serialVersionUID = 7580495859264340032L;
	private String nombre;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
	private List<Developer> developer = new ArrayList<Developer>();
	@OneToOne(mappedBy = "proyecto")
	private Backlog backlog;
	

	public Proyecto() {
	}

	public Proyecto(String nombre, int peso) {
		this.setNombre(nombre);
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Developer> getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer.add(developer);
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

}
