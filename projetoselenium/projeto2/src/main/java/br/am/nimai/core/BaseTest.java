package br.am.nimai.core;

import static br.am.nimai.core.DriverFactory.getDriver;
import static br.am.nimai.core.DriverFactory.killDriver;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	@Before
	public void inicializar() {
		getDriver().get("https://bugbank.netlify.app/");
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='styles__WarnigWrapper-sc-1ota0lw-0 kpiCJH']")));
	}
	
	@After
	public void finalizar() {
		killDriver();
	}
}
