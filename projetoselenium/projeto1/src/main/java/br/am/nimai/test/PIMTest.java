package br.am.nimai.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.LoginPage;
import br.am.nimai.page.MenuPage;
import br.am.nimai.page.PIMPage;

public class PIMTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	PIMPage pimPage = new PIMPage();
	
	@Before
	public void login() {
		loginPage.loginCompleto("Admin", "admin123");
		loginPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		menuPage.acessarPIM();
		pimPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-table-card']"));
	}
	
	@Test
	public void id_23_criarNovoEmpregado() throws InterruptedException {
		pimPage.clicarAddEmployee();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		pimPage.escreverFirstName("Ferdinando");
		pimPage.escreverLastName("Nareta");
		pimPage.escreverEmployeeId(pimPage.pegarNumeroAleatorioId());
		pimPage.salvar();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		Assert.assertThat(pimPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_24_criarNovoEmpregadoSemDados() throws InterruptedException {
		pimPage.clicarAddEmployee();
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		
		pimPage.salvar();
		
		Assert.assertThat(pimPage.pegarRequiredDoFirstName(), Matchers.is("Required"));
		Assert.assertThat(pimPage.pegarRequiredDoLastName(), Matchers.is("Required"));
	}
	
	@Test
	public void id_25_criarNovoEmpregadoComId10Digitos() throws InterruptedException {
		pimPage.clicarAddEmployee();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		pimPage.escreverFirstName("Ferdinando");
		pimPage.escreverLastName("Nareta");
		pimPage.escreverEmployeeId("12312312312");
		pimPage.salvar();
		
		Assert.assertThat(pimPage.pegarSpanDoEmployeeId(), Matchers.is("Should not exceed 10 characters"));
	}
	
	@Test
	public void id_26_criarNovoEmpregadoComId000() throws InterruptedException {
		//deve dar erro
		pimPage.clicarAddEmployee();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		pimPage.escreverFirstName("Ferdinando");
		pimPage.escreverLastName("Nareta");
		pimPage.escreverEmployeeId("000");
		pimPage.salvar();
		
		Assert.assertThat(pimPage.pegarSpanDoEmployeeId(), Matchers.is("ID should not be less than 1"));
	}
	
	@Test
	public void id_27_criarNovoEmpregadoComIdNegativo() throws InterruptedException {
		//deve dar erro
		pimPage.clicarAddEmployee();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		pimPage.escreverFirstName("Ferdinando");
		pimPage.escreverLastName("Nareta");
		pimPage.escreverEmployeeId("-354");
		pimPage.salvar();
		
		Assert.fail("deve dar erro");
		Assert.assertThat(pimPage.pegarSpanDoEmployeeId(), Matchers.is("ID should not be less than 1"));
	}
	
	@Test
	public void id_28_criarNovoEmpregadoSemId() throws InterruptedException {
		//deve dar erro
		pimPage.clicarAddEmployee();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		pimPage.escreverFirstName("Ferdinando");
		pimPage.escreverLastName("Nareta");
		pimPage.escreverEmployeeId("");
		pimPage.salvar();
		
		Assert.fail("deve dar erro");
		Assert.assertThat(pimPage.pegarSpanDoEmployeeId(), Matchers.is("Required"));
	}
	
	@Test
	public void id_29_criarNovoEmpregadoComNovoLogin() throws InterruptedException {
		//deve dar erro
		pimPage.clicarAddEmployee();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		pimPage.escreverFirstName("Ferdinando");
		pimPage.escreverLastName("Nareta");
		pimPage.escreverEmployeeId(pimPage.pegarNumeroAleatorioId());
		
		pimPage.clicarBotaoCriarDetalhesLogin();
		
		pimPage.escreverUsername("Jacaibo" + pimPage.randomNum(5000));
		pimPage.escreverPassword("admin123");
		pimPage.escreverConfirmPassword("admin123");
		
		pimPage.salvar();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		Assert.assertThat(pimPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_30_criarNovoEmpregadoComNovoLoginSemUsuarioESenhaPreenchidos() throws InterruptedException {
		//deve dar erro
		pimPage.clicarAddEmployee();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		pimPage.escreverFirstName("Ferdinandoo2");
		pimPage.escreverLastName("Naretaa");
		pimPage.escreverEmployeeId(pimPage.pegarNumeroAleatorioId());
		
		pimPage.clicarBotaoCriarDetalhesLogin();
		
		pimPage.salvar();
		
		Assert.assertThat(pimPage.pegarSpanUsername(), Matchers.is("Required"));
		Assert.assertThat(pimPage.pegarSpanPassword(), Matchers.is("Required"));
		Assert.assertThat(pimPage.pegarSpanConfirmPassword(), Matchers.is("Required"));
	}
	
	@Test
	public void id_31_clicarSuporteAddNovoEmployee() throws InterruptedException {
		pimPage.clicarAddEmployee();
		pimPage.esperarPresencaPorElemento(By.xpath("//label[@class='oxd-label oxd-input-field-required']"));
		pimPage.esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
		
		pimPage.clicarBotaoSuporte();
		pimPage.trocarFocoPSuporte();
		
		pimPage.esperarPresencaPorElemento(By.xpath("//h1[@title='How to Add an Employee']"));
		
		Assert.assertThat(pimPage.pegarTitlePageSuporte(), Matchers.startsWith("How to Add an Employee"));
		// – 
	}
	
	@Test
	public void id_32_fazerPesquisaDeEmployeeName() throws InterruptedException {
		pimPage.search();
		pimPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']"));
		Assert.assertThat(pimPage.existeAlgumElementoNaTabela(), Matchers.is(true));
	}
}
