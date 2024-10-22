package br.am.nimai.core;

import static br.am.nimai.core.DriverFactory.getDriver;

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
	
	protected void escreverPorXpath(String xpath, String texto) {
		DriverFactory.getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
	}
	
	protected void esperarElementoPorXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	protected String pegarTextXpath(String xpath) {
		return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
	}
	
	protected boolean existeElementoPorTexto(String text) {
		//Realiza a pesquisa do elemento utilizando findElements e armazenar em um list
		List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath("//*[text()='"+text+"']"));
		
		//Retornar true se o elements é maior que 0
		return elements.size() > 0;
	}
	
}
