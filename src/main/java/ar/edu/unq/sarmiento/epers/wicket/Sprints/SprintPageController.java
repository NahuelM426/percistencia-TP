package ar.edu.unq.sarmiento.epers.wicket.Sprints;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.wicket.model.IModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.SprintHome;
import ar.edu.unq.sarmiento.epers.home.UserStoryHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.model.UserStory;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class SprintPageController implements Serializable{

	private static final long serialVersionUID = 1L;

	private UserStory newUserStory;

	@Autowired
	private SprintHome sprintHome;
	@Autowired
	private ProyectoHome proyectoHome;
	@Autowired 
	private UserStoryHome userStoryHome;
	
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
	
	public List<UserStory> getUserStories(){
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		return this.buscarUserStories(sprint1.getId());
	}
	
	public List<UserStory> buscarUserStories(int id){
		Proyecto proyecto1 = proyectoHome.findByName(this.proyecto.getNombre());
		List<UserStory> stories = sprintHome.find(id).getUserStories().stream().filter(u -> u.isEnSprint() == true).collect(Collectors.toList());
		return stories.stream().filter(u -> u.getProyecto() == proyecto1).collect(Collectors.toList());
	}

	public void cerrarSprint() {
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		Proyecto proyecto1 = proyectoHome.findByName(this.proyecto.getNombre());
		
		sprint1.cerrar();
		
		Sprint sprint = new Sprint();
		sprint.setUserStories(sprint1.buscarUserStoriesSinCompletar());
		
		sprint1.removerUserStoriesSinCompletar();
		proyecto1.agregarSprint(sprint);
		sprintHome.saveOrUpdate(sprint);
		
		sprintHome.saveOrUpdate(sprint1);
		proyectoHome.saveOrUpdate(proyecto1);

	}

	public void confirmarAgregarUserStory() {
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		Proyecto proyecto1 = proyectoHome.findByName(this.proyecto.getNombre());

		sprint1.agregarUserStory(this.newUserStory);
		this.newUserStory.setEnSprint(true);
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
		List<UserStory> userStories = pro.getUserStori().stream().filter(u -> u.isEnSprint() == false).collect(Collectors.toList());
		return userStories.stream().filter(u->u.getProyecto() == pro).collect(Collectors.toList());
	}

	public UserStory getNewUserStory() {
		return newUserStory;
	}

	public void setNewUserStory(UserStory newUserStory) {
		this.newUserStory = newUserStory;
	}

	public void completarUserStory(UserStory userStory) {
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		
		UserStory userStory1 = userStoryHome.findByName(userStory.getTitulo());
		userStory1.setCompletado(true);
		userStoryHome.saveOrUpdate(userStory1);
	}

	public String getEstadoDeUserStory(UserStory userStory) {
		UserStory userStory1 = userStoryHome.find(userStory.getId());
		return userStory1.getEstado();
	}

	public int getComplejidad(UserStory userStory) {
		UserStory userStory1 = userStoryHome.find(userStory.getId());
		
		return userStory1.getComplejidadEstimada();
	}
	
	public int getComplejidadTotalInicial(){
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		sprint1.setComplejidadEstimadaInicial();
		sprintHome.saveOrUpdate(sprint1);
		return sprint1.getComplejidadEstimadaInicial();
	}
	
	public int getComplejidadTotal(){
		Sprint sprint1 = sprintHome.find(this.sprint.getId());
		return sprint1.setComplejidadEstimadaInicial();
	}
	
}
