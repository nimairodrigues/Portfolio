package br.am.nimai.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.LoginPage;
import br.am.nimai.services.EmailService;

public class LoginTest extends BaseTest{
	
	@Mock
	private EmailService email;
	
	
	LoginPage loginPage = new LoginPage();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void id_01_loginComUsuarioESenhaCorreta() {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("Admin");
		loginPage.setSenha("admin123");
		loginPage.clicarLogar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Dashboard");
		Assert.assertThat(loginPage.existeElementoPorTexto("Dashboard"), Matchers.is(true));
	}
	
	@Test
	public void id_02_loginComUsuarioIncorretoESenhaIncorreta() throws InterruptedException {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("usuarioIncorreto");
		loginPage.setSenha("naoexiste");
		loginPage.clicarLogar();
		
		//assertiva
//		loginPage.esperarPresenca("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Invalid credentials"), Matchers.is(true));
	}
	
	@Test
	public void id_03_loginComUsuarioIncorretoESenhaCorreta() {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("usuarioIncorreto");
		loginPage.setSenha("admin123");
		loginPage.clicarLogar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Invalid credentials"), Matchers.is(true));
	}
	
	@Test
	public void id_04_loginUsuarioCorretoESenhaIncorreto() {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("Admin");
		loginPage.setSenha("senhaIncorreta");
		loginPage.clicarLogar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Invalid credentials"), Matchers.is(true));
	}
	
	@Test
	public void id_05_loginSemUsuarioESemSenha() {
		//pre condicoes
		
		//execucao
		loginPage.clicarLogar();
		
		//assertiva
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"), Matchers.is(true));
	}
	
	@Test
	public void id_06_loginSemUsuarioESenhaQualquerPreenchida() {
		//pre condicoes
		
		//execucao
		loginPage.setSenha("senhaQualquer");
		loginPage.clicarLogar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"), Matchers.is(true));
	}
	
	@Test
	public void id_07_loginUsuarioQualquerPreenhidoESemSenha() {
		//pre condicoes

		//execucao
		loginPage.setUsuario("Nimai");
		loginPage.clicarLogar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"), Matchers.is(true));
	}
	
	@Test
	public void id_08_esqueceuASenha() {
		//pre condicoes
		
		//execucao
		loginPage.clicarEsqueceuSenha();
		loginPage.esperarPresencaPorTexto("Reset Password");
		
		//assertiva
		Assert.assertThat(loginPage.existeElementoPorXPath("//*[@class='oxd-form']"),
				Matchers.is(true));
	}
	
	@Test
	public void id_09_cancelarResetarSenha() {
		//pre condicoes
		
		//execucao
		loginPage.clicarEsqueceuSenha();
		loginPage.esperarPresencaPorTexto("Reset Password");
		loginPage.clicarCancelarResetPassword();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Login"),
				Matchers.is(true));
	}
	
	@Test
	public void id_10_resetarSenhaDeUsuarioValido() {
		//pre condicoes
		Mockito.when(email.enviarEmail("carlossilva@site.com")).thenReturn(true);
		
		//execucao
		loginPage.clicarEsqueceuSenha();
		loginPage.esperarPresencaPorTexto("Reset Password");
		loginPage.setUserEsqueceuSenha("carlossilva");
		loginPage.clicarResetPassword();
		
		boolean enviou = email.enviarEmail("carlossilva@site.com");
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Reset Password link sent successfully");
		Assert.assertThat(loginPage.existeElementoPorTexto("Reset Password link sent successfully"),
				Matchers.is(true));
		Assert.assertThat(enviou, Matchers.is(true));
	}
	
	@Test
	public void id_11_esqueceuSenhaSemUsuario() {
		//pre condicoes

		//execucao
		loginPage.clicarEsqueceuSenha();
		loginPage.esperarPresencaPorTexto("Reset Password");
		loginPage.clicarResetPassword();
		
		//assertiva
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"), Matchers.is(true));
	}
	
	@Test
	public void id_12_esqueceuASenhaComUsuarioInexistente() {
		//pre condicoes
		
		//execucao
		loginPage.clicarEsqueceuSenha();
		loginPage.esperarPresencaPorTexto("Reset Password");
		loginPage.setUserEsqueceuSenha("usuarioInexistente");
		loginPage.clicarResetPassword();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Reset Password link sent successfully");
		Assert.assertThat(loginPage.existeElementoPorTexto("Reset Password link sent successfully"),
				Matchers.is(true));
	}
}
