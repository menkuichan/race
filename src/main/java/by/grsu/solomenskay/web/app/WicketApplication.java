package by.grsu.solomenskay.web.app;

import by.grsu.solomenskay.web.page.home.HomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {

	@Override
	public void init() {
		super.init();
		//mountPage("/home", HomePage.class);
		//mountPage("/edit", CircleEditPage.class);
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

}
