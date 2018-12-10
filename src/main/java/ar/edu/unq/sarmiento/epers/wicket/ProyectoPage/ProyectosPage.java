
package ar.edu.unq.sarmiento.epers.wicket.ProyectoPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.wicket.DetallesDeProyecto.DetalleDeProyecto;

public class ProyectosPage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	@SpringBean(name = "proyectosPageController")
	private ProyectosPageController controller;
	
	
	public ProyectosPage(Developer developer) {
		this.controller.setDeveloper(developer);
		this.crearTablaProyectos();
	}

	private void crearTablaProyectos() {
		this.add(new ListView<Proyecto>("filaProyectos", new PropertyModel<>(this.controller, "proyectos")) {
			private static final long serialVersionUID = 5512414749510820593L;

			@Override
			protected void populateItem(ListItem<Proyecto> panel) {
				Proyecto proyecto = panel.getModelObject();
				panel.add(new Label("nombreProyectos", new PropertyModel<>(proyecto, "nombre")));

				Link<String> botonVerProyecto = new Link<String>("ver") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new DetalleDeProyecto(proyecto));
					}
				};
				panel.add(botonVerProyecto);
			};
		});
	}

}
