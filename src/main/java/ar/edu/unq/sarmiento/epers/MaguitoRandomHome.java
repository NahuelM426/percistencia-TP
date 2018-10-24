package ar.edu.unq.sarmiento.epers;

import java.util.Random;

import org.hibernate.Session;

import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.home.Home;
import ar.edu.unq.sarmiento.epers.model.Developer;

public class MaguitoRandomHome implements Home<Developer>{

	private static final long serialVersionUID = 5914747011225145115L;
	static MaguitoRandomHome instance = new MaguitoRandomHome();
	
	@Override
	public Developer findByName(String name) {
		Developer result = new Developer();
		result.setNombre(name);
		result.setVida(new Random().nextInt(100));
		Proyecto item = new Proyecto();
		item.setNombre("primer item");
		item.setPeso(new Random().nextInt(100));
		result.addProyecto(item);
		item = new Proyecto();
		item.setNombre("segundo item");
		item.setPeso(new Random().nextInt(100));
		result.addProyecto(item);
		return result;
	}

	public static MaguitoRandomHome getInstance() {
		return instance;
	}



	@Override
	public void delete(Developer object) {
		
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Developer find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Developer object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attach(Developer result) {
		// TODO Auto-generated method stub
		
	}

}
