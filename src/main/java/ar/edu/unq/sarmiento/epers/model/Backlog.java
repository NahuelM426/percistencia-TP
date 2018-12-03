package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Backlog extends Persistible{

	private static final long serialVersionUID = 1L;

	@OneToMany
	private List<UserStory> userStories= new ArrayList<>();
	
	private String nombre;
	
	public Backlog(){
	}
	public Backlog(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<UserStory> getUserStories() {
		return userStories;
	}
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	public void agregarUserStory(UserStory userstory){
		this.userStories.add(userstory);
	}
}