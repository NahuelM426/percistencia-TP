package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Sprint;
import ar.edu.unq.sarmiento.epers.model.UserStory;

public class SprintPage extends WebPage{

	private static final long serialVersionUID = 1L;

	@SpringBean(name = "sprintPageController")
	private SprintPageController controller;
	
	public SprintPage(Sprint sprint){
		this.controller.setSprint(sprint);
		this.add(new Link<String>("cerrarSprint"){
			
			@Override
			public void onClick(){
				controller.getSprint().cerrar();
			}
		});
		this.crearTablaUserStories();
	}

	private void crearTablaUserStories() {
		this.add(new ListView<UserStory>("filaUserStories", new PropertyModel<>(this.controller, "userStories")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> panel) {
				UserStory userStory= panel.getModelObject();
				panel.add(new Label("tituloUserStories", new PropertyModel<>(userStory, "titulo")));

				Link<String> botonVerProyecto = new Link<String>("ver") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						this.setResponsePage(new HomePage());
					}
				};
				panel.add(botonVerProyecto);
			};
		});
	}
}
