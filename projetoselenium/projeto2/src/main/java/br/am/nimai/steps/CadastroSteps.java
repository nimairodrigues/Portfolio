package br.am.nimai.steps;

import org.junit.Assert;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.CadastroPage;
import br.am.nimai.page.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroSteps extends BaseTest {
	
	CadastroPage cadastroPage = new CadastroPage();
	LoginPage loginPage = new LoginPage();
	
	@Dado("que sou um visitante")
	public void queSouUmVisitante() {
	    
	}

	@Quando("eu clicar em Registrar")
	public void euClicarEmRegistrar() {
	    loginPage.clicarRegistrar();
	}

	@Quando("digitar o e-mail {string} na tela de cadastro")
	public void digitarOEMail(String string) {
	    cadastroPage.escreverEmail(string);
	}

	@Quando("digitar o nome {string}")
	public void digitarONome(String string) {
	    cadastroPage.escreverNome(string);
	}
	
	@Quando("digitar a senha {string} na tela de cadastro")
	public void digitarASenhaNaTelaDeCadastro(String string) {
	    cadastroPage.escreverSenha(string);
	}

	@Quando("digitar a senha novamente {string} na tela de cadastro")
	public void digitarASenhaNovamenteNaTelaDeCadastro(String string) {
		cadastroPage.escreverConfirmarSenha(string);
	}

	@Quando("clicar em Cadastrar")
	public void clicarEmCadastrar() throws InterruptedException {
	    cadastroPage.clicarCadastrar();
	}

	@Então("deve aparecer que a conta foi criada com sucesso")
	public void deveAparecerQueAContaFoiCriadaComSucesso() {
		Assert.assertTrue(cadastroPage.existeMensagemContaCriadaComSucesso());
	}
	
	@Então("deve informar que o campo nome é obrigatório")
	public void deveInformarQueOCampoNomeÉObrigatório() {
	    Assert.assertEquals("É campo obrigatório", cadastroPage.pegarTextoWarningNome());
	}

	@Então("deve informar que o campo e-mail é obrigatório na tela de cadastro")
	public void deveInformarQueOCampoEMailÉObrigatórioNaTelaDeCadastro() {
	    Assert.assertEquals("É campo obrigatório", cadastroPage.pegarTextoWarningEmail());
	}

	@Então("deve informar que o campo senha é obrigatório na tela de cadastro")
	public void deveInformarQueOCampoSenhaÉObrigatórioNaTelaDeCadastro() {
	    Assert.assertEquals("É campo obrigatório", cadastroPage.pegarTextoWarningSenha());
	}
	
	@Então("deve informar que o campo confirmação de senha é obrigatório")
	public void deveInformarQueOCampoConfirmaçãoDeSenhaÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", cadastroPage.pegarTextoWarningSenhaConfirm());
	}
	
	@Então("deve informar que o formato do e-mail está inválido na tela de cadastro")
	public void deveInformarQueOFormatoDoEMailEstáInválidoNaTelaDeCadastro() {
	    Assert.assertEquals("Formato inválido", cadastroPage.pegarTextoWarningEmail());
	}
	
	@Então("deve informar que o campo confirmar senha é obrigatório na tela de cadastro")
	public void deveInformarQueOCampoConfirmarSenhaÉObrigatórioNaTelaDeCadastro() {
		Assert.assertEquals("É campo obrigatório", cadastroPage.pegarTextoWarningSenhaConfirm());
	}

}
