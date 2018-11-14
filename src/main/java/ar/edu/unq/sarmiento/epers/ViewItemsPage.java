package ar.edu.unq.sarmiento.epers;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.epers.home.DeveloperHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Developer;

public class ViewItemsPage extends WebPage {

	
	@Autowired
	DeveloperHome maguitoHome;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewItemsPage(Developer maguito) {

		IModel<Developer> model = new CompoundPropertyModel<Developer>(maguito);
		this.setDefaultModel(model);
		
		Form<Developer> form = new Form<Developer>("form", model);
		
		form.add(new Label("nombre"));
		form.add(new Label("vida"));
		form.add(new Label("experiencia"));

		PropertyListView<Proyecto> items = new PropertyListView<Proyecto>("items") {
			@Override
			protected void populateItem(ListItem<Proyecto> itemWrapper) {
				itemWrapper.add(new Label("nombre"));
				itemWrapper.add(new Label("peso"));
			}
		};
		form.add(items);
		items.setOutputMarkupId(true);

		
		Link<Developer> ab = new Link<Developer>("volver", new Model<Developer>((Developer)this.getDefaultModel().getObject())) {
			public void onClick()
			 {
			     setResponsePage(new HomePage((Developer)this.getDefaultModelObject()));
			 }
		};
		
		add(ab);

		add(form);


	}

}
