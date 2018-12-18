package ar.edu.unq.sarmiento.epers.wicket.Sprints;

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

import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.model.UserStory;
import ar.edu.unq.sarmiento.epers.wicket.ListaDeSprint.ListaDeSprintsPage;
import ar.edu.unq.sarmiento.epers.wicket.home.HomePage;

public class SprintPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean(name = "sprintPageController")
	private SprintPageController controller;

	public SprintPage(Proyecto proyecto, Sprint sprint) {
		this.controller.setSprint(sprint);
		this.controller.setProyecto(proyecto);
		this.nombreDeMateriaElegida();
		this.add(new Link<String>("cerrarSprint") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				controller.cerrarSprint();
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(controller.getEstadoDeSprint() == "Abierto");
			}
		});
		this.add(new Link<String>("volver") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListaDeSprintsPage(proyecto));
			}
		});
		this.crearTablaUserStories();
		this.crearFormAgregar();
		this.complejidadEstimada();
		this.complejidadTotal();
	}

	private void complejidadTotal() {
		this.add(new Label("complejidadTotal", new PropertyModel<>(this.controller, "complejidadTotal")));
		
	}

	private void crearFormAgregar() {
		Form<SprintPageController> agregarUserStory = new Form<SprintPageController>("agregarUserStory") {
			private static final long serialVersionUID = 5932937158394555903L;

			@Override
			protected void onSubmit() {
				controller.confirmarAgregarUserStory();
			}
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(controller.getEstadoDeSprint() == "Abierto");
			}
		};

		agregarUserStory.add(new DropDownChoice<>(
				// id
				"titulo",
				// binding del valor
				new PropertyModel<>(controller, "newUserStory"),
				// binding de la lista de items
				new PropertyModel<>(controller, "listaDeUserStories"),
				// que se muestra de cada item
				new ChoiceRenderer<>("titulo")));
		this.add(agregarUserStory);
	}

	private void crearTablaUserStories() {
		this.add(new ListView<UserStory>("filaUserStories", new PropertyModel<>(this.controller, "userStories")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> panel) {
				UserStory userStory = panel.getModelObject();
				panel.add(new Label("tituloUserStories", new PropertyModel<>(userStory, "titulo")));
				panel.add(new Label("complejidad", controller.getComplejidad(userStory)));
				panel.add(new Label("completado", controller.getEstadoDeUserStory(userStory)));
				Link<String> completarUserStory = new Link<String>("completar") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						controller.completarUserStory(userStory);
					}

					@Override
					protected void onConfigure() {
						super.onConfigure();
						setVisible(controller.getEstadoDeUserStory(userStory) == "Sin Completar");
					}
				};
				panel.add(completarUserStory);
			};
		});
	}

	private void nombreDeMateriaElegida() {
		this.add(new Label("estadoDeSprint", new PropertyModel<>(this.controller, "estadoDeSprint")));
	}
	private void complejidadEstimada() {
		this.add(new Label("complejidadTotalInicial", new PropertyModel<>(this.controller, "complejidadTotalInicial")));
	}
}
