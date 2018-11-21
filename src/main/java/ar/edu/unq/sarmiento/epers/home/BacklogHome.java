package ar.edu.unq.sarmiento.epers.home;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ar.edu.unq.sarmiento.epers.model.Backlog;

@Repository
@Component
public class BacklogHome extends AbstractHome<Backlog>  {

	private static final long serialVersionUID = 1L;

	@Override
	public Backlog findByName(String name) {
		return this.getSession().createQuery("FROM Backlog WHERE nombre = :name", Backlog.class)
				.setParameter("name", name).getSingleResult();
		

	}
}
