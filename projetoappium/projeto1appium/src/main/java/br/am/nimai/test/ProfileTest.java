package br.am.nimai.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.LoginPage;
import br.am.nimai.page.ProfilePage;

public class ProfileTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	ProfilePage profilePage = new ProfilePage();
	
	@Before
	public void logarEAcessarExplorer() {
		loginPage.logar();
		loginPage.clicarNotNow();
		profilePage.acessarExplorer();
		profilePage.escreverNoSearch("@zuck");
		profilePage.clicarNoPerfilSearch("zuck");
	}
	
	@Test
	public void ct_13_clicarLikeEmAlgumaFotoPeloPerfil() throws InterruptedException {
		profilePage.clicarFoto();
		profilePage.verificarBarraDeOpcoesVisivel();
		Boolean fotoIsLiked = profilePage.likeIsSelected();
		
		profilePage.clicarLike();
		
		Assert.assertNotEquals(fotoIsLiked, profilePage.likeIsSelected());
	}
	
	@Test
	public void ct_14_comentarEmAlgumaFotoPeloPerfil() {
		profilePage.clicarFoto();
		profilePage.verificarBarraDeOpcoesVisivel();
		
		profilePage.clicarComentar();
		profilePage.escreverComentario("Interessante!");
		profilePage.clicarEnviarComentario();
		
		Assert.assertTrue(profilePage.obterIsCommented());
		
		profilePage.apagarComentario();
		
	}
}
