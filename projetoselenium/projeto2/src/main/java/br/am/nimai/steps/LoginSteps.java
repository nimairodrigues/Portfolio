package br.am.nimai.steps;

import static br.am.nimai.core.DriverFactory.getDriver;
import static br.am.nimai.core.DriverFactory.killDriver;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.BaseTest;
import br.am.nimai.core.DriverFactory;
import br.am.nimai.page.CadastroPage;
import br.am.nimai.page.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps extends BaseTest {
	
	@Before
	public void t() {
		DriverFactory.getDriver().get("https://bugbank.netlify.app/");
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
	    //nada
	}

	@Dado("que tenho uma conta criada")
	public void queTenhoUmaContaCriada() {
	    //necessário criar conta
		loginPage.clicarRegistrar();
		cadastroPage.cadastrarUsuario();
	}

	@Dado("que estou na tela de login")
	public void queEstouNaTelaDeLogin() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Quando("eu digitar o e-mail {string}")
	public void euDigitarOEMail(String string) {
		loginPage.escreverEmail(string);
	}

	@Quando("digitar a senha {string}")
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
	public void deveAparecerADashboardDoUsuário() {
		Assert.assertTrue(loginPage.existeMsgBemVindo());
	}
	
	@Então("deve aparecer uma tela informando que o usuário ou senha estão inválidos.")
	public void deveAparecerUmaTelaInformandoQueOUsuárioOuSenhaEstãoInválidos() {
		Assert.assertTrue(loginPage.existeMensagemDeSenhaErrada());
	}
	
	@Então("deve informar que o campo e-mail é obrigatório")
	public void deveInformarQueOCampoEMailÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", loginPage.pegarTextoWarningEmail());
	}

	@Então("deve informar que o campo senha é obrigatório")
	public void deveInformarQueOCampoSenhaÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", loginPage.pegarTextoWarningSenha());
	}
	
	@Então("deve informar que o formato do e-mail está inválido")
	public void deveInformarQueOFormatoDoEMailEstáInválido() {
		Assert.assertEquals("Formato inválido", loginPage.pegarTextoWarningEmail());
	}
}
