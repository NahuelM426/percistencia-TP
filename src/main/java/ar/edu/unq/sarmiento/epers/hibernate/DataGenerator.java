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
		
		Backlog juan=new Backlog("backlog 01");
		Backlog backlog1 = new Backlog("backlog 02");
		Backlog backlog2 = new Backlog("backlog 03");
		Backlog backlog3 = new Backlog("backlog 04");
		Backlog backlog4 = new Backlog("backlog 05");
		
		Sprint sprint1 = new Sprint();
		Sprint sprint2 = new Sprint();
		Sprint sprint3 = new Sprint();
		Sprint sprint4 = new Sprint();
		
		proyecto1.agregarSprint(sprint1);
		proyecto1.agregarSprint(sprint3);
		proyecto2.agregarSprint(sprint2);
		proyecto2.agregarSprint(sprint4);
		
		UserStory userStory1 = new UserStory();
		userStory1.setTitulo("Configurar Travis");
		
		UserStory userStory2 = new UserStory();
		userStory2.setTitulo("Configurar modelo");
		
		Proyecto tp = new Proyecto("tp1", 1);
		Proyecto tp1 = new Proyecto("tp2", 2);
		Proyecto tp2 = new Proyecto("tp3", 3);
		
		tp.setBacklog(juan);
		proyecto1.setBacklog(backlog2);
		proyecto2.setBacklog(backlog4);
		tp2.setBacklog(backlog1);
		tp1.setBacklog(backlog3);
		
		tp.setDeveloper(harry);
		tp.setDeveloper(gandalf);
		tp1.setDeveloper(gandalf);
		
		juan.agregarUserStory(userStory1);
		sprint1.agregarUserStory(userStory1);
		sprint1.agregarUserStory(userStory2);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		backlogHome.saveOrUpdate(juan);
		userStoryHome.saveOrUpdate(userStory1);
		userStoryHome.saveOrUpdate(userStory2);
		proyectosHome.saveOrUpdate(proyecto1);
		developerHome.saveOrUpdate(harry);
		proyectosHome.saveOrUpdate(proyecto2);
		developerHome.saveOrUpdate(gandalf);
		proyectosHome.saveOrUpdate(tp);
		proyectosHome.saveOrUpdate(tp1);
		proyectosHome.saveOrUpdate(tp2);
		sprintHome.saveOrUpdate(sprint1);
		sprintHome.saveOrUpdate(sprint2);
		sprintHome.saveOrUpdate(sprint3);
		sprintHome.saveOrUpdate(sprint4);
		backlogHome.saveOrUpdate(backlog1);
		backlogHome.saveOrUpdate(backlog2);
		backlogHome.saveOrUpdate(backlog3);
		backlogHome.saveOrUpdate(backlog4);
		ts.commit();
		
		System.out.println("Termine!!");
	}
}
