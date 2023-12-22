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
	public void fazerUmPost() throws InterruptedException {
		buzzPage.escreverPost("Meu numero da sorte e: " + buzzPage.aleatorizarNumeros(100));
		buzzPage.clicarPost();
		Assert.assertThat(buzzPage.pegarPopupSucessoSaved(), Matchers.is("Successfully Saved"));
		Thread.sleep(5000);
	}
	
	@Test
	public void apagarUmPost() {
		buzzPage.clicarApagarPost();
		buzzPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		buzzPage.clicarPorTexto(" Yes, Delete ");
		
		Assert.assertThat(buzzPage.pegarPopupSucessoDelete(), Matchers.is("Successfully Deleted"));
	}
	
	@Test
	public void alterarUmPost() throws InterruptedException {
		//nomes de usuarios que contem nos post pode mudar tendo um middle name
		buzzPage.clicarAlterarPost();
		buzzPage.escreverEditPost();
		buzzPage.clicarPostEdit();
		Assert.assertThat(buzzPage.pegarPopupSucessoUpdated(), Matchers.is("Successfully Updated"));
	}
	
	@Test
	public void tests() throws InterruptedException {
		buzzPage.encontrarPostDeUmUsuario(buzzPage.pegarUsuarioLogado());
		Thread.sleep(5000);
	}
	
	@Test
	public void fazerUmPostAcimaDe65530() throws InterruptedException {
		//ficou inviavel por demorar demais pra escrever na tela
		buzzPage.escreverPostLongo();
//		buzzPage.clicarPost();
		Thread.sleep(5000);
	}
	
	@Test
	public void darLikeEmAlgumPost() throws InterruptedException {
		//nao da pra garantir que haverá post likeado ou não likeado para fazer os testes divididos entre darLikeEmPost e darUnlikeEmPost
		//melhor opcao era fazer só a interação no icone de like e verificar se a interação foi feita
		if(buzzPage.isLikeado()) {
			int likesAnterior = buzzPage.pegarQtdLikes();
			System.out.println("1 caso");
			buzzPage.clicarLikePost2();
			buzzPage.esperarInvisibilidadeDeElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']//*[@class='orangehrm-like-animation']"));
			Assert.assertThat(buzzPage.isLikeado(), Matchers.is(false));
			Assert.assertThat(buzzPage.pegarQtdLikes(), Matchers.is(likesAnterior - 1));
		} else {
			int likesAnterior = buzzPage.pegarQtdLikes();
			System.out.println("2 caso");
			buzzPage.clicarLikePost2();
			buzzPage.esperarPresencaPorElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']//*[@class='orangehrm-like-animation']"));
			Assert.assertThat(buzzPage.isLikeado(), Matchers.is(true));
			Assert.assertThat(buzzPage.pegarQtdLikes(), Matchers.is(likesAnterior + 1));
		}
	}
	
	@Test
	public void shareAlgumPost() throws InterruptedException {
		buzzPage.clicarCompartilharPost();
		buzzPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-dialog-container-default--inner']//*[@class='oxd-form']"));
		buzzPage.clicarShare();
		Assert.assertThat(buzzPage.pegarPopupSucessoSaved(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void comentarAlgumPost() {
		buzzPage.clicarBotaoComentar();
		buzzPage.escreverNosComents("Legal!");
		buzzPage.enviarComent();
		Assert.assertThat(buzzPage.pegarPopupSucessoSaved(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void curtirAlgumComentarioDeAlgumPost() throws InterruptedException {
		buzzPage.comentarEmAlgumPost("Incrivel!");
		
		buzzPage.clicarLikeComent("Incrivel!");
		Assert.assertThat(buzzPage.pegarLikesComent("Incrivel!"), Matchers.is("1"));
		
		buzzPage.apagarMeuComentario("Incrivel!");
	}
	
	@Test
	public void editarOProprioComentario() {
		buzzPage.comentarEmAlgumPost("Incrivel!");
		
		buzzPage.clicarEditComent("Incrivel!");
		buzzPage.escreverEditComent("Incrivel!2");
		Assert.assertThat(buzzPage.pegarPopupSucessoUpdated(), Matchers.is("Successfully Updated"));
		
		buzzPage.apagarMeuComentario("Incrivel!2");
	}
	
	@Test
	public void apagarOProprioComentario() {
		buzzPage.comentarEmAlgumPost("Incrivel!");
		
		buzzPage.clicarApagarComent("Incrivel!");
		buzzPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		buzzPage.clicarPorTexto(" Yes, Delete ");
		Assert.assertThat(buzzPage.pegarPopupSucessoDelete(), Matchers.is("Successfully Deleted"));
		
	}
	
	
}
