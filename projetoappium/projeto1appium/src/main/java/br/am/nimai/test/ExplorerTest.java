package br.am.nimai.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.ExplorerPage;
import br.am.nimai.page.LoginPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExplorerTest extends BaseTest {
	
	ExplorerPage explorerPage = new ExplorerPage();
	LoginPage loginPage = new LoginPage();
	
	@Before
	public void logarEAcessarExplorer() {
		loginPage.logar();
		loginPage.clicarNotNow();
		explorerPage.acessarExplorer();
		explorerPage.esperarCarregarExplorer();
	}
	
	@Test
	public void ct_07_pesquisarMarkEAbrirPerfil() {
		explorerPage.escreverNoSearch("@zuck");
		explorerPage.clicarNoPerfilSearch("zuck"); 
		
		Assert.assertEquals("zuck", explorerPage.obterProfileUsername());
		
	}
	
	@Test
	public void ct_08_darLikeEmPost() {
		explorerPage.clicarPub();
		explorerPage.clicarLike();
		
		Assert.assertTrue(explorerPage.obterIsLiked());
	}
	
	@Test
	public void ct_09_comentarEmPost() throws InterruptedException {
		explorerPage.clicarPub();
		
		explorerPage.clicarComentarPost();
		
		explorerPage.escreverComentario("Me parece interessante, bom post.");
		explorerPage.clicarEnviarComentario();
		
		Assert.assertTrue(explorerPage.obterIsCommented()); 
		
		explorerPage.apagarComentario();
	}
	
	@Test
	public void ct_10_atualizarPageExplorar() throws InterruptedException {
		String nomePost = explorerPage.obterNomePost();
		explorerPage.scroll(0.3, 0.8);
		explorerPage.esperarAtualizarPaginaExplorer();
		
		Assert.assertNotEquals(nomePost, explorerPage.obterNomePost());
		
	}
	
	@Test
	public void ct_11_salvarPost() {
		explorerPage.clicarPub();
		explorerPage.clicarSalvarPost();
		
		Assert.assertTrue(explorerPage.existeElementoPorTexto("Saved"));
	}
	
	@Test
	public void ct_12_clicarBotaoNaoRecomendarPost() throws InterruptedException {
		explorerPage.cliqueESeguraNaPubParaOptions();
		explorerPage.clicarNotInterested();
		
		Assert.assertTrue(explorerPage.existeElementoPorTexto("Post hidden"));
	}
}
