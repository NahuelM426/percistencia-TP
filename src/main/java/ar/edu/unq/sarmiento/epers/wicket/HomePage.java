package ar.edu.unq.sarmiento.epers.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage{
	@SpringBean(name="controllerDeHomePage")
	private ControllerDeHomePage controller;
	public HomePage() {
		super();
		
	}

}
