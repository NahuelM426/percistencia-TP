package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerListadoDeProyectos implements Serializable  {

	@Autowired
	private ProyectoHome home;
	
	private Proyecto proyecto;
	private String nombre="";
	
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

	public List<Proyecto> lista(){
		return home.listaDeTodosLosProyectos();
	}
	public void eliminar(Proyecto por){
		home.delete(por);
	}

	public void confirmarProyecto() {
		proyecto.setNombre(getNombre());
		home.saveOrUpdate(proyecto);
		
	}
}
