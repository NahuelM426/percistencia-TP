package ar.edu.unq.sarmiento.epers.wicket;

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

public class ListaDeProyectos extends WebPage {
	
	@SpringBean(name="controllerListadoDeProyectos")
	private ControllerListadoDeProyectos controller;
	
	public ListaDeProyectos(){
		this(new Proyecto());
		this.add(new Link<String>("carreraHome") {

			@Override
			public void onClick() {
				this.setResponsePage(new CreaProyecto());
			}
		});
	}
	@SuppressWarnings("serial")
	public ListaDeProyectos(Proyecto pro){
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
