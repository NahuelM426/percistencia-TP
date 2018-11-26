package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;


public class CrearUnDeveloperPage extends WebPage {
	@SpringBean(name="crearDeveloperController")
	private CrearDeveloperController controller;
	private Developer developer;
	
	public CrearUnDeveloperPage(){
	this(new Developer());
	}
	public CrearUnDeveloperPage(Developer developer){
		controller.setDeveloper(developer);
		this.developer=developer;
		this.crearFormAgregar();
	}
	private void crearFormAgregar() {
		Form<CrearDeveloperController> agregarMateria = new Form<CrearDeveloperController>("agregarMateria") {
			private static final long serialVersionUID = 5932937158394555903L;

			@Override
			protected void onSubmit() {
				controller.confirmarProyecto();
				this.setResponsePage(new CrearUnDeveloperPage(CrearUnDeveloperPage.this.controller.getDeveloper()));
				this.setResponsePage(new HomePage());
			}
		};
		agregarMateria.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());

			}

		});

		agregarMateria.add(new DropDownChoice<>(
				// id
				"materia",
				// binding del valor
				new PropertyModel<>(controller, "proyectoElegido"),
				// binding de la lista de items
				new PropertyModel<>(controller, "proyectos"),
				// que se muestra de cada item
				new ChoiceRenderer<>("nombre")));
		this.add(agregarMateria);
		
		agregarMateria.add(new TextField<>("nombre", new PropertyModel<>(controller, "nombre")));

		this.add(agregarMateria);
	}
	
	

}
