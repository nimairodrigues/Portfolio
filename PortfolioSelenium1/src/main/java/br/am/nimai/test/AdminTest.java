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
	public void criarNovoUsuario() throws InterruptedException {
		adminPage.clicarAddUser();
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
		adminPage.selecionarComboUserRole("Admin");
		adminPage.setEmployeeName("a");
		adminPage.selecionarComboStatus("Enabled");
		adminPage.setUsername("username5");
		adminPage.setSenha("admin123");
		adminPage.setSenhaConfirm("admin123");
		
		adminPage.salvar();
		
		Assert.assertThat(adminPage.pegarPopupSucessoSaved(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void apagarUsuario() {
		adminPage.apagarUserPorUsername(adminPage.escolherUmNaoAdmin());
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		adminPage.clicarPorTexto(" Yes, Delete ");
		
		Assert.assertThat(adminPage.pegarPopupSucessoDelete(), Matchers.is("Successfully Deleted"));
	}
	
	@Test
	public void editarUsuario() throws InterruptedException {
		String usuarioEscolhido = adminPage.escolherUmNaoAdmin();
		adminPage.editarUserPorUsername(usuarioEscolhido);
		adminPage.esperarPresencaPorElemento(By.xpath("//button[@type='submit']"));
		//achar outro elemento para esperar a presenca, aqui ele ta escrevendo antes de carregar o texto escrito no site
		Thread.sleep(1000);
		adminPage.editarUsername(usuarioEscolhido);
		Thread.sleep(1000);
		adminPage.clicarBotaoSalvarEdit();
		Assert.assertThat(adminPage.pegarPopupSucessoUpdated(), Matchers.is("Successfully Updated"));
	}
	
	@Test
	public void criarNovoUsuarioCom5Caracteres() throws InterruptedException {
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
	public void criarNovoUsuarioComSenha6Caracteres() throws InterruptedException {
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
	public void criarNovoUsuarioComSenhasDiferentes() throws InterruptedException {
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
	public void criarNovoUsuarioSemDados() throws InterruptedException {
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
	public void criarNovoUsuarioSemPreencherUsuarioESenha() throws InterruptedException {
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
	public void criarNovoUsuarioSemPreencherSenha() throws InterruptedException {
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
	public void fazerPesquisaPorGrupoAdmin() throws InterruptedException {
		adminPage.selecionarComboUserRole("Admin");
		adminPage.search();
		adminPage.esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-table-loader']"));
		Assert.assertThat(adminPage.pesquisarNaTabelaUmUsuario(adminPage.pegarEmployeeNameLogado()), Matchers.is(true));
	}
}
