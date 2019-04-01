package br.ce.soctest.managers;

import static br.ce.soctest.core.DriverFactory.getDriver;

import br.ce.soctest.pages.BuscaPage;

public class PageObjectManager {

	private BuscaPage buscaPage;

	public PageObjectManager() {
		getDriver();
	}

	public BuscaPage getBuscaPage() {
		return (buscaPage == null) ? buscaPage = new BuscaPage() : buscaPage;
	}

}
