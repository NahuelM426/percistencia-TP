package ar.edu.unq.sarmiento.epers.hibernate;

import org.hibernate.Session;

import ar.edu.unq.sarmiento.epers.model.Home;
import ar.edu.unq.sarmiento.epers.model.Developer;

public class MaguitoHome implements Home<Developer> {

	private static final long serialVersionUID = 4775910097257163038L;

	static private MaguitoHome instance = new MaguitoHome();
	
	public static MaguitoHome getInstance() {
		return instance;
	}
	
	private Session getSession() {
		return SessionFactoryContainer.getSessionFactory().getCurrentSession();
	}

	@Override
	public Developer findByName(String name) {
		return this.getSession()
				.createQuery("FROM Developer WHERE nombre = :name", Developer.class)
				.setParameter("name", name)
				.getSingleResult();
		
	}

	@Override
	public void insert(Developer object) {
		this.getSession().save(object);
	}

	@Override
	public void update(Developer object) {
		this.getSession().update(object);

	}

	@Override
	public void delete(Developer object) {
		this.getSession().delete(object);
	}

}
