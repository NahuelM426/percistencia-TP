package ar.edu.unq.sarmiento.epers.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.epers.home.BacklogHome;
import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.SprintHome;
import ar.edu.unq.sarmiento.epers.home.UserStoryHome;
import ar.edu.unq.sarmiento.epers.model.Backlog;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Rol;
import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.model.UserStory;

@Component
public class DataGenerator {

	@Autowired
	private DeveloperHome developerHome;
	@Autowired
	private ProyectoHome proyectosHome;
	@Autowired
	private BacklogHome backlogHome;
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
		UserStory userStory1 = new UserStory();
		userStory1.setComplejidadEstimada(2);
		userStory1.setRol(Rol.Usuario);
		userStory1.setCompletado(false);
		proyecto1.setUserStori(userStory1);
		
		Proyecto tp = new Proyecto("tp1", 1);
		Proyecto tp1 = new Proyecto("tp2", 2);
		Proyecto tp2 = new Proyecto("tp3", 3);
		
		tp.setDeveloper(harry);
		tp.setDeveloper(gandalf);
		tp1.setDeveloper(gandalf);

		sprint1.agregarUserStory(userStory1);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
//		backlogHome.saveOrUpdate(juan);
		developerHome.saveOrUpdate(harry);
		proyectosHome.saveOrUpdate(proyecto1);
//		developerHome.saveOrUpdate(gandalf);
//		proyectosHome.saveOrUpdate(tp);
//		proyectosHome.saveOrUpdate(tp1);
//		proyectosHome.saveOrUpdate(tp2);
		userStoryHome.saveOrUpdate(userStory1);
//		sprintHome.saveOrUpdate(sprint1);
//		backlogHome.saveOrUpdate(backlog1);
		ts.commit();
		
		System.out.println("Termine!!");
	}
}
