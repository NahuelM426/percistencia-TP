package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.BacklogHome;
import ar.edu.unq.sarmiento.epers.model.Backlog;
import ar.edu.unq.sarmiento.epers.model.Persistible;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerBacklog < T extends Persistible > implements Serializable{
	
	@Autowired
	private BacklogHome home;
	
	private Proyecto proyecto;

	public BacklogHome getHome() {
		return home;
	}

	public void setHome(BacklogHome home) {
		this.home = home;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}
	public Backlog nobre(){
		return this.buscar(this.proyecto.getBacklog().getNombre());
	}
	public Backlog buscar(String name){
		return home.findByName(name);
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
