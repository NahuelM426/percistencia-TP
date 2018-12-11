package ar.edu.unq.sarmiento.epers.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserStory extends Persistible{
	
	private static final long serialVersionUID = 1L;
	private String titulo;
	private int valorAlCliente;
	private int complejidadEstimada;
	private boolean completado = false; 
	private String rol;
	@ManyToOne
	private Proyecto proyecto;
	@OneToMany
	private List<Developer> developers;
	
	public UserStory(int complejidadEstimada, boolean completado,String titulo,int valor,String roll) {
		super();
		this.titulo = titulo;
		this.valorAlCliente = valor;
		this.complejidadEstimada = complejidadEstimada;
		this.completado = completado;
		this.rol = roll;
	}
	public UserStory(){
		
	}
	public int getValorAlCliente() {
		return valorAlCliente;
	}
	public void setValorAlCliente(int valorAlCliente) {
		this.valorAlCliente = valorAlCliente;
	}
	public int getComplejidadEstimada() {
		return complejidadEstimada;
	}
	public void setComplejidadEstimada(int complejidadEstimada) {
		this.complejidadEstimada = complejidadEstimada;
	}
	public boolean isCompletado() {
		return completado;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto Proyecto) {
		this.proyecto = Proyecto;
	}
	public List<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getEstado(){
		if(this.completado == true){
			return "Completado";
		} else {
			return "Sin Completar";
		}
	}
}
