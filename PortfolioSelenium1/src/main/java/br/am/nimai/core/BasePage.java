package br.am.nimai.core;

import static br.am.nimai.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
/********* TextField e TextArea ************/
	
	protected void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	protected void escrever(String id_campo, String texto){
		getDriver().findElement(By.id(id_campo)).clear();
		escrever(By.id(id_campo), texto);
	}
	
	protected String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/********* Radio e Check ************/
	
	protected void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	protected void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	
	//protected void clicarRadio(String id) {
	//	getDriver().findElement(By.id(id)).click();
	//}
	
	protected boolean isRadioMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	protected void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	protected boolean isCheckMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	protected void selecionarCombo(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	protected void selecionarCombo(String id, String valor) {
		selecionarCombo(By.id(id), valor);
	}
	
	//protected void selecionarCombo(String id, String valor) {
	//	WebElement element = getDriver().findElement(By.id(id));
	//	Select combo = new Select(element);
	//	combo.selectByVisibleText(valor);
	//}
	
	
	protected void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	protected String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	protected List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	protected int obterQuantidadeOpcoesCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	protected boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	protected void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"_items']/li[.='"+valor+"']"));
	}
	
	/********* Botao ************/
	
	protected void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	protected void clicar(String id) {
		clicar(By.id(id));
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//button[.='"+texto+"']"));
	}
	
	protected String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Link ************/
	
	protected void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	protected String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	protected String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	/********* Alerts ************/
	
	protected String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	protected String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	protected String alertaObterTextoENega(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	protected void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
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
	
	/******** JS **********/
	
	protected Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	/********* Tabela ************/
	
	protected WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		//encontar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColunaBotao+"]"));
		return celula;
		
	}
	
	protected void clicarbotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		////procurar coluna do registro
		//WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		//int idColuna = obterIndiceColuna(colunaBusca, tabela);
		////encontar a linha do registro
		//int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		////procurar coluna do botao
		//int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		////clicar no botao da celula encontrada
		//WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColunaBotao+"]"));
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}		
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}		
		}
		return idColuna;
	}
	
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
	
	public String obterTextoXpath(String texto) {
		return getDriver().findElement(By.xpath(texto)).getText();
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
	
	protected void apagarElemento(By by) {
		DriverFactory.getDriver().findElement(by).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
	
	protected String randomNum(int qtdNum) {
		Random aleatorio = new Random();
		int num = aleatorio.nextInt(qtdNum);
		String numero = Integer.toString(num); 
		return numero;
	}
}
