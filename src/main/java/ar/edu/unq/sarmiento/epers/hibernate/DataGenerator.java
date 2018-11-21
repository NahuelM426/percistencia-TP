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
		harry.addProyecto(new Proyecto("Persistencia", 1));
		harry.addProyecto(new Proyecto("Libro Matriz", 3));

		Developer gandalf = new Developer("Gandalf");
		gandalf.addProyecto(new Proyecto("Toxy-taxi", 7));
		gandalf.addProyecto(new Proyecto("Aerolineas", 2));
		
		Backlog juan=new Backlog("juan");
		
		Sprint sprint1 = new Sprint();
		UserStory userStory1 = new UserStory();
		
		Proyecto tp = new Proyecto("tp1", 1);
		Proyecto tp1 = new Proyecto("tp2", 2);
		Proyecto tp2 = new Proyecto("tp3", 3);
		
		tp.setBacklog(juan);
		tp.setDeveloper(harry);
		tp.setDeveloper(gandalf);
		tp1.setDeveloper(gandalf);
		juan.setSprint(sprint1);
		juan.agregarUserStory(userStory1);
		sprint1.agregarUserStory(userStory1);
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		backlogHome.saveOrUpdate(juan);
		developerHome.saveOrUpdate(harry);
		developerHome.saveOrUpdate(gandalf);
		proyectosHome.saveOrUpdate(tp);
		proyectosHome.saveOrUpdate(tp1);
		proyectosHome.saveOrUpdate(tp2);
		userStoryHome.saveOrUpdate(userStory1);
		sprintHome.saveOrUpdate(sprint1);
		ts.commit();
		
		System.out.println("Termine!!");
	}
}
