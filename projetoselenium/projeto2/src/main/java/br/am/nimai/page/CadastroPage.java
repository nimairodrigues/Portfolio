package br.am.nimai.page;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class CadastroPage extends BasePage {
	
	public void escreverEmail(String email) {
		String xpath = "//*[@class='card__register']//*[@type='email']"; 
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
		limparCampo(xpath);
		escreverPorXpath(xpath, email);
	}
	
	public void escreverNome(String nome) {
		String xpath = "//*[@class='card__register']//*[@type='name']";
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
		limparCampo(xpath);
		escreverPorXpath(xpath, nome);
	}
	
	public void escreverSenha(String senha) {
		String xpath = "//*[@class='card__register']//*[@for='password']/../input";
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
		limparCampo(xpath);
		escreverPorXpath(xpath, senha);
	}
	
	public void escreverConfirmarSenha(String senha) {
		String xpath = "//*[@class='card__register']//*[@for='passwordConfirmation']/../input";
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
		limparCampo(xpath);
		escreverPorXpath(xpath, senha);
	}
	
	public void clicarAdicionarBalance() {
		WebElement elementoAdicionarBalanco = DriverFactory.getDriver().findElement(By.xpath("//*[@id='toggleAddBalance']/.."));
		System.out.println(elementoAdicionarBalanco.toString().contains("kIwoPV"));
		if(elementoAdicionarBalanco.getAttribute("class").toString().contains("kIwoPV")) {
			clicarPorId("toggleAddBalance");
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='styles__Container-sc-1pngcbh-0 hsmFIT']")));
		}
		
		
	}
	
	public void clicarCadastrar() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='card__register']//*[@type='submit']")));
		
		clicarPorXpath("//*[@class='card__register']//*[@type='submit']");
	}
	
	public void clicarFecharConfirm() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnCloseModal']")));
		
		clicarPorXpath("//*[@id='btnCloseModal']"); //talvez elenão esteja clicando pra fechar o modal
	}
	
	public boolean existeMensagemContaCriadaComSucesso() {
		//Esperar até o id=textBalance aparecer para continuar o fluxo
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='modalText']")));
		
		//realizar a busca do texto e retornar se existe ou não
		List<WebElement> elements = DriverFactory.getDriver().findElements(By.xpath("//*[contains(text(), 'A conta' and 'foi criada com sucesso')]"));
		return elements.size() > 0;
	}
	
	public String cadastrarUsuario(String email, String nome, String senha, String confirmSenha) {
		escreverEmail(email);
		escreverNome(nome);
		escreverSenha(senha);
		escreverConfirmarSenha(confirmSenha);
		clicarAdicionarBalance();
		clicarCadastrar();
		
		String textoConfirmCadastro = pegarTextXpath("//*[@id='modalText']");
		String regex = "(?<=conta\\s)(.*?)(?=\\sfoi)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(textoConfirmCadastro);
		
		clicarFecharConfirm();

		if(matcher.find()) {
			return matcher.group();
		} else {
			return "Erro ao encontrar o matcher.find()";
		}
	}
	
	public String pegarTextoWarningEmail() {
		return pegarTextXpath("//*[@class='card__register']//*[@for='email']/..//*[@class='input__warging']");
	}
	
	public String pegarTextoWarningNome() {
		return pegarTextXpath("//*[@class='card__register']//*[@for='name']/..//*[@class='input__warging']");
	}
	
	public String pegarTextoWarningSenha() {
		return pegarTextXpath("//*[@class='card__register']//*[@for='password']/..//*[@class='input__warging']");
	}
	
	public String pegarTextoWarningSenhaConfirm() {
		return pegarTextXpath("//*[@class='card__register']//*[@for='passwordConfirmation']/..//*[@class='input__warging']");
	}
	
	
}
