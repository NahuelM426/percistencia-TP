package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.eclipse.jetty.server.Authentication.User;

@Entity
public class Proyecto extends Persistible{

	private static final long serialVersionUID = 7580495859264340032L;
	private String nombre;
	
	@ManyToMany
	private List<Developer> developer = new ArrayList<Developer>();
	@OneToMany
	@JoinColumn(name = "proyecto_id")
	private List<Sprint> sprintBacklogs = new ArrayList<>();
	@OneToMany
	@JoinColumn(name = "proyecto_id")
	private List<UserStory> userStory = new ArrayList<UserStory>();
	


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

	public List<UserStory> getUserStori() {
		return userStory;
	}

	public void addUserStory(UserStory userStori) {
		this.getUserStori().add(userStori);
	}

	public List<Sprint> getSprintBacklogs() {
		return sprintBacklogs;
	}

	public void setSprintBacklogs(List<Sprint> sprintBacklogs) {
		this.sprintBacklogs = sprintBacklogs;
	}
	public void agregarSprint(Sprint sprint){
		this.sprintBacklogs.add(sprint);
	}

	public void removerUser(UserStory bac) {
		this.userStory.remove(bac);
	}
}
