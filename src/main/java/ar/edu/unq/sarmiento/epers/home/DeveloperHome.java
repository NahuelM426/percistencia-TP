package ar.edu.unq.sarmiento.epers.home;

import org.springframework.stereotype.Repository;

import ar.edu.unq.sarmiento.epers.model.Developer;

@Repository
public class DeveloperHome extends AbstractHome<Developer> {

	private static final long serialVersionUID = 4775910097257163038L;

	@Override
	public Developer findByName(String name) {
		return this.getSession().createQuery("FROM Developer WHERE nombre = :name", Developer.class)
				.setParameter("name", name).getSingleResult();
		

	}
	public java.util.List<Developer> listaDeDeveloper(){
		return this.getSession().createQuery("FROM Developer", Developer.class).list();
	}

}
