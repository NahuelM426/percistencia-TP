package ar.edu.unq.sarmiento.epers;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class DescripcionDeProyecto extends  WebPage {
	@SpringBean(name="controlerProyecto")
	private ControlerProyecto controller;
	private Proyecto proy;
	
public DescripcionDeProyecto (Proyecto proyec){
	proy= proyec;
}

private void nombreDeProyecto() {
	this.add(new Label("nombreMateria", new PropertyModel<>(this.controller, "nombreProyecto")));
}
}
