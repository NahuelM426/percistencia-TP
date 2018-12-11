package ar.edu.unq.sarmiento.epers.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Developer extends Persistible {

	private static final long serialVersionUID = -786414214144659508L;
	private String nombre = "";
	
	@ManyToMany(cascade=CascadeType.REFRESH)
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();

	public Developer() {
	}

	public Developer(String nombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Proyecto proyectos) {
		this.proyectos.add(proyectos);
	}

	public void addProyecto(Proyecto project) {
		this.getProyectos().add(project);
	}

}
