package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class AgregarUserStory extends WebPage {

	@SpringBean(name="controllerCrearUserStory")
	private ControllerCrearUserStory controller;
	
public AgregarUserStory(Proyecto pro){
	
	controller.setProyecto(pro);
	this.crearUserStory();	
}
	
	
	
	public void crearUserStory(){
		Form<ControllerDetalleDeProyecto> agregarMateria = new Form<ControllerDetalleDeProyecto>("agregarMateria") {
			private static final long serialVersionUID = 5932937158394555903L;

			@Override
			protected void onSubmit() {
				controller.confirmar();
				this.setResponsePage(new HomePage());
			}
		};
		


		agregarMateria.add(new TextField<>("complejidad", new PropertyModel<>(controller, "complejidad")));
		agregarMateria.add(new TextField<>("completado", new PropertyModel<>(controller, "completado")));
//		agregarMateria.add(new TextField<>("rol", new PropertyModel<>(controller, "rol")));

		this.add(agregarMateria);
	
	}

}
