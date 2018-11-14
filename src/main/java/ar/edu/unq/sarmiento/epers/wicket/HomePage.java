package ar.edu.unq.sarmiento.epers.wicket;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;

public class HomePage extends WebPage{
	private static final int ListItem = 0;
	
	@SpringBean(name="controllerDeHomePage")
	private ControllerDeHomePage controller;
	
	public HomePage(){
		this(new Developer());
	}
	@SuppressWarnings("serial")
	public HomePage(Developer developer) {
		super();
		this.controller.setDesarrollador(developer);
		this.nombreDeDeveloper();
	}
	private void nombreDeDeveloper() {
		this.add(new Label("nombreDeveloper", new PropertyModel(controller, "nombre")));
	}
	
}
