package br.am.nimai.page;


import org.openqa.selenium.By;

import br.am.nimai.core.BasePage;

public class LoginPage extends BasePage {
	
	public void setUsuario(String usuario) {
//		getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(usuario);
		escrever(By.xpath("//input[@name='username']"), usuario);
	}
	
	public void setSenha(String senha) {
//		getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(senha);
		escrever(By.xpath("//input[@name='password']"), senha);
	}
	
	public void logar() {
//		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public void clicarEsqueceuSenha() {
		clicar(By.xpath("//*[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
	}
	
	public void clicarResetPassword() {
		clicar(By.xpath("//*[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']"));
	}
	
	public void setUserEsqueceuSenha(String user) {
		escrever(By.xpath("//*[@name='username']"), user);
	}
	
	public void clicarCancelarResetPassword() {
		clicar(By.xpath("//*[@class='oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel']"));
	}
}