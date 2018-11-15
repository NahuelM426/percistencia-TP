package ar.edu.unq.sarmiento.epers.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Component
public class DataGenerator {

	@Autowired
	private Home<Developer> developerHome;
	@Autowired
	private Home<Proyecto> proyectosHome; 
	@Autowired
	private SessionFactory sessionFactory;

	protected void generate() {
		Developer harry = new Developer("Harry");
		harry.addProyecto(new Proyecto("varita", 1));
		harry.addProyecto(new Proyecto("capa", 3));

		Developer gandalf = new Developer("Gandalf");
		gandalf.addProyecto(new Proyecto("baculo", 7));
		gandalf.addProyecto(new Proyecto("sombrero", 2));
		
		Proyecto tp = new Proyecto("tp", 1);
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
		developerHome.saveOrUpdate(harry);
		developerHome.saveOrUpdate(gandalf);
		proyectosHome.saveOrUpdate(tp);
		ts.commit();
		
		System.out.println("Termine!!");
	}
}
