package br.am.nimai.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class CadastroPage extends BasePage {
	
	public void escreverEmail(String email) {
		escreverPorXpath("//*[@class='card__register']//*[@type='email']", email);
	}
	
	public void escreverNome(String nome) {
		escreverPorXpath("//*[@class='card__register']//*[@type='name']", nome);
	}
	
	public void escreverSenha(String senha) {
		escreverPorXpath("//*[@class='card__register']//*[@for='password']/../input", senha);
	}
	
	public void escreverConfirmarSenha(String senha) {
		escreverPorXpath("//*[@class='card__register']//*[@for='passwordConfirmation']/../input", senha);
	}
	
	public void clicarCadastrar() {
		clicarPorXpath("//*[@class='card__register']//*[@type='submit']");
	}
	
	public void clicarFecharConfirm() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnCloseModal']")));
		
		clicarPorXpath("//*[@id='btnCloseModal']");
	}
	
	public void cadastrarUsuario() {
		escreverEmail("nimai@qa.com");
		escreverNome("Nimai");
		escreverSenha("teste");
		escreverConfirmarSenha("teste");
		clicarCadastrar();
		clicarFecharConfirm();
	}
}
