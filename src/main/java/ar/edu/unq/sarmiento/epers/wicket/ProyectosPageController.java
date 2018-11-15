package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.home.ProyectosHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Persistible;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Component
@Transactional
public class ProyectosPageController < T extends Persistible > implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public List<Proyecto> proyectos(){
		return home.listaDeDeveloper();
	}
}
