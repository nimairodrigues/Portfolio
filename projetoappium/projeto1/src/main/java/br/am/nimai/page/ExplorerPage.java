package br.am.nimai.page;

import static br.am.nimai.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class ExplorerPage extends BasePage {

	public void acessarExplorer() {
		clicar(By.xpath("//*[@content-desc='Search and explore']"));
	}
	
	public void escreverNoSearch(String text) {
//		clicar(By.xpath("//android.widget.TextView[@text='Search']"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_search_hints_text_layout']")));
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_search_hints_text_layout']"));
		escrever(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_search_edit_text']"), text);
	}
	
	public void clicarNoPerfilSearch(String profileName) {
//		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_search_user_container']//*[@text='"+profileName+"']"));
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_search_user_container']//*[@text='zuck']/../../.."));
	}
	
	public String obterProfileUsername() {
		return obterTexto(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_title']"));
	}
	
	public void clicarPub() {
		clicar(By.xpath("//*[ends-with(lower-case(@content-desc), 'at row 2, column 2')]"));
	}
	
	public void cliqueESeguraNaPub() throws InterruptedException {
		swipeElement5(DriverFactory.getDriver().findElement(By.xpath("//*[ends-with(lower-case(@content-desc), 'at row 2, column 2')]")));
	}
	
	public void clicarLike() {
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_like']"));
	}
	
	public Boolean obterIsLiked() {
		return getDriver().findElement(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_like']")).getAttribute("selected").contains("true");
	}
	
	public void clicarComentarPost() {
		if(existeElementoNaTela(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_comment']"))) {
			clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_comment']"));
		} else {
			scroll(0.6, 0.4);
			clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_comment']"));
		}
	}
	
	public void clicarSalvarPost() {
		if(existeElementoNaTela(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_save']"))) {
			clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_save']"));
		} else {
			scroll(0.65, 0.35);
			clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_save']"));
		}
	}
	
	public void escreverComentario(String comentario) {
		escrever(By.xpath("//*[@resource-id='com.instagram.android:id/comment_composer_edittext']"), comentario);
	}
	
	public void clicarEnviarComentario() {
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/layout_comment_thread_post_button_icon']"));
	}
	
	public boolean obterIsCommented() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView//*[@content-desc=\"Go to qanimairodrigues's profile\"]/..//*[@content-desc=\"Like\"]")));
		return existeElementoNaTela(By.xpath("//androidx.recyclerview.widget.RecyclerView//*[@content-desc=\"Go to qanimairodrigues's profile\"]"));
	}
	
	public void apagarComentario() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		cliqueLongo(By.xpath("//*[@content-desc=\"Go to qanimairodrigues's profile\"]/.."));
		clicar(By.xpath("//android.widget.Button[@content-desc='Delete']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Comment deleted.']")));
	}
	
	public void esperarBotaoSearchAparecer() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc='Search and explore']")));
	}

	public void esperarCarregarExplorer() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[ends-with(lower-case(@content-desc), 'at row 2, column 2')]")));
	}
	
	public String obterNomePost() {
		return getDriver().findElement(By.xpath("//*[ends-with(lower-case(@content-desc), 'at row 2, column 2')]")).getAttribute("content-desc");
	}
	
	public void esperarAtualizarPaginaExplorer() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		String nomePost = obterNomePost();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@content-desc='"+ nomePost +"']")));
	}
}
