package br.am.nimai.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage = new LoginPage();
	
	@Test
	public void loginUsuarioESenhaCorretos() {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("Admin");
		loginPage.setSenha("admin123");
		loginPage.logar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Dashboard");
		Assert.assertThat(loginPage.existeElementoPorTexto("Dashboard"), Matchers.is(true));
	}
	
	@Test
	public void loginUsuarioESenhaIncorretos() throws InterruptedException {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("usuarioIncorreto");
		loginPage.setSenha("naoexiste");
		loginPage.logar();
		
		//assertiva
//		loginPage.esperarPresenca("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Invalid credentials"), Matchers.is(true));
	}
	
	@Test
	public void loginUsuarioIncorretoESenhaCorreto() {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("usuarioIncorreto");
		loginPage.setSenha("admin123");
		loginPage.logar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Invalid credentials"), Matchers.is(true));
	}
	
	@Test
	public void loginUsuarioCorretoESenhaIncorreto() {
		//pre condicoes
		
		//execucao
		loginPage.setUsuario("Admin");
		loginPage.setSenha("senhaIncorreta");
		loginPage.logar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Invalid credentials"), Matchers.is(true));
	}
	
	@Test
	public void loginSemUsuarioESenha() {
		//pre condicoes
		
		//execucao
		loginPage.logar();
		
		//assertiva
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"), Matchers.is(true));
	}
	
	@Test
	public void loginSemUsuarioESenhaPreenchida() {
		//pre condicoes
		
		//execucao
		loginPage.setSenha("senhaQualquer");
		loginPage.logar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"), Matchers.is(true));
	}
	
	@Test
	public void loginUsuarioPreenhidoESemSenha() {
		//pre condicoes

		//execucao
		loginPage.setUsuario("Nimai");
		loginPage.logar();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Login");
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"), Matchers.is(true));
	}
	
	@Test
	public void esqueceuASenhaComSucesso() {
		//pre condicoes
		
		//execucao
		loginPage.clicarEsqueceuSenha();
		loginPage.esperarPresencaPorTexto("Reset Password");
		loginPage.setUserEsqueceuSenha("carlossilva");
		loginPage.clicarResetPassword();
		
		//assertiva
		loginPage.esperarPresencaPorTexto("Reset Password link sent successfully");
		Assert.assertThat(loginPage.existeElementoPorTexto("Reset Password link sent successfully"),
				Matchers.is(true));
	}
	
	@Test
	public void esqueceuASenhaCancelar() {
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
	public void esqueceuSenhaSemUsuario() {
		//pre condicoes

		//execucao
		loginPage.clicarEsqueceuSenha();
		loginPage.esperarPresencaPorTexto("Reset Password");
		loginPage.clicarResetPassword();
		
		//assertiva
		Assert.assertThat(loginPage.existeElementoPorTexto("Required"),
						Matchers.is(true));
	}
	
	@Test
	public void esqueceuASenhaUsuarioInexistente() {
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
