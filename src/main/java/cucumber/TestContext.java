package cucumber;

import static br.ce.soctest.core.DriverFactory.getDriver;

import org.openqa.selenium.WebDriver;

import br.ce.soctest.managers.PageObjectManager;

public class TestContext {

	private PageObjectManager pageObjectManager;

	public TestContext() {
		pageObjectManager = new PageObjectManager();
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public static WebDriver getDriverFactory() {
		return getDriver();
		
	}

}
