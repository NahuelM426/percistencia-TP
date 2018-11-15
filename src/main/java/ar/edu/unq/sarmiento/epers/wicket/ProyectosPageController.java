package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.home.ProyectosHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class ProyectosPageController implements Serializable{

	private List<Proyecto> proyectos = new ArrayList<>();
	@Autowired
	private ProyectosHome home;

	public ProyectosPageController(Developer developer) {
		super();
		this.proyectos = developer.getProyectos();
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	public Home<Proyecto> getHome(){
		return this.home;
	}
	
	public void setHome(ProyectosHome home){
		this.home = home;
	}
	
	public Proyecto findByName(String name){
		return home.findByName(name);
	}
}
