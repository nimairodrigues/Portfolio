package br.am.nimai.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.LoginPage;
import br.am.nimai.page.MenuPage;
import br.am.nimai.page.RecruitmentPage;

public class RecruitmentTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	RecruitmentPage recruitPage = new RecruitmentPage();
	
	@Before
	public void login() {
		loginPage.loginCompleto("Admin", "admin123");
		loginPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		menuPage.acessarRecruit();
		loginPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-table-card']"));
	}
	
	@Test
	public void id_44_criarNovoCandidato() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.escreverFirstName("Josevane");
		recruitPage.escreverLastName("Trigueiro");
		recruitPage.escreverEmail("josevanetrigueiro"+recruitPage.randomNum(4000)+"@yahoo.com");
		recruitPage.clicarSave();
		Assert.assertThat(recruitPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_45_criarNovoCandidatoSemDados() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.clicarSave();
		
		Assert.assertThat(recruitPage.pegarSpanFirstName(), Matchers.is("Required"));
		Assert.assertThat(recruitPage.pegarSpanLastName(), Matchers.is("Required"));
		Assert.assertThat(recruitPage.pegarSpanEmail(), Matchers.is("Required"));
	}
	
	@Test
	public void id_46_criarNovoCandidatoComEmailIncorreto() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.escreverFirstName("Josevane");
		recruitPage.escreverLastName("Trigueiro");
		recruitPage.escreverEmail("josevanetrigueiro"+recruitPage.randomNum(4000)+"#yahoo.com");
		recruitPage.clicarSave();
		Assert.assertThat(recruitPage.pegarSpanEmail(), Matchers.is("Expected format: admin@example.com"));
	}
	
	@Test
	public void id_47_criarNovoCandidatoComVagaPreenchida() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.escreverFirstName("Josevane");
		recruitPage.escreverLastName("Trigueiro");
		recruitPage.escreverEmail("josevanetrigueiro"+recruitPage.randomNum(4000)+"@yahoo.com");
		recruitPage.selecionarComboVacancy("");
		recruitPage.clicarSave();
		
		Assert.assertThat(recruitPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_48_apagarUmCandidato() throws InterruptedException {
		recruitPage.criarCandidato("Josevanese", "Trigueiro", "josevanesetrigueiro@yahoo.com");
		recruitPage.acessarCandidates();
		recruitPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-table-body']//*[@class='oxd-table-row oxd-table-row--with-border']/div[3]"));
		recruitPage.clicarApagarCandidato("Josevanese  Trigueiro");
		recruitPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		recruitPage.clicarPorTexto(" Yes, Delete ");
		
		Assert.assertThat(recruitPage.pegarPopupResultado(), Matchers.is("Successfully Deleted"));
	}
	
	@Test
	public void id_49_fazerPesquisaPorGrupoJobTitle() throws InterruptedException {
		recruitPage.selecionarComboJobTitle("QA Lead");
		recruitPage.search();
		
		try{
			recruitPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-table-card']/div"));
			Assert.assertThat(recruitPage.existeElementoPorXPath("//*[@class='oxd-table-card']/div"), Matchers.is(true));
		} catch (Exception e){
			Assert.fail("Nao encontrou elementos na tela");
		}
	}
	
	@Test
	public void id_50_clicarMaisInfoDeCandidato() throws InterruptedException {
		recruitPage.clicarMaisInfo();
		recruitPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-text oxd-text--p']"));
		Assert.assertThat(recruitPage.existeElementoPorXPath("//*[@class='oxd-text oxd-text--p']"), Matchers.is(true));
	}
}
