package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;

import ar.edu.unq.sarmiento.epers.model.Proyecto;

public class ProyectoPage extends WebPage{

	private static final long serialVersionUID = 1L;
	private Proyecto proyecto;
	
	public ProyectoPage(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
