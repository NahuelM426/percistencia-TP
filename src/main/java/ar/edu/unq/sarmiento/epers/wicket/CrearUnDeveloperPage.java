package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;


public class CrearUnDeveloperPage extends WebPage {
	@SpringBean(name="crearDeveloperController")
	
	private CrearDeveloperController controller;
	
	public CrearUnDeveloperPage(){
	this(new Developer());
	}
	public CrearUnDeveloperPage(Developer developer){
		controller.setDeveloper(developer);
		this.formularioDeDeveloper();
	}
	
	public void formularioDeDeveloper() {
		Form<CrearDeveloperController> altaCarrera = new Form<CrearDeveloperController>("laCarrera") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				controller.agregarCarrera();
				this.setResponsePage(new HomePage());

			}
		};
		altaCarrera.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());

			}

		});


		altaCarrera.add(new TextField<>("nombre", new PropertyModel<>(controller, "nombre")));

		this.add(altaCarrera);

	}

}
