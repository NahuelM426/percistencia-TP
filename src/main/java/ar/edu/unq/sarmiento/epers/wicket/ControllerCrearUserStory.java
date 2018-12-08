package ar.edu.unq.sarmiento.epers.wicket;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.epers.home.ProyectoHome;
import ar.edu.unq.sarmiento.epers.home.UserStoryHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Rol;
import ar.edu.unq.sarmiento.epers.model.UserStory;
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ControllerCrearUserStory implements Serializable {
	
	@Autowired 
	private ProyectoHome home; 
	@Autowired
	private UserStoryHome home2;
	
	private Proyecto proyecto;
	private UserStory nueva;
	
	private String titulo;
	private int valorAlCliente;
	private int complejidad;
	private boolean completado = false; 
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getValorAlCliente() {
		return valorAlCliente;
	}

	public void setValorAlCliente(int valorAlCliente) {
		this.valorAlCliente = valorAlCliente;
	}

	public UserStory getNueva() {
		return nueva;
	}

	public void setNueva(UserStory nueva) {
		this.nueva = nueva;
	}

	public ProyectoHome getHome() {
		return home;
	}

	public void setHome(ProyectoHome home) {
		this.home = home;
	}
	public void attch(Proyecto pro){
		home.attach(pro);
	}
	
	
	public int getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(int complejidadEstimada) {
		this.complejidad = complejidadEstimada;
	}

	public boolean getCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public void confirmar() {
		Proyecto pro = home.findByName(this.proyecto.getNombre());
		pro.addUserStory(crearUser());
		home.saveOrUpdate(pro);
	}
	public UserStory crearUser(){
		UserStory user = new UserStory(getComplejidad(), getCompletado(),getTitulo(),getValorAlCliente());
		home2.saveOrUpdate(user);
		return user;
	}

	public Proyecto buscarProyecto(Proyecto pro){
		return home.findByName(pro.getNombre());
	}
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}



}
