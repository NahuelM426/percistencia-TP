package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class CreaProyectoPage extends WebPage {
	@SpringBean(name="controllerCrearProyecto")
	private ControllerCrearProyecto controller;
	
	public CreaProyectoPage (){
		this(new Proyecto());
	}
	public CreaProyectoPage(Proyecto pro){
		this.controller.setProyecto(pro);
		this.crearProyecto();
	}
	public void crearProyecto(){
		Form<CrearDeveloperController> agregarMateria = new Form<CrearDeveloperController>("agregarMateria") {
			private static final long serialVersionUID = 5932937158394555903L;

			@Override
			protected void onSubmit() {
				controller.confirmarProyecto();
				this.setResponsePage(new HomePage());
			}
		};

		agregarMateria.add(new TextField<>("nombre", new PropertyModel<>(controller, "nombre")));

		this.add(agregarMateria);
	
	}
}
