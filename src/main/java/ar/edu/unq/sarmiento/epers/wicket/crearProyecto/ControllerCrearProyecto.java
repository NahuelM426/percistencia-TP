package ar.edu.unq.sarmiento.epers.wicket.crearProyecto;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.SprintHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Sprint;
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerCrearProyecto implements Serializable {

	@Autowired
	private ProyectoHome proyectoHome;
	@Autowired
	private SprintHome sprintHome;
	
	private String nombre="";
	private Proyecto proyecto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public void confirmarProyecto() {
		Sprint sprint = new Sprint();
		sprintHome.saveOrUpdate(sprint);
		this.proyecto.setNombre(getNombre());
		this.proyecto.setSprint(sprint);
		proyectoHome.saveOrUpdate(proyecto);
	}
}
