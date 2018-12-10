package ar.edu.unq.sarmiento.epers.wicket.home;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.wicket.ListadoDeProyectos.ListaDeProyectosPage;
import ar.edu.unq.sarmiento.epers.wicket.listadoDeDeveloper.ListaDeDevelopersPage;

public class HomePage extends WebPage{
	private static final int ListItem = 0;
		
	
	public HomePage(){
		
		this.add(new Link<String>("ListaDeDevelopers"){
			
			@Override
			public void onClick(){
				this.setResponsePage(new ListaDeDevelopersPage());
			}
		});
		this.add(new Link<String>("ListadoDeProyectos") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListaDeProyectosPage());
			}
		});
	}
}	
