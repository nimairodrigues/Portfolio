package br.am.nimai.page;

import org.openqa.selenium.By;

import br.am.nimai.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarAdmin() {
		clicar(By.xpath("//li[@class='oxd-main-menu-item-wrapper']"));
	}
}
