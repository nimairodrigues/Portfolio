package br.am.nimai.page;

import static br.am.nimai.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.am.nimai.core.BasePage;
import br.am.nimai.core.DriverFactory;

public class ProfilePage extends BasePage {
	
	public void acessarExplorer() {
		clicar(By.xpath("//*[@content-desc='Search and explore']"));
	}
	
	public void escreverNoSearch(String text) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_search_hints_text_layout']")));
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_search_hints_text_layout']"));
		escrever(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_search_edit_text']"), text);
	}
	
	public void clicarNoPerfilSearch(String profileName) {
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_search_user_container']//*[@text='"+profileName+"']/../../.."));
	}
	
	public void clicarFoto() {
		clicar(By.xpath("//*[ends-with(lower-case(@content-desc), 'at row 1, column 2')]"));
	}
	
	public void clicarLike() {
			clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_like']"));
	}
	
	public void clicarComentar() {
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_comment']"));
	}
	
	public void escreverComentario(String comentario) {
		escrever(By.xpath("//*[@resource-id='com.instagram.android:id/comment_composer_edittext']"), comentario);
	}
	
	public void clicarEnviarComentario() {
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/layout_comment_thread_post_button_icon']"));
	}
	
	public void apagarComentario() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		cliqueLongo(By.xpath("//*[@content-desc=\"Go to qanimairodrigues's profile\"]/.."));
		clicar(By.xpath("//android.widget.Button[@content-desc='Delete']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Comment deleted.']")));
	}
	
	public boolean obterIsCommented() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView//*[@content-desc=\"Go to qanimairodrigues's profile\"]/..//*[@content-desc=\"Like\"]")));
		return existeElementoNaTela(By.xpath("//androidx.recyclerview.widget.RecyclerView//*[@content-desc=\"Go to qanimairodrigues's profile\"]"));
	}
	
	public Boolean likeIsSelected() {
			return DriverFactory.getDriver().findElement(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_button_like']")).getAttribute("selected").contains("true");
	}
	
	public void verificarBarraDeOpcoesVisivel() {
		if(existeElementoNaTela(By.xpath("//*[@resource-id='com.instagram.android:id/row_feed_view_group_buttons']"))) {
			
		} else {
			scroll(0.6, 0.4);
		}
	}
	
	public void swipeLeft() {
		swipe(0.9, 0.1);
	}
	
	public boolean obterMsgDaTelaMensagem() {
		return DriverFactory.getDriver().findElement(By.xpath("//*[@resource-id='com.instagram.android:id/privacy_disclosure_text']")).getText().contains("You started a chat with");
	}

	public void clicarBotaoOpcao() {
		clicar(By.xpath("//*[@resource-id='com.instagram.android:id/action_bar_overflow_icon']"));
	}

	public void clicarHideStory() {
		clicar(By.xpath("//android.widget.Button[@text='Hide your story']"));
	}
	
	public void clicarUnhideStory() {
		clicar(By.xpath("//android.widget.Button[@text='Unhide your story']"));
	}

	public void clicarConfirmarHideStory() {
		clicar(By.xpath("//android.widget.Button[@text='Hide']"));
	}
	
	public void unhideStory() {
		clicarBotaoOpcao();
		clicarUnhideStory();
	}
	
}
