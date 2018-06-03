package by.grsu.solomenskay.web.component.menu;

import by.grsu.solomenskay.web.page.home.HomePage;
import by.grsu.solomenskay.web.page.horse.HorsePage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class MenuPanel extends Panel {

	public MenuPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link("link-home") {
			@Override
			public void onClick() {
				setResponsePage(new HomePage());
			}
		});

        add(new Link("link-horses") {
            @Override
            public void onClick() {
                setResponsePage(new HorsePage());
            }
        });
	}
}