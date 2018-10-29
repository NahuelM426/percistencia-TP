package ar.edu.unq.sarmiento.epers.wicket;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage{
	private static final int ListItem = 0;
	@SpringBean(name="controllerDeHomePage")
	private ControllerDeHomePage controller;
	
	public HomePage() {
		super();
		this.nombreDeDeveloper();
	}
	private void nombreDeDeveloper() {
		this.add(new Label("nombreDeveloper", new PropertyModel<>(this.controller, "nombreDeveloper")));
	}
	
}
