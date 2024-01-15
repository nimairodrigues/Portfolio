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
	public void criarNovoCandidato() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.escreverFirstName("Josevane");
		recruitPage.escreverLastName("Trigueiro");
		recruitPage.escreverEmail("josevanetrigueiro"+recruitPage.randomNum(4000)+"@yahoo.com");
		recruitPage.clicarSave();
		Assert.assertThat(recruitPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void criarNovoCandidatoSemDados() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.clicarSave();
		
		Assert.assertThat(recruitPage.pegarSpanFirstName(), Matchers.is("Required"));
		Assert.assertThat(recruitPage.pegarSpanLastName(), Matchers.is("Required"));
		Assert.assertThat(recruitPage.pegarSpanEmail(), Matchers.is("Required"));
	}
	
	@Test
	public void criarNovoCandidatoComEmailIncorreto() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.escreverFirstName("Josevane");
		recruitPage.escreverLastName("Trigueiro");
		recruitPage.escreverEmail("josevanetrigueiro"+recruitPage.randomNum(4000)+"#yahoo.com");
		recruitPage.clicarSave();
		Assert.assertThat(recruitPage.pegarSpanEmail(), Matchers.is("Expected format: admin@example.com"));
	}
	
	@Test
	public void criarNovoCandidatoComVagaPreenchida() throws InterruptedException {
		recruitPage.clicarAdd();
		recruitPage.escreverFirstName("Josevane");
		recruitPage.escreverLastName("Trigueiro");
		recruitPage.escreverEmail("josevanetrigueiro"+recruitPage.randomNum(4000)+"@yahoo.com");
		recruitPage.selecionarComboVacancy("");
		recruitPage.clicarSave();
		
		Assert.assertThat(recruitPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void fazerPesquisaPorGrupoJobTitle() throws InterruptedException {
		recruitPage.selecionarComboJobTitle("QA Lead");
		recruitPage.search();
		recruitPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-table-card']/div"));
		Assert.assertThat(recruitPage.existeElementoPorXPath("//*[@class='oxd-table-card']/div"), Matchers.is(true));
	}
	
	@Test
	public void clicarMaisInfoDeCandidato() throws InterruptedException {
		recruitPage.clicarMaisInfo();
		recruitPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-text oxd-text--p']"));
		Assert.assertThat(recruitPage.existeElementoPorXPath("//*[@class='oxd-text oxd-text--p']"), Matchers.is(true));
	}
	
}
