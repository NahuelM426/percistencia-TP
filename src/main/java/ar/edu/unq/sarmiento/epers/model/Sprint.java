package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Sprint extends Persistible{

	private static final long serialVersionUID = 1L;
	@OneToMany
	@JoinColumn(name = "sprint_id")
	private List<UserStory> userStories = new ArrayList<>();
	private boolean estaAbierto = true;
	private int complejidadEstimadaInicial;
	public List<UserStory> getUserStories() {
		return userStories;
	}
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	public void agregarUserStory(UserStory newUserStory){
		if(this.estaAbierto == true){
			this.userStories.add(newUserStory);
		}
	}	
	public boolean isEstaAbierto() {
		return estaAbierto;
	}
	public void cerrar(){
		this.estaAbierto = false;
	}
	public String getEstado(){
		if(estaAbierto == true){
			return "Abierto";
		} else{
			return "Cerrado";
		}
	}
	
	public List<UserStory> buscarUserStoriesSinCompletar(){
		return this.userStories.stream().filter(u -> u.isCompletado() == false).collect(Collectors.toList());
	}
	public void removerUserStoriesSinCompletar(){
		this.userStories.removeAll(this.buscarUserStoriesSinCompletar());
	}
	public int setComplejidadEstimadaInicial() {
		if(this.estaAbierto == true){
			return this.complejidadEstimadaInicial = this.userStories.stream().mapToInt(u -> u.getComplejidadEstimada()).sum();
		} else{
			return this.userStories.stream().mapToInt(u -> u.getComplejidadEstimada()).sum();
		}
	}
	
	public int getComplejidadEstimadaInicial() {
		return complejidadEstimadaInicial;
	}
	public void setComplejidadEstimadaInicial(int complejidadEstimadaInicial) {
		this.complejidadEstimadaInicial = complejidadEstimadaInicial;
	}
	
}
