package ar.edu.unq.sarmiento.epers.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserStory extends Persistible{
	
	private int valorAlCliente;
	private int complejidadEstimada;
	private boolean completado = false; 
	private Rol rol;
	@ManyToOne
	private Backlog backlogAlQuePertenece;
	@OneToMany
	private List<Developer> developers;
	public int getValorAlCliente() {
		return valorAlCliente;
	}
	public void setValorAlCliente(int valorAlCliente) {
		this.valorAlCliente = valorAlCliente;
	}
	public int getComplejidadEstimada() {
		return complejidadEstimada;
	}
	public void setComplejidadEstimada(int complejidadEstimada) {
		this.complejidadEstimada = complejidadEstimada;
	}
	public boolean isCompletado() {
		return completado;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Backlog getBacklogAlQuePertenece() {
		return backlogAlQuePertenece;
	}
	public void setBacklogAlQuePertenece(Backlog backlogAlQuePertenece) {
		this.backlogAlQuePertenece = backlogAlQuePertenece;
	}
	public List<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	
}
