package ar.edu.unq.sarmiento.epers;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ar.edu.unq.sarmiento.epers.hibernate.MaguitoHome;
import ar.edu.unq.sarmiento.epers.hibernate.SessionFactoryContainer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Developer;

public class GenerateData {

	public static void main(String[] args) {

		SessionFactoryContainer.buildSessionFactory(true);
		Session s = SessionFactoryContainer.getSessionFactory().getCurrentSession();

		Transaction transaction = s.beginTransaction();

		try {
			Developer harry = new Developer("Harry", 100);
			harry.addProyecto(new Proyecto("varita", 1));
			harry.addProyecto(new Proyecto("capa", 3));
			harry.setExperiencia(10);

			Developer gandalf = new Developer("Gandalf", 90);
			gandalf.addProyecto(new Proyecto("baculo", 7));
			gandalf.addProyecto(new Proyecto("sombrero", 2));
			gandalf.setExperiencia(200);

			MaguitoHome.getInstance().insert(harry);
			MaguitoHome.getInstance().insert(gandalf);

			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		} finally {
			s.close();
			SessionFactoryContainer.getSessionFactory().close();
		}

	}

}
