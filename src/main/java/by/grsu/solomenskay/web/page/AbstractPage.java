package by.grsu.solomenskay.web.page;


import by.grsu.solomenskay.web.component.menu.MenuPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.Calendar;

public abstract class AbstractPage extends WebPage {

	public AbstractPage() {
		super();
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		/*
		 * if (getPage().getClass().equals(HomePage.class)) { add(new
		 * MenuPanelHome("menu-panel")); } else { add(new
		 * MenuPanel("menu-panel")); }
		 */
		add(new MenuPanel("menu-panel"));
		
		AbstractReadOnlyModel<Integer> yearModel = new AbstractReadOnlyModel<Integer>() {
			@Override
			public Integer getObject() {
				return Calendar.getInstance().get(Calendar.YEAR);
			}
		};

		WebMarkupContainer footer = new WebMarkupContainer("footer");
		add(footer);
		footer.add(new Label("current-year", yearModel));
	}

}
