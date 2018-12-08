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
	private Proyecto proyecto;
	
public AgregarUserStory(Proyecto pro){
	this.proyecto = pro;
	controller.attch(proyecto);
	controller.setProyecto(proyecto);
	this.crearUserStory();	
}
	
	
	
	public void crearUserStory(){
		Form<ControllerDetalleDeProyecto> agregarMateria = new Form<ControllerDetalleDeProyecto>("agregarMateria") {
			private static final long serialVersionUID = 5932937158394555903L;

			@Override
			protected void onSubmit() {
				controller.confirmar();
				this.setResponsePage(new DetalleDeProyecto(proyecto));
			}
		};
		

		agregarMateria.add(new TextField<>("titulo", new PropertyModel<>(controller, "titulo")));
		agregarMateria.add(new TextField<>("valorAlCliente", new PropertyModel<>(controller, "valorAlCliente")));
		agregarMateria.add(new TextField<>("complejidad", new PropertyModel<>(controller, "complejidad")));
		agregarMateria.add(new TextField<>("completado", new PropertyModel<>(controller, "completado")));
//		agregarMateria.add(new TextField<>("rol", new PropertyModel<>(controller, "rol")));

		this.add(agregarMateria);
	
	}

}
