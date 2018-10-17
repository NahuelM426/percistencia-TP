package ar.edu.unq.sarmiento.epers.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class UserStory extends Persistible{
	
	private int valorAlCliente;
	private int complejidadEstimada;
	private boolean completado = false; 
	private Rol rol;
	private Projecto proyectoAlQuePertenece;
	private Backlog backlogAlQuePertenece;
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
	public Projecto getProyectoAlQuePertenece() {
		return proyectoAlQuePertenece;
	}
	public void setProyectoAlQuePertenece(Projecto proyectoAlQuePertenece) {
		this.proyectoAlQuePertenece = proyectoAlQuePertenece;
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
