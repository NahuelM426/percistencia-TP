package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.home.ProyectosHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Persistible;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ProyectosPageController < T extends Persistible > implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Proyecto> proyectos = new ArrayList<>();
	
	@Autowired
	private ProyectosHome home;
	
	private Developer developer;
	
	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
	public Home<Proyecto> getHome(){
		return this.home;
	}
	
	public void setHome(ProyectosHome home){
		this.home = home;
	}
	
	public List<Proyecto> proyectos(){
		return this.buscarProyectos(this.developer.getNombre());
	}
	public List<Proyecto> buscarProyectos(String name){
		return home.findByNamee(name).getProyectos();
	}
}
