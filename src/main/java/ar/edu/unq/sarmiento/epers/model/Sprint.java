package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Sprint extends Persistible{
	
	@OneToMany
	private List<UserStory> userStories = new ArrayList<>();
	@Transient
	private List<Rol> roles = new ArrayList<>();
	
	public List<UserStory> getUserStories() {
		return userStories;
	}
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public void agregarUserStory(UserStory newUserStory){
		this.userStories.add(newUserStory);
	}	
	public void agregarRol(Rol rol){
		this.roles.add(rol);
	}
}
