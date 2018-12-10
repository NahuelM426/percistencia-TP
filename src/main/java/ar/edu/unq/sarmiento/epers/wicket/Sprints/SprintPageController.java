package ar.edu.unq.sarmiento.epers.wicket.Sprints;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.home.SprintHome;
import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.model.UserStory;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class SprintPageController implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<UserStory> userStories;
	@Autowired
	private SprintHome home;
	
	private Sprint sprint;
	
	public Home<Sprint> getHome() {
		return home;
	}

	public void setHome(SprintHome home) {
		this.home = home;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
	public List<UserStory> getUserStories(){
		return this.buscarUserStories(this.sprint.getId());
	}
	
	public List<UserStory> buscarUserStories(int id){
		return home.find(id).getUserStories();
	}

	public void cerrarSprint() {
		this.sprint.cerrar();
		home.saveOrUpdate(sprint);
	}

}
