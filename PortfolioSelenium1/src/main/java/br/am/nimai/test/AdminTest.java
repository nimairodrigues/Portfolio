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
		adminPage.setUsername("username4");
		adminPage.setSenha("admin123");
		adminPage.setSenhaConfirm("admin123");
		
		adminPage.salvar();
		
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		Assert.assertThat(adminPage.pegarPopupSucessoSaved(), Matchers.is("Successfully Saved"));
	}
	
	@Test
	public void apagarUsuario() {
		adminPage.apagarUserPorUsername(adminPage.escolherUmNaoAdmin());
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		adminPage.clicarPorTexto(" Yes, Delete ");
		
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
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
		adminPage.esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
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
		
		Thread.sleep(4000);
		adminPage.setSenhaConfirm("admin123");
		
		adminPage.salvar();
		
		Assert.assertThat(adminPage.pegarRequiredDoUsername(), Matchers.is("Should be at least 5 characters"));
	}
}
