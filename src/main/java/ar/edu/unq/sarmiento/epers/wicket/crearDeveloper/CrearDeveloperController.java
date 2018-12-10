package ar.edu.unq.sarmiento.epers.wicket.crearDeveloper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class CrearDeveloperController implements Serializable {

	
	
	@Autowired
	private DeveloperHome home;
	@Autowired
	private ProyectoHome homeProy;
	
	private String nombre = "";	
	private List<Proyecto> proyectos= new ArrayList<>();
	
	private Developer developer;
	private Proyecto proyectoElegido;
	
	
	public List<Proyecto> getProyectos() {
		this.proyectos = homeProy.listaDeTodosLosProyectos();
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto getProyectoElegido() {
		return proyectoElegido;
	}

	public void setProyectoElegido(Proyecto proyectoElegido) {
		this.proyectoElegido = proyectoElegido;
	}

	public DeveloperHome getHome() {
		return home;
	}

	public void setHome(DeveloperHome home) {
		this.home = home;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public void agregarCarrera() {
		if(developer.getNombre() != getNombre()){
		this.developer.setNombre(getNombre());
		home.saveOrUpdate(developer);
		}
	}

	public void confirmarProyecto() {
		this.agregarCarrera();
		this.developer.addProyecto(this.proyectoElegido);
		home.saveOrUpdate(developer);
		
	}

	public void guardar(Developer dev){
		home.saveOrUpdate(dev);
	}

	

}
