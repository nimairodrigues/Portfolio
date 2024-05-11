package br.am.nimai.test;

import org.junit.Assert;
import org.junit.Test;

import br.am.nimai.core.BaseTest;
import br.am.nimai.core.Properties;
import br.am.nimai.page.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage = new LoginPage();
	
//	@Test
	public void ct_01_loginComSucesso() throws InterruptedException {
		  loginPage.escreverUsuario(Properties.user);
		  loginPage.escreverSenha(Properties.pw);
		  loginPage.clicarLogin();
		  
		  Assert.assertTrue(loginPage.existeElementoPorTexto("Save your login info?"));
		  
	}
	
	@Test
	public void ct_02_loginUsuarioValidoESenhaIncorreta() throws InterruptedException {
		loginPage.escreverUsuario(Properties.user);
		loginPage.escreverSenha("senhaqualquer935");
		loginPage.clicarLogin();
		  
		Assert.assertTrue(loginPage.existeElementoPorTexto("The password you entered is incorrect. To log in, you'll need to enter a code."));
//		Assert.assertTrue(loginPage.existeElementoPorTexto("The password you entered is incorrect."));
		
	}
	
	@Test 
	public void ct_03_loginApenasComUsuarioPreenchido() throws InterruptedException {
		loginPage.escreverUsuario(Properties.user);
		loginPage.clicarLogin();
		  
		Assert.assertTrue(loginPage.isPasswordFocused());
		
	}
	
	@Test
	public void ct_04_loginSemPreencherUsuarioESenha() throws InterruptedException {
		loginPage.clicarLogin();
		
		Assert.assertTrue(loginPage.existeElementoPorTexto("Enter your username, email or mobile number to log in"));
		
	}
	
	@Test
	public void ct_05_loginUsuarioInexistenteComSenhaQualquer() throws InterruptedException {
		  loginPage.escreverUsuario("msEkj46fewas21");
		  loginPage.escreverSenha("senhaqualquer935");
		  loginPage.clicarLogin();
		  
		  Assert.assertTrue(loginPage.existeElementoPorTexto("Can't find account"));
		  
	}
	
	@Test
	public void ct_06_clicarSalvarCredenciais() throws InterruptedException {
		loginPage.clicarCheckboxCredenciais();
		
		Assert.assertTrue(loginPage.isCheckboxMarcado());
		
	}
}
