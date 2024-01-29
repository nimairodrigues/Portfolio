package br.am.nimai.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class BuzzPage extends BasePage {
	
	public void escreverPost(String texto) {
		escrever(By.xpath("//*[@class='oxd-buzz-post-input']"), texto);
	}
	
	public void escreverPostLongo() {
		escrever(By.xpath("//*[@class='oxd-buzz-post-input']"), textoLongo());
	}
	
	public String pegarPopupResultado() {
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		return obterTexto(By.xpath("//*[@class='oxd-toast-start']//p[2]"));
	}
	
	public void clicarPost() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String aleatorizarNumeros(int qtdNum) {
		return randomNum(qtdNum);
	}

	public void clicarApagarPost() {
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Delete Post']"));
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Delete Post']"));
	}
	
	public void clicarAlterarPost() {
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']"));
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
		clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div[1]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
	}
	
	public void clicarLikePost() {
			clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']/div"));
	}

	public void escreverEditPost() {
		esperarPresencaPorElemento(By.xpath("//*[@class='orangehrm-buzz-post-modal-header-text']/div/textarea"));
		escrever(By.xpath("//*[@class='orangehrm-buzz-post-modal-header-text']/div/textarea"), " " + randomNum(50));
	}
	
	public void clicarPostEdit() {
		clicar(By.xpath("//*[@class='oxd-dialog-container-default--inner']//button[@type='submit']"));
	}
	
	public void encontrarPostDeUmUsuario(String string) {
		List<WebElement> findElements = DriverFactory.getDriver().findElements(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div//*[@class='oxd-text oxd-text--p orangehrm-buzz-post-emp-name']"));
		boolean achei = false;
		
		for(WebElement doidos: findElements) {
			System.out.println(doidos.getText());
		}
		
		for(int i = 0; i < findElements.size(); i++) {
			if(findElements.get(i).getText().contains(string)) {
				i++;
				clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div["+i+"]//*[@class='orangehrm-buzz-post-header-config']"));
				esperarPresencaPorElemento(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div["+i+"]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
				clicar(By.xpath("//*[@class='oxd-grid-1 orangehrm-buzz-newsfeed-posts']/div["+i+"]//*[@class='orangehrm-buzz-post-header-config']//ul//*[text()='Edit Post']"));
				achei = true;
				break;
			}
		}
		
		if(achei) {
			System.out.println("Achei um post desse cara na tela");
		} else {
			System.out.println("Nao achei nenhum post desse cara na tela");
		}
		
	}
	
	public String pegarUsuarioLogado() {
		return obterTexto(By.xpath("//*[@class='oxd-userdropdown-name']"));
	}
	
	public boolean isLikeado() {
		String string = DriverFactory.getDriver()
				.findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-post-actions']/div"))
				.getAttribute("class");
		return string.contains("orangehrm-like-animation");
	}
	
	public int pegarQtdLikes() {
		String text = DriverFactory.getDriver().findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]"
				+ "//*[@class='orangehrm-buzz-stats']/div[1]/p")).getText();
		String valor = text.replaceAll("(?:[^0-9]+)", "");
		int resultado = Integer.parseInt(valor);
		return resultado;
	}
	
	public void clicarCompartilharPost() {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]"
				+ "//*[@class='orangehrm-buzz-post-actions']//*[@class='oxd-icon bi-share-fill']"));
	}
	
	public void clicarShare() {
		clicar(By.xpath("//*[@class='oxd-dialog-container-default--inner']//button[@class='oxd-button oxd-button--medium oxd-button--main']"));
	}
	
	public void clicarBotaoComentar() {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]"
				+ "//*[@class='orangehrm-buzz-post-actions']//*[@class='oxd-icon bi-chat-text-fill']"));
	}
	
	public void escreverNosComents(String comentario) {
		escrever(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//input"), comentario);
	}
	
	public void enviarComent() {
		DriverFactory.getDriver().findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//input"))
		.sendKeys(Keys.ENTER);
	}
	
	public void comentarEmAlgumPost(String comentario) {
		clicarBotaoComentar();
		escreverNosComents(comentario);
		enviarComent();
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-toast-start']"));
	}
	
	public void apagarMeuComentario(String comentario) {
		clicarApagarComent(comentario);
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']"));
		clicarPorTexto(" Yes, Delete ");
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-toast-start']"));
	}
	
	public void clicarLikeComent(String comentario) {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../..//*[text()='Like']"));
		esperarPresencaPorElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../*[@class='orangehrm-post-comment-stats']/p"));
	}
	
	public String pegarLikesComent(String comentario) {
		return obterTexto(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../*[@class='orangehrm-post-comment-stats']/p"));
	}
	
	public void clicarEditComent(String comentarioQueSeraEditado) {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentarioQueSeraEditado+"']/../..//*[text()='Edit']"));
	}
	
	public void escreverEditComent(String comentarioNovo) {
		apagarElemento(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//input"));
		escrever(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//input"), comentarioNovo);
		DriverFactory.getDriver().findElement(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//input"))
		.sendKeys(Keys.ENTER);
	}
	
	public void clicarApagarComent(String comentario) {
		clicar(By.xpath("(//*[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-buzz'])[1]//*[@class='orangehrm-buzz-comment']//*[@class='orangehrm-comment-wrapper']//*[@class='orangehrm-post-comment-area']//*[text()='"+comentario+"']/../..//*[text()='Delete']"));
	}
	
	public String textoLongo() {
		String textoGrande = "";
		return textoGrande;
	}

	public void fazerPost(String texto) {
		escreverPost(texto);
		clicarPost();
		esperarPresencaPorElemento(By.xpath("//*[@class='oxd-toast-start']"));
		esperarInvisibilidadeDeElemento(By.xpath("//*[@class='oxd-toast-start']"));
	}

}
