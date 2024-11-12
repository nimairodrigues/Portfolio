package br.am.nimai.page;

import br.am.nimai.core.BasePage;

public class LoginPage extends BasePage{
	
	public void escreverEmail(String email) {
		esperarVisibilidadeDeElemento("//input[@type='email']");
		escreverPorXpath("//input[@type='email']", email);
	}
	
	public void escreverSenha(String senha) {
		esperarVisibilidadeDeElemento("//input[@type='email']");
		escreverPorXpath("//input[@type='password']", senha);
	}

	public void clicarAcessar() {
		clicarPorXpath("//button[@class='style__ContainerButton-sc-1wsixal-0 otUnI button__child']");
	}
	
	public void clicarRegistrar() {
		clicarPorXpath("//button[@class='style__ContainerButton-sc-1wsixal-0 ihdmxA button__child']");
		esperarVisibilidadeDeElemento("//*[@class='card__register']");
	}
	
	public boolean existeMsgBemVindo() {
		//Esperar até o id=textBalance aparecer para continuar o fluxo
		esperarVisibilidadeDeElemento("//*[@id='textBalance']");
		
		//realizar a busca do texto e retornar se existe ou não
		return existeElementoPorTexto("Olá Nimai,");
	}
	
	public boolean existeMensagemDeSenhaErrada() {
		//Esperar até o id=textBalance aparecer para continuar o fluxo
		esperarVisibilidadeDeElemento("//*[@id='modalText']");
		
		//realizar a busca do texto e retornar se existe ou não
		return existeElementoPorTexto("Usuário ou senha inválido.\nTente novamente ou verifique suas informações!");
	}
	
	public String pegarTextoWarningEmail() {
		//vai retornar o texto do elemento
		return pegarTextXpath("//*[@class='card__login']//*[@for='email']/..//*[@class='input__warging']");
	}

	public Object pegarTextoWarningSenha() {
		//vai retornar o texto do elemento
		return pegarTextXpath("//*[@class='card__login']//*[@for='password']/..//*[@class='input__warging']");
	}
	
	public void realizarLogin(String email, String senha) {
		escreverEmail(email);
		escreverSenha(senha);
		clicarAcessar();
		
		esperarVisibilidadeDeElemento("//*[@id='textBalance']");
	}
}
