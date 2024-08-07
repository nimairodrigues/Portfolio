package br.am.nimai.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.am.nimai.page.LoginPage;


public class BaseTest {
	
	LoginPage loginPage = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void setup() {
		try {
			loginPage.esperarTela();
		} catch (Exception e) {
			Assert.fail("Não carregou a tela inicial");
		}
	}
	
	@AfterClass
	public static void finalizar() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		gerarScreenshot();
		DriverFactory.getDriver().resetApp();
	}
	
	public void gerarScreenshot() {		
		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshot/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void espera(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
