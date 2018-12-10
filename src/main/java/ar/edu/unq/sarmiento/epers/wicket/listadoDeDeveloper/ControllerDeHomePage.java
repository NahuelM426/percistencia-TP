package ar.edu.unq.sarmiento.epers.wicket.listadoDeDeveloper;

import java.io.Serializable;

import org.apache.wicket.request.component.IRequestablePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Persistible;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerDeHomePage implements Serializable {
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

	public void Eliminar(Developer develp) {
		home.delete(develp);
		
	}
	
}
