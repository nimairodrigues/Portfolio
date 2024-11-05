package br.am.nimai.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class LoginPage extends BasePage{
	
	public void escreverEmail(String email) {
		escreverPorXpath("//input[@type='email']", email);
	}
	
	public void escreverSenha(String senha) {
		escreverPorXpath("//input[@type='password']", senha);
	}

	public void clicarAcessar() {
		clicarPorXpath("//button[@class='style__ContainerButton-sc-1wsixal-0 otUnI button__child']");
	}
	
	public void clicarRegistrar() {
		clicarPorXpath("//button[@class='style__ContainerButton-sc-1wsixal-0 ihdmxA button__child']");
	}
	
	public boolean existeMsgBemVindo() {
		//Esperar até o id=textBalance aparecer para continuar o fluxo
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='textBalance']")));
		
		//realizar a busca do texto e retornar se existe ou não
		return existeElementoPorTexto("Olá Nimai,");
	}
	
	public boolean existeMensagemDeSenhaErrada() {
		//Esperar até o id=textBalance aparecer para continuar o fluxo
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='modalText']")));
		
		//realizar a busca do texto e retornar se existe ou não
		return existeElementoPorTexto("Usuário ou senha inválido.\nTente novamente ou verifique suas informações!");
	}
	
	public String pegarTextoWarningEmail() {
		return pegarTextXpath("//*[@class='card__login']//*[@for='email']/..//*[@class='input__warging']");
	}

	public Object pegarTextoWarningSenha() {
		return pegarTextXpath("//*[@class='card__login']//*[@for='password']/..//*[@class='input__warging']");
	}
	
	public void realizarLogin(String email, String senha) {
		escreverEmail(email);
		escreverSenha(senha);
		clicarAcessar();
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='textBalance']")));
	}
}
