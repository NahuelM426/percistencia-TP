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

	public List<UserStory> getUserStories() {
		return userStories;
	}
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	public void agregarUserStory(UserStory newUserStory){
		this.userStories.add(newUserStory);
	}
}
