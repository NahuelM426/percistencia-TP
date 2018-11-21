package ar.edu.unq.sarmiento.epers.home;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ar.edu.unq.sarmiento.epers.model.Sprint;

@Repository
@Component
public class SprintHome extends AbstractHome<Sprint> {

	private static final long serialVersionUID = 1L;

	@Override
	public Sprint findByName(String name) {
		return this.getSession().createQuery("FROM Sprint WHERE nombre = :name", Sprint.class)
				.setParameter("name", name).getSingleResult();		
	}

}
