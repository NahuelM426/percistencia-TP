package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class CrearDeveloperController implements Serializable {

	private Developer developer;
	@Autowired
	private DeveloperHome home;
	
	private String nombre = "";
	
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
		Developer developer1 = new Developer(getNombre());
		home.saveOrUpdate(developer1);
		
	}

	

}
