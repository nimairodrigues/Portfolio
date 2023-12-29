package br.am.nimai.core;

import static br.am.nimai.core.DriverFactory.getDriver;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
    /*** TextField e TextArea ***/
	
	protected void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	
	/********* Botao ************/
	
	protected void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//button[.='"+texto+"']"));
	}
	
	/********* Textos ************/
	
	protected String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	/********* Frames e Janelas ************/
	
	protected void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	protected void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	protected void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	/********* Tabela ************/
	
	protected WebElement obterCelula2(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@class='"+idTabela+"']"));
		int idColuna = obterIndiceColuna2(colunaBusca, tabela);
		//encontar a linha do registro
		int idLinha = obterIndiceLinha2(valor, tabela, idColuna);
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna2(colunaBotao, tabela);
		//clicar no botao da celula encontrada
//		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColunaBotao+"]"));
		WebElement celula = tabela.findElement(By.xpath("./div[@class='oxd-table-body']/div["+idLinha+"]/div/div["+idColunaBotao+"]"));
		
		return celula;
		
	}
	
	protected void clicarbotaoTabela2(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		WebElement celula = obterCelula2(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
	}

	protected int obterIndiceLinha2(String valor, WebElement tabela, int idColuna) {
		//continuar com qual botao clicar
//		List<WebElement> linhas = tabela.findElements(By.xpath("./div[@class='oxd-table-body']/div[@class='oxd-table-card']/div[@class='oxd-table-row oxd-table-row--with-border']/div["+idColuna+"]"));
		List<WebElement> linhas = tabela.findElements(By.xpath("./div[@class='oxd-table-body']/div[@class='oxd-table-card']/div/div["+idColuna+"]"));
//		int idLinha = -1;
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}		
		}
		return idLinha;
	}

	protected int obterIndiceColuna2(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//*[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th']"));
//		int idColuna = -1;
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}		
		}
		return idColuna;
	}
	
	/********* Elementos ************/
	
	public void esperarPresencaPorTexto(String texto) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+texto+"']")));
	}
	
	public void esperarPresencaPorElemento(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void esperarInvisibilidadeDeElemento(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<WebElement> findElements = getDriver().findElements(By.xpath("//*[text()='"+texto+"']"));
		return findElements.size() > 0;
	}
	
	public boolean existeElementoPorXPath(String xpath) {
		List<WebElement> findElements = getDriver().findElements(By.xpath(xpath));
		return findElements.size() > 0;
	}
	
	public String obterTextoXpath(String xpath) {
		return getDriver().findElement(By.xpath(xpath)).getText();
	}
	
	public void mostrarFilhosElementoXpath(String xpath) {
		System.out.println("filhos do elemento xpath: " + xpath);
		List<WebElement> findElements = DriverFactory.getDriver().findElements(By.xpath(xpath));
		System.out.println("---- aqui os filhos: ------");
		for(WebElement elemento: findElements) {
			System.out.println(elemento.getTagName());
		}
		System.out.println("--- texto dos filhos: -----");
		for(WebElement elemento: findElements) {
			System.out.println(elemento.getText());
		}
		System.out.println("---- aqui o nome da classe dos elementos: -----");
		for(WebElement elemento: findElements) {
			System.out.println(elemento.getAttribute("class").toString());
		}
	}
	
	protected void apagarElemento(By by) {
		DriverFactory.getDriver().findElement(by).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
	
	/********* Outros ************/
	
	public String randomNum(int qtdNum) {
		Random aleatorio = new Random();
		int num = aleatorio.nextInt(qtdNum);
		String numero = Integer.toString(num); 
		return numero;
	}
}
