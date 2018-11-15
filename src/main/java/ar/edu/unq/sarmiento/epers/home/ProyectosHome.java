package ar.edu.unq.sarmiento.epers.home;

import java.util.List;

import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class ProyectosHome extends AbstractHome<Proyecto>{

	private static final long serialVersionUID = 1L;

	@Override
	public Proyecto findByName(String name) {
		return this.getSession().createQuery("FROM Proyecto WHERE nombre = :name", Proyecto.class)
				.setParameter("name", name).getSingleResult();		
	}

	public List<Proyecto> listaDeDeveloper(){
		return this.getSession().createQuery("FROM Proyecto", Proyecto.class).list();
	}
}
