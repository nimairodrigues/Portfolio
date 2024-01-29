package br.am.nimai.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.am.nimai.core.BaseTest;
import br.am.nimai.page.AdminPage;
import br.am.nimai.page.LoginPage;
import br.am.nimai.page.MenuPage;

public class AdminTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	MenuPage menuPage = new MenuPage();
	AdminPage adminPage = new AdminPage();
	
	@Before
	public void login() {
		loginPage.loginCompleto("Admin", "admin123");
		loginPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		menuPage.acessarAdmin();
		loginPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-table-card']"));
	}
	
	@Test
	public void id_13_criarNovoUsuario() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.selecionarComboUserRole("Admin");
		adminPage.setEmployeeName("a");
		adminPage.selecionarComboStatus("Enabled");
		adminPage.setUsername("username" + adminPage.randomNum(5000));
		adminPage.setSenha("admin123");
		adminPage.setSenhaConfirm("admin123");
		
		adminPage.salvar();
		
		Assert.assertThat(adminPage.pegarPopupResultado(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void id_14_apagarUsuario() {
		String randomNum = adminPage.randomNum(1000);
		adminPage.criarNovoUser("ausername"+randomNum);
		adminPage.esperarPresencaPorElemento(By.xpath("//*[text()='ausername"+randomNum+"']"));
		
		adminPage.apagarUserPorUsername("ausername"+randomNum);
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		adminPage.clicarPorTexto(" Yes, Delete ");
		
		Assert.assertThat(adminPage.pegarPopupResultado(), Matchers.is("Successfully Deleted"));
	}
	
	@Test
	public void id_15_editarUsuario() throws InterruptedException {
		String randomNum = adminPage.randomNum(1000);
		adminPage.criarNovoUser("ausername"+randomNum);
		adminPage.esperarPresencaPorElemento(By.xpath("//*[text()='ausername"+randomNum+"']"));
		
		adminPage.editarUserPorUsername("ausername"+randomNum);
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-label']"));
		
		adminPage.editarUsername("ausername"+randomNum);
		adminPage.clicarBotaoSalvarEdit();
		Assert.assertThat(adminPage.pegarPopupResultado(), Matchers.is("Successfully Updated"));
	}
	
	@Test
	public void id_16_criarNovoUsuarioCom5Caracteres() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
		adminPage.selecionarComboUserRole("Admin");
		adminPage.setEmployeeName("a");
		adminPage.selecionarComboStatus("Enabled");
		adminPage.setUsername("user");
		adminPage.setSenha("admin123");
		adminPage.setSenhaConfirm("admin123");
		
		adminPage.salvar();
		
		Assert.assertThat(adminPage.pegarSpanDoUsername(), Matchers.is("Should be at least 5 characters"));
	}
	
	@Test
	public void id_17_criarNovoUsuarioComSenha6Caracteres() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
		adminPage.selecionarComboUserRole("Admin");
		adminPage.setEmployeeName("a");
		adminPage.selecionarComboStatus("Enabled");
		adminPage.setUsername("usernamee1");
		adminPage.setSenha("admin1");
		adminPage.setSenhaConfirm("admin1");
		
		adminPage.salvar();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/div//span"));
		Assert.assertThat(adminPage.pegarSpanDaSenha(), Matchers.is("Should have at least 7 characters"));
	}
	
	@Test
	public void id_18_criarNovoUsuarioComSenhasDiferentes() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
		adminPage.selecionarComboUserRole("Admin");
		adminPage.setEmployeeName("a");
		adminPage.selecionarComboStatus("Enabled");
		adminPage.setUsername("usernameee1");
		adminPage.setSenha("admin123");
		adminPage.setSenhaConfirm("admin124");
		
		adminPage.salvar();
		
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//span"));
		Assert.assertThat(adminPage.pegarSpanDaSenhaConfirm(), Matchers.is("Passwords do not match"));
	}
	
	@Test
	public void id_19_criarNovoUsuarioSemDados() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
		
		adminPage.salvar();
		
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//span"));
		Assert.assertThat(adminPage.pegarSpanDoUserRole(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDoEmployeeName(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDoStatus(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDoUsername(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDaSenha(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDaSenhaConfirm(), Matchers.is("Required"));
	}
	
	@Test
	public void id_20_criarNovoUsuarioSemPreencherUsuarioESenha() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
		adminPage.selecionarComboUserRole("Admin");
		adminPage.setEmployeeName("a");
		adminPage.selecionarComboStatus("Enabled");
		
		adminPage.salvar();
		
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//span"));
		Assert.assertThat(adminPage.pegarSpanDoUsername(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDaSenha(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDaSenhaConfirm(), Matchers.is("Required"));
	}
	
	@Test
	public void id_21_criarNovoUsuarioSemPreencherSenha() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
		adminPage.selecionarComboUserRole("Admin");
		adminPage.setEmployeeName("a");
		adminPage.selecionarComboStatus("Enabled");
		adminPage.setUsername("usernameee1");
		
		adminPage.salvar();
		
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//span"));
		Assert.assertThat(adminPage.pegarSpanDaSenha(), Matchers.is("Required"));
		Assert.assertThat(adminPage.pegarSpanDaSenhaConfirm(), Matchers.is("Required"));
	}
	
	@Test
	public void id_22_fazerPesquisaPorGrupoAdmin() throws InterruptedException {
		adminPage.selecionarComboUserRole("Admin");
		adminPage.search();
		adminPage.esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-table-loader']"));
		Assert.assertThat(adminPage.pesquisarNaTabelaUmUsuario(adminPage.pegarEmployeeNameLogado()), Matchers.is(true));
	}
	
}
