package br.am.nimai.steps;

import org.junit.Assert;

import br.am.nimai.page.CadastroPage;
import br.am.nimai.page.LoginPage;
import br.am.nimai.page.TransferenciaPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class TransferenciaSteps {
	
	TransferenciaPage transferenciaPage = new TransferenciaPage();
	CadastroPage cadastroPage = new CadastroPage();
	LoginPage loginPage = new LoginPage();
	
	String usuarioParaReceberValor;
	
	@Dado("que estou na dashboard de usuário")
	public void queEstouNaDashboardDeUsuário() throws InterruptedException {
	    loginPage.realizarLogin("nimaiqa@test.com", "nimai123");
	}
	
	@Dado("que há uma conta criada para receber o valor")
	public void queHáUmaContaCriadaParaReceberOValor() {
		loginPage.clicarRegistrar();
		System.out.println("user2");
		usuarioParaReceberValor = cadastroPage.cadastrarUsuario("nimaiqa2@test.com", "Nimai2", "nimai123", "nimai123");
	}
	
	@Dado("que tenho valores disponíveis na minha conta")
	public void queTenhoValoresDisponíveisNaMinhaConta() {
	    
	}
	
	@Quando("eu clicar em Transferência")
	public void euClicarEmTransferência() {
		transferenciaPage.clicarTransferencia();
	}
	
	@Quando("digitar um número da conta")
	public void digitarUmNúmeroDaConta() {
		String[] accNumber = usuarioParaReceberValor.split("-");
		transferenciaPage.escreverNumeroConta(accNumber[0]);
	}
	
	@Quando("digitar um dígito")
	public void digitarUmDígito() throws InterruptedException {
		String[] digit = usuarioParaReceberValor.split("-");
	    transferenciaPage.escreverDigito(digit[1]);
	}
	
	@Quando("digitar o valor da transferência {string}")
	public void digitarUmValorDaTransferência(String valor) throws InterruptedException {
		transferenciaPage.escreverValor(valor);
	}
	
	@Quando("digitar a descrição {string}")
	public void digitarUmaDescrição(String desc) {
		transferenciaPage.escreverDescricao(desc);
	}
	
	@Quando("clicar em Transferir agora")
	public void clicarEmTransferirAgora() {
		transferenciaPage.clicarTransferir();
	}
	
	@Quando("digitar o número da conta {string}")
	public void digitarONúmeroDaConta(String string) {
		transferenciaPage.escreverNumeroConta(string);
	}
	
	@Então("deve aparecer que a transferência foi realizada com sucesso")
	public void deveAparecerQueATransferênciaFoiRealizadaComSucesso() {
	    Assert.assertEquals("Transferencia realizada com sucesso", transferenciaPage.pegarMensagemTransferenciaRealizada());
	}
	
	@Então("deve informar que o campo número da conta é obrigatório")
	public void deveInformarQueOCampoNúmeroDaContaÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", transferenciaPage.pegarTextoWarningNumConta());
	}

	@Então("deve informar que o campo dígito é obrigatório")
	public void deveInformarQueOCampoDígitoÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", transferenciaPage.pegarTextoWarningNumDigit());
	}

	@Então("deve informar que o campo número da conta está inválido")
	public void deveInformarQueOCampoValorNúmeroDaContaEstáInválido() {
		Assert.assertEquals("É campo obrigatório", transferenciaPage.pegarTextoWarningNumConta());
	}
	
	@Então("deve informar que o campo valor da transferência é obrigatório")
	public void deveInformarQueOCampoValorDaTransferênciaÉObrigatório() {
		Assert.assertEquals("É campo obrigatório", transferenciaPage.pegarTextoWarningTransferValue());
	}

}
