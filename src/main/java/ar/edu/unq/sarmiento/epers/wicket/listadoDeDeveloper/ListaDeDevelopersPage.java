package ar.edu.unq.sarmiento.epers.wicket.listadoDeDeveloper;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.wicket.DetallesDeProyecto.DetalleDeProyecto;
import ar.edu.unq.sarmiento.epers.wicket.ProyectoPage.ProyectosPage;
import ar.edu.unq.sarmiento.epers.wicket.crearDeveloper.CrearUnDeveloperPage;

public class ListaDeDevelopersPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private static final int ListItem = 0;
	
	@SpringBean(name="controllerDeHomePage")
	private ControllerDeHomePage controller;
	
	public ListaDeDevelopersPage(){
		this(new Developer());
		this.add(new Link<String>("listadoDeCarreras") {

			@Override
			public void onClick() {
				this.setResponsePage(new DetalleDeProyecto());
			}
		});
		this.add(new Link<String>("CrearDeveloper") {

			@Override
			public void onClick() {
				this.setResponsePage(new CrearUnDeveloperPage());
			}
		});
	}
	@SuppressWarnings("serial")
	public ListaDeDevelopersPage(Developer developer) {
		super();
		this.controller.setDesarrollador(developer);
		this.agregarTablaDeDevelopers();
	
	}
	

	
	private void agregarTablaDeDevelopers() {
		this.add(new ListView<Developer>( "filaDeveloper", new PropertyModel<>(this.controller, "listaDeDeveloper")) {

			private static final long serialVersionUID = 2426749934569985837L;

			protected void populateItem(ListItem<Developer> panel) {
				Developer developer = panel.getModelObject();
				CompoundPropertyModel<Developer> developerModel = new CompoundPropertyModel<>(developer);
				panel.add(new Label("nombre", developerModel.bind("nombre")));
				
				Link<String> botonAsignar = new Link<String>("detalles") {
					private static final long serialVersionUID = 3672370417232954427L;

					@Override
					public void onClick() {

						this.setResponsePage(new ProyectosPage(developer));
					}
				};
				Link<String> botonEliminar = new Link<String>("eliminar") {
					private static final long serialVersionUID = 3672370417232954427L;

					@Override
					public void onClick() {

						controller.Eliminar(developer);
					}
				};
				panel.add(botonAsignar);
				panel.add(botonEliminar);
			}	
		});
	}
}
