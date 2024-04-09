package br.am.nimai.page;

import org.openqa.selenium.By;

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
		System.out.println(element.getText());
		System.out.println(element.getLocation().y);
		System.out.println(element.getLocation().x);
		int yele = (int) (element.getLocation().y + (element.getLocation().y * 0.010));
		int xele = (int) (element.getLocation().x + (element.getLocation().x * 10));
		System.out.println("y "+yele);
		System.out.println("x "+xele);
		tap(xele, yele);
		
	}
	
	public void clicarCheckboxCredenciais() {
		clicar(By.xpath("//*[@content-id='Checkbox credentials']"));
		
	}
	
	public boolean isCheckboxMarcado() {
		return isCheckMarcado(By.xpath("//*[@content-id='Checkbox credentials']"));
		
	}
	
	public void logar() {
		escreverUsuario(Properties.user);
		escreverSenha(Properties.pw);
		clicarLogin();
		
	}
	
	public void clicarNotNow() {
		clicar(By.xpath("//*[@content-desc='Not now']"));
	}
	
}
