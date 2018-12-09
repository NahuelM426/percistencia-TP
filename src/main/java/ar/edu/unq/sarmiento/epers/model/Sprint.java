package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Sprint extends Persistible{

	private static final long serialVersionUID = 1L;
	@OneToMany
	@JoinColumn(name = "sprin_id")
	private List<UserStory> userStories = new ArrayList<>();
	private boolean estaAbierto = true;
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
}
