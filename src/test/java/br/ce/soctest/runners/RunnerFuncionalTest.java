package br.ce.soctest.runners;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.cucumber.listener.Reporter;

import br.ce.soctest.core.DriverFactory;
import br.ce.soctest.core.Propriedades;
import br.ce.soctest.managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports", "json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report-extent.html" },
		// defino caminho dos arquivos cucumber
		features = "src/test/resources/features/",
		// defino caminho arquivos de classe steps
		glue = "br.ce.soctest.steps",
		// defino que tipo de cenario exatamente quero executar
		tags = "@funcionais",
		// deixa o console mais legivel se false, se true, nao fica legivel
		monochrome = true,
		// o nome dos metodos fica tudo junto com a primeira letra de cada palavra
		// maiuscula
		snippets = SnippetType.CAMELCASE,
		// se tiver true, o sysout nao aparecer� no console
		dryRun = false,
		// se tiver como true, e algum passo estiver especificado no cenario, vai dar
		// erro
		strict = false)
public class RunnerFuncionalTest {

	// antes de cada teste, execute o conteúdo deste método
	@BeforeClass
	public static void inicializa() throws UnsupportedEncodingException {
		// getDriver().get("https://ww2.soc.com.br/blog/");
		ExtentReports extent = new ExtentReports();
		extent.setGherkinDialect("pt");

	}

	@AfterClass
	public static void termina() throws IOException {

		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 7" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.9.1");
		Reporter.setSystemInfo("Maven", "2.18.1");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");

		if (Propriedades.FECHAR_BROWSER) {
			DriverFactory.KillDriver();
		}

	}

}
