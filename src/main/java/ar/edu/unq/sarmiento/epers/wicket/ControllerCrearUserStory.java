package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.UserStoryHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Rol;
import ar.edu.unq.sarmiento.epers.model.UserStory;
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerCrearUserStory implements Serializable {
	
	@Autowired 
	private ProyectoHome home; 
	@Autowired
	private UserStoryHome home2;
	private Proyecto proyecto;
	
	public ProyectoHome getHome() {
		return home;
	}

	public void setHome(ProyectoHome home) {
		this.home = home;
	}

	private int complejidad;
	private boolean completado = false; 
	
	public int getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(int complejidadEstimada) {
		this.complejidad = complejidadEstimada;
	}

	public boolean getCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public void confirmar() {
		UserStory user = new UserStory(getComplejidad(),getCompletado());
		home2.saveOrUpdate(user);
		proyecto.addUserStory(user);
		home.saveOrUpdate(proyecto);
	}

	public Proyecto buscarProyecto(Proyecto pro){
		return home.findByName(pro.getNombre());
	}
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		home.attach(proyecto);
		this.proyecto = proyecto;
	}



}
