package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.AbstractHome;
import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.model.Developer;
@Component
@Transactional
public class ControllerDeHomePage implements Serializable {
	
	private Developer desarrollador;
	@Autowired
	private Home<Developer> home;

	public Developer getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(Developer desarrollador) {
		this.desarrollador = desarrollador;
	}
	public void buscarDeveloper(){
		this.desarrollador = this.findByName(desarrollador.getNombre());
	}
	public String getNombre(){
		return this.desarrollador.getNombre();
	}


	public Home<Developer> getHome() {
		return home;
	}

	public void setHome(Home<Developer> home) {
		this.home = home;
	}

	public Developer findByName(String name) {
		return home.findByName(name);
//		return this.getSession().createQuery("FROM Developer WHERE nombre = :name", Developer.class)
//				.setParameter("name", name).getSingleResult();
	}
	
	
}
