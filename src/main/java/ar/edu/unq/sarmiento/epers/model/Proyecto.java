package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Proyecto extends Persistible{

	private static final long serialVersionUID = 7580495859264340032L;
	private String nombre;
	@Transient
	private List<Backlog> backlogs = new ArrayList<>();
	@ManyToOne
	private Developer developer;

	public Proyecto() {
	}

	public Proyecto(String nombre) {
		this.setNombre(nombre);
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

	public List<Backlog> getBacklogs() {
		return backlogs;
	}

	public void setBacklogs(List<Backlog> backlogs) {
		this.backlogs = backlogs;
	}

	public void addBacklog(Backlog backlog){
		this.backlogs.add(backlog);
	}
}
