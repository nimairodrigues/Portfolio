package br.am.nimai.page;

import org.openqa.selenium.By;

import br.am.nimai.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarAdmin() {
		clicar(By.xpath("//*[@class='oxd-sidepanel-body']//*[@class='oxd-main-menu']/li[1]"));
	}
	
	public void acessarPIM() {
		clicar(By.xpath("//*[@class='oxd-sidepanel-body']//*[@class='oxd-main-menu']/li[2]"));
	}
	
	public void acessarBuzz() {
		clicar(By.xpath("//*[@class='oxd-sidepanel-body']//*[@class='oxd-main-menu']/li[12]"));
	}
	
	public void acessarRecruit() {
		clicar(By.xpath("//*[@class='oxd-sidepanel-body']//*[@class='oxd-main-menu']/li[5]"));
	}
}
