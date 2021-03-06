package ar.edu.unq.sarmiento.epers.wicket.ListaDeSprint;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.wicket.ListadoDeProyectos.ListaDeProyectosPage;
import ar.edu.unq.sarmiento.epers.wicket.Sprints.SprintPage;
import ar.edu.unq.sarmiento.epers.wicket.crearDeveloper.CrearUnDeveloperPage;

public class ListaDeSprintsPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean(name = "listaDeSprintsPageController")
	private ListaDeSprintsPageController controller;
	
	public ListaDeSprintsPage (Proyecto proyecto){
		this.controller.setProyecto(proyecto);
		this.crearTablaSprints();
		this.crearSprint();
		this.add(new Link<String>("volver") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListaDeProyectosPage());
			}
		});
	}
	private void crearSprint(){
		this.add(new Link<String>("agregarSprint") {

			@Override
			public void onClick() {
				controller.craerSprinte();
			}
		});
	}
	
	private void crearTablaSprints() {
		this.add(new ListView<Sprint>("filaSprints", new PropertyModel<>(this.controller, "sprints")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Sprint> panel) {
				Sprint sprint= panel.getModelObject();
				panel.add(new Label("idSprints", new PropertyModel<>(sprint, "id")));

				Link<String> botonVerProyecto = new Link<String>("ver") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new SprintPage(controller.getProyecto(), sprint));
					}
				};
				panel.add(botonVerProyecto);
			};
		});
	}
	
}
