package br.ce.soctest.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.soctest.core.Propriedades.Browsers;
import br.ce.soctest.core.Propriedades.TipoExecucao;
import br.ce.soctest.managers.FileReaderManager;

public class DriverFactory {

	private static Browsers driverType;
	private static TipoExecucao environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

	// a thread inicia chamando o initDriver()
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};

	// construtor privado
	private DriverFactory() {

	};

	// vai retornar o driver que a thread esta gerenciando
	public static WebDriver getDriver() {
		return threadDriver.get();

	}

	// o initdriver por sua vez ja cria uma instancia propria do webdriver para
	// aquela thread
	public static WebDriver initDriver() {
		WebDriver driver = null;
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();

		// se o tipo de ambiente for local
		if (environmentType == TipoExecucao.LOCAL) {
			// realize um switch com a variavel drivertype
			switch (driverType) {
			case CHROME:
				// driver para Chrome
				System.setProperty(CHROME_DRIVER_PROPERTY,
						FileReaderManager.getInstance().getConfigReader().getDriverPath());
				driver = new ChromeDriver();

				break;
			case FIREFOX:
				// driver para firefox
				System.setProperty(FIREFOX_DRIVER_PROPERTY,
						FileReaderManager.getInstance().getConfigReader().getDriverPath());
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("não foram encontrados drivers");
			}
		}
		if (environmentType == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (driverType) {
			case CHROME:
				cap = DesiredCapabilities.chrome();
				break;
			case FIREFOX:
				cap = DesiredCapabilities.firefox();
				break;
			default:
				System.out.println("não foram encontrados drivers");

			}
			try {
				// driver = new RemoteWebDriver(new URL("http://192.168.1.32:4444/wd/hub"),
				// cap);
				driver = new RemoteWebDriver(new URL("http://192.168.1.32:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexao com o GRID");
				e.printStackTrace();
			}
		}

		 if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
		driver.manage().window().maximize();

		return driver;

	}

	public static void KillDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}

		if (threadDriver != null) {
			threadDriver.remove();
		}
	}

}
