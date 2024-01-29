package br.am.nimai.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.BuzzPage;
import br.am.nimai.page.LoginPage;
import br.am.nimai.page.MenuPage;

public class BuzzTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	BuzzPage buzzPage = new BuzzPage();
	
	@Before
	public void login() {
		loginPage.loginCompleto("Admin", "admin123");
		loginPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		menuPage.acessarBuzz();
		buzzPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']"));
	}
	
	@Test
	public void id_33_fazerUmPost() throws InterruptedException {
		buzzPage.escreverPost("Meu numero da sorte e: " + buzzPage.aleatorizarNumeros(100));
		buzzPage.clicarPost();
		
		Assert.assertThat(buzzPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_34_apagarUmPost() {
		buzzPage.clicarApagarPost();
		buzzPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		buzzPage.clicarPorTexto(" Yes, Delete ");
		
		Assert.assertThat(buzzPage.pegarPopupResultado(), Matchers.is("Successfully Deleted"));
	}
	
	@Test
	public void id_35_alterarUmPost() throws InterruptedException {
		buzzPage.fazerPost("esse post sera alterado");
		
		buzzPage.clicarAlterarPost();
		buzzPage.escreverEditPost();
		buzzPage.clicarPostEdit();
		
		Assert.assertThat(buzzPage.pegarPopupResultado(), Matchers.is("Successfully Updated"));
	}
	
	@Test
	public void id_36_fazerUmPostAcimaDe65530() throws InterruptedException {
		buzzPage.escreverPostLongo();
		buzzPage.clicarPost();
		
		Assert.fail("Inviavel por demorar demais para escrever na tela");
	}
	
	@Test
	public void id_37_e_38_darLikeEmAlgumPost() throws InterruptedException {
		if(buzzPage.isLikeado()) {
			int likesAnterior = buzzPage.pegarQtdLikes();
			System.out.println("1 caso");
			buzzPage.clicarLikePost();
			buzzPage.esperarInvisibilidadeDeElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']//*[@class='orangehrm-like-animation']"));
			Assert.assertThat(buzzPage.isLikeado(), Matchers.is(false));
			Assert.assertThat(buzzPage.pegarQtdLikes(), Matchers.is(likesAnterior - 1));
		} else {
			int likesAnterior = buzzPage.pegarQtdLikes();
			System.out.println("2 caso");
			buzzPage.clicarLikePost();
			buzzPage.esperarPresencaPorElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']//*[@class='orangehrm-like-animation']"));
			Assert.assertThat(buzzPage.isLikeado(), Matchers.is(true));
			Assert.assertThat(buzzPage.pegarQtdLikes(), Matchers.is(likesAnterior + 1));
		}
	}
	
	@Test
	public void id_39_shareAlgumPost() throws InterruptedException {
		buzzPage.clicarCompartilharPost();
		buzzPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-dialog-container-default--inner']//*[@class='oxd-form']"));
		buzzPage.clicarShare();
		Assert.assertThat(buzzPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_40_comentarAlgumPost() {
		buzzPage.clicarBotaoComentar();
		buzzPage.escreverNosComents("Legal!");
		buzzPage.enviarComent();
		Assert.assertThat(buzzPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_41_curtirAlgumComentarioDeAlgumPost() throws InterruptedException {
		buzzPage.comentarEmAlgumPost("Incrivel!");
		
		buzzPage.clicarLikeComent("Incrivel!");
		Assert.assertThat(buzzPage.pegarLikesComent("Incrivel!"), Matchers.is("1"));
		
		buzzPage.apagarMeuComentario("Incrivel!");
	}
	
	@Test
	public void id_42_editarOProprioComentario() {
		buzzPage.comentarEmAlgumPost("Incrivel!");
		
		buzzPage.clicarEditComent("Incrivel!");
		buzzPage.escreverEditComent("Incrivel!2");
		Assert.assertThat(buzzPage.pegarPopupResultado(), Matchers.is("Successfully Updated"));
		
		buzzPage.apagarMeuComentario("Incrivel!2");
	}
	
	@Test
	public void id_43_apagarOProprioComentario() {
		buzzPage.comentarEmAlgumPost("Incrivel!");
		
		buzzPage.clicarApagarComent("Incrivel!");
		buzzPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		buzzPage.clicarPorTexto(" Yes, Delete ");
		
		Assert.assertThat(buzzPage.pegarPopupResultado(), Matchers.is("Successfully Deleted"));
	}
}
