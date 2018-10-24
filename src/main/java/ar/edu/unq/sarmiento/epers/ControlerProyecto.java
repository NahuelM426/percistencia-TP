package ar.edu.unq.sarmiento.epers;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.epers.home.Home;
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

@Override
public Proyecto findByName(String name) {
	// TODO Auto-generated method stub
	return null;
}


public void insert(Proyecto object) {
	this.session.save(object);
}

public void update(Proyecto object) {
	this.session.update(object);
}

@Override
public void delete(Proyecto object) {
	this.session.delete(object);
}

@Override
public Session getSession() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Proyecto find(Integer id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void saveOrUpdate(Proyecto object) {
	// TODO Auto-generated method stub
	
}

@Override
public void attach(Proyecto result) {
	// TODO Auto-generated method stub
	
}
}
