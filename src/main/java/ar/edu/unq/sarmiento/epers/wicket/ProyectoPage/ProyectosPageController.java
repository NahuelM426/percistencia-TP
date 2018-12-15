package ar.edu.unq.sarmiento.epers.wicket.ProyectoPage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Persistible;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Sprint;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ProyectosPageController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Proyecto> proyectos = new ArrayList<>();

	@Autowired
	private ProyectoHome home;
	@Autowired
	private DeveloperHome developerHome;

	private Developer developer;

	private Proyecto newProyecto;

	public DeveloperHome getDeveloperHome() {
		return developerHome;
	}

	public void setDeveloperHome(DeveloperHome developerHome) {
		this.developerHome = developerHome;
	}

	public Proyecto getNewProyecto() {
		return newProyecto;
	}

	public void setNewProyecto(Proyecto newProyecto) {
		this.newProyecto = newProyecto;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public Home<Proyecto> getHome() {
		return this.home;
	}

	public void setHome(ProyectoHome home) {
		this.home = home;
	}

	public List<Proyecto> getProyectos() {
		return this.buscarProyectos(this.developer.getNombre());
	}

	public List<Proyecto> buscarProyectos(String name) {
		return home.findByNamee(name).getProyectos();
	}

	public void confirmarAgregarUserStory() {
		Developer developer1 = developerHome.findByName(this.developer.getNombre());
		developer1.addProyecto(this.newProyecto);
		developerHome.saveOrUpdate(developer1);

	}

	public List<Proyecto> getProyectosLista() {
		List<Proyecto> todosLostProyectos = home.listaDeTodosLosProyectos();
		List<Proyecto> proyectos1 = developerHome.findByName(this.getDeveloper().getNombre()).getProyectos();
		todosLostProyectos.removeAll(proyectos1);
		return todosLostProyectos;
	}
}
