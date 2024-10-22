package br.am.nimai.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.CadastroPage;
import br.am.nimai.page.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage = new LoginPage();
	CadastroPage cadastroPage = new CadastroPage();	
	
	@Test
	public void CT_001_RealizarLogin() {
		//Pré-condições
		loginPage.clicarRegistrar();
		cadastroPage.cadastrarUsuario();
		
		//Ações
		loginPage.escreverEmail("nimai@qa.com");
		loginPage.escreverSenha("teste");
		loginPage.clicarAcessar();
		
		//Verificações
		Assert.assertTrue(loginPage.existeMsgBemVindo());		
	}
	
	@Test
	public void CT_002_LogarComSenhaInvalida() throws Exception{
		//Pré-condições
		loginPage.clicarRegistrar();
		cadastroPage.cadastrarUsuario();
		
		//Ações
		loginPage.escreverEmail("nimai@qa.com");
		loginPage.escreverSenha("pwErrada");
		loginPage.clicarAcessar();
		
		//Verificações
		Assert.assertTrue(loginPage.existeMensagemDeSenhaErrada());
	}
	
	@Test
	public void CT_003_LogarComEmailInvalido() {
		//Ações
		loginPage.escreverEmail("nimaiInexistente@qa.com");
		loginPage.escreverSenha("pwQualquer");
		loginPage.clicarAcessar();
		
		//Verificações
		Assert.assertTrue(loginPage.existeMensagemDeSenhaErrada());
	}
	
	@Test
	public void CT_004_LogarSemDados() {
		//Ações
		loginPage.clicarAcessar();
		
		//Verificações
		Assert.assertEquals("É campo obrigatório", loginPage.pegarTextoWarningEmail());
		Assert.assertEquals("É campo obrigatório", loginPage.pegarTextoWarningSenha());
	}
	
	@Test
	public void CT_005_LogarSemSenha() {
		//Ações
		loginPage.escreverEmail("nimai@qa.com");
		loginPage.clicarAcessar();
		
		//Verificações
		Assert.assertEquals("É campo obrigatório", loginPage.pegarTextoWarningSenha());
	}
	
	@Test
	public void CT_006_LogarComEmailForaDosPadroes() {
		//Ações
		loginPage.escreverEmail("nimai@qa");
		loginPage.escreverSenha("pwQualquer");
		loginPage.clicarAcessar();
		
		//Verificações
		Assert.assertEquals("Formato inválido", loginPage.pegarTextoWarningEmail());
	}
}
