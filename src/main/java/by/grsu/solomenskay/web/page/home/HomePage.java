package by.grsu.solomenskay.web.page.home;

import by.grsu.solomenskay.web.page.AbstractPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class HomePage extends AbstractPage {

	public HomePage() {

		add(new FeedbackPanel("feedback"));
	}

}