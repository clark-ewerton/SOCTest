package br.ce.soctest.core;

public class Propriedades {
	
	//defino a velocidade dos testes, se a janela do browser sera fechada a cada teste ou nao
		public static Boolean FECHAR_BROWSER = false;
		
		//define o chaveamento de browsers
		public static Browsers BROWSER = Browsers.CHROME;
		
		public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;
		
		//garantir um novo nome de conta toda vez que eu executar meus testes sem precisar ficar mudando na mao
		//public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();
		
		public enum Browsers{
			CHROME,
			FIREFOX,
			IE
		}
		
		public enum TipoExecucao{
			LOCAL,
			GRID,
			NUVEM
		}

}
