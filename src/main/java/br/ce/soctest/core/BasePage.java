package br.ce.soctest.core;

import static br.ce.soctest.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {

	/********************** TextField ************************/
	public void escreverCampo(String id, String valor) {
		getDriver().findElement(By.id(id)).clear();
		getDriver().findElement(By.id(id)).sendKeys(valor);
	}
	public void escreverCampo(By by, String valor) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(valor);
	}
	
	/********************** Botoes *****************************/

	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}


	/****************** validacoes ***************************/
	public String obterMensagemValidada(By by) {
		return getDriver().findElement(by).getText();
	}


	/********************* interacao com javascript *****************/
	public Object executarJS(String comando, Object... parametro) {
		// como o driver é uma instancia de um webdriver e nao de Javascriptexecutor,
		// faço um cast
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		// js.executeScript("alert ('Testando js via selenium')");
		// js.executeScript("document.getElementById('elementosForm:nome').value =
		// 'Escrito via js'");
		// js.executeScript("document.getElementById('elementosForm:sobrenome').type =
		// 'radio'");

		// WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		return js.executeScript(comando, parametro);
	}

}
