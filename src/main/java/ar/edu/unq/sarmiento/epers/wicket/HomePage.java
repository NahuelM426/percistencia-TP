package ar.edu.unq.sarmiento.epers.wicket;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
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
		this.add(new Link<String>("listadoDeProyectos") {

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
			}
		});
		this.add(new Link<String>("ListaDeDevelopers"){
			
			@Override
			public void onClick(){
				this.setResponsePage(new ListaDeDevelopersPage());
			}
		});
		this.add(new Link<String>("ListaDeProyectos") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListaDeProyectos());
			}
		});
	}
	@SuppressWarnings("serial")
	public HomePage(Developer developer) {
		super();
		this.controller.setDesarrollador(developer);
	}
}	