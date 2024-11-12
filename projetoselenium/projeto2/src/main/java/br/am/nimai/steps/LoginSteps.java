package br.am.nimai.steps;

import static br.am.nimai.core.DriverFactory.getDriver;
import static br.am.nimai.core.DriverFactory.killDriver;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.DriverFactory;
import br.am.nimai.page.CadastroPage;
import br.am.nimai.page.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	
	//@Before (do cucumber) para ser executado antes de cada cenário
	@Before
	public void iniciar() {
		//acessando o site da bugbank
		DriverFactory.getDriver().get("https://bugbank.netlify.app/");
		//esperando um elemento na tela aparecer para poder começar as ações dos testes
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='styles__WarnigWrapper-sc-1ota0lw-0 kpiCJH']")));
	}
	
	@After
	public void finalizar() {
		killDriver();
	}
	
	LoginPage loginPage = new LoginPage();
	CadastroPage cadastroPage = new CadastroPage();
	
	@Dado("que sou um usuário")
	public void queSouUmUsuário() {
	}

	@Dado("que tenho uma conta criada")
	public void queTenhoUmaContaCriada() {
	    //necessário criar conta
		loginPage.clicarRegistrar();
		cadastroPage.cadastrarUsuario("nimaiqa@test.com", "Nimai", "nimai123", "nimai123");
	}

	@Dado("que estou na tela de login")
	public void queEstouNaTelaDeLogin() {
	    
	}

	@Quando("eu digitar o e-mail {string} na tela de login")
	public void euDigitarOEMail(String string) {
		loginPage.escreverEmail(string);
	}

	@Quando("digitar a senha {string} na tela de login")
	public void digitarASenha(String string) {
		loginPage.escreverSenha(string);
	}

	@Quando("clicar em Acessar")
	public void clicarEmAcessar() {
		loginPage.clicarAcessar();
	}
	
	@Quando("eu clicar em Acessar")
	public void euClicarEmAcessar() {
		loginPage.clicarAcessar();
	}

	@Então("deve aparecer a dashboard do usuário")
	public void deveAparecerADashboardDoUsuário() throws InterruptedException {
//		Thread.sleep(1000);
		Assert.assertTrue(loginPage.existeMsgBemVindo());
	}
	
	@Então("deve aparecer uma tela informando que o usuário ou senha estão inválidos.")
	public void deveAparecerUmaTelaInformandoQueOUsuárioOuSenhaEstãoInválidos() {
		Assert.assertTrue(loginPage.existeMensagemDeSenhaErrada());
	}
	
	@Então("deve informar que o campo e-mail é obrigatório na tela de login")
	public void deveInformarQueOCampoEMailÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", loginPage.pegarTextoWarningEmail());
	}

	@Então("deve informar que o campo senha é obrigatório na tela de login")
	public void deveInformarQueOCampoSenhaÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", loginPage.pegarTextoWarningSenha());
	}
	
	@Então("deve informar que o formato do e-mail está inválido na tela de login")
	public void deveInformarQueOFormatoDoEMailEstáInválido() {
		Assert.assertEquals("Formato inválido", loginPage.pegarTextoWarningEmail());
	}
}
