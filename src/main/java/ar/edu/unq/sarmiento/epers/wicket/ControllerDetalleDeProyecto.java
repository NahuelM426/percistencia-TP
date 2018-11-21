package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.ProyectosHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Persistible;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerDetalleDeProyecto implements Serializable {
	
	private Proyecto proyecto;

	@Autowired
	private ProyectosHome home; 
	
	public void setProyecto(Proyecto proyecto) {
		this.proyecto= proyecto;
	}

	public ProyectosHome getHome() {
		return home;
	}

	public void setHome(ProyectosHome home) {
		this.home = home;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}
	public List<Developer> lista(){
		return this.listadoDeDeveloperDeProy("tp1");
	}
	public List<Developer> listadoDeDeveloperDeProy(String name){
		return home.findByName(name).getDeveloper();
	}
	public String nombre(){
		this.proyecto = home.findByName("baculo");
		return this.proyecto.getNombre();
	}
	

}
