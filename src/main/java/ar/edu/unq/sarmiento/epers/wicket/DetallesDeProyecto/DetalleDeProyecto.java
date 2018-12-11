package ar.edu.unq.sarmiento.epers.wicket.DetallesDeProyecto;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.UserStory;
import ar.edu.unq.sarmiento.epers.wicket.ListadoDeProyectos.ListaDeProyectosPage;
import ar.edu.unq.sarmiento.epers.wicket.agregarUserStory.AgregarUserStory;
import ar.edu.unq.sarmiento.epers.wicket.listadoDeDeveloper.ListaDeDevelopersPage;

public class DetalleDeProyecto extends WebPage {
	
	private static final int ListItem = 0;
	
	@SpringBean(name="controllerDetalleDeProyecto")
	private ControllerDetalleDeProyecto controller;
	
	public DetalleDeProyecto() {
		this(new Proyecto());
	}
	@SuppressWarnings("serial")
	public DetalleDeProyecto(Proyecto proy) {
		super();
		this.controller.setProyecto(proy);
		this.agregarTablaDeMaterias();
		this.nombreDeMateria();
		this.add(new Link<String>("proyectoHome") {

			@Override
			public void onClick() {
				this.setResponsePage(new AgregarUserStory(proy));
			}
		});
		this.add(new Link<String>("volver") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListaDeProyectosPage());
			}
		});
		
		
	}
	private void nombreDeMateria() {
		this.add(new Label("nombreMateria", new PropertyModel<>(this.controller, "nombre")));
	}

	
	private void agregarTablaDeMaterias() {
		this.add(new ListView<UserStory>( "filaDeveloper", new PropertyModel<>(this.controller, "lista")) {

			private static final long serialVersionUID = 2426749934569985837L;

			protected void populateItem(ListItem<UserStory> panel) {
				UserStory bac = panel.getModelObject();
				CompoundPropertyModel<UserStory> backlogModel = new CompoundPropertyModel<>(bac);
				
				
				panel.add(new Label("titulo", backlogModel.bind("titulo")));
				panel.add(new Label("valorAlCliente", backlogModel.bind("valorAlCliente")));
				panel.add(new Label("complejidad", backlogModel.bind("complejidadEstimada")));
				panel.add(new Label("completado", backlogModel.bind("completado")));
				panel.add(new Label("rol", backlogModel.bind("rol")));
			
				Link<String> botonEliminar = new Link<String>("eliminar") {
					private static final long serialVersionUID = 3672370417232954427L;

					@Override
					public void onClick() {

						controller.eliminar(bac);
					}
				};	Link<String> botoncompletado = new Link<String>("completar") {
					private static final long serialVersionUID = 3672370417232954427L;

					@Override
					public void onClick() {

						controller.completadoUserStory(bac);
					}
				};
				panel.add(botoncompletado);
				panel.add(botonEliminar);
			}
		});
	
	}
	
}
