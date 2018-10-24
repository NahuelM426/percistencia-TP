package ar.edu.unq.sarmiento.epers;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.epers.model.Home;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class ControlerProyecto implements Home<Proyecto> {	
	private Proyecto proyectoDecrip;
	
	@Autowired
	private Session session;
	
public ControlerProyecto (Proyecto proyecto){
	proyectoDecrip = proyecto; 
}

public String nombreProyecto(){
	return proyectoDecrip.getNombre();
}

private Session getSession() {
	return session.getSessionFactory().getCurrentSession();
}

@Override
public Proyecto findByName(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void insert(Proyecto object) {
	getSession().save(object);
}

@Override
public void update(Proyecto object) {
	getSession().update(object);
}

@Override
public void delete(Proyecto object) {
	getSession().delete(object);
}
}
