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
	
	private Proyecto proyecto;
	
	private int complejidad;
	private boolean completado = false; 
	private Rol rol;
	
	public int getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(int complejidadEstimada) {
		this.complejidad = complejidadEstimada;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public void confirmar() {
		UserStory user = new UserStory();
		user.setComplejidadEstimada(this.complejidad);
		user.setRol(this.rol);
		user.setCompletado(this.completado);
		this.proyecto.setUserStori(user);
		home.saveOrUpdate(proyecto);
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}



}
