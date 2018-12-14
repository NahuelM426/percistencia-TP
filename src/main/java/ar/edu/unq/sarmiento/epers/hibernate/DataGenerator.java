package ar.edu.unq.sarmiento.epers.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.SprintHome;
import ar.edu.unq.sarmiento.epers.home.UserStoryHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.model.UserStory;

@Component
public class DataGenerator {

	@Autowired
	private DeveloperHome developerHome;
	@Autowired
	private ProyectoHome proyectosHome;
	@Autowired
	private SprintHome sprintHome;
	@Autowired
	private UserStoryHome userStoryHome;
	@Autowired
	private SessionFactory sessionFactory;

	protected void generate() {
		Developer harry = new Developer("Harry");
		Proyecto proyecto1 = new Proyecto("Libro Matriz", 3);
		harry.addProyecto(proyecto1);
		
		Developer gandalf = new Developer("Gandalf");
		Proyecto proyecto2 = new Proyecto("Toxy-taxi", 7);
		gandalf.addProyecto(proyecto2);
		
		Sprint sprint1 = new Sprint();
		Sprint sprint2 = new Sprint();
		
		Sprint sprint5 = new Sprint();
		
		proyecto1.agregarSprint(sprint1);
		proyecto2.agregarSprint(sprint2);
		
		UserStory userStory1 = new UserStory();
		userStory1.setTitulo("Configurar Travis");
		userStory1.setCompletado(true);
		userStory1.setComplejidadEstimada(5);
		userStory1.setEnSprint(true);
		userStory1.setProyecto(proyecto1);
		UserStory userStory2 = new UserStory();
		userStory2.setTitulo("Configurar modelo");
		userStory2.setComplejidadEstimada(3);
		userStory2.setEnSprint(true);
		userStory2.setProyecto(proyecto1);
		UserStory story3 = new UserStory();
		story3.setTitulo("Modificar ReadMe");
		
		UserStory story4 = new UserStory();
		story4.setTitulo("Configurar cardinalidades");
		
		proyecto1.addUserStory(story3);
		proyecto1.addUserStory(story4);


		sprint1.agregarUserStory(userStory1);
		sprint1.agregarUserStory(userStory2);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		userStoryHome.saveOrUpdate(userStory1);
		userStoryHome.saveOrUpdate(userStory2);
		userStoryHome.saveOrUpdate(story3);
		userStoryHome.saveOrUpdate(story4);
		proyectosHome.saveOrUpdate(proyecto1);
		developerHome.saveOrUpdate(harry);
		proyectosHome.saveOrUpdate(proyecto2);
		developerHome.saveOrUpdate(gandalf);
		sprintHome.saveOrUpdate(sprint1);
		sprintHome.saveOrUpdate(sprint2);
		sprintHome.saveOrUpdate(sprint5);
		ts.commit();
		
		System.out.println("Termine!!");
	}
}
