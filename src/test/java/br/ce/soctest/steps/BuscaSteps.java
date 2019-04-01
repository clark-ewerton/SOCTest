package br.ce.soctest.steps;

import br.ce.soctest.pages.BuscaPage;
import cucumber.TestContext;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class BuscaSteps {

	TestContext testContext;
	// PageObjectManager pageObjectManager = new PageObjectManager();
	BuscaPage buscaPage;

	public BuscaSteps(TestContext context) {
		testContext = context;
		buscaPage = testContext.getPageObjectManager().getBuscaPage();
	}

	@Dado("^que estou acessando a pagina de busca$")
	public void que_estou_acessando_a_pagina_de_busca() throws Throwable {
		buscaPage.inicializaWebPage();
		buscaPage.deveValidarElementoExistente();
	}

	@Quando("^insiro no campo \"([^\"]*)\" o valor \"([^\"]*)\"$")
	public void insiro_no_campo_o_valor(String campo, String valor) throws Throwable {
		buscaPage.deveEscreverCampoBusca(campo, valor);

	}

	@Quando("^clico no icone de busca$")
	public void clico_no_icone_de_busca() throws Throwable {
		buscaPage.deveClicarBotaoPesquisa();

	}

	@Entao("^recebo a mensagem \"([^\"]*)\"$")
	public void recebo_a_mensagem(String mensagem) throws Throwable {
		buscaPage.deveValidarConteudoExistente(mensagem);

	}

	@Entao("^verifico a quantidade de conteudos retornados pela pagina$")
	public void verifico_a_quantidade_de_conteudos_retornados_pela_pagina() throws Throwable {
		buscaPage.deveContarQuantidadeConteudoPagina();
	}

}
