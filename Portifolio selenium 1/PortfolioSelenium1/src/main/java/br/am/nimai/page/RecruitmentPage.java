package br.am.nimai.page;

import org.openqa.selenium.By;

import br.am.nimai.core.BasePage;

public class RecruitmentPage extends BasePage {
	
	public void clicarAdd() {
		clicar(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']"));
	}
	
	public void clicarSave() {
		clicar(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
	}
	
	public void escreverFirstName(String firstName) {
		escrever(By.xpath("//*[@class='oxd-input oxd-input--active orangehrm-firstname']"), firstName);
	}
	
	public void escreverLastName(String lastName) {
		escrever(By.xpath("//*[@class='oxd-input oxd-input--active orangehrm-lastname']"), lastName);
	}
	
	public void escreverEmail(String email) {
		escrever(By.xpath("//div[@class='oxd-form-row'][3]/div/div[1]//input"), email);
	}
	
	public String pegarSpanFirstName() {
		return obterTextoXpath("//*[@class='oxd-form']//div[@class='oxd-form-row'][1]//div[@class='oxd-input-group oxd-input-field-bottom-space'][1]/span");
	}
	
	public String pegarSpanLastName() {
		return obterTextoXpath("//*[@class='oxd-form']//div[@class='oxd-form-row'][1]//div[@class='oxd-input-group oxd-input-field-bottom-space'][3]/span");
	}
	
	public String pegarSpanEmail() {
		return obterTextoXpath("//*[@class='oxd-form']//div[@class='oxd-form-row'][3]//*[@class='oxd-input-group oxd-input-field-bottom-space']/span");
	}
	
	public String pegarPopupResultado() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return obterTexto(By.xpath("//*[@class='oxd-toast-start']//p[2]"));
	}
	
	public void selecionarComboVacancy(String vacancy) {
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']/div[@role='listbox']/div[2]/span"));
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])/..//div[@role='listbox']/div[2]/span"));
//		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])/..//div[@role='listbox']//*[text()='"+vacancy+"']"));
	}
	
	public void selecionarComboJobTitle(String jobTitle) {
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-select-wrapper']/div[@role='listbox']/div[2]/span"));
		clicar(By.xpath("(//*[@class='oxd-select-wrapper'])/..//div[@role='listbox']//*[text()='"+jobTitle+"']"));
	}
	
	public void clicarApagarCandidato(String candidatoNome) {
		clicar(By.xpath("//*[text()='"+candidatoNome+"']/../..//*[@class='oxd-icon bi-trash']"));
	}
	
	public void search() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public void clicarMaisInfo() {
		clicar(By.xpath("//i[@class='oxd-icon bi-eye-fill']"));
	}
	
	public void criarCandidato() {
		clicarAdd();
		escreverFirstName("Josevane");
		escreverLastName("Trigueiro");
		escreverEmail("josevanetrigueiro@yahoo.com");
		clicarSave();
		
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-toast-start']"));
	}
	
	public void acessarCandidates() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-text oxd-text--p']"));
		clicar(By.xpath("//*[@class='oxd-topbar-body']//li[1]"));
		
	}
}
