package br.am.nimai.page;

import static br.am.nimai.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;
import br.am.nimai.core.Properties;
import io.appium.java_client.MobileElement;

public class LoginPage extends BasePage{
	
	public void escreverUsuario(String username) {
		escrever(By.xpath("//*[@text='Username, email or mobile number']/../../android.widget.EditText"), username);
		
	}
	
	public void escreverSenha(String senha) {
		escrever(By.xpath("//*[@text='Password']/../../android.widget.EditText"), senha);
		
	}
	
	public void clicarSenha() {
		clicar(By.xpath("//*[@text='Password']/../../android.widget.EditText"));
		
	}
	
	public void clicarLogin() {
		clicar(By.xpath("//*[@text='Log in']/.."));
		
	}
	
	public void clicarLoginDenovo() throws InterruptedException {
		MobileElement element = DriverFactory.getDriver().findElement(By.xpath("//*[@content-desc='Log in']"));
		int yele = (int) (element.getLocation().y + (element.getLocation().y * 0.010));
		int xele = (int) (element.getLocation().x + (element.getLocation().x * 10));
		tap(xele, yele);
		
	}
	
	public void clicarCheckboxCredenciais() {
		clicar(By.xpath("//*[@content-desc='Checkbox credentials']"));
		
	}
	
	public boolean isCheckboxMarcado() {
		return isCheckMarcado(By.xpath("//*[@content-desc='Checkbox credentials']"));
		
	}
	
	public void logar() {
		escreverUsuario(Properties.user);
		escreverSenha(Properties.pw);
		clicarLogin();
		
	}
	
	public void clicarNotNow() {
		clicar(By.xpath("//*[@content-desc='Not now']"));
	}
	
	public boolean isPasswordFocused() {
		return getDriver().findElement(By.xpath("//*[@text='Password']/../../android.widget.EditText")).getAttribute("focused").contains("true");
	}

	public void esperarTela() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Username, email or mobile number']/../../android.widget.EditText")));
		
	}
	
}
