package br.am.nimai.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {
		
	}
	
	//Criando o driver
	public static WebDriver getDriver() {
		if(driver == null) {
		//escolhendo o navegador a ser utilizado
		driver = new FirefoxDriver();
		
		//escolhendo a dimensão do navegador
		driver.manage().window().setSize(new Dimension(1200, 900));
		}
		
		//retornando o driver
		return driver;
	}
	
	//Finalizando o driver
	public static void killDriver() {
		if(driver != null) {
			//fechar o driver
			driver.quit();
			driver = null;
		}
	}
}
