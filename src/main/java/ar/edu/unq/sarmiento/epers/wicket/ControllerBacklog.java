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
public class ControllerBacklog implements Serializable{
	
	@Autowired
	private BacklogHome home;
	
	private Backlog backlog;

	public BacklogHome getHome() {
		return home;
	}

	public void setHome(BacklogHome home) {
		this.home = home;
	}

	public String nombre(){
		this.backlog= home.findByName("juan");
		return this.backlog.getNombre();
	}
	public Backlog getBacklog() {
		return backlog;
	}
	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}



}
