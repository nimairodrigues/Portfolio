package br.am.nimai.page;

import br.am.nimai.core.BasePage;

public class TransferenciaPage extends BasePage {
	
	public void clicarTransferencia() {
		clicarPorId("btn-TRANSFERÊNCIA");
	}
	
	public void escreverNumeroConta(String string) {
		escreverPorXpath("//*[@type='accountNumber']", string);
	}
	
	public void escreverDigito(String string) {
		escreverPorXpath("//*[@type='digit']", string);
	}
	
	public void escreverValor(String string) {
		escreverPorXpath("//*[@type='transferValue']", string);
	}
	
	public void escreverDescricao(String string) {
		escreverPorXpath("//*[@type='description']", string);
	}
	
	public void clicarTransferir() {
		clicarPorXpath("//*[@type='submit']");
	}
	
	public String pegarMensagemTransferenciaRealizada() {
		//Esperar até o id=textBalance aparecer para continuar o fluxo
		esperarVisibilidadeDeElemento("//*[@id='modalText']");
		
		//realizar a busca do texto e retornar se existe ou não
		return pegarTextXpath("//*[@id='modalText']");
	}
	
	public Object pegarTextoWarningNumConta() {
		return pegarTextXpath("//*[@for='accountNumber']/..//*[@class='input__warging']");
	}
	
	public Object pegarTextoWarningNumDigit() {
		return pegarTextXpath("//*[@for='digit']/..//*[@class='input__warging']");
	}
	
	public Object pegarTextoWarningTransferValue() {
		return pegarTextXpath("//*[@for='transferValue']/..//*[@class='input__warging']");
	}
	
	public Object pegarTextoWarningDescription() {
		return pegarTextXpath("//*[@for='description']/..//*[@class='input__warging']");
	}
	
}
