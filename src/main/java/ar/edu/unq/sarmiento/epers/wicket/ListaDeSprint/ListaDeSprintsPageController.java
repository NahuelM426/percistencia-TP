package ar.edu.unq.sarmiento.epers.wicket.ListaDeSprint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.wicket.request.component.IRequestablePage;
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
public class ListaDeSprintsPageController implements Serializable{

	private Proyecto proyecto;
	@Autowired
	private ProyectoHome home;
	@Autowired SprintHome sprintHome;
	
	private List<Sprint> sprints = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public ProyectoHome getHome() {
		return home;
	}

	public void setHome(ProyectoHome home) {
		this.home = home;
	}

	public List<Sprint> getSprints() {
		return home.findByName(proyecto.getNombre()).getSprintBacklogs();
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void craerSprinte() {
		Sprint sprint = new Sprint();
		sprintHome.saveOrUpdate(sprint);
		Proyecto proyecto1 = home.findByName(proyecto.getNombre());
		proyecto1.setSprint(sprint);
		home.saveOrUpdate(proyecto1);
	}
}
