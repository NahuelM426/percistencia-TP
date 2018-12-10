package ar.edu.unq.sarmiento.epers.wicket.ListadoDeProyectos;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.wicket.DetallesDeProyecto.DetalleDeProyecto;
import ar.edu.unq.sarmiento.epers.wicket.ListaDeSprint.ListaDeSprintsPage;
import ar.edu.unq.sarmiento.epers.wicket.crearProyecto.CreaProyectoPage;

public class ListaDeProyectosPage extends WebPage {
	
	@SpringBean(name="controllerListadoDeProyectos")
	private ControllerListadoDeProyectos controller;
	
	public ListaDeProyectosPage(){
		this(new Proyecto());
		this.add(new Link<String>("proyectoHome") {

			@Override
			public void onClick() {
				this.setResponsePage(new CreaProyectoPage());
			}
		});
	}
	@SuppressWarnings("serial")
	public ListaDeProyectosPage(Proyecto pro){
		controller.setProyecto(pro);
		this.agregarTablaDeMaterias();
	}
	
	private void agregarTablaDeMaterias() {
		this.add(new ListView<Proyecto>( "filaDeveloper", new PropertyModel<>(this.controller, "lista")) {

			private static final long serialVersionUID = 2426749934569985837L;

			protected void populateItem(ListItem<Proyecto> panel) {
				Proyecto proyecto = panel.getModelObject();
				CompoundPropertyModel<Proyecto> proyectoModel = new CompoundPropertyModel<>(proyecto);
				panel.add(new Label("nombre", proyectoModel.bind("nombre")));
				
				Link<String> botonVerSprint = new Link<String>("sprintProyecto"){
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick(){
						this.setResponsePage(new ListaDeSprintsPage(proyecto));
					}
				};
				
				panel.add(botonVerSprint);
					
				Link<String> botonEliminar = new Link<String>("eliminar") {
					private static final long serialVersionUID = 3672370417232954427L;

					@Override
					public void onClick() {

						controller.eliminar(proyecto);
					}
				};
				Link<String> agregara = new Link<String>("detalles") {
					private static final long serialVersionUID = 3672370417232954427L;

					@Override
					public void onClick() {
						this.setResponsePage(new DetalleDeProyecto(proyecto));

					}
				};
				panel.add(botonEliminar);
				panel.add(agregara);
			}	
		});
		
	}
}
