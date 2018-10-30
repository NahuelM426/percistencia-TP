package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.model.Developer;
@Component
@Transactional
public class ControllerDeHomePage implements Serializable{
	
	private Developer desarrollador;

	public Developer getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(Developer desarrollador) {
		this.desarrollador = desarrollador;
	}
	public String nombreDeveloper(){
		return desarrollador.getNombre();
	}
	
	
}
