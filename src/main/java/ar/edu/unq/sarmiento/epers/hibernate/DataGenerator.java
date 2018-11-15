package ar.edu.unq.sarmiento.epers.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Component
@Transactional
public class DataGenerator {

	@Autowired
	private DeveloperHome maguitoHome;

	protected void generate() {
		Developer harry = new Developer("Harry", 100);
		harry.addProyecto(new Proyecto("Persistencia"));
		harry.addProyecto(new Proyecto("Libro-matriz-digital"));
		harry.setExperiencia(10);

		Developer gandalf = new Developer("Gandalf", 90);
		gandalf.addProyecto(new Proyecto("Toxi-taxi"));
		gandalf.addProyecto(new Proyecto("Aerolineas"));
		gandalf.setExperiencia(200);

		maguitoHome.saveOrUpdate(harry);
		maguitoHome.saveOrUpdate(gandalf);
	}
}
