package br.ce.soctest.pages;

import static br.ce.soctest.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.soctest.core.BasePage;
import br.ce.soctest.managers.FileReaderManager;

public class BuscaPage extends BasePage {

	// construtor
	public BuscaPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// declaração de elementos fixos
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement btn_Pesquisa;

	@FindBy(how = How.CLASS_NAME, using = "form-busca")
	private WebElement element_form;

	@FindBy(how = How.XPATH, using = "//h2[@class='pagetitle search']")
	private WebElement element_pagetitle_search;

	@FindBy(how = How.XPATH, using = "//div[@class='content-articles']//article")
	private WebElement element_article;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Nenhum post')]")
	private WebElement element_noarticle;

	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='content-articles']/article"))
	private List<WebElement> elements_articles;

	private WebDriverWait wait;
	

	// metodos
	public void inicializaWebPage() {
		getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

	}

	public void deveEscreverCampoBusca(String campo, String valor) {
		escreverCampo(By.xpath("//input[@placeholder='" + campo + "']"), valor);

	}

	public void deveClicarBotaoPesquisa() {
		btn_Pesquisa.click();
	}

	/******************* validacoes *****************************/

	public boolean deveValidarElementoExistente() {
		boolean valida = false;
		wait = new WebDriverWait(getDriver(), 10);
		if (wait.until(ExpectedConditions.visibilityOf(element_form)).isDisplayed())
			valida = true;

		return valida;

	}

	public void deveValidarConteudoExistente(String mensagem) {
		boolean conteudo = false;
		boolean sem_conteudo = false;
		wait = new WebDriverWait(getDriver(), 10);
		// valido mensagem o title da busca realizada
		Assert.assertEquals(mensagem, element_pagetitle_search.getText());

		// após isso, valido se a pagina retorna conteudo baseado no valor de
		// pesquisa fornecido
		try {
			if (wait.until(ExpectedConditions.visibilityOf(element_article)).isDisplayed()) {
				System.err.println("HÁ CONTEUDO NA PAGINA BASEADO NO CRITERIO DE PESQUISA UTILIZADO");
				conteudo = true;
			}

		} catch (TimeoutException e) {
			// e.printStackTrace();

		}

		// ou se a pagina valida que nao ha conteudo algum
		try {
			if (wait.until(ExpectedConditions.visibilityOf(element_noarticle)).isDisplayed()) {
				System.err.println("NÃO HA CONTEUDO PARA O CRITERIO DE PESQUISA UTILIZADO");
				Assert.assertEquals("Nenhum post encontrado. Tente uma busca diferente", element_noarticle.getText());
				sem_conteudo = true;
			}
		} catch (TimeoutException e) {
			// e.printStackTrace();
		}
		Assert.assertTrue(conteudo | sem_conteudo);
	}

	public void deveContarQuantidadeConteudoPagina() {
		System.err.println("PAGINA TROUXE: " + elements_articles.size() + " CONTEUDOS");
	}
}
