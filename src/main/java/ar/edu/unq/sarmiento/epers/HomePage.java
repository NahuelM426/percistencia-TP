package ar.edu.unq.sarmiento.epers;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import ar.edu.unq.sarmiento.epers.hibernate.MaguitoHome;
import ar.edu.unq.sarmiento.epers.model.Proyecto;
import ar.edu.unq.sarmiento.epers.model.Developer;
import ar.edu.unq.sarmiento.epers.model.SearchModel;

public class HomePage extends WebPage {

	private static final long serialVersionUID = -3657874371670902273L;
	Form<SearchModel<Developer>> form = null;

	@SuppressWarnings("serial")
	public HomePage() {

		IModel<SearchModel<Developer>> model = new CompoundPropertyModel<SearchModel<Developer>>(
				new SearchModel<Developer>(MaguitoHome.getInstance()));
		form = new Form<SearchModel<Developer>>("form", model);

		form.add(new TextField<String>("search"));

		form.add(new Label("message"));

		form.add(new TextField<String>("result.nombre"));
		form.add(new TextField<String>("result.vida"));
		form.add(new TextField<String>("result.experiencia"));

		PropertyListView<Proyecto> items = new PropertyListView<Proyecto>("result.proyectos") {
			@Override
			protected void populateItem(ListItem<Proyecto> itemWrapper) {
				itemWrapper.add(new Label("nombre"));
				itemWrapper.add(new Label("peso"));
			}
		};
		form.add(items);
		items.setOutputMarkupId(true);

		AjaxButton ab = new AjaxButton("action") {
			@Override
			protected void onSubmit(AjaxRequestTarget target) {

				if (target != null) {
					model.getObject().find();
					target.add(form);
				}

			}

		};
		form.add(ab);

		ab = new AjaxButton("update") {
			@Override
			protected void onSubmit(AjaxRequestTarget target) {

				if (target != null) {
					model.getObject().update();
					target.add(form);
				}

			}

		};

		form.add(ab);
		add(form);

	}
}
