package br.am.nimai.test;

import org.junit.Test;

import br.am.nimai.core.BaseTest;
import br.am.nimai.core.DriverFactory;

public class OMaisSimplesDoUniverso extends BaseTest{
	
	@Test
	public void aessar() throws InterruptedException {
		DriverFactory.getDriver().get("https://www.google.com.br/");
		Thread.sleep(3000);
	}
}
