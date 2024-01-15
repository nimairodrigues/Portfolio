package br.am.nimai.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class AdminPage extends BasePage {
	
	public void clicarAddUser() {
		clicar(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
	}
	
	public void selecionarComboUserRole(String role) {
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])[1]"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']/div[@role='listbox']"));
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])[1]/..//div[@role='listbox']/div[2]/span"));
	}
	
	public void selecionarComboStatus(String status) {
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])[2]"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']/div[@role='listbox']"));
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])[2]/..//div[@role='listbox']/div[2]/span"));
	}
	
	public void setEmployeeName(String name) {
		escrever(By.xpath("//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/..//input"), name);
		//esperar opção aparecer:
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--focus']/..//div[@role='listbox']/div[1]/span"));
		//selecionar a primeira opção:
		clicar(By.xpath("//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--focus']/..//div[@role='listbox']/div[1]/span"));
	}
	
	public void setUsername(String username) {
		escrever(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"), username);
	}
	
	public void setSenha(String username) {
		escrever(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input"), username);
	}
	
	public void setSenhaConfirm(String username) {
		escrever(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//input"), username);
	}
	
	public void salvar() {
		clicar(By.xpath("//*[@type='submit']"));
	}
	
	public void search() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String pegarEmployeeNameLogado() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).getText();
	}
	
	public boolean pesquisarNaTabelaUmUsuario(String nomeDoEmpregado) {
		List<WebElement> findElements = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-table-body']//*[@class='oxd-table-row oxd-table-row--with-border']/div[4]/div"));
		boolean achou = false;
		for(int i = 0; i < findElements.size(); i++) {
			if(findElements.get(i).getText().contains(nomeDoEmpregado)) {
				achou = true;
				break;
			}
		}
		return achou;
	}
	
	public void apagarUserPorUsername(String username) {
		obterCelula2("Username", username, "Actions", "oxd-table").findElement(By.xpath(".//i[@class='oxd-icon bi-trash']")).click();
	}
	
	public void editarUserPorUsername(String username) {
		obterCelula2("Username", username, "Actions", "oxd-table").findElement(By.xpath(".//i[@class='oxd-icon bi-pencil-fill']")).click();
	}
	
	public String pegarPopupResultado() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return obterTexto(By.xpath("//*[@class='oxd-toast-start']//p[2]"));
	}
	
	public String pegarSpanDaSenha() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//*[@class='oxd-input-group oxd-input-field-bottom-space']//span"));
	}
	
	public String pegarSpanDaSenhaConfirm() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//span"));
	}
	
	public String pegarSpanDoUserRole() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//span"));
	}
	
	public String pegarSpanDoEmployeeName() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//span"));
	}
	
	public String pegarSpanDoStatus() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]//span"));
	}
	
	public String pegarSpanDoUsername() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]//span"));
	}
	
	public void editarUsername(String usuarioEscolhido) {
		escrever(By.xpath("//*[@class='oxd-form-row']//*[@class='oxd-input oxd-input--active']"), "1");
		esperarInvisibilidadeDeElemento(By.xpath("//div[@class='oxd-form-loader']"));
	}

	public void clicarBotaoSalvarEdit() {
		clicar(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
		
	}

	public void criarNovoUser(String user) {
		clicarAddUser();
		selecionarComboUserRole("Admin");
		setEmployeeName("a");
		selecionarComboStatus("Enabled");
		setUsername(user);
		setSenha("admin123");
		setSenhaConfirm("admin123");
		
		salvar();
	}
	
}
