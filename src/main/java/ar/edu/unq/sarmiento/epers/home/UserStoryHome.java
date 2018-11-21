package ar.edu.unq.sarmiento.epers.home;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ar.edu.unq.sarmiento.epers.model.UserStory;

@Repository
@Component
public class UserStoryHome extends AbstractHome<UserStory>{

	private static final long serialVersionUID = 1L;

	@Override
	public UserStory findByName(String name) {
		return this.getSession().createQuery("FROM UserStory WHERE nombre = :name", UserStory.class)
				.setParameter("name", name).getSingleResult();		
	}
}
