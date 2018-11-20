package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class BacklogPage extends WebPage {

	@SpringBean(name="controllerBacklog")
	private ControllerBacklog controller;
	
	public BacklogPage() {
		this(new Proyecto());
	}
	@SuppressWarnings("serial")
	public BacklogPage(Proyecto proy) {
		super();
		this.controller.setProyecto(proy);
		this.nombreDeMateria();
	}
	private void nombreDeMateria() {
		this.add(new Label("nombre", new PropertyModel<>(this.controller, "nombre")));
	}
	
}
