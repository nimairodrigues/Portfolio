package br.am.nimai.core;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Método para clicar utilizando o ID através do xpath, porém, utilizando o método do XPATH para facilitar a manutenção
	protected void clicarPorId(String id) {
		clicarPorXpath("//*[@id='"+ id + "']");
	}
	
	//Método para clicar utilizando o xpath
	protected void clicarPorXpath(String xpath) {
		DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
	}
	
	//Método para limpar o campo de texto e depois escrever
	protected void escreverPorXpath(String xpath, String texto) {
		esperarVisibilidadeDeElemento(xpath);
		
		//vai limpar o campo
		DriverFactory.getDriver().findElement(By.xpath(xpath)).clear();
		
		//vai escrever no campo
		DriverFactory.getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
	}
	
	//Método para pegar um texto de um elemento através do xpath
	protected String pegarTextXpath(String xpath) {
		return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
	}
	
	//Método para verificar se existe algum elemento que contém certo texto na tela
	protected boolean existeElementoPorTexto(String text) {
		//Realiza a pesquisa do elemento utilizando findElements e armazenar em um list
		List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath("//*[text()='"+text+"']"));
		
		//Retornar true se o elements é maior que 0 (no caso será 1 se tiver encontrado o elemento que precisamos)
		return elements.size() > 0;
	}
	
	//Método para esperar que algum elemento esteja visível na tela para voltar ao fluxo normal dos testes, tempo de espera é 5 segundos
	//utilizando o xpath para identificação do elemento
	protected void esperarVisibilidadeDeElemento(String xpath) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
}
