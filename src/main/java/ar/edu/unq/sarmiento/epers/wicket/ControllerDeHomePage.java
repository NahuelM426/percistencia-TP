package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Persistible;

@Component
@Transactional
public class ControllerDeHomePage< T extends Persistible > implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Developer desarrollador;
	
	@Autowired
	private DeveloperHome home;
	
	public Developer getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(Developer desarrollador) {
		this.desarrollador = desarrollador;
	}
	public String getNombre(){
		return this.desarrollador.getNombre();
	}
	public java.util.List<Developer> listaDeDeveloper(){
		return home.listaDeDeveloper();
	}
	
}
