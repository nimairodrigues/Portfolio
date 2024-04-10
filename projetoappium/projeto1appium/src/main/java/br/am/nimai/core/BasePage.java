package br.am.nimai.core;

import static br.am.nimai.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String texto) {
		getDriver().findElement(by).click();
		clicarPorTexto(texto);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> findElements = getDriver().findElements(By.xpath("//*[@text=\""+texto+"\"]"));
		return findElements.size() > 0;
	}
	
	public boolean existeElementoNaTela(By by) {
		List<MobileElement> findElements = getDriver().findElements(by);
		return findElements.size() > 0;
	}
	
	public void tap(int x, int y) {
		new TouchAction<>(getDriver())
		.tap(PointOption.point(new Point(x, y)))
		.perform();
	}
	
	
	public void tap2(int x, int y) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence clickSequence = new Sequence(finger, 1);
		clickSequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
		clickSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		getDriver().perform(Arrays.asList(clickSequence));
	}
	
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(x, start_y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(x, end_y)))
		.release()
		.perform();
			
	}
	
	public void scrollDown() {
		scroll(0.8, 0.2);
	}
	
	public void scrollUp() {
		scroll(0.2, 0.8);
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(start_x, y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(end_x, y)))
		.release()
		.perform();
	}
	
	public void swipeRight() {
		swipe(0.9, 0.1);
	}
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public String obterTituloAlerta(String id) {
		return obterTexto(By.id(id));
	}
	
	public String obterMensagemAlerta(String id) {
		return obterTexto(By.id(id));
	}
	
	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height / 2);
		
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		new TouchAction<>(getDriver())
		.press(PointOption.point(new Point(start_x, y)))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(new Point(end_x, y)))
		.release()
		.perform();
	}
	
	public void cliqueLongo(By by) {
		MobileElement center = getDriver().findElement(by);
		
		new TouchAction<>(getDriver())
//		.longPress(PointOption.point(elex, eley)).perform();
		.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(center)).withDuration(Duration.ofSeconds(2)))
		.release()
		.perform();
	}
}
