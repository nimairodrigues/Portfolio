package br.am.nimai.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class PIMPage extends BasePage {
	
	public void clicarAddEmployee() {
		clicar(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
	}
	
	public void escreverFirstName(String firstName) {
		escrever(By.xpath("//*[@class='oxd-input oxd-input--active orangehrm-firstname']"), firstName);
	}
	
	public void escreverLastName(String lastName) {
		escrever(By.xpath("//*[@class='oxd-input oxd-input--active orangehrm-lastname']"), lastName);
	}
	
	public void escreverEmployeeId(String employeeId) {
		apagarElemento(By.xpath("//*[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-input-group oxd-input-field-bottom-space']//input"));
		escrever(By.xpath("//*[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-input-group oxd-input-field-bottom-space']//input"), employeeId);
	}
	
	public void salvar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String pegarPopupResultado() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return obterTexto(By.xpath("//*[@class='oxd-toast-start']//p[2]"));
	}
	
	public String pegarRequiredDoFirstName() {
		return obterTexto(By.xpath("//*[@class='--name-grouped-field']/div[1]/span"));
	}
	
	public String pegarRequiredDoLastName() {
		return obterTexto(By.xpath("//*[@class='--name-grouped-field']/div[3]/span"));
	}
	
	public String pegarSpanDoEmployeeId() {
		return obterTexto(By.xpath("//*[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-input-group oxd-input-field-bottom-space']/span"));
	}
	
	public void clicarBotaoCriarDetalhesLogin() {
		clicar(By.xpath("//*[@class='oxd-switch-wrapper']"));
	}

	public void escreverUsername(String username) {
		escrever(By.xpath("//*[@class='oxd-form-row'][2]//*[@class='oxd-input oxd-input--active']"), username);
		
	}

	public void escreverPassword(String senha) {
		escrever(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input"), senha);
	}

	public void escreverConfirmPassword(String confirmPassword) {
		escrever(By.xpath("//*[@class='oxd-form-row user-password-row']//*[@class='oxd-grid-item oxd-grid-item--gutters']//input"), confirmPassword);
	}

	public String pegarSpanUsername() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row'][2]/div/div[1]//span"));
	}

	public String pegarSpanPassword() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row user-password-row']/div/div[1]//span"));
	}

	public String pegarSpanConfirmPassword() {
		return obterTexto(By.xpath("//*[@class='oxd-form-row user-password-row']/div/div[2]//span"));
	}
	
	public String pegarNumeroAleatorioId() {
		return randomNum(99999);
	}
	
	public void clicarBotaoSuporte() {
		clicar(By.xpath("//*[@class='oxd-topbar-body-nav']//button[@title='Help']"));
	}
	
	public String pegarTitlePageSuporte() {
		return DriverFactory.getDriver().getTitle();
	}
	
	public void trocarFocoPSuporte() {
		trocarJanela((String) DriverFactory.getDriver().getWindowHandles().toArray()[1]);
	}

	public void escreverNoCampoPesquisaEmployeeName(String usuarioLogado) {
		escrever(By.xpath("(//*[@class='oxd-grid-item oxd-grid-item--gutters'])[1]//input"), usuarioLogado);
		//esperar opcai aparecer
		esperarPresencaPorElemento(By.xpath("(//*[@class='oxd-grid-item oxd-grid-item--gutters'])[1]//div[@role='listbox']/div[1]/span"));
		//selecionar a primeria opcao
		clicar(By.xpath("(//*[@class='oxd-grid-item oxd-grid-item--gutters'])[1]//div[@role='listbox']/div[1]/span"));
		
	}

	public void search() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public void procurarNaTabelaOUsuario(String usuario) {
	//descontinuado, motivo: incapaz de fazer assertiva na tabela do site, textos variam muito, nao tem como garantir um elemento pra sempre existir na hora de pesquisar
		List<WebElement> firstNames = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-table-body']//*[@class='oxd-table-card']//*[@role='cell'][3]"));
		List<WebElement> lastNames = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-table-body']//*[@class='oxd-table-card']//*[@role='cell'][4]"));
		
		for(int i = 0; i < firstNames.size(); i++) {
			if((firstNames.get(i).getText() +" "+ lastNames.get(i).getText()).contains(usuario)) {
				System.out.println("achei é o numero: " + i);
			}
		}
	}
	
	public boolean existeAlgumElementoNaTabela() {
		List<WebElement> firstNames = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-table-body']//*[@class='oxd-table-card']//*[@role='cell'][3]"));
		
		return firstNames.size() > 0;
	}
	
}
