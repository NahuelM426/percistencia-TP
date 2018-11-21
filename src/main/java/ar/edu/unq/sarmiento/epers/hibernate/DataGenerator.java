package ar.edu.unq.sarmiento.epers.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.model.Backlog;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Component
public class DataGenerator {

	@Autowired
	private Home<Developer> developerHome;
	@Autowired
	private Home<Proyecto> proyectosHome;
	@Autowired
	private Home<Backlog> backlogHome;
	@Autowired
	private SessionFactory sessionFactory;

	protected void generate() {
		Developer harry = new Developer("Harry");
		harry.addProyecto(new Proyecto("varita", 1));
		harry.addProyecto(new Proyecto("capa", 3));

		Developer gandalf = new Developer("Gandalf");
		gandalf.addProyecto(new Proyecto("baculo", 7));
		gandalf.addProyecto(new Proyecto("sombrero", 2));
		
		Backlog juan=new Backlog("juan");
		
		Proyecto tp = new Proyecto("tp1", 1);
		Proyecto tp1 = new Proyecto("tp2", 2);
		Proyecto tp2 = new Proyecto("tp3", 3);
		tp.setBacklog(juan);
		tp.setDeveloper(harry);
		tp.setDeveloper(gandalf);
		tp1.setDeveloper(gandalf);
		
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		backlogHome.saveOrUpdate(juan);
		developerHome.saveOrUpdate(harry);
		developerHome.saveOrUpdate(gandalf);
		proyectosHome.saveOrUpdate(tp);
		proyectosHome.saveOrUpdate(tp1);
		proyectosHome.saveOrUpdate(tp2);
		
		ts.commit();
		
		System.out.println("Termine!!");
	}
}
