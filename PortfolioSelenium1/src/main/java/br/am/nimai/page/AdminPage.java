package br.am.nimai.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class AdminPage extends BasePage {
	
	public void clicarAddUser() {
		clicar(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
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
	//*[@class='oxd-table-loader']
	
	public void apagarUserPorUsername(String username) {
		obterCelula2("Username", username, "Actions", "oxd-table").findElement(By.xpath(".//i[@class='oxd-icon bi-trash']")).click();
	}
	
	public void editarUserPorUsername(String username) {
		obterCelula2("Username", username, "Actions", "oxd-table").findElement(By.xpath(".//i[@class='oxd-icon bi-pencil-fill']")).click();
	}
	
	public String pegarPopupSucessoDelete() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-toast-start']//*[text()='Successfully Deleted']")).getText();
	}
	
	public String pegarPopupSucessoSaved() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-toast-start']//*[text()='Successfully Saved']")).getText();
	}
	
	public String pegarPopupSucessoUpdated() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-toast-start']//*[text()='Successfully Updated']")).getText();
	}
	
	public String pegarSpanDaSenha() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//span")).getText();
	}
	
	public String pegarSpanDaSenhaConfirm() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//span")).getText();
	}
	
	public String pegarSpanDoUserRole() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//span")).getText();
	}
	
	public String pegarSpanDoEmployeeName() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//span")).getText();
	}
	
	public String pegarSpanDoStatus() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]//span")).getText();
	}
	
	public String pegarSpanDoUsername() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@class='oxd-form-row']//div[@class='oxd-grid-item oxd-grid-item--gutters'][4]//span")).getText();
	}
	
	public void editarUsername(String usuarioEscolhido) {
		escrever(By.xpath("//*[@class='oxd-form-row']//*[@class='oxd-input oxd-input--active']"), "1");
	}

	public void clicarBotaoSalvarEdit() {
		clicar(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
		
	}

	public String escolherUmNaoAdmin() {
		List<WebElement> findElements = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-table-body']//*[@class='oxd-table-row oxd-table-row--with-border']/div[2]/div"));
		
		for(int i = 0; i < findElements.size(); i++) {
//			System.out.println("Usuario " + i + ": " + findElements.get(i).getText());
		}
		
		if(findElements.get(0).getText().contains("Admin")) {
			System.out.println("Admin é o primeiro.");
			System.out.println("Pegando o próximo usuário... " + findElements.get(1).getText());
			return findElements.get(1).getText();
		} else {
			System.out.println("Admin nao é o primeiro.");
			System.out.println("Pegando o primeiro usuário... " + findElements.get(0).getText());
			return findElements.get(0).getText();
		}
	}
}
