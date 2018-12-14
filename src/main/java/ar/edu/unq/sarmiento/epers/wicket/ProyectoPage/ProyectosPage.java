
package ar.edu.unq.sarmiento.epers.wicket.ProyectoPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.wicket.DetallesDeProyecto.DetalleDeProyecto;
import ar.edu.unq.sarmiento.epers.wicket.Sprints.SprintPageController;
import ar.edu.unq.sarmiento.epers.wicket.crearDeveloper.CrearUnDeveloperPage;
import ar.edu.unq.sarmiento.epers.wicket.listadoDeDeveloper.ListaDeDevelopersPage;

public class ProyectosPage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	@SpringBean(name = "proyectosPageController")
	private ProyectosPageController controller;
	
	
	public ProyectosPage(Developer developer) {
		this.controller.setDeveloper(developer);
		this.crearTablaProyectos();
		this.add(new Link<String>("volver") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListaDeDevelopersPage());
			}
		});
		this.crearFormAgregar();
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
	private void crearFormAgregar() {
		Form<SprintPageController> agregarProyeto = new Form<SprintPageController>("agregarProyecto") {
			private static final long serialVersionUID = 5932937158394555903L;

			@Override
			protected void onSubmit() {
				controller.confirmarAgregarUserStory();
			}
		};

		agregarProyeto.add(new DropDownChoice<>(
				// id
				"titulo",
				// binding del valor
				new PropertyModel<>(controller, "newProyecto"),
				// binding de la lista de items
				new PropertyModel<>(controller, "proyectosLista"),
				// que se muestra de cada item
				new ChoiceRenderer<>("nombre")));
		this.add(agregarProyeto);
	}
	
}
