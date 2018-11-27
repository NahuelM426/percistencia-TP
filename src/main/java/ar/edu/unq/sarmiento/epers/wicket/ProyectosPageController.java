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
import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Persistible;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ProyectosPageController  implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Proyecto> proyectos = new ArrayList<>();
	
	@Autowired
	private ProyectoHome home;
	
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
	
	public void setHome(ProyectoHome home){
		this.home = home;
	}
	
	public List<Proyecto> getProyectos(){
		return this.buscarProyectos(this.developer.getNombre());
	}
	public List<Proyecto> buscarProyectos(String name){
		return home.findByNamee(name).getProyectos();
	}
}
