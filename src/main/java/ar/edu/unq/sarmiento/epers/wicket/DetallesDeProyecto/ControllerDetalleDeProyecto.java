package ar.edu.unq.sarmiento.epers.wicket.DetallesDeProyecto;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.UserStoryHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.UserStory;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerDetalleDeProyecto implements Serializable {
	
	private Proyecto proyecto;

	@Autowired
	private ProyectoHome proyectoHome; 
	@Autowired
	private UserStoryHome userStoryHome;
	
	

	public void setProyecto(Proyecto proyecto) {
		this.proyecto= proyecto;
	}

	public ProyectoHome getHome() {
		return proyectoHome;
	}

	public void setHome(ProyectoHome home) {
		this.proyectoHome = home;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}
	public List<UserStory> getLista(){
		return buscaProyecto().getUserStori();
	}
	public Proyecto buscaProyecto(){
		return proyectoHome.findByName(proyecto.getNombre());
	}
	public String nombre(){
		return this.proyecto.getNombre();
	}

	public void eliminar(UserStory bac) {
		userStoryHome.delete(bac);
	}

	public void completadoUserStory(UserStory bac) {
		UserStory userStory = userStoryHome.find(bac.getId());
		userStory.setCompletado(true);
		userStoryHome.saveOrUpdate(userStory);
		
	}
	
}
