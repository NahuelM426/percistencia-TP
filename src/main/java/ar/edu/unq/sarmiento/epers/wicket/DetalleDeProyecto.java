package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Backlog;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;

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
		
	}
	private void nombreDeMateria() {
		this.add(new Label("nombreMateria", new PropertyModel<>(this.controller, "nombre")));
	}

	
	private void agregarTablaDeMaterias() {
		this.add(new ListView<Backlog>( "filaDeveloper", new PropertyModel<>(this.controller, "lista")) {

			private static final long serialVersionUID = 2426749934569985837L;

			protected void populateItem(ListItem<Backlog> panel) {
				Backlog bac = panel.getModelObject();
				CompoundPropertyModel<Backlog> backlogModel = new CompoundPropertyModel<>(bac);
				
				panel.add(new Label("nombre", backlogModel.bind("nombre")));
				
			}	
		});
	}

}
