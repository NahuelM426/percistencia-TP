package ar.edu.unq.sarmiento.epers.wicket.Sprints;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.SprintHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.model.UserStory;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class SprintPageController implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserStory newUserStory;

	@Autowired
	private SprintHome sprintHome;
	@Autowired
	private ProyectoHome proyectoHome;

	private Sprint sprint;

	private Proyecto proyecto;

	public Home<Sprint> getHome() {
		return sprintHome;
	}

	public void setHome(SprintHome home) {
		this.sprintHome = home;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public List<UserStory> getUserStories() {
		return this.buscarUserStories(this.sprint.getId());
	}

	public List<UserStory> buscarUserStories(int id) {
		return sprintHome.find(id).getUserStories();

	}

	public void cerrarSprint() {
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		sprint1.cerrar();
		Proyecto proyecto1 = proyectoHome.findByName(this.proyecto.getNombre());

		Sprint sprint = new Sprint();
		sprint.setUserStories(sprint1.buscarUserStoriesSinCompletar());

		sprint1.removerUserStoriesSinCompletar();
		proyecto1.agregarSprint(sprint);
		sprintHome.saveOrUpdate(sprint1);
		sprintHome.saveOrUpdate(sprint);
		proyectoHome.saveOrUpdate(proyecto1);

	}

	public void confirmarAgregarUserStory() {
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		sprint1.agregarUserStory(this.newUserStory);

		Proyecto proyecto1 = proyectoHome.findByName(this.proyecto.getNombre());

		proyecto1.removerUser(newUserStory);
		sprintHome.saveOrUpdate(sprint1);

		proyectoHome.saveOrUpdate(proyecto1);

	}

	public String getEstadoDeSprint() {
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		return sprint1.getEstado();
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public List<UserStory> getListaDeUserStories() {
		Proyecto pro = proyectoHome.findByName(proyecto.getNombre());
		return pro.getUserStori();

	}

	public UserStory getNewUserStory() {
		return newUserStory;
	}

	public void setNewUserStory(UserStory newUserStory) {
		this.newUserStory = newUserStory;
	}

}
